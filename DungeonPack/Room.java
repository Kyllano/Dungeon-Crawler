package DungeonPack;

import java.io.Serializable;
import java.util.Random;

import MonsterPack.*;
import TreasurePack.Armor;
import TreasurePack.Treasure;
import TreasurePack.Weapon;


public class Room implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer x;
    private Integer y;
    private Monster monster;
    private Treasure treasure;

    public Room(Integer coordX, Integer coordY){
        this.x = coordX;
        this.y = coordY;
        this.monster = new Monster(new Random().nextInt(3)+1);

        boolean isTreasureArmor = new Random().nextFloat() < 0.25f;
        if (isTreasureArmor)    this.treasure = new Armor();
        else                    this.treasure = new Weapon();
    }

    public Integer getx(){
        return this.x;
    }

    public Integer gety(){
        return this.y;
    }

    public Monster getMonster(){
        return this.monster;
    }

    public void setMonster(Monster monster){
        this.monster = monster;
    }

    public Treasure getTreasure(){
        return this.treasure;
    }

    public void setTreasure(Treasure t){
        this.treasure = t;
    }
}