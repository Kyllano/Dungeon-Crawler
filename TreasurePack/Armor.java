package TreasurePack;

import java.util.Random;

/**
 * Classe représentant les armures que le personnage portera
 */
public class Armor extends Treasure{

    Integer armorPoint;
    Integer armorHealth;

    /**
     * Constructeur de classe
     */
    public Armor(){
        super(null, 0);
        Integer rarityRoll = new Random().nextInt(100);
        if (rarityRoll < 40)        this.rarity = 0;
        else if (rarityRoll < 65)   this.rarity = 1;
        else if (rarityRoll < 82)   this.rarity = 2;
        else if (rarityRoll < 92)   this.rarity = 3;
        else                        this.rarity = 4;

        //les points d'armures sont égaux a la rareté*2 + un roll qui va de -rareté à + rareté
        this.armorPoint = (this.rarity+1)*2 + new Random().nextInt(2*(this.rarity)+1) - this.rarity;
        this.armorHealth = armorPoint;
        
        this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getArmorType();
        this.art = TreasureArt.getArmorArt();
    }

    /**
     * Constructeur de classe, mais avec une raretée prédéfinie (entre 1 et 5)
     * @param rarity    Raretée de l'armure
     */
    public Armor(Integer rarity){
        super(null, rarity);
        this.armorPoint = (this.rarity+1) + new Random().nextInt(2*(this.rarity)+1) - this.rarity;
        this.armorHealth = armorPoint;
        
        this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getArmorType();
    }

    /**
     * Permet a l'armure de prendre des dégats
     * @param damage    Le nombre de dégat que l'armure prend
     * @return          un nombre négatif si le joueur ne doit pas prendre de dégat, sinon le nombre de dégat que le joueur doit prendre
     */
    public Integer takeDamage(Integer damage){
        this.armorHealth -= damage;
        if (this.armorHealth <= 0){
            System.out.println("Your armor takes "+ (damage + this.armorHealth)+ " damages");
            System.out.println("The "+ this.name + " has broken!");
            return this.armorHealth * (-1); //On est sur que la vie de l'armure est négative, on renvoie donc le nombre de point de vie que le joueur doit perdre en positif
        }
        System.out.println("You armor absorb all of the "+ damage +" damage !");
        return -1; // si le joueur ne doit pas prendre de dégat, on peut renvoyer -1
    }

    /**
     * Permet de réparer l'armure
     */
    public void repair(){
        this.armorHealth = this.armorPoint;
    }

    /**
     * Getter des points d'armure maximaux
     * @return  Les points d'armure maximaux
     */
    public Integer getArmorPoint(){
        return this.armorPoint;
    }

    /**
     * Getter des points d'armure restants
     * @return  Les points d'armures restants
     */
    public Integer getArmorHealth(){
        return this.armorHealth;
    }


}
