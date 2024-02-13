public class HeroDefense extends Hero {
    public HeroDefense(String heroName, int health, int attackPoints, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive) {
        super(heroName, health, attackPoints, maxHealth, experience, level, enemiesKilled, isAlive);

    }

    @Override
    public void attack(Enemy enemy) {
        int health = enemy.getHealth();
        int newHealth = (int)Math.ceil((health - 0.5 * this.getAttackPoints())); //  attaque = 1/2 x points d'attaque normaux
        enemy.setHealth(newHealth);
    }

    public void receiveDamage(int attackPoints) {
        int newHealth = (int)Math.ceil((this.getHealth() - 0.5 * attackPoints)); //  degats = 1/2 x points d'attaque normaux
        this.setHealth(newHealth);
    }
}
