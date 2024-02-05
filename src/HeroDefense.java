public class HeroDefense extends Hero{
    public HeroDefense(String heroName, int health, int maxHealth, int attackPoint, int experience, int level, int enemiesKilled){
        super( heroName, health, maxHealth,  attackPoint,  experience,  level, enemiesKilled);

    }
    @Override
    public void attackEnemy(Enemy enemy){
        int health = enemy.getHealth();
        int newHealth = health - (int)( 0.5 * this.getAttackPoint() ); //  attaque = 1/2 x points d'attaque normaux
        enemy.setHealth( newHealth );
    }
    public void receiveDamage(int attackPoints){
        int newHealth = this.getHealth() - (int)(0.5 * attackPoints); //  degats = 1/2 x points d'attaque normaux
        this.setHealth(newHealth);
    }
}
