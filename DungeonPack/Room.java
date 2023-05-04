package DungeonPack;

import java.io.Serializable;
import java.util.Random;

import MonsterPack.*;
import TreasurePack.Armor;
import TreasurePack.Treasure;
import TreasurePack.Weapon;

/**
 * Représente les salles du dongeon
 */
public class Room implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer x;
    private Integer y;
    private Monster monster;
    private Treasure treasure;

    /**
     * Constructeur de classe
     * @param coordX    Coordonnées de la salle
     * @param coordY    Coordonnées de la salle
     */
    public Room(Integer coordX, Integer coordY){
        this.x = coordX;
        this.y = coordY;
        this.monster = new Monster(new Random().nextInt(3)+1);

        boolean isTreasureArmor = new Random().nextFloat() < 0.25f;
        if (isTreasureArmor)    this.treasure = new Armor();
        else                    this.treasure = new Weapon();
    }

    /**
     * getter de la coordonnée x de la salle
     * @return
     */
    public Integer getx(){
        return this.x;
    }


    /**
     * getter de la coordonnée y de la salle
     * @return
     */
    public Integer gety(){
        return this.y;
    }

    /**
     * Getter du monstre présent dans la salle
     * @return
     */
    public Monster getMonster(){
        return this.monster;
    }

    /**
     * setter du monstre dans la salle
     * @param monster
     */
    public void setMonster(Monster monster){
        this.monster = monster;
    }

    /**
     * getter du trésor de la salle
     * @return
     */
    public Treasure getTreasure(){
        return this.treasure;
    }

    /**
     * setter du trésor de la salle
     * @param t
     */
    public void setTreasure(Treasure t){
        this.treasure = t;
    }
}