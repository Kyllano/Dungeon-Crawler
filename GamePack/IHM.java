package GamePack;

import java.util.Scanner;

import DungeonPack.DiscoveryMap;
import DungeonPack.Dungeon;
import DungeonPack.DiscoveryMap.DiscoveryStates;
import MonsterPack.Monster;
import MonsterPack.MonsterArt;
import TreasurePack.Armor;
import TreasurePack.Treasure;
import TreasurePack.Weapon;


/**
 * Classe contenant des fonctions permettant d'obtenir des fonctions d'affichage du jeu
 */
public class IHM{

    Scanner s;

    /**
     * Constructeur de classe
     */
    public IHM(){
        super();
        this.s = new Scanner(System.in);
    }

    /**
     * Permet d'obtenir un input de la part de l'utilisateur
     * @return
     */
    public String input(){
        return s.nextLine();
    }

    /**
     * Permet d'obtenir un nombre de la part de l'utilisateur
     * @return
     */
    public Integer inputNumber(){
        while(true){
            try {
                Integer userInput = s.nextInt();
                return userInput;
            } catch (Exception e) {
                System.out.println("Invalid number");
                s.nextLine();
            }
        }
    }

    /**
     * Code zombie, ne pas y faire attention
     */
    /* 
     public static void setConsoleToUTF8() {
         try {
             PrintStream out = new PrintStream(System.out, true, "UTF-8");
             System.setOut(out);
            } catch (Exception e) {
                System.out.println("Unable to change the console printStream to UTF-8 :");
                System.out.println(e);
            }
        }
    */


    /**
     * Permet d"afficher la carte
     * @param dungeon   Le dongeon a afficher
     * @param player    Le joueur dans le dongeon
     */
    public static void showMap(Dungeon dungeon, Player player){
        DiscoveryMap discoveryMap = dungeon.getDiscoveryMap();
        
        //Première ligne du cadre de la map
        String toPrint = "╔";
        for (int i = 0; i < dungeon.getDimension(); i++)
            toPrint += "══";
        toPrint += "╗\n";

        //La map
        for (int i=0; i < dungeon.getDimension(); i++){
            toPrint += "║";
            for (int j = 0; j < dungeon.getDimension(); j++) {
                if (i == player.x && j == player.y) {
                    toPrint += "><";
                }
                else if(discoveryMap.getDiscoveryMap()[i][j] == DiscoveryStates.DISCOVERED){
                    if (!dungeon.isCellSpaceOccupied(i,j)){
                        toPrint += "██";
                    }
                    else{
                        toPrint += "░░";
                    }
                }
                else if(discoveryMap.getDiscoveryMap()[i][j] == DiscoveryStates.UNKNOWN ){
                    if (!dungeon.isCellSpaceOccupied(i,j)){
                        toPrint += "██";
                    }
                    else{
                        toPrint += "??";
                    }
                }
                else{
                    toPrint += "  ";
                }
            }
            toPrint += "║\n";
        }

        //Dernière ligne du cadre de la map
        toPrint += "╚";
        for (int i = 0; i < dungeon.getDimension(); i++)
            toPrint += "══";
        toPrint += "╝\n";

        System.out.println(toPrint);
    }

    /**
     * Permet d'afficher un monstre
     * @param monster   Le monstrea a afficher
     */
    public static void showMonster(Monster monster){
        if (monster == null) {
            System.out.println(MonsterArt.getDeadMonster());
            System.out.println("The monster in this room has been defeated");
            return ;
        }
        Monster m = monster;
        String monsterArt = m.getMonsterArt();
        String monsterName = m.getMonsterName();

        
        System.out.println(monsterArt);
        System.out.println(monsterName + ", Lvl." + m.getMonsterlvl());
        showHPBar(m);
    }

    /**
     * Permet d'afficher la barre de vie d'une entitée
     * @param e Entitée dont l'on doit afficher la barre de vie
     */
    public static void showHPBar(Entity e){
        Integer hp = e.getHP();
        Integer maxHP = e.getMaxHP();
        
        Integer hpPercentage = (hp*100)/(maxHP);
        Integer nbChar = hpPercentage/10;
        String toPrint = "     ";
        for (int i = 0; i < nbChar; i++) {
            toPrint += "██";
        }
        for (int i=nbChar; i < 10; i++){
            toPrint += "░░";
        }
        toPrint += " " + hp + "/" + maxHP+ " HP";
        System.out.println(toPrint);
    }

    /**
     * Affichage du menu d'aide
     */
    public static void showHelp(){
        System.out.println("Valid commands :");
        System.out.println("->N : Go North");
        System.out.println("->S : Go South");
        System.out.println("->E : Go East");
        System.out.println("->W : Go West");
        System.out.println("->Map : show map");
        System.out.println("->M : Show monster in current room");
        System.out.println("->C : Engage combat with monster in current room");
        System.out.println("->T : Show your current equipement");
        System.out.println("->save : Saves the game");
        System.out.println("->load : Loads the game");
        System.out.println("->DM : Enter Dungeon Master mod");
        System.out.println("->Quit : Quit the game");
    }

    /**
     * Affichage du menu d'aide en mode DM
     */
    public static void showHelpDM(){
        System.out.println("Valid commands :");
        System.out.println("->N : Go North");
        System.out.println("->S : Go South");
        System.out.println("->E : Go East");
        System.out.println("->W : Go West");
        System.out.println("->Map : show map");
        System.out.println("->M : Show monster in current room");
        System.out.println("->Monster : Add/Change monster in the current room");
        System.out.println("->Treasure : Add/Change treasure in the current room");
        System.out.println("->Addroom : Add room at current position");
        System.out.println("->Delroom : Delete room at current position");
        System.out.println("->Quit : Quit DM mod");
    }

    /**
     * Affichage d'un trésor
     * @param t Trésor à afficher
     */
    public static void showTreasure(Treasure t){
        System.out.println(t.getArt());
        System.out.println(t.getTitle());

        if (t instanceof Weapon){
            Weapon weapon = (Weapon) t;
            System.out.println("Damage Points : "+ weapon.getDamagePoint());
        }
        else{
            Armor armor = (Armor) t;
            System.out.println("Armor Points : "+ armor.getArmorHealth()+ " / "+ armor.getArmorPoint());
        }
    }
}
