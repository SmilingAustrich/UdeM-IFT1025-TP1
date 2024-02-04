public abstract class Character {
    private int health, maxHealth, attackPoint;

    public Character( int health, int maxHealth, int attackPoint){
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPoint = attackPoint;
    }

    public void setHealth( int health ){
        this.health = health;
    }
    public void setMaxHealth( int maxHealth ){
        this.maxHealth = maxHealth;
    }

    public void setAttackPoint( int attackPoint ){
        this.attackPoint = attackPoint;
    }

    public int getHealth(){
        return this.health;
    }
    public int getMaxHealth(){
        return this.maxHealth;
    }
    public int getAttackPoint(){
        return this.attackPoint;
    }

    abstract void attack(Character character); // method to attack characters in general
    static void fight(Character characterOne, Character characterTwo){

    };
}
