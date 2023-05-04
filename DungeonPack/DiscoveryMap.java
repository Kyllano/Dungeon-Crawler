package DungeonPack;

import java.io.Serializable;


/**
 * Represente a quelle point la carte a été découverte
 * C'est une carte miroitant la carte contenant les salles et pour chaques salles donne un état parmis les suivants:
 * UNDISCOVERED
 * UNKNOWN
 * DISCOVERED
 */
public class DiscoveryMap implements Serializable{
    private static final long serialVersionUID = 1L;

    public enum DiscoveryStates {
        UNDISCOVERED,   //Ne sais pas si il y a une salle ou un mur 
        UNKNOWN,        //Assez proche pour voir si c'est une salle ou un mur, mais non visité
        DISCOVERED      //On sais ce qu'il y a
    }

    private Integer dimension;
    private DiscoveryStates[][] discoveryMap;

    /**
     * Constructeur de classe
     * @param dimension La dimension du dongeon
     */
    public DiscoveryMap(Integer dimension) {
        this.dimension = dimension;
        this.discoveryMap = new DiscoveryStates[dimension][dimension];

        //remplis la discoveryMap initiale
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.discoveryMap[i][j] = DiscoveryStates.UNDISCOVERED;
            }
        }
    }

    
    /**
     * Permet de donner l'état découvert a une salle et updater les états des salles adjascentes.
     * @param x Cooredonnées de la salle
     * @param y Cooredonnées de la salle
     */
    public void setRoomDiscovered(Integer x, Integer y){
        if (!Dungeon.isCoordsValid(x, y, this.dimension)){
            return; //coordonnees invalides
        }
        this.discoveryMap[x][y] = DiscoveryStates.DISCOVERED;

        Integer[][] directions =  {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int i = 0; i < directions.length; i++){
            Integer dx = x + directions[i][0];
            Integer dy = y + directions[i][1];
            if (Dungeon.isCoordsValid(dx, dy, dimension) && this.discoveryMap[dx][dy] != DiscoveryStates.DISCOVERED){
                this.discoveryMap[dx][dy] = DiscoveryStates.UNKNOWN;
            }
        }
    }

    /**
     * getter de la discovery map
     * @return la discovery map
     */
    public DiscoveryStates[][] getDiscoveryMap(){
        return this.discoveryMap;
    }
}
