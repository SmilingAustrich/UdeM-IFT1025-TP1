public abstract class Play {
    public static boolean fight(int nbrEnemiesToFight, Hero currentHero) {

        for (int i = 0; i < nbrEnemiesToFight; i++) {

            Enemy enemy = createEnemy(currentHero); // new Enemy for each new fight

            while (currentHero.IsAlive()) { // while loop to initiate fight
                currentHero.attack(enemy);

                if (!enemy.IsAlive()){ // We check if the enemy is still alive before attacking the hero.
                    break;
                }

                currentHero.receiveDamage(enemy.getAttackPoints()); // Enemy attacks the hero

                if(!currentHero.IsAlive()){ // if the hero is dead, we stop the fight and return false
                    return false;
                }
            }
            currentHero.incrementKillCount(); // increment the kill counter
            levelUp(currentHero,enemy); // if we can level up, we level up!
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
        int heroUpdatedAtkPoints = hero.getAttackPoints() + attackPoints;
        hero.setAttackPoints(heroUpdatedAtkPoints);
    }
    public static void levelUp(Hero hero, Enemy enemy){

        int heroExperienceNeeded = hero.computeExperienceRequired(hero.getLevel() + 1);

        int heroUpdatedExperience = enemy.getExperienceDrop() + hero.getExperience();
        hero.setExperience(heroUpdatedExperience);

        if (heroUpdatedExperience >= heroExperienceNeeded) {
            hero.incrementLevel();

        }
    }
    public static Hero createHero(String[] phrase){
        Hero currentHero;
        String heroName = phrase[0];
        int heroHealth = Integer.parseInt(phrase[1]);

        int heroAttackPoint = Integer.parseInt(phrase[2]);

        // TODO: are theses variables constants?
        int EXPERIENCE = 0;
        int LEVEL = 1;
        int ENNEMIESKILLED = 0;

        boolean isAlive = true;
        if (heroName.toLowerCase().startsWith("a")) {

            currentHero = new HeroAttack(heroName, heroHealth, heroAttackPoint, heroHealth, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);

        } else if (heroName.toLowerCase().startsWith("d")) {

            currentHero = new HeroDefense(heroName, heroHealth, heroAttackPoint, heroHealth, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);

        } else {

            currentHero = new HeroEquilibre(heroName, heroHealth, heroAttackPoint, heroHealth, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);
        }

        return currentHero;
    }
    public static Enemy createEnemy(Hero hero){

        int heroEnemiesKilled = hero.getEnemiesKilled();
        int enemyHealth = (heroEnemiesKilled * 10) + 100;
        int enemyAttackPoints = (heroEnemiesKilled * 5) + 25;
        int enemyExperienceDrop = (heroEnemiesKilled * 8) + 35;
        boolean enemyIsAlive = true;

        return new Enemy(enemyHealth, enemyHealth, enemyAttackPoints, enemyExperienceDrop, enemyIsAlive);

    }
}
