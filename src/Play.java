public abstract class Play {

    public static Hero createHero(String[] phrase) {
        Hero currentHero;
        String heroName = phrase[0];
        int heroHealth = Integer.parseInt(phrase[1]);

        int heroAttackPoint = Integer.parseInt(phrase[2]);

        // TODO: are theses variables constants?
        int EXPERIENCE = 0;
        int LEVEL = 1;
        int ENEMIESKILLED = 0;

        boolean isAlive = true;
        if (heroName.toLowerCase().startsWith("a")) {

            currentHero = new HeroAttack(heroName, heroHealth, heroAttackPoint, heroHealth, EXPERIENCE, LEVEL, ENEMIESKILLED, isAlive);

        } else if (heroName.toLowerCase().startsWith("d")) {

            currentHero = new HeroDefense(heroName, heroHealth, heroAttackPoint, heroHealth, EXPERIENCE, LEVEL, ENEMIESKILLED, isAlive);

        } else {

            currentHero = new HeroEquilibre(heroName, heroHealth, heroAttackPoint, heroHealth, EXPERIENCE, LEVEL, ENEMIESKILLED, isAlive);
        }

        return currentHero;
    }

    public static Enemy createEnemy(Hero hero) {

        int heroEnemiesKilled = hero.getEnemiesKilled();
        int enemyHealth = (heroEnemiesKilled * 10) + 100;
        int enemyAttackPoints = (heroEnemiesKilled * 5) + 25;
        int enemyExperienceDrop = (heroEnemiesKilled * 8) + 35;
        boolean enemyIsAlive = true;

        return new Enemy(enemyHealth, enemyAttackPoints ,enemyHealth, enemyExperienceDrop, enemyIsAlive);

    }
}
