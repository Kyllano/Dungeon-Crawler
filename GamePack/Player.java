package GamePack;

import java.util.Random;

import MonsterPack.Monster;
import TreasurePack.Armor;
import TreasurePack.Treasure;
import TreasurePack.TreasureArt;
import TreasurePack.Weapon;

/**
 * Classe permettant de représenter le joueur
 */
public class Player extends Entity {

    public Integer x;
    public Integer y;
    private Game game;
    private Integer fightWon;
    private Armor armor;
    private Weapon weapon;


    /**
     * Constructeur de classe
     * @param startingX Coordonnée de départ du joueur
     * @param startingY Coordonnée de départ du joueur
     * @param game      Le je dans lequel le joueur doit être contenu
     */
    public Player(Integer startingX, Integer startingY, Game game){
        super(5);
        this.x = startingX;
        this.y = startingY;
        this.game = game;
        this.fightWon = 0;
    }

    /**
     * Permet d'engager un combat avec un monstre
     * @param m     Monstre a attaquer
     * @param ihm   Objet IHM pour les inputs
     */
    public void EngageCombat(Monster m, IHM ihm){

        IHM.showMonster(m);
        System.out.println("\n");
        Boolean continueCombat = true;
        
        while (this.getHP() > 0 && m.getHP()> 0 && continueCombat) {

            attackTurn(m);

            if (this.getHP() > 0 && m.getHP()> 0){
                continueCombat = checkIfContinueCombat(ihm);
            }

            if (!continueCombat){
                m.fullHeal();
                this.fullHeal();
                if (this.hasArmor()){
                    this.getArmor().repair();
                }
            }

            System.out.println("\n");
        }


        if (m.getHP() <= 0){
            System.out.println(GameArt.getCombatWinArt());
            System.out.println("You defeated "+m.getMonsterName()+ "!");
            System.out.println("You feel stronger and get 1 more HP");

            //find treasure
            if (this.game.getCurrentRoom().getTreasure() != null){
                System.out.println(TreasureArt.getTreasureArt());
                System.out.println("You found a treasure!");
                Boolean openTreasure = checkIfOpenTreasure(ihm);
                if (openTreasure){
                    checkIfUseTreasure(ihm);
                }
            }
            else{
                System.out.println("There is no treasure in this room");
            }


            this.game.getCurrentRoom().setMonster(null);
            this.fightWon ++;
            this.setMaxHP(this.getMaxHP() + 1);
            this.fullHeal();
            if (this.hasArmor()){
                this.getArmor().repair();
            }
        }
        else if (this.getHP() <= 0){
            System.out.println(m.getMonsterName() + " has defeated you!");
            game.GameOver(m);
        }
        else{
            System.out.println("You successfully fled the combat. "+m.getMonsterName()+" will have time to recover its forces");
            this.fullHeal();
            m.fullHeal();
        }
    }

    /**
     * Permet d'effectuer un tour d'attaque
     * @param m Monstre à attaquer
     */
    private void attackTurn(Monster m){
        Boolean playerAttacks = new Random().nextBoolean();
        if (playerAttacks){
            Integer damage = this.rollDamage();
            m.TakeDamage(damage);

            if (hasWeapon()){
                System.out.println("You attack " + m.getMonsterName() + " with "+this.weapon.getTitle()+" for " + damage + " HP");
            }
            else{
                System.out.println("You attack " + m.getMonsterName() + " with your bear hands for " + damage + " HP");
            }
        }
        else{
            Integer damage = m.rollDamage();
            System.out.println(m.getMonsterName() + " attacks you for " + damage + " damage!");

            if (hasArmor()){
                damage = this.armor.takeDamage(damage); //L'armure renvoit -1 si le perso ne doit pas prendre de damage
            }

            if (damage != -1){ //Si l'armure s'est cassé et que le perso doit prendre des dégats
                System.out.println("You lose "+ damage + " HP!");
                this.TakeDamage(damage);
                this.armor = null; // l'armure est cassée donc on la jette
            }

        }

        System.out.println("       "+ m.getMonsterName());
        IHM.showHPBar(m);
        System.out.println("                  You");
        IHM.showHPBar(this);

        System.out.println("\n");
    }

    /**
     * Permet à un joueur de faire un jet de dégât
     * @return
     */
    public Integer rollDamage(){
        Integer damage = new Random().nextInt(2)+1;
        if (this.hasWeapon()){
            damage += this.weapon.getDamagePoint();
        }
        return damage;
    }

    /**
     * Permet de cvérifier si l'utilisateur veut continuer à attaquer la monstre ou si il veut fuir
     * @param ihm   Objet IHM pour les inputs
     * @return      True si le joueur veut continuer le combat
     */
    private Boolean checkIfContinueCombat(IHM ihm){
        String action = askIfContinueCombat(ihm);
        switch (action.toUpperCase()) {
            case "R":
                System.out.println("You are fleeing the combat...");
                return false;
            case "A":
                System.out.println("You decide to keep fighting...");
                return true;
            default:
            System.out.println("Ya probleme ptdrr");
            return false;
        }
    }

    /**
     * Permet d'effectuer la demande de poursuite du combat
     * @param ihm   objet IHM pour l'input
     * @return      la réponse de l'utilisateur
     */
    private String askIfContinueCombat(IHM ihm){
        String userInput = "";
        while (!userInput.equalsIgnoreCase("A") && !userInput.equalsIgnoreCase("R")){
            System.out.println("What action will you take? A: Attack R:Run");
            userInput = ihm.input();
        }
        return userInput;
    }

    /**
     * Permet de checker si l'utilisateur veut ouvrir le trésor
     * @param ihm   Objet IHM pour les input
     * @return      True si l'utilisateur veut ouvrir le trésor
     */
    private Boolean checkIfOpenTreasure(IHM ihm){
        String action = askIfOpenTreasure(ihm);
        switch (action.toUpperCase()) {
            case "O":
                Treasure t = this.game.getCurrentRoom().getTreasure();
                System.out.println(t.getArt());
                System.out.println("You open the treasure and find " + t.getTitle());
                return true;
            case "D":
                System.out.println("You decide to discard the Treasure");
                this.game.getCurrentRoom().setTreasure(null);
                return false;
            default:
                System.out.println("Ya probleme ptdrr");
                return false;
        }
    }

    /**
     * Permet d'effectuer la demande d'ouverture de trésor
     * @param ihm   Objet IHM pour les input
     * @return      la réponse de l'utilisateur
     */
    private String askIfOpenTreasure(IHM ihm){
        String userInput = "";
        while (!userInput.equalsIgnoreCase("O") && !userInput.equalsIgnoreCase("D")){
            System.out.println("What action will you take? O:Open Treasure | D:Discard Treasure");
            userInput = ihm.input();
        }
        return userInput;
    }

    /**
     * Permet de checker si l'utilisateur veut équiper le trésor
     * @param ihm   Objet IHM pour les input
     * @return      True si il veut équiper le trésor
     */
    private Boolean checkIfUseTreasure(IHM ihm){
        String action = askIfUseTreasure(ihm);
        switch (action.toUpperCase()) {
            case "W":
                Treasure t = this.game.getCurrentRoom().getTreasure();
                if (t instanceof Armor){
                    System.out.println("You decide to wear the "+ t.getTitle());
                    this.wearArmor((Armor) t);
                }
                else{
                    System.out.println("You decide to use the "+ t.getTitle());
                    this.pickupWeapon((Weapon) t);
                }
                return true;
            case "D":
                System.out.println("You discard the treasure");
                this.game.getCurrentRoom().setTreasure(null);
                return false;
            default:
                System.out.println("Ya probleme ptdrr");
                return false;
        }
    }

    /**
     * Permet d'effectuer la demande d'équipage du trésor
     * @param ihm   Objet IHM pour les input
     * @return      la réponse de l'utilisateur
     */
    private String askIfUseTreasure(IHM ihm){
        String userInput = "";
        while (!userInput.equalsIgnoreCase("W") && !userInput.equalsIgnoreCase("D")){
            System.out.println("What action will you take? W: Wear D:Discard");
            userInput = ihm.input();
        }
        return userInput;
    }

    /**
     * Permet d'afficher l'équipement de l'utilisateur
     */
    public void showEquipement(){
        System.out.println("You are wearing :");
        if (this.getArmor() != null){
            IHM.showTreasure(game.getPlayer().getArmor());
        }
        else{
            System.out.println("No armor");
        }
        if (this.getWeapon() != null){
            IHM.showTreasure(game.getPlayer().getWeapon());
        }
        else{
            System.out.println("No weapon");
        }
    }

    /**
     * Getter du nombre de combat gagné
     */
    public Integer getFightWon(){
        return this.fightWon;
    }

    /**
     * Permet de retourner si l'utilisateur a une arme ou non
     * @return True si le joueur a une arme
     */
    public Boolean hasWeapon(){
        return !(this.weapon == null);
    }

    /**
     * Permet de retourner si l'utilisateur a une armure ou non
     * @return True si le joueur a une armure
     */
    public Boolean hasArmor(){
        return !(this.armor == null);
    }

    /**
     * Permet a l'utilisateur de porter une armure
     * @param armor L'armure a porter
     */
    public void wearArmor(Armor armor){
        this.armor = armor;
    }

    /**
     * Permet au joueur d'utiliser une arme
     * @param weapon    L'arme a porter
     */
    public void pickupWeapon (Weapon weapon){
        this.weapon = weapon;
    }

    /**
     * Getter de l'armure du joueur
     */
    public Armor getArmor(){
        return this.armor;
    }

    /**
     * Getter de l'arme du joueur
     */
    public Weapon getWeapon(){
        return this.weapon;
    }
}