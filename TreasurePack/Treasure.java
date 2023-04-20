package TreasurePack;

import java.io.Serializable;

public class Treasure implements Serializable{
    private static final long serialVersionUID = 1L;

    protected Integer rarity; //De 0 à 4 pour common, uncommon, rare, epic, legendary
    protected String name;
    protected String art;

    public Treasure (String name, Integer rarity){
        this.name = name;
        this.art = "";
        
        //histoire que l'on n'ai pas une raretée inattendue
        if (rarity < 0) this.rarity = 0;
        else if (rarity > 4) this.rarity = 4;
        else this.rarity = rarity;
    }

    public String getName(){
        return this.name;
    }

    public Integer getRarity(){
        return this.rarity;
    }

    public String getRarityString(){
        String[] rarities = {
            "common",
            "uncommon",
            "rare",
            "epic",
            "legendary"
        };

        return rarities[this.rarity];
    }

    // le titre du trésor est son nom et sa raretée
    public String getTitle(){
        return this.getRarityString() + " "+  this.getName();
    }

    public String getArt(){
        return this.art;
    }
}
