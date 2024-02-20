public class HeroDefense extends Hero {
    public HeroDefense(String heroName, int health, int attackPoints, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive) {
        super(heroName, health, attackPoints, maxHealth, experience, level, enemiesKilled, isAlive);

    }

    @Override
    /**
     * Each character handles attacks differently, so we need to override the method for every type of hero.
     * HeroDefense's attack = 1/2 x attack points
     * @param enemy the opponent.
     */
    public void attack(Enemy enemy) {
        int health = enemy.getHealth();
        int newHealth = (int)Math.ceil((health - 0.5 * this.getAttackPoints()));
        enemy.setHealth(newHealth);
    }
    /**
     * Each hero handles receiving damage differently, so we need to override the method for every type of hero.
     * @param attackPoints the damage to be inflicted to the hero.
     */
    public void receiveDamage(int attackPoints) {
        int newHealth = (int)Math.ceil((this.getHealth() - 0.5 * attackPoints));
        this.setHealth(newHealth);
    }
}
