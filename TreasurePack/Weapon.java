package TreasurePack;

import java.util.Random;

public class Weapon extends Treasure{
    enum WeaponType {
        BOW,
        SWORD,
        AXE,
        GUN
    }
    
    private Integer damagePoint;
    private WeaponType weaponType;

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

    public Integer getDamagePoint(){
        return this.damagePoint;
    }
    
}
