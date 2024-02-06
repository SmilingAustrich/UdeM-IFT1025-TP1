public abstract class Character {
    private int health, maxHealth, attackPoints;
    private boolean isAlive;
    public Character( int health, int attackPoints, int maxHealth, boolean isAlive){
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPoints = attackPoints;
        this.isAlive = isAlive;
    }
    public void setHealth( int health ){
        this.health = health;
        if(this.health <= 0){
            this.setIsAlive(false); // Change the state of the character's life to false
        }
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public void setAttackPoints(int attackPoints){
        this.attackPoints = attackPoints;
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
    public int getAttackPoints(){
        return this.attackPoints;
    }
    public boolean IsAlive(){
        return this.isAlive;
    }
    abstract void receiveDamage(int attackPoints);
}
