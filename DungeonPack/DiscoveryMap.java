package DungeonPack;

public class DiscoveryMap {
    public enum DiscoveryStates {
        UNDISCOVERED,   //Ne sais pas si il y a une salle ou un mur 
        UNKNOWN,        //Assez proche pour voir si c'est une salle ou un mur, mais non visité
        DISCOVERED      //On sais ce qu'il y a
    }

    private Integer dimension;
    private DiscoveryStates[][] discoveryMap;

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

    public void setRoomDiscovered(Integer x, Integer y){
        if (!DungeonUtils.isCoordsValid(x, y, this.dimension)){
            return; //coordonnees invalides
        }
        this.discoveryMap[x][y] = DiscoveryStates.DISCOVERED;

        Integer[][] directions =  {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int i = 0; i < directions.length; i++){
            Integer dx = x + directions[i][0];
            Integer dy = y + directions[i][1];
            if (DungeonUtils.isCoordsValid(dx, dy, dimension) && this.discoveryMap[dx][dy] != DiscoveryStates.DISCOVERED){
                this.discoveryMap[dx][dy] = DiscoveryStates.UNKNOWN;
            }
        }
    }

    public DiscoveryStates[][] getDiscoveryMap(){
        return this.discoveryMap;
    }
}
