package GamePack;

import DungeonPack.DiscoveryMap;
import DungeonPack.Room;
import DungeonPack.DiscoveryMap.DiscoveryStates;
import MonsterPack.Monster;
import MonsterPack.Monster.MonsterType;
import TreasurePack.Armor;
import TreasurePack.Treasure;
import TreasurePack.Weapon;
import TreasurePack.Weapon.WeaponType;

/**
 * Classe qui contient uniquement des fonctions statiques permettant de passer en mode Dungeon Master
 */
public class DM {
    
    /**
     * Boucle principale du mod DM, permet de prendre l'input de l'utilisateur et d'appeler les fonctions correspondantes à chaque input
     * @param game
     */
    public static void askDM(Game game){
        String userInput = "";
        IHM ihm = game.ihm;

        //save player info
        int playerPosX = game.getPlayer().x;
        int playerPosY = game.getPlayer().y;
        DiscoveryMap playerDiscoverymap = game.getDungeon().getDiscoveryMap();

        //On découvre la map
        DiscoveryMap discoveryMap = new DiscoveryMap(game.getDungeon().getDimension());
        for (int i = 0; i < game.getDungeon().getDimension(); i++) {
            for (int j = 0; j < game.getDungeon().getDimension(); j++) {
                discoveryMap.getDiscoveryMap()[i][j] = DiscoveryStates.DISCOVERED;
            }
        }
        game.getDungeon().setDiscoveryMap(discoveryMap);
        

        System.out.println("Entering Dungeon Master mod");
        System.out.print("DM>");

        while (!userInput.equalsIgnoreCase("quit")){
            userInput = ihm.input();

            switch (userInput.toUpperCase()) {
                case "HELP":
                    IHM.showHelpDM();
                    break;
                case "N":
                    System.out.println("Going North!");
                    game.moveDMNorth();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "S":
                    System.out.println("Going South!");
                    game.moveDMSouth();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "E":
                    System.out.println("Going East!");
                    game.moveDMEast();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "W":
                    System.out.println("Going West!");
                    game.moveDMWest();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "M":
                    System.out.println("Showing monster in current Room");
                    IHM.showMonster(game.getCurrentRoomMonster());
                    break;
                case "MAP":
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "T":
                    game.getPlayer().showEquipement();
                    break;
                case "MONSTER" :
                    if (game.getCurrentRoom() != null){
                        addMonster(game, ihm);
                        System.out.println("Monster placed into this room");
                    }
                    else{
                        System.out.println("There is no room at this location");
                    }
                    break;
                case "TREASURE" :
                    if (game.getCurrentRoom() != null){
                        addTreasure(game, ihm);
                        System.out.println("Treasure placed into this room");
                    }
                    else{
                        System.out.println("There is no room at this location");
                    }
                    break;
                case "ADDROOM" :
                    addRoom(game);
                    break;
                case "DELROOM" :
                    deleteRoom(game);
                    break;
                case "QUIT" :
                    break;
                default :
                    System.out.println("Invalid input command, use \"help\"");
            }
            System.out.print("DM>");

        }
        System.out.println("Exiting DM mod");

        game.getPlayer().x = playerPosX;
        game.getPlayer().y = playerPosY;game.getDungeon().setDiscoveryMap(playerDiscoverymap);
    }



    /**
     * Permet configurer un monstre demandé à l'utilisateur dans la salle courante
     * @param game  L'objet jeu
     * @param ihm   L'objet IHM
     */
    private static void addMonster(Game game, IHM ihm){
        System.out.println("What will be the monster to add in the current room? (Skeleton, Zombie, Dragon, Crab, Wolf, Slime)");
        MonsterType monsterType = null;
        Boolean isMonsterTypeValid = false;

        //On choisis un type de monstre
        while (!isMonsterTypeValid){
            try {
                String userInput = ihm.input();
                monsterType = MonsterType.valueOf(userInput.toUpperCase());
                isMonsterTypeValid = true;
            }catch(Exception e){
                System.out.println("Invalid monster type (Skeleton, Zombie, Dragon, Crab, Wolf, Slime)");
            }
        }
        
        Integer level;
        System.out.println("What will be the monster level? (1 -> 3)");
        Integer userInput = ihm.inputNumber();
        while (userInput < 1 || userInput > 3) {
            System.out.println("The level of the monster must be between 1 and 3");
            userInput = ihm.inputNumber();
        }
        level = userInput;

        Monster m = new Monster(level, monsterType);
        game.getCurrentRoom().setMonster(m);

        //Aparament, y'a besoin de flush ici
        ihm.input();
    }

    /**
     * Permet de configurer un trésor demandé à l'utilisateur dans la salle courante
     * @param game  L'objet jeu
     * @param ihm   L'objet IHM
     */
    private static void addTreasure(Game game, IHM ihm){
        
        //On demande si il veut une arme ou une armure
        System.out.println("Would you like to have an armor or a weapon in this room?");
        String userInputTreasure = ihm.input();
        while (!userInputTreasure.equalsIgnoreCase("Weapon") && !userInputTreasure.equalsIgnoreCase("Armor")) {
            System.out.println("You must set an \'Armor\' or a \'Weapon\'");
            userInputTreasure = ihm.input();
        }
        
        //Si il a demandé une arme, on demande le type d'arme
        WeaponType weaponType = null;
        if (userInputTreasure.equalsIgnoreCase("weapon")){
            System.out.println("What will be the weapon to add in the current room? (Bow, Sword, Axe, Gun)");
            
            Boolean isWeaponTypeValid = false;
    
            while (!isWeaponTypeValid){
                try {
                    String userInput = ihm.input();
                    weaponType = WeaponType.valueOf(userInput.toUpperCase());
                    isWeaponTypeValid = true;
                }catch(Exception e){
                    System.out.println("Invalid treasure type (Bow, Sword, Axe, Gun)");
                }
            }
        }

        //On choisis le niveau de l'arme
        Integer rarity;
        System.out.println("What will be the rarity of the treasure? (1 -> 5)");
        Integer userInput = ihm.inputNumber();
        while (userInput < 1 || userInput > 5) {
            System.out.println("The rarity of the treasure must be between 1 and 5");
            userInput = ihm.inputNumber();
        }
        rarity = userInput-1;

        Treasure treasure;
        if (userInputTreasure.equalsIgnoreCase("weapon")){
            treasure = new Weapon(rarity, weaponType);
        }
        else{
            treasure = new Armor(rarity);
        }
        game.getCurrentRoom().setTreasure(treasure);

        //Aparament, y'a besoin de flush ici
        ihm.input();
    }

    /**
     * Permet d'ajouter une salle vide à la coordonnée courante
     * @param game
     */
    private static void addRoom (Game game){
        if (game.getCurrentRoom() == null){
            game.getDungeon().getRooms()[game.getPlayer().x][game.getPlayer().y] = new Room(game.getPlayer().x, game.getPlayer().y);
            System.out.println("Adding room at current location");
        }
        else{
            System.out.println("There is already a room at this location");
        }
    }

    /**
     * Permet de supprime la salle à la coordonnée courante
     * @param game
     */
    private static void deleteRoom (Game game){
        if (game.getCurrentRoom() != null){
            game.getDungeon().getRooms()[game.getPlayer().x][game.getPlayer().y] = null;
            System.out.println("Deleting room at current location");
        }
        else{
            System.out.println("There is already no room at this location");
        }
    }
}
