public abstract class Character {
    private int health, maxHealth, attackPoint;
    private boolean isAlive;

    public Character( int health, int attackPoint, int maxHealth, boolean isAlive){
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPoint = attackPoint;
        this.isAlive = isAlive;
    }
    public void setHealth( int health ){
        this.health = health;
        if(this.health <= 0){
            this.setIsAlive(false);
        }
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public void setAttackPoint(int attackPoint){
        this.attackPoint = attackPoint;
    }
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
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
    public boolean IsAlive(){
        return this.isAlive;
    }
    abstract void receiveDamage(int attackPoints);
}
