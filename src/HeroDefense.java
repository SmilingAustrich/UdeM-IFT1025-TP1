public class HeroDefense extends Hero{
    public HeroDefense(String heroName, int health, int attackPoint, int maxHealth, int experience, int level, int enemiesKilled, boolean isAlive){
        super( heroName, health, attackPoint, maxHealth,  experience,  level, enemiesKilled, isAlive);

    }
    @Override
    public void attack(Enemy enemy){
        int health = enemy.getHealth();
        int newHealth = (int)(health - (0.5 * this.getAttackPoint())); //  attaque = 1/2 x points d'attaque normaux
        enemy.setHealth( newHealth );
    }
    public void receiveDamage(int attackPoints){
        int newHealth = (int)(this.getHealth() - (0.5 * attackPoints)); //  degats = 1/2 x points d'attaque normaux
        this.setHealth(newHealth);
    }
}
