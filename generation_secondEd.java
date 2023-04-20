import GamePack.Game;
import GamePack.IHM;
import GamePack.Save;


public class generation_secondEd {
    public static void main(String[] args) {
        /*
         * 
         Game game = new Game(20);
         game.movePlayerNorth();
         game.movePlayerSouth();
         IHM.showMap(game.getDungeon(), game.getPlayer());
         
         Save.save(game);
        */

        Game game = Save.load("prout");

        IHM.showMap(game.getDungeon(), game.getPlayer());
        IHM.showMonster(game.getCurrentRoomMonster());
        

    }



}
