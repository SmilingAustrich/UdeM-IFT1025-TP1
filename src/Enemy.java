public class Enemy extends Character {
    private int experienceDrop;

    public Enemy(int health, int attackPoints, int maxHealth, int experienceDrop, boolean isAlive) {
        super(health, attackPoints, maxHealth, isAlive);
        this.experienceDrop = experienceDrop;
    }

    public int getExperienceDrop() {
        return this.experienceDrop;
    }

    public void setExperienceDrop(int experienceDrop) {
        this.experienceDrop = experienceDrop;
    }
    /**
     * Each character handles attacks differently, so we need to override the method for every type of hero.
     * @param attackPoints the opponent.
     */
    public void receiveDamage(int attackPoints) {
        int newHealth = this.getHealth() - attackPoints;
        this.setHealth(newHealth);
    }

}
