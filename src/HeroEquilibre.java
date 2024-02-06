public class HeroEquilibre extends Hero {
    public HeroEquilibre(String heroName, int health, int attackPoints, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive) {
        super(heroName, health, attackPoints, maxHealth, experience, level, enemiesKilled, isAlive);
    }

    public void receiveDamage(int attackPoints) {
        int newHealth = this.getHealth() - attackPoints;
        this.setHealth(newHealth);
    }

    @Override
    public void attack(Enemy enemy) {
        int health = enemy.getHealth();
        int newHealth = health - this.getAttackPoints();
        enemy.setHealth(newHealth);
    }

}
