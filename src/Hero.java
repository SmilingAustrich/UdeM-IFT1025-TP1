
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

    // We redefine the toString method of the hero class to ouput the Hero's story
    // Depending on the hero's health and the amount of enemies killed, a different scenario is chosen
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
    /**
     * method to level up a hero.
     * We calculate the required experience and compare it with the current experience of the hero.
     * If the current experience is bigger or equal to the required experience, the hero's stats are
     * increased to the ones corresponding to the next level.
     * @param enemyExperienceDrop, the xp that the enemy drops once killed.
     */

    public void levelUp( int enemyExperienceDrop) {

        int heroExperienceNeeded = this.computeExperienceRequired(this.getLevel() + 1);

        int heroUpdatedExperience = enemyExperienceDrop + this.getExperience();
        this.setExperience(heroUpdatedExperience);

        if (heroUpdatedExperience >= heroExperienceNeeded) {
            int nextLevel = this.getLevel() + 1;

            if( nextLevel <= 99){ // We increment the hero's level and his stats as long as the hero's level isn't the max.
                int nextAttackPoint = this.getAttackPoints() + 6;
                int nextMaxHealth = this.getMaxHealth() + 12;

                this.setLevel(nextLevel);
                this.setAttackPoints(nextAttackPoint);
                this.setMaxHealth(nextMaxHealth);
                this.setHealth(nextMaxHealth);
                this.setExperience(0);

            }
        }

    }
    /**
     * abstract method to attack an enemy.
     * @param enemy, hero attack enemies.
     */
    abstract void attack(Enemy enemy); // method to attack enemies in general
}
