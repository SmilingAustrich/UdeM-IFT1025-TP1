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
            boolean enemyIsAlive = true;

            Enemy enemy = new Enemy(enemyHealth, enemyMaxHealth, enemyAttackPoints, enemyExperienceDrop, enemyIsAlive);

            while (hero.IsAlive()) {
                hero.attack(enemy);

                if (!enemy.IsAlive()){
                    break;
                }
                hero.receiveDamage(enemyAttackPoints);

                if(!hero.IsAlive()){
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

    public static Hero createHero(String[] phrase){
        Hero currentHero;
        String heroName = phrase[0];
        int heroHealth = Integer.parseInt(phrase[1]);

        int heroAttackPoint = Integer.parseInt(phrase[2]);

        // TODO: are theses variables constants?
        int EXPERIENCE = 0;
        int MAXHEALTH = heroHealth;
        int LEVEL = 1;
        int ENNEMIESKILLED = 0;

        boolean isAlive = true;


        if (heroName.toLowerCase().startsWith("a")) {

            currentHero = new HeroAttack(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);

        } else if (heroName.toLowerCase().startsWith("d")) {

            currentHero = new HeroDefense(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);
        } else {
            currentHero = new HeroEquilibre(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);
        }

        return currentHero;
    }

}
