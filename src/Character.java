public abstract class Character {
    private int health, maxHealth, attackPoint;
    private boolean isAlive;

    public Character( int health, int attackPoint, int maxHealth, boolean isAlive){
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPoint = attackPoint;
        this.isAlive = isAlive;
    }
    // Getters and setters for the instance variables.
    public void setHealth( int health ){ this.health = health; }
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
    // this is a method that returns a boolean, indicating the state of the Character's life.
    public boolean isAlive(){
        if(this.health <= 0){
            this.setIsAlive(false); // Update the state of the character if he is dead.

        }
        return this.health > 0;
    }

    /**
     * Inflicts damage to the character.
     * The amount of damage inflicted depends on the type of character.
     * @param attackPoints the amount of damage to be inflicted
     */
    abstract void receiveDamage(int attackPoints);

    /**
     * Static method to initiate a fight between a hero and an enemy.
     * @param currentHero the hero that is fighting.
     * @param enemy the opponent of the hero.
     * @return true if the hero wins and false otherwise.
     */
    public static boolean fight(Hero currentHero, Enemy enemy) {

        while (currentHero.isAlive()) { // while loop to initiate fight
            currentHero.attack(enemy);  // enemy attacks first

            if (!enemy.isAlive()) { // We check if the enemy is still alive before attacking the hero.
                break;              // if the enemy is dead, the hero wins the fight
            }

            currentHero.receiveDamage(enemy.getAttackPoints()); // Enemy attacks the hero

            if (!currentHero.isAlive()) { // if the hero is dead, we stop the fight and return false
                return false;
            }
        }
        if (!currentHero.isAlive()){
            return false;
        }else
        {
        currentHero.incrementKillCount(); // increment the kill counter
        currentHero.levelUp(enemy); // if we can level up, we level up!
        return true;
        }
    }

}
