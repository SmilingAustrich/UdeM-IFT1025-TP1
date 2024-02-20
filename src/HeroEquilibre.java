public class HeroEquilibre extends Hero {
    public HeroEquilibre(String heroName, int health, int attackPoints, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive) {
        super(heroName, health, attackPoints, maxHealth, experience, level, enemiesKilled, isAlive);
    }
    /**
     * Each hero handles receiving damage differently, so we need to override the method for every type of hero.
     * HeroEquilibre's attack = attack points
     * @param attackPoints the damage to be inflicted to the hero.
     */
    public void receiveDamage(int attackPoints) {
        int newHealth = this.getHealth() - attackPoints;
        this.setHealth(newHealth);
    }
    /**
     * Each character handles attacks differently, so we need to override the method for every type of hero.
     * @param enemy the opponent.
     */
    @Override
    public void attack(Enemy enemy) {
        int health = enemy.getHealth();
        int newHealth = health - this.getAttackPoints();
        enemy.setHealth(newHealth);
    }

}
