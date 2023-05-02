package MonsterPack;

import java.util.Random;

import GamePack.Entity;

public class Monster extends Entity{
    public enum MonsterType {
        SKELETON,
        ZOMBIE,
        DRAGON,
        CRAB,
        WOLF,
        SLIME
    }

    private Integer lvl;
    private MonsterType monsterType;
    private String name;
    private String art;

    public Monster(){
        
    }

    public Monster(Integer lvl, MonsterType monsterType){
        super(lvl*5 + (new Random().nextInt(2*lvl)-lvl));
        this.lvl = lvl;
        this.monsterType = monsterType;
        String monsterTypeStr;
        switch (this.monsterType) {
            case SKELETON:
                this.art = MonsterArt.getSkeletonArt();
                break;
            case ZOMBIE:
                this.art = MonsterArt.getZombieArt();
                break;
            case DRAGON:
                this.art = MonsterArt.getDragonArt();
                break;
            case CRAB:
                this.art = MonsterArt.getCrabArt();
                break;
            case WOLF:
                this.art = MonsterArt.getWolfArt();
                break;
            case SLIME:
                this.art = MonsterArt.getSlimeArt();
                break;
            default:
                monsterTypeStr = "Unknown";
                this.art = "???";
                break;
            }   
        monsterTypeStr = monsterType.name().substring(0, 1).toUpperCase() + monsterType.name().substring(1);

        this.name = MonsterName.RandomMonsterNickname() + ", The "+ MonsterName.RandomMonsterAdjective() + " " + monsterTypeStr;
    }

    public Monster(Integer lvl){
        super(lvl*5 + (new Random().nextInt(2*lvl)-lvl));
        this.lvl = lvl;
        this.monsterType = MonsterType.values()[new Random().nextInt(MonsterType.values().length)];

        String monsterTypeStr;
        switch (this.monsterType) {
            case SKELETON:
                this.art = MonsterArt.getSkeletonArt();
                break;
            case ZOMBIE:
                this.art = MonsterArt.getZombieArt();
                break;
            case DRAGON:
                this.art = MonsterArt.getDragonArt();
                break;
            case CRAB:
                this.art = MonsterArt.getCrabArt();
                break;
            case WOLF:
                this.art = MonsterArt.getWolfArt();
                break;
            case SLIME:
                this.art = MonsterArt.getSlimeArt();
                break;
            default:
                monsterTypeStr = "Unknown";
                this.art = "???";
                break;
            }   
        monsterTypeStr = monsterType.name().substring(0, 1).toUpperCase() + monsterType.name().substring(1);

        this.name = MonsterName.RandomMonsterNickname() + ", The "+ MonsterName.RandomMonsterAdjective() + " " + monsterTypeStr;
    }

    public String getMonsterArt(){
        return this.art;
    }

    public String getMonsterName(){
        return this.name;
    }

    public Integer getMonsterlvl(){
        return this.lvl;
    }

    public Integer rollDamage(){
        Random r = new Random();
        Integer damage = (r.nextInt(lvl)+1) * lvl;
        return damage;
    }

    public MonsterType getMonsterType(){
        return this.monsterType;
    }
}
