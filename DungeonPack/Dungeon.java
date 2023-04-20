package DungeonPack;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Dungeon implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer dimension;
    private Room[][] rooms;
    private Integer maxCoverage; // la couverture en pourcentage
    private DiscoveryMap discoveryMap;
    
    public Dungeon(int dungeonDim){
        this.dimension = dungeonDim;
        this.rooms = new Room[dungeonDim][dungeonDim];
        this.maxCoverage = 50;
        this.discoveryMap = new DiscoveryMap(dimension);

        //Genere le dongeon
        generateDungeon();
    }

    private void generateDungeon(){
        //remplissons d'abord le dungeon de null au cas où Java ne le fais pas déjà (ça coute rien)
        for (int i = 0; i < this.dimension; i++){
            for (int j = 0; j < this.dimension; j++){
                this.rooms[i][j] = null;
            }
        }

        //Plaçons ensuite la premère salle au centre
        Integer centerRoomX = this.dimension/2;
        Integer centerRoomY = this.dimension/2; 
        Room centerRoom = new Room(centerRoomX,centerRoomY);
        this.rooms[centerRoomX][centerRoomY] = centerRoom;

        //Remplissons les paramètres de nombre de salles
        Integer nbRooms = 1;
        Integer neededNbRooms = (this.dimension*this.dimension)*maxCoverage/100;
        //La génération utilisera une Queue
        Queue<Room> roomsQueue = new LinkedList<Room>();
        roomsQueue.add(centerRoom);


        //Plaçons les salles selon mon algorithme (inspiré d'Isaac :3)
        //Le coverage est a plus ou moins 4 salles. C'est pas vraiment un problème donc meh ¯\_(ツ)_/¯
        while((!roomsQueue.isEmpty()) && (nbRooms < neededNbRooms)){
            Room placedRoom = roomsQueue.remove();
            // On itère selon les 4 cardinalités de la salle déjà placé
            Integer[][] directions =  {{0,-1}, {0,1}, {-1,0}, {1,0}};
            for (int i = 0; i < directions.length; i++){
                Integer x = placedRoom.getx() + directions[i][0];
                Integer y = placedRoom.gety() + directions[i][1];

                //Si l'espace n'est pas occupé et est valide et cet espace a un autre voisin
                //Et si l'espace libre n'a pas de voisin (sans compter la salle que l'on vient d'extraire de la queue)
                //Et une chance de 10% de juste abandonner et ne pas placer la salle
                if(DungeonUtils.isCoordsValid(x, y, dimension)
                && !isCellSpaceOccupied(x, y)
                && getNumberOfNeighbor(x, y) <= 1
                && Math.random() > 0.1){
                    Room newRoom = new Room(x, y);
                    this.rooms[x][y] = newRoom;
                    nbRooms ++;
                    roomsQueue.add(newRoom);
                }
            }
        }
    }

    //renvoit True si il y a une salle, False si il y a un mur (ou du vide dans le cas de la generation)
    public Boolean isCellSpaceOccupied(Integer x, Integer y){
        if (this.rooms[x][y] == null) return false;
        return true;
    }

    private Integer getNumberOfNeighbor(Integer x, Integer y){
        Integer numOfNeighbor = 0;
        Integer[][] directions =  {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int i = 0; i < directions.length; i++){
            Integer dx = x + directions[i][0];
            Integer dy = y + directions[i][1];
            if (DungeonUtils.isCoordsValid(dx, dy, dimension) && isCellSpaceOccupied(dx, dy)){
                numOfNeighbor ++;
            }
        }
        return numOfNeighbor;
    }

    public Room[][] getRooms(){
        return this.rooms;
    }

    public void setMaxCoverage(Integer newMaxCoverage){
        if (newMaxCoverage < 0 || newMaxCoverage > 100){
            System.out.println("MaxCoverage est en pourcentage (entre 0 et 100)");
        }
        else{
            this.maxCoverage = newMaxCoverage;
        }
    }

    public Integer getMaxCoverage(){
        return this.maxCoverage;
    }

    public Integer getDimension(){
        return this.dimension;
    }

    public DiscoveryMap getDiscoveryMap(){
        return this.discoveryMap;
    }
}
