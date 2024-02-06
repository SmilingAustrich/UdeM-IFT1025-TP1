public abstract class Play {

    public static boolean fight(int nbrEnemiesToFight, Hero hero) {


        for (int i = 0; i < nbrEnemiesToFight; i++) {

            int heroEnemiesKilled = hero.getEnemiesKilled();
            int heroNextLevel = hero.getLevel() + 1;
            int heroExperienceNeeded = hero.computeExperienceRequired(heroNextLevel);

            int enemyHealth = (heroEnemiesKilled * 10) + 100;
            int enemyMaxHealth = enemyHealth;
            int enemyAttackPoints = (heroEnemiesKilled * 5) + 25;
            int enemyExperienceDrop = (heroEnemiesKilled * 8) + 35;

            Enemy enemy = new Enemy(enemyHealth, enemyMaxHealth, enemyAttackPoints, enemyExperienceDrop);

            while (hero.getHealth() > 0) {
                hero.attackEnemy(enemy);
                hero.receiveDamage(enemyAttackPoints);
                if(hero.getHealth() <= 0){
                    return false;
                }
            }
            hero.incrementEnemiesKilled();
            int heroUpdatedExperience = enemyExperienceDrop + hero.getExperience();
            hero.setExperience(heroUpdatedExperience);

            if (heroUpdatedExperience >= heroExperienceNeeded) {
                hero.incrementLevel();

                }
            }
        return true;
    }

    public static void rested(Hero hero){
        int maxHealth = hero.getMaxHealth();
        hero.setHealth(maxHealth);
    }

    public static void healed(int healthPoints, Hero hero){
        int heroUpdatedHealth = hero.getHealth() + healthPoints;
        hero.setHealth(heroUpdatedHealth);
    }

    public static void trained(int attackPoints, Hero hero){
        int heroUpdatedAtkPoints = hero.getAttackPoint() + attackPoints;
        hero.setAttackPoint(heroUpdatedAtkPoints);
    }
}
