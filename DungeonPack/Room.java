package DungeonPack;

import java.util.Random;

import MonsterPack.*;


public class Room {
    private Integer x;
    private Integer y;
    private Monster monster;

    public Room(Integer coordX, Integer coordY){
        this.x = coordX;
        this.y = coordY;
        this.monster = new Monster(new Random().nextInt(3)+1);   
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
}