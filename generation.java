import GamePack.Game;
import GamePack.IHM;

public class generation {
    public static void main(String[] args) {
        Game game = new Game(20);

        String userInput = "";
        IHM ihm = game.ihm;
        IHM.showMap(game.getDungeon(), game.getPlayer());
        
        
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
                case "heal":
                System.out.println("You heal");
                    game.getPlayer().fullHeal();
                
            }

        }
    }
}
