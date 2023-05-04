package TreasurePack;

import java.util.Random;

/**
 * Classe représentant une arme que le joueur pourra utiliser
 */
public class Weapon extends Treasure{

    /**
     * Enum représentant les types d'arme (arc, épée, hache et pistolet)
     */
    public enum WeaponType {
        BOW,
        SWORD,
        AXE,
        GUN
    }
    
    private Integer damagePoint;
    private WeaponType weaponType;

    /**
     * Constructeur de classe pour une arme aléatoire de raretée aléatoire
     */
    public Weapon(){
        super(null, 0);
        Integer rarityRoll = new Random().nextInt(100);
        if (rarityRoll < 40)        this.rarity = 0;
        else if (rarityRoll < 65)   this.rarity = 1;
        else if (rarityRoll < 82)   this.rarity = 2;
        else if (rarityRoll < 92)   this.rarity = 3;
        else                        this.rarity = 4;
        this.damagePoint = (this.rarity+1) + new Random().nextInt(2*(this.rarity)+1) - this.rarity;

        this.weaponType = WeaponType.values()[new Random().nextInt(WeaponType.values().length)];
        switch (this.weaponType) {
            case BOW:
                this.art = TreasureArt.getBowArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getBowType();
                break;
            case SWORD:
                this.art = TreasureArt.getSwordArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getSwordType();
                break;
            case AXE:
                this.art = TreasureArt.getAxeArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getAxeType();
                break;
            case GUN:
                this.art = TreasureArt.getGunArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getGunType();
                break;

        }
    }

    /**
     * Constructeur de classe pour une arme d'une raretée connue et de type connue
     * @param rarity        La raretée de l'arme
     * @param weaponType    Le type de l'arme
     */
    public Weapon(int rarity, WeaponType weaponType){
        super(null, rarity);
        this.damagePoint = (this.rarity+1) + new Random().nextInt(2*(this.rarity)+1) - this.rarity;
        this.weaponType = weaponType;
        switch (this.weaponType) {
            case BOW:
                this.art = TreasureArt.getBowArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getBowType();
                break;
            case SWORD:
                this.art = TreasureArt.getSwordArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getSwordType();
                break;
            case AXE:
                this.art = TreasureArt.getAxeArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getAxeType();
                break;
            case GUN:
                this.art = TreasureArt.getGunArt();
                this.name = TreasureName.getTreasureAdjective() + " " + TreasureName.getGunType();
                break;
        }
    }

    /**
     * Getter des points de dégat causé par l'arme
     * @return
     */
    public Integer getDamagePoint(){
        return this.damagePoint;
    }
    
}
