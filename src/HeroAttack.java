public class HeroAttack extends Hero{

    public HeroAttack(String heroName, int health, int attackPoint, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive){
        super( heroName, health, attackPoint, maxHealth,  experience,  level, enemiesKilled, isAlive);
    }

    @Override
    public void attack(Enemy enemy ){
        int health = enemy.getHealth();
        int newHealth = health - (2 * this.getAttackPoint());

        enemy.setHealth(newHealth);
    }
    public void receiveDamage(int attackPoints){
        int newHealth = this.getHealth() - (2 * attackPoints);
        this.setHealth(newHealth);
    }
}
