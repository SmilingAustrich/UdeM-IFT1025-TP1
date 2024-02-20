public abstract class Play {

    /**
     * Static method to create a Hero.
     *
     * @param phrase the information about the hero.
     * @return the hero after instantiating it.
     */
    public static Hero createHero(String[] phrase) {
        Hero currentHero; // creating a reference variable, we will instantiate it later.

        // the variables below are all information needed to instantiate hero.

        String heroName = phrase[0];

        int heroHealth = Integer.parseInt(phrase[1]);
        int heroAttackPoint = Integer.parseInt(phrase[2]);
        int experience = 0;
        int level = 1;
        int enemiesKilled = 0;

        boolean isAlive = true; // All characters are alive when instantiated.

        // Depending on the first letter of the hero's name, the type of hero instantiated will differ.
        // A heroAttack is created if its name starts with an "a".
        // A heroDefense is created if its name starts with a "d".
        // A heroEquilibre is created in all other cases.

        if (heroName.toLowerCase().startsWith("a")) {

            currentHero = new HeroAttack(
                    heroName, heroHealth, heroAttackPoint, heroHealth, experience, level, enemiesKilled, isAlive
            );

        } else if (heroName.toLowerCase().startsWith("d")) {

            currentHero = new HeroDefense(
                    heroName, heroHealth, heroAttackPoint, heroHealth, experience, level, enemiesKilled, isAlive
            );

        } else {

            currentHero = new HeroEquilibre(
                    heroName, heroHealth, heroAttackPoint, heroHealth, experience, level, enemiesKilled, isAlive
            );
        }

        return currentHero;
    }

    /**
     * Static method to create an enemy.
     *
     * @param heroEnemiesKilled the number of enemies that the hero killed are needed to generate the new enemy's stats.
     * @return the enemy after instantiating it.
     */
    public static Enemy createEnemy(int heroEnemiesKilled) {
        // We need the hero.
        int enemyHealth = (heroEnemiesKilled * 10) + 100;
        int enemyAttackPoints = (heroEnemiesKilled * 5) + 25;
        int enemyExperienceDrop = (heroEnemiesKilled * 8) + 35;
        boolean enemyIsAlive = true;

        return new Enemy(enemyHealth, enemyAttackPoints, enemyHealth, enemyExperienceDrop, enemyIsAlive);

    }
}
