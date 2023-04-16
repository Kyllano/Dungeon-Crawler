package MonsterPack;

import java.util.Random;

import GamePack.Entity;

public class Monster extends Entity{
    enum MonsterType {
        SKELETON,
        ZOMBIE,
        DRAGON,
        CRAB,
        WOLF,
        FROG
    }

    private Integer lvl;
    private MonsterType monsterType;
    private String name;
    private String art;

    public Monster(Integer lvl){
        super(lvl*5 + (new Random().nextInt(2*lvl)-lvl));
        this.lvl = lvl;
        this.monsterType = MonsterType.values()[new Random().nextInt(MonsterType.values().length)];

        String monsterTypeStr;
        switch (this.monsterType) {
            case SKELETON:
                monsterTypeStr = "Skeleton";
                this.art = MonsterArt.getSkeletonArt();
                break;
            case ZOMBIE:
                monsterTypeStr = "Zombie";
                this.art = MonsterArt.getZombieArt();
                break;
            case DRAGON:
                monsterTypeStr = "Dragon";
                this.art = MonsterArt.getDragonArt();
                break;
            case CRAB:
                monsterTypeStr = "Crab";
                this.art = MonsterArt.getCrabArt();
                break;
            case WOLF:
                monsterTypeStr = "Wolf";
                this.art = MonsterArt.getWolfArt();
                break;
            case FROG:
                monsterTypeStr = "Slime";
                this.art = MonsterArt.getSlimeArt();
                break;
            default:
                monsterTypeStr = "Unknown";
                this.art = "???";
                break;
        }

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
}
