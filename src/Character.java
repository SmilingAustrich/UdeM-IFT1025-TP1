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

    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public void setAttackPoints(int attackPoint){
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
    public int getAttackPoints(){
        return this.attackPoint;
    }
    public boolean IsAlive(){
        return this.health > 0;
    }
    abstract void receiveDamage(int attackPoints);

    public static boolean fight(Hero currentHero, Enemy enemy) {


        while (currentHero.IsAlive()) { // while loop to initiate fight
            currentHero.attack(enemy);

            if (!enemy.IsAlive()) { // We check if the enemy is still alive before attacking the hero.
                break;
            }

            currentHero.receiveDamage(enemy.getAttackPoints()); // Enemy attacks the hero

            if (!currentHero.IsAlive()) { // if the hero is dead, we stop the fight and return false
                return false;
            }
        }
        currentHero.incrementKillCount(); // increment the kill counter
        currentHero.levelUp(enemy); // if we can level up, we level up!
        return true;
    }

}
