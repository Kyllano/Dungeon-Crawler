package GamePack;

import java.io.Serializable;


/**
 * Représente une entité vivante (Monstre ou Joueur)
 */
public class Entity implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer hp;
    private Integer maxHp;

    /**
     * Constructeur de classe vide pour la sauvegarde
     */
    public Entity(){

    }

    /**
     * Constructeur de classe
     * @param maxHp Nombre de point de vie de l'entitée
     */
    public Entity(Integer maxHp){
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    /**
     * Permet à l'entitée de prendre un certain nombre de dégat
     * @param damageValue   Nombre de dégat à prendre
     */
    public void TakeDamage(Integer damageValue){
        this.hp -= damageValue;
        if (this.hp <0) this.hp = 0;
    }

    /**
     * Permet de healer l'entitée
     */
    public void fullHeal(){
        this.hp = this.maxHp;
    }

    /**
     * Permet de retourner le nombre d'HP restant de l'entitée
     */
    public Integer getHP(){
        return this.hp;
    }

    /**
     * Permet de retourner le nombre d'HP maximum de l'entitée
     * @return
     */
    public Integer getMaxHP(){
        return this.maxHp;
    }

    /**
     * Permet de modifier le nombre d'HP maximum de l'entité
     * @param newMaxHP
     */
    public void setMaxHP(int newMaxHP){
        this.maxHp = newMaxHP;
    }
}
