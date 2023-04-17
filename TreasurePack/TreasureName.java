package TreasurePack;

import java.util.Random;

public class TreasureName {
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

    public static String getAxeType(){
        String axeType[] = {
            "short axe",
            "great axe",
            "moon axe",
            "double-edged axe"
        };
        return axeType[new Random().nextInt(axeType.length)];
    }

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
