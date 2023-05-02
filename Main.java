import GamePack.DM;
import GamePack.Game;
import GamePack.GameArt;
import GamePack.IHM;
import GamePack.Save;

public class Main {
    public static void main(String[] args) {
        System.out.println(GameArt.getKnightArt());
        Game game = new Game(20);

        String userInput = "";
        IHM ihm = game.ihm;
        IHM.showMap(game.getDungeon(), game.getPlayer());
        
        System.out.print(">");
        while (!userInput.equals("quit") && ! game.isGameOver()){
            userInput = ihm.input();
            

            switch (userInput) {

                case "N":
                    System.out.println("Going North!");
                    game.movePlayerNorth();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "S":
                    System.out.println("Going South!");
                    game.movePlayerSouth();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "E":
                    System.out.println("Going East!");
                    game.movePlayerEast();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "W":
                    System.out.println("Going West!");
                    game.movePlayerWest();
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "C":
                    System.out.println("Engagine combat !");
                    game.getPlayer().EngageCombat(game.getCurrentRoomMonster(), game.ihm);
                    break;
                case "show":
                    System.out.println("Showing monster in current Room");
                    IHM.showMonster(game.getCurrentRoomMonster());
                    break;
                case "map":
                    IHM.showMap(game.getDungeon(), game.getPlayer());
                    break;
                case "T":
                    game.getPlayer().showEquipement();
                    break;
                case "heal":
                    System.out.println("You heal");
                    game.getPlayer().fullHeal();
                    break;
                case "save":
                    Save.saveGameIHM(ihm, game);
                    break;
                case "load":
                    game = Save.loadGameIHM(ihm);
                    break;
                case "DM" :
                    DM.askDM(game);
                    break;
            }
            System.out.print(">");

        }
    }
}
