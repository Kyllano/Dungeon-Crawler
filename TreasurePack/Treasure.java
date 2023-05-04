package TreasurePack;

import java.io.Serializable;

/**
 * Classe représentant les trésor que le joueur peut ramasser
 */
public class Treasure implements Serializable{
    private static final long serialVersionUID = 1L;

    protected Integer rarity; //De 0 à 4 pour common, uncommon, rare, epic, legendary
    protected String name;
    protected String art;

    /**
     * Constructeur de classe
     * @param name      Nom du trésor
     * @param rarity    Rareté du trésor (entre 1 et 5)
     */
    public Treasure (String name, Integer rarity){
        this.name = name;
        this.art = "";
        
        //histoire que l'on n'ai pas une raretée inattendue
        if (rarity < 0) this.rarity = 0;
        else if (rarity > 4) this.rarity = 4;
        else this.rarity = rarity;
    }

    /**
     * Getter du nom du trésor
     * @return  Le nom du trésor
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter de la raretée du trésor
     * @return  La raretée du trésor
     */
    public Integer getRarity(){
        return this.rarity;
    }

    /**
     * Permet de retourner l'équivalent en chaine de caractère de la rareté (common, uncommmon ...)
     * @return  La raretée en string
     */
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

    /**
     * Permet de retourner le titre du trésor soit son nom et sa raretée
     * @return  Le titre du trésor
     */
    public String getTitle(){
        return this.getRarityString() + " "+  this.getName();
    }

    /**
     * Permet de retourner l'art ASCII du trésor
     * @return  L'art ASCII du trésor
     */
    public String getArt(){
        return this.art;
    }
}
