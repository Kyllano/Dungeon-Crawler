package DungeonPack;

public class DungeonUtils {

    public static Boolean isCoordsValid(Integer x, Integer y, Integer dimension){
        if (x < 0 || x >= dimension) return false;
        if (y < 0 || y >= dimension) return false;
        return true;
    }
}
