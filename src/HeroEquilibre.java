public class HeroEquilibre extends Hero{
    public HeroEquilibre(String heroName, int health, int attackPoint, int maxHealth, int experience, int level, int enemiesKilled) {
        super(heroName, health, attackPoint, maxHealth, experience, level, enemiesKilled);
    }

    public void receiveDamage(int attackPoints){
        int newHealth = this.getHealth() - attackPoints;
        this.setHealth(newHealth);
    }
    @Override
    public void attackEnemy(Enemy enemy){
        int health = enemy.getHealth();
        int newHealth = health - this.getAttackPoint();
        enemy.setHealth( newHealth );
    }

}
