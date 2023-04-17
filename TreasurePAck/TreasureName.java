package TreasurePAck;

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
}
