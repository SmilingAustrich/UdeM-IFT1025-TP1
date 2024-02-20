public class HeroAttack extends Hero {

    public HeroAttack(String heroName, int health, int attackPoints, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive) {
        super(heroName, health, attackPoints, maxHealth, experience, level, enemiesKilled, isAlive);
    }

    @Override
    /**
     * Each hero handles attacks differently, so we need to override the method for every type of hero.
     * @param enemy the opponent.
     */
    public void attack(Enemy enemy) {
        int health = enemy.getHealth();
        int newHealth = health - (2 * this.getAttackPoints());

        enemy.setHealth(newHealth);
    }
    /**
     * Each character handles receiving damage differently, so we need to override the method for every type of hero.
     * HeroAttack's attack = 2 * attack points
     * @param attackPoints the damage to be inflicted to the hero.
     */
    public void receiveDamage(int attackPoints) {
        int newHealth = this.getHealth() - (2 * attackPoints);
        this.setHealth(newHealth);
    }
}
