package GamePack;

public class Entity {
    private Integer hp;
    private Integer maxHp;

    public Entity(Integer maxHp){
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public void TakeDamage(Integer damageValue){
        this.hp -= damageValue;
        if (this.hp <0) this.hp = 0;
    }

    public void fullHeal(){
        this.hp = this.maxHp;
    }

    public Integer getHP(){
        return this.hp;
    }

    public Integer getMaxHP(){
        return this.maxHp;
    }
}
