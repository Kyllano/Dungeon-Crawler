import GamePack.DM;
import GamePack.Game;
import GamePack.IHM;
import GamePack.Save;

/**
 * Programme principale a lancer pour lancer le jeu
 */
public class Main {
    public static void main(String[] args) {
        
        Game game = new Game(20);
        game.StartGame();

        String userInput = "";
        IHM ihm = game.ihm;
        
        System.out.print(">");
        while (!userInput.equalsIgnoreCase("quit") && ! game.isGameOver()){
            userInput = ihm.input();
            

            switch (userInput.toUpperCase()) {
                case "HELP" :
                    IHM.showHelp();
                    break;
                case "N":
                    System.out.println("Going North!");
                    System.out.println("Current position :");
                    game.movePlayerNorth();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "S":
                    System.out.println("Going South!");
                    System.out.println("Current position :");
                    game.movePlayerSouth();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "E":
                    System.out.println("Going East!");
                    System.out.println("Current position :");
                    game.movePlayerEast();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "W":
                    System.out.println("Going West!");
                    System.out.println("Current position :");
                    game.movePlayerWest();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "C":
                    System.out.println("Engagine combat !");
                    game.getPlayer().EngageCombat(game.getCurrentRoomMonster(), game.ihm);
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
                case "SAVE":
                    Save.saveGameIHM(ihm, game);
                    break;
                case "LOAD":
                    game = Save.loadGameIHM(ihm);
                    break;
                case "DM" :
                    DM.askDM(game);
                    break;
                case "QUIT" :
                    break;
                default :
                    System.out.println("Invalid input command, use \"help\"");
            }
            System.out.print(">");

        }
    }
}
