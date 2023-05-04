package DungeonPack;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Représente un dongeon (ou la carte du jeu) contenant toutes les salles
 */
public class Dungeon implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer dimension;
    private Room[][] rooms;
    private Integer maxCoverage; // la couverture en pourcentage
    private DiscoveryMap discoveryMap;
    
    /**
     * Constructeur de classe
     * @param dungeonDim La dimension du dongeon
     */
    public Dungeon(int dungeonDim){
        this.dimension = dungeonDim;
        this.rooms = new Room[dungeonDim][dungeonDim];
        this.maxCoverage = 50;
        this.discoveryMap = new DiscoveryMap(dimension);

        //Genere le dongeon
        generateDungeon();
    }

    /**
     * Permet de generer le dongeon selon un algorithme inspire du jeu "The Binding of Isaac"
     */
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
                if(Dungeon.isCoordsValid(x, y, dimension)
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

    /**
     * Permet de renvoyer s'il y a une salle a une coordonnée donnée
     * @param x Coordonnee a checker
     * @param y Coordonnee a checker
     * @return  true si il y a une salle a la coordonnée
     */
    public Boolean isCellSpaceOccupied(Integer x, Integer y){
        //renvoit True si il y a une salle, False si il y a un mur (ou du vide dans le cas de la generation)
        if (this.rooms[x][y] == null) return false;
        return true;
    }

    /**
     * Permet de revoyer le nombre de salle voisine a une coordonnée
     * @param x Coordonnée à checker
     * @param y Coordonnée à checker
     * @return  Le nombre de salle voisine
     */
    private Integer getNumberOfNeighbor(Integer x, Integer y){
        Integer numOfNeighbor = 0;
        Integer[][] directions =  {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int i = 0; i < directions.length; i++){
            Integer dx = x + directions[i][0];
            Integer dy = y + directions[i][1];
            if (Dungeon.isCoordsValid(dx, dy, dimension) && isCellSpaceOccupied(dx, dy)){
                numOfNeighbor ++;
            }
        }
        return numOfNeighbor;
    }

    /**
     * Permet de vérifier si une coordonnée fait parti du dongeon
     * @param x         Coordonnée a vérifier
     * @param y         Coordonnée a vérifier
     * @param dimension Dimension du dongeon
     * @return          true si la coordonnée fait parti du dongeon
     */
    public static Boolean isCoordsValid(Integer x, Integer y, Integer dimension){
        if (x < 0 || x >= dimension) return false;
        if (y < 0 || y >= dimension) return false;
        return true;
    }

    /**
     * getter pour le dongeon
     * @return
     */
    public Room[][] getRooms(){
        return this.rooms;
    }

    /**
     * Permet de modifier la couverture en pourcentage de salle du dongeon
     * @param newMaxCoverage
     */
    public void setMaxCoverage(Integer newMaxCoverage){
        if (newMaxCoverage < 0 || newMaxCoverage > 100){
            System.out.println("MaxCoverage est en pourcentage (entre 0 et 100)");
        }
        else{
            this.maxCoverage = newMaxCoverage;
        }
    }

    /**
     * Getter de la couverture en salle du dongeon
     * @return rooms
     */
    public Integer getMaxCoverage(){
        return this.maxCoverage;
    }

    /**
     * Getter de la dimension du dongeon
     * @return dimension
     */
    public Integer getDimension(){
        return this.dimension;
    }

    /**
     * getter de la discovery map du dongeon
     * @return discoveryMap
     */
    public DiscoveryMap getDiscoveryMap(){
        return this.discoveryMap;
    }

    /**
     * setter de la discovery map du dongeon
     * @param discoveryMap
     */
    public void setDiscoveryMap(DiscoveryMap discoveryMap){
        this.discoveryMap = discoveryMap;
    }
}
