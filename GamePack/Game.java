package GamePack;

import java.io.Serializable;

import DungeonPack.Dungeon;
import MonsterPack.Monster;
import DungeonPack.Room;

/**
 * Classe permettant de contenir le jeu (dongeon, joueur, ihm etc.)
 */
public class Game implements Serializable{
    private static final long serialVersionUID = 1L;

    private Player player;
    private Dungeon dungeon;
    public transient IHM ihm;
    public Boolean gameOver;

    /**
     * constructeur de la classe
     * @param dungeonDimension  Taille du dongeon
     */
    public Game(Integer dungeonDimension){
        super();
        this.dungeon = new Dungeon(dungeonDimension);
        this.player = new Player(dungeonDimension/2, dungeonDimension/2, this);
        this.dungeon.getDiscoveryMap().setRoomDiscovered(dungeonDimension/2, dungeonDimension/2);
        this.ihm = new IHM();
        this.gameOver = false;
    }

    /**
     * Permet d'afficher l'écran de début de jeu
     */
    public void StartGame(){
        System.out.println(GameArt.getKnightArt());
        System.out.println("Welcome to Dungeon Crawler, you wake up, naked, ready to take on the world with your fists and with a dream of surviving from this dungeon");
        System.out.println("This is your curent location :");
        IHM.showMap(this.getDungeon(), this.getPlayer());
        System.out.println("you can type \'help\' if you do not know where to start");
    }

    /**
     * Permet de lancer la fin de la partie et d'afficher l'écran de mort
     * @param m Monstre qui a tué le joueur
     */
    public void GameOver(Monster m){
        System.out.println(GameArt.getDeathArt());
        this.gameOver = true;
        System.out.println("You have been defeated by "+m.getMonsterName());
        System.out.println("You won " + player.getFightWon() + " fights in this run");
        System.out.println("Better luck next run soldier!");
    }

    /**
     * Permet de déplacer le joueur vers la salle nord si elle est présente
     */
    public void movePlayerNorth(){
        if (!Dungeon.isCoordsValid(player.x-1, player.y, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x-1, player.y)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x-1, player.y);
            player.x -= 1;
        }
    }

    /**
     * Permet de déplacer le joueur vers la salle sud si elle est présente
     */
    public void movePlayerSouth(){
        if (!Dungeon.isCoordsValid(player.x+1, player.y, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x+1, player.y)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x+1, player.y);
            player.x += 1;
        }
    }

    /**
     * Permet de déplacer le joueur vers la salle ouest si elle est présente
     */
    public void movePlayerWest(){
        if (!Dungeon.isCoordsValid(player.x, player.y-1, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x, player.y-1)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x, player.y-1);
            player.y -= 1;
        }
    }

    /**
     * Permet de déplacer le joueur vers la salle est si elle est présente
     */
    public void movePlayerEast(){
        if (!Dungeon.isCoordsValid(player.x, player.y+1, dungeon.getDimension())){
            return;
        }
        if (dungeon.isCellSpaceOccupied(player.x, player.y+1)){
            dungeon.getDiscoveryMap().setRoomDiscovered(player.x, player.y+1);
            player.y += 1;
        }
    }

    /**
     * Permet de déplacer le joueur en mode DM vers le nord
     */
    public void moveDMNorth(){
        if (!Dungeon.isCoordsValid(player.x-1, player.y, dungeon.getDimension())){
            return;
        }
        player.x -= 1;
    }

    /**
     * Permet de déplacer le joueur en mode DM vers le sud
     */
    public void moveDMSouth(){
        if (!Dungeon.isCoordsValid(player.x+1, player.y, dungeon.getDimension())){
            return;
        }
        player.x += 1;
    }

    /**
     * Permet de déplacer le joueur en mode DM vers l'ouest
     */
    public void moveDMWest(){
        if (!Dungeon.isCoordsValid(player.x, player.y-1, dungeon.getDimension())){
            return;
        }
        player.y -= 1;
    }

    /**
     * Permet de déplacer le joueur en mode DM vers l'est
     */
    public void moveDMEast(){
        if (!Dungeon.isCoordsValid(player.x, player.y+1, dungeon.getDimension())){
            return;
        }
        player.y += 1;
    }

    /**
     * getter du monstre de la salle dans laquelle le joueur est présent
     * @return
     */
    public Monster getCurrentRoomMonster(){
        return this.dungeon.getRooms()[this.player.x][this.player.y].getMonster();
    }
    
    /**
     * getter de la salle dans laquelle le joueur est présent
     * @return
     */
    public Room getCurrentRoom(){
        return this.dungeon.getRooms()[this.player.x][this.player.y];
    }   

    /**
     * getter du joueur
     * @return
     */
    public Player getPlayer(){
        return this.player;
    }

    /**
     * Getter du dongeon
     * @return
     */
    public Dungeon getDungeon(){
        return this.dungeon;
    }

    /**
     * Getter de l'état du jeu (game over ou non?)
     * @return
     */
    public Boolean isGameOver(){
        return this.gameOver;
    }
}
