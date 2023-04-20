package GamePack;

import java.util.Random;

import MonsterPack.Monster;
import TreasurePack.Armor;
import TreasurePack.Treasure;
import TreasurePack.TreasureArt;
import TreasurePack.Weapon;

public class Player extends Entity {

    public Integer x;
    public Integer y;
    private Game game;
    private Integer fightWon;
    private Armor armor;
    private Weapon weapon;


    
    public Player(Integer startingX, Integer startingY, Game game){
        super(5);
        this.x = startingX;
        this.y = startingY;
        this.game = game;
        this.fightWon = 0;
    }

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
            }

            System.out.println("\n");
        }


        if (m.getHP() <= 0){
            System.out.println(GameArt.getCombatWinArt());
            System.out.println("You defeated "+m.getMonsterName()+ "!");
            System.out.println("You feel stronger and get 1 more HP");

            //find treasure
            System.out.println(TreasureArt.getTreasureArt());
            System.out.println("You found a treasure!");
            Boolean openTreasure = checkIfOpenTreasure(ihm);
            if (openTreasure){
                checkIfUseTreasure(ihm);
            }


            this.game.getCurrentRoom().setMonster(null);
            this.fightWon ++;
            this.fullHeal();
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

    public Integer rollDamage(){
        Integer damage = new Random().nextInt(2)+1;
        if (this.hasWeapon()){
            damage += this.weapon.getDamagePoint();
        }
        return damage;
    }

    private Boolean checkIfContinueCombat(IHM ihm){
        String action = askIfContinueCombat(ihm);
        switch (action) {
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

    private String askIfContinueCombat(IHM ihm){
        String userInput = "";
        while (!userInput.equals("A") && !userInput.equals("R")){
            System.out.println("What action will you take? A: Attack R:Run");
            userInput = ihm.input();
        }
        return userInput;
    }

    private Boolean checkIfOpenTreasure(IHM ihm){
        String action = askIfOpenTreasure(ihm);
        switch (action) {
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

    private String askIfOpenTreasure(IHM ihm){
        String userInput = "";
        while (!userInput.equals("O") && !userInput.equals("D")){
            System.out.println("What action will you take? O:Open Treasure | D:Discard Treasure");
            userInput = ihm.input();
        }
        return userInput;
    }

    private Boolean checkIfUseTreasure(IHM ihm){
        String action = askIfUseTreasure(ihm);
        switch (action) {
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

    private String askIfUseTreasure(IHM ihm){
        String userInput = "";
        while (!userInput.equals("W") && !userInput.equals("D")){
            System.out.println("What action will you take? W: Wear D:Discard");
            userInput = ihm.input();
        }
        return userInput;
    }

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

    public Integer getFightWon(){
        return this.fightWon;
    }

    public Boolean hasWeapon(){
        return !(this.weapon == null);
    }

    public Boolean hasArmor(){
        return !(this.armor == null);
    }

    public void wearArmor(Armor armor){
        this.armor = armor;
    }

    public void pickupWeapon (Weapon weapon){
        this.weapon = weapon;
    }

    public Armor getArmor(){
        return this.armor;
    }

    public Weapon getWeapon(){
        return this.weapon;
    }
}