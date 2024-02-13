
public abstract class Hero extends Character {
    private int experience, level, enemiesKilled;

    private String heroName;
    public Hero(String heroName, int health, int attackPoint, int maxHealth, int experience, int level,
                int enemiesKilled, boolean isAlive) {
        super(health, attackPoint, maxHealth, isAlive);
        this.experience = experience;
        this.level = level;
        this.heroName = heroName;
        this.enemiesKilled = enemiesKilled;
    }
    @Override
    public String toString(){

        if(this.getEnemiesKilled() > 1){

            if( this.getHealth() <= 0 ){
                return "In his quest, " + this.getHeroName() + " died after beating " + this.getEnemiesKilled()
                        + " enemies and attaining level " + this.getLevel() +"!";
            }
            else {
                return "In his quest, " + this.getHeroName() + " beat " + this.getEnemiesKilled()
                        + " enemies, attained level " + this.getLevel() + " and survived with "
                        + this.getHealth() + " HP!";
            }
        }else {
            if( this.getHealth() <= 0 ){
                return "In his quest, " + this.getHeroName()+ " died after beating " + this.getEnemiesKilled()
                        + " enemy and attaining level " + this.getLevel() +"!";
            }else{

                return "In his quest, " + this.getHeroName() + " beat " + this.getEnemiesKilled()
                        + " enemy, attained level " + this.getLevel() + " and survived with "
                        + this.getHealth() + " HP!";
            }

        }
    }
    // Getters and setters for the instance variables.
    public void setHeroName(String name){
        this.heroName = name;
    }
    public void setExperience( int experience ){
        this.experience = experience;
    }
    public void setLevel( int level ){this.level = level;}
    public String getHeroName(){
        return this.heroName;
    }
    public int getEnemiesKilled(){ return this.enemiesKilled;}
    public int getExperience(){return this.experience;}
    public int getLevel(){
        return this.level;
    }
    public void incrementKillCount(){
        this.enemiesKilled++;
    }
    public int computeExperienceRequired(int level){

        return (int)Math.ceil((50 + level * 20 * Math.pow(1.1,level)));
    }
    public void incrementLevel(){

        int nextLevel = this.getLevel() + 1;

        if( nextLevel <= 99){
            int nextAttackPoint = this.getAttackPoints() + 6;
            int nextMaxHealth = this.getMaxHealth() + 12;

            this.setLevel(nextLevel);
            this.setAttackPoints(nextAttackPoint);
            this.setMaxHealth(nextMaxHealth);
            this.setHealth(nextMaxHealth);
            this.setExperience(0);
        }
    }
    public void levelUp( Enemy enemy) {

        int heroExperienceNeeded = this.computeExperienceRequired(this.getLevel() + 1);

        int heroUpdatedExperience = enemy.getExperienceDrop() + this.getExperience();
        this.setExperience(heroUpdatedExperience);

        if (heroUpdatedExperience >= heroExperienceNeeded) {
            this.incrementLevel();

        }
    }
    abstract void attack(Enemy enemy); // method to attack enemies in general
}
