package GamePack;

import java.util.Random;

import MonsterPack.Monster;

public class Player extends Entity{
    public Integer x;
    public Integer y;
    private Game game;
    private Integer fightWon;

    
    public Player(Integer startingX, Integer startingY, Game game){
        super(5);
        this.x = startingX;
        this.y = startingY;
        this.game = game;
        this.fightWon = 0;
    }

    public void EngageCombat(Monster m, IHM ihm){

        IHM.showMonster(m);
        System.out.println("\n");
        Boolean continueCombat = true;
        
        while (this.getHP() > 0 && m.getHP()> 0 && continueCombat) {

            attackTurn(m);

            if (this.getHP() > 0 && m.getHP()> 0){
                continueCombat = checkIfContinueCombat(ihm);
            }

            if (!continueCombat){
                m.fullHeal();
                this.fullHeal();
            }

            System.out.println("\n");
        }


        if (m.getHP() <= 0){
            System.out.println(GameArt.getCombatWinArt());
            System.out.println("You defeated "+m.getMonsterName()+ "!");
            System.out.println("You feel stronger and get 1 more HP");
            this.game.getCurrentRoom().setMonster(null);
            this.fightWon ++;
            this.fullHeal();
        }
        else if (this.getHP() <= 0){
            System.out.println(m.getMonsterName() + " has defeated you!");
            game.GameOver(m);
        }
        else{
            System.out.println("You successfully fled the combat. "+m.getMonsterName()+" will have time to recover its forces");
            this.fullHeal();
            m.fullHeal();
        }
    }

    private void attackTurn(Monster m){
        Boolean playerAttacks = new Random().nextBoolean();
        if (playerAttacks){
            Integer damage = this.rollDamage();
            m.TakeDamage(damage);

            System.out.println("You attack " + m.getMonsterName() + " for " + damage + " HP");
        }
        else{
            Integer damage = m.rollDamage();
            this.TakeDamage(damage);

            System.out.println(m.getMonsterName() + " attacks you for " + damage + " HP");
        }

        System.out.println("       "+ m.getMonsterName());
        IHM.showHPBar(m);
        System.out.println("                  You");
        IHM.showHPBar(this);

        System.out.println("\n");
    }

    public Integer rollDamage(){
        Integer damage = new Random().nextInt(2)+1;
        return damage;
    }

    private Boolean checkIfContinueCombat(IHM ihm){
        String action = askIfContinueCombat(ihm);
        switch (action) {
            case "R":
                System.out.println("You are fleeing the combat...");
                return false;
            case "A":
                System.out.println("You decide to keep fighting...");
                return true;
            default:
            System.out.println("Ya probleme ptdrr");
            return false;
        }
    }

    private String askIfContinueCombat(IHM ihm){
        String userInput = "";
        while (!userInput.equals("A") && !userInput.equals("R")){
            System.out.println("What action will you take? A: Attack R:Run");
            userInput = ihm.input();
        }
        return userInput;
    }

    public Integer getFightWon(){
        return this.fightWon;
    }
}