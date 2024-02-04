public class HeroDefense extends Hero{
    public HeroDefense(String heroName, int health, int maxHealth, int attackPoint, int experience, int level, int enemiesKilled){
        super( heroName, health, maxHealth,  attackPoint,  experience,  level, enemiesKilled);

    }
    @Override
    public void attack( Character enemy ){
        int health = enemy.getHealth();
        int newHealth = health - (int)( 0.5 * this.getAttackPoint() ); //  degats = 1/2 x points d'attaque normaux
        enemy.setHealth( newHealth );
    }
}
