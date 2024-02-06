public class Enemy extends Character{

    private int experienceDrop;
    public Enemy(int health, int maxHealth, int attackpoint, int experienceDrop,boolean isAlive){
        super(health, maxHealth, attackpoint, isAlive);
        this.experienceDrop = experienceDrop;

    }
    public void setExperienceDrop(int experienceDrop){
        this.experienceDrop = experienceDrop;
    }
    public int getExperienceDrop(){
        return this.experienceDrop;
    }

    public void receiveDamage(int attackPoints){
        int newHealth = this.getHealth() - attackPoints;
        this.setHealth(newHealth);
    }
}
