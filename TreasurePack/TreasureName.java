package TreasurePack;

import java.util.Random;

/**
 * Classe permettant d'obtenir des noms et adjectifs pour les trésors, armes et armures
 */
public class TreasureName {
    /**
     * Permet d'obtenir un adjectif aléatoire pour un trésors
     * @return  L'adjectif du trésor
     */
    public static String getTreasureAdjective(){
        String[] adjectives ={
            "defensive",
            "golden",
            "silver",
            "copper",
            "bronze",
            "impenetrable",
            "diamond",
            "polished",
            "broken",
            "light",
            "worthy",
            "fragile",
            "unbroken",
            "medieval",
            "resplendent",
            "shiny",
            "rusty",
            "splendid",
            "knightly",
            "little",
            "tiny",
            "big",
            "humongus",
            "ponderous",
            "weighty",
            "better",
            "delicate",
            "shelly",
            "solid",
            "thin",
            "stiff",
            "glorious",
            "enchanted",
            "heavenly",
            "blood-stained",
            "flashy",
            "amazing"
        };
        return adjectives[new Random().nextInt(adjectives.length)];
    }


    /**
     * Permet d'obtenir un nom de type d'armure aléatoire
     * @return  Le type d'armure
     */
    public static String getArmorType(){
        String armorType[] = {
            "padded armor",
            "studded leather armor",
            "hide armor",
            "scale mail armor",
            "breastplate armor",
            "half plate armor",
            "ring mail armor",
            "chain mail armor",
            "splint armor"
        };
        return armorType[new Random().nextInt(armorType.length)];
    }

    /**
     * Permet d'obtenir un nom de type d'arc aléatoire
     * @return  Le type d'arc
     */
    public static String getBowType(){
        String bowType[] = {

            "great bow",
            "long bow",
            "short bow",
            "curved bow",
            "hunting bow",
            "coumpound bow",
            "yumi bow"
        };
        return bowType[new Random().nextInt(bowType.length)];
    }

    /**
     * Permet d'obtenir un nom de type d'épée aléatoire
     * @return  Le type d'épée
     */
    public static String getSwordType(){
        String swordType[] = {
            "longsword",
            "shortsword",
            "katana",
            "wakizashi",
            "broadsword",
            "greatsword"
        };
        return swordType[new Random().nextInt(swordType.length)];
    }

    /**
     * Permet d'obtenir un nom de type d'hache aléatoire
     * @return  Le type d'hache
     */
    public static String getAxeType(){
        String axeType[] = {
            "short axe",
            "great axe",
            "moon axe",
            "double-edged axe"
        };
        return axeType[new Random().nextInt(axeType.length)];
    }

    /**
     * Permet d'obtenir un nom de type de pistolet aléatoire
     * @return  Le type de pistolet
     */
    public static String getGunType(){
        String gunType[] = {
            "P2020",
            "R8 Revolver",
            "Colt 1911",
            "Glock 18",
            "Smith&Wesson 642 CT",
            "USP",
            "Barretta M9"
        };
        return gunType[new Random().nextInt(gunType.length)];
    }
}
