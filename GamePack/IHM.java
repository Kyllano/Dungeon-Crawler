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

public class IHM{

    Scanner s;

    public IHM(){
        super();
        this.s = new Scanner(System.in);
    }

    public String input(){
        return s.nextLine();
    }

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
