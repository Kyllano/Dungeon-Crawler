import GamePack.Game;
import GamePack.IHM;

public class generation {
    public static void main(String[] args) {
        Game game = new Game(20);
        
        Boolean cond = true;
        String userInput = "";
        //IHM.showMap(game.getDungeon(), game.getPlayer());
        IHM ihm = game.ihm;
        
        
        while (cond){
            userInput = ihm.input();

            switch (userInput) {
                case "N":
                    System.out.println("Going North!");
                    game.movePlayerNorth();
                    break;
                case "S":
                    System.out.println("Going South!");
                    game.movePlayerSouth();
                    break;
                case "E":
                    System.out.println("Going East!");
                    game.movePlayerEast();
                    break;
                case "W":
                    System.out.println("Going West!");
                    game.movePlayerWest();
                    break;
                case "quit":
                    cond = false;
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