
public class Hero extends Character {
    private int experience, level, enemiesKilled;
    private String heroName;
    public Hero(String heroName, int health, int attackPoint, int maxHealth, int experience, int level, int enemiesKilled ) {
        super(health, maxHealth, attackPoint);
        this.experience = experience;
        this.level = level;
        this.heroName = heroName;
        this.enemiesKilled = enemiesKilled;
    }
    @Override
    public String toString(){
//        return "health: " + this.getHealth() +"level: " + this.level + " experience: " + this.experience + " Enemies Killed: " + this.enemiesKilled;


        if(this.getEnemiesKilled() > 1){

            if( this.getHealth() <= 0 ){
                return "In his quest, " + this.getHeroName() + " died after beating " + this.getEnemiesKilled() + " enemies and attaining level "
                        + this.getLevel() +"!";
            }
            else {
                return "In his quest, " + this.getHeroName() + " beat " + this.getEnemiesKilled() + " enemies, attained level "
                        + this.getLevel() + " and survived with " + this.getHealth() + " HP!";
            }

        }else{

            if( this.getHealth() <= 0 ){
                return "In his quest, " + this.getHeroName()+ " died after beating " + this.getEnemiesKilled() + " enemy and attaining level "
                        + this.getLevel() +"!";
            }else{
                return "In his quest, " + this.getHeroName() + " beat " + this.getEnemiesKilled() + " enemy, attained level "
                        + this.getLevel() + " and survived with " + this.getHealth() + " HP!";
            }

        }


    }
    public void setHeroName(String name){
        this.heroName = name;
    }
    public void incrementEnemiesKilled(){
        this.enemiesKilled++;
    }
    public void setExperience( int experience ){
        this.experience = experience;
    };
    public void setLevel( int level ){

        this.level = level;
    };
    public String getHeroName(){
        return this.heroName;
    }
    public int getEnemiesKilled(){
        return this.enemiesKilled;
    }
    public int getExperience(){
        return this.experience;
    };
    public int getLevel(){
        return this.level;
    };
    @Override
    public void attack( Character enemy ){
        int health = enemy.getHealth();
        int newHealth = health - this.getAttackPoint();
        enemy.setHealth( newHealth );
    }
    public int computeExperienceRequired( int level ){
        int experienceRequired = 50 + level * 20 * (int)Math.pow(1.1,level);
        return experienceRequired;
    }
    public void incrementLevel(){

        int nextLevel = this.getLevel() + 1;

        if( nextLevel <= 99){
            int nextAttackPoint = this.getAttackPoint() + 6;
            int nextMaxHealth = this.getMaxHealth() + 12;

            this.setLevel( nextLevel );
            this.setAttackPoint( nextAttackPoint);
            this.setMaxHealth( nextMaxHealth);
            this.setHealth( nextMaxHealth );
            this.setExperience(0);
        }

    }
}
