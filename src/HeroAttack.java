public class HeroAttack extends Hero{

    public HeroAttack(String heroName, int health, int attackPoint, int maxHealth, int experience, int level, int enemiesKilled){
        super( heroName, health, maxHealth,  attackPoint,  experience,  level, enemiesKilled);
    }

    @Override
    public void attack( Character enemy ){
        int health = enemy.getHealth();
        int newHealth = health - ( 2 * this.getAttackPoint() ); //  degats = 2 x points d'attaque normaux
        enemy.setHealth( newHealth );
    }


}