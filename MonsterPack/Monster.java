package MonsterPack;

import java.util.Random;

import GamePack.Entity;

/**
 * Classe représentant les monstre que l'utilisateur pourra combattre
 */
public class Monster extends Entity{
    /**
     * Enum permettant d'avoir multiple type de mosntre
     */
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

    /**
     * Constructeur de classe vide pour pouvoir charger la partie
     */
    public Monster(){
        
    }

    /**
     * Constructeur de classe
     * @param lvl           Niveau du monstre (ne pouvant aller que de 1 a 3 en réalité)
     * @param monsterType   Type de monstre parmis l'enum MonsterType
     */
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

    /**
     * Constructeur de classe prenant seulement le niveau et attribut un type de mosntre aléatoire
     * @param lvl   Niveau du monstre (1 -> 3)
     */
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

    /**
     * Getter de l'art ASCII du monstre
     * @return  art ASCII du monstre
     */
    public String getMonsterArt(){
        return this.art;
    }

    /**
     * Getter du nom du monstre
     * @return  Le nom du monstre
     */
    public String getMonsterName(){
        return this.name;
    }

    /**
     * gettern du niveau du monstre
     * @return  Le niveau du monstre
     */
    public Integer getMonsterlvl(){
        return this.lvl;
    }

    /**
     * Permet au monstre de faire un jet de dégât
     * @return  Les dégats infligés par le monstre
     */
    public Integer rollDamage(){
        Random r = new Random();
        Integer damage = (r.nextInt(lvl)+1) * lvl;
        return damage;
    }

    /**
     * Getter du type de monstre
     * @return  Le type de monstre
     */
    public MonsterType getMonsterType(){
        return this.monsterType;
    }
}
