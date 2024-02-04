public class Enemy extends Character{

    private int experienceDrop;
    public Enemy(int health, int maxHealth, int attackpoint, int experienceDrop){
        super(health, maxHealth, attackpoint);
        this.experienceDrop = experienceDrop;

    }
    public void setExperienceDrop(int experienceDrop){
        this.experienceDrop = experienceDrop;
    }
    public int getExperienceDrop(){
        return this.experienceDrop;
    }
    @Override
    public void attack(Character hero){


        int heroHealth = hero.getHealth(); // Retrieve the hero's Health

        if ( hero instanceof HeroAttack ){
            int newHealth = heroHealth - ( 2 * this.getAttackPoint() );
            hero.setHealth(newHealth);
        }
         else if ( hero instanceof HeroDefense ) {
             int newHealth = heroHealth - (int) (0.5 * this.getAttackPoint());
             hero.setHealth(newHealth);
         }
        else {
            int newHealth = heroHealth - this.getAttackPoint();
            hero.setHealth(newHealth);
        }
    }
}
