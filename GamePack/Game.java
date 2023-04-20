package GamePack;

import java.io.Serializable;

import DungeonPack.Dungeon;
import DungeonPack.DungeonUtils;
import MonsterPack.Monster;
import DungeonPack.Room;

public class Game implements Serializable{
    private static final long serialVersionUID = 1L;

    private Player player;
    private Dungeon dungeon;
    public transient IHM ihm;
    public Boolean gameOver;

    public Game(Integer dungeonDimension){
        super();
        this.dungeon = new Dungeon(dungeonDimension);
        this.player = new Player(dungeonDimension/2, dungeonDimension/2, this);
        this.dungeon.getDiscoveryMap().setRoomDiscovered(dungeonDimension/2, dungeonDimension/2);
        this.ihm = new IHM();
        this.gameOver = false;
    }

    public void GameOver(Monster m){
        System.out.println(GameArt.getDeathArt());
        this.gameOver = true;
        System.out.println("You have been defeated by "+m.getMonsterName());
        System.out.println("You won " + player.getFightWon() + " fights in this run");
        System.out.println("Better luck next run soldier!");
    }

    public void movePlayerNorth(){
        if (!DungeonUtils.isCoordsValid(player.x-1, player.y, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x-1, player.y)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x-1, player.y);
            player.x -= 1;
        }
    }

    public void movePlayerSouth(){
        if (!DungeonUtils.isCoordsValid(player.x+1, player.y, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x+1, player.y)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x+1, player.y);
            player.x += 1;
        }
    }

    public void movePlayerWest(){
        if (!DungeonUtils.isCoordsValid(player.x, player.y-1, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x, player.y-1)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x, player.y-1);
            player.y -= 1;
        }
    }

    public void movePlayerEast(){
        if (!DungeonUtils.isCoordsValid(player.x, player.y+1, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x, player.y+1)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x, player.y+1);
            player.y += 1;
        }
    }

    public Monster getCurrentRoomMonster(){
        return this.dungeon.getRooms()[this.player.x][this.player.y].getMonster();
    }
    
    public Room getCurrentRoom(){
        return this.dungeon.getRooms()[this.player.x][this.player.y];
    }   

    public Player getPlayer(){
        return this.player;
    }

    public Dungeon getDungeon(){
        return this.dungeon;
    }

    public Boolean isGameOver(){
        return this.gameOver;
    }
}
