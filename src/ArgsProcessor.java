public class ArgsProcessor {
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);
        //TODO : Handle the phrase and output the result

        Hero currentHero;
        String heroName = phrase[0].toLowerCase();
        int heroHealth = Integer.parseInt(phrase[1]);
        int heroAttackPoint = Integer.parseInt(phrase[2]);
        // TODO: are theses variables constants?
        int EXPERIENCE = 0;
        int MAXHEALTH = heroHealth;
        int LEVEL = 1;
        int ENNEMIESKILLED = 0;


        int arraySize = phrase.length - 1;
        // We substract 3 from the arraySize to start right after the first 3 arguments
        // which are the Hero's name, health and attack points
        int heroActionsIdx = arraySize - 3;

        if (heroName.startsWith("a")) {

            currentHero = new HeroAttack(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED);

        } else if (heroName.startsWith("d")) {

            currentHero = new HeroDefense(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED);
        } else {
            currentHero = new Hero(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED);
        }

        for (int actions = heroActionsIdx; actions < phrase.length; actions++) {
            doAction(phrase[actions], currentHero);

        }
        ;
        System.out.println(currentHero); // Play! output.

    }

    private static String[] makePhrase(String args) {
        return args.trim().split(",");
    }

    // méthode qui prend la partie de la phrase qui décrit l'action et le héros, puis effectue l'action correspondante
    // retourne true si le joueur survit à l'action, false sinon
    private static boolean doAction(String action, Hero hero) {
        // ici, on transforme le String action en un tableau de String, en séparant les mots par des espaces
        String[] phrase = action.trim().split(" ");
        // le type d'action est déterminé par le premier mot de la phrase
        switch (phrase[0]) {
            case "fought":

                int nbrEnemiesToFight = Integer.parseInt(phrase[1]);

                for (int i = 0; i < nbrEnemiesToFight; i++) {

                    int heroEnemiesKilled = hero.getEnemiesKilled();
                    int heroNextLevel = hero.getLevel() + 1;
                    int heroExperienceNeeded = hero.computeExperienceRequired(heroNextLevel);

                    int enemyHealth = (heroEnemiesKilled * 10) + 100;
                    int enemyMaxHealth = enemyHealth;
                    int enemyAttackPoints = (heroEnemiesKilled * 5) + 25;
                    int enemyExperienceDrop = (heroEnemiesKilled * 8) + 35;

                    Enemy enemy = new Enemy(enemyHealth, enemyMaxHealth, enemyAttackPoints, enemyExperienceDrop);

                    while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
                        hero.attack(enemy);

                        if (enemy.getHealth() > 0) { // in case the enemy's health drops below zero before the end of the round.
                            enemy.attack(hero);
                        }

                    }

                    if (enemy.getHealth() > 0) {

                        return false;

                    } else {

                        int heroUpdatedExperience = enemyExperienceDrop + hero.getExperience();

                        hero.setExperience(heroUpdatedExperience);
                        hero.incrementEnemiesKilled();

                        if (heroUpdatedExperience >= heroExperienceNeeded) {
                            hero.incrementLevel();
                        }

                    }
                }

                break;
            case "rested":
                //TODO : Handle the resting, add points to Health
                int maxHealth = hero.getMaxHealth();
                hero.setHealth(maxHealth);
                break;
            case "healed":
                //TODO : Handle the healing
                int healthPoints = Integer.parseInt(phrase[1]);
                int heroUpdatedHealth = hero.getHealth() + healthPoints;

                hero.setHealth(heroUpdatedHealth);
                break;
            case "trained":
                //TODO : Handle the training
                int attackPoints = Integer.parseInt(phrase[3]);
                int heroUpdatedAtkPoints = hero.getAttackPoint() + attackPoints;
                hero.setAttackPoint(heroUpdatedAtkPoints);
                break;
        }
        return true;
    }

}
