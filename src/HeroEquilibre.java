public class HeroEquilibre extends Hero{
    public HeroEquilibre(String heroName, int health, int attackPoint, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive) {
        super(heroName, health, attackPoint, maxHealth, experience, level, enemiesKilled, isAlive);
    }

    public void receiveDamage(int attackPoints){
        int newHealth = this.getHealth() - attackPoints;
        this.setHealth(newHealth);
    }
    @Override
    public void attack(Enemy enemy){
        int health = enemy.getHealth();
        int newHealth = health - this.getAttackPoint();
        enemy.setHealth( newHealth );
    }

}
