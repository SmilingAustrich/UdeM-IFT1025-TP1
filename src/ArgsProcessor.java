public class ArgsProcessor {
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);

        Hero currentHero = Play.createHero(phrase);

        for (int actions = 3; actions < phrase.length; actions++) {
            if (currentHero.isAlive()) {
                ArgsProcessor.doAction(phrase[actions], currentHero);
            }
        }

        System.out.println(currentHero); // Play! output
    }

    private static String[] makePhrase(String args) {
        return args.trim().split(",");
    }

    /**
     * Static method to create a Hero.
     * @param action the actions that the hero will perform.
     * @param hero the hero that will perform the actions.
     * @return true as long as the hero is still alive.
     */
    private static boolean doAction(String action, Hero hero) {
        // Here, we are transforming the String action into an array of Strings by splitting the words with spaces.
        String[] phrase = action.trim().split(" ");
        // The type of the action is determinated by the first word of the variable "phrase".
        switch (phrase[0]) {
            case "fought":
                int nbrEnemiesToFight = Integer.parseInt(phrase[1]);
                for( int i = 0; i < nbrEnemiesToFight; i++){
                // A new enemy is instantiated for every iteration, with new stats
                Enemy enemy = Play.createEnemy(hero.getEnemiesKilled());
                Character.fight(hero, enemy); // The hero keeps fights "nbrEnemiesToFight" enemies.
                }
                break;
            case "rested":
                hero.setHealth(hero.getMaxHealth()); // The hero regenerates his health back to max
                break;
            case "healed":
                int healthPoints = Integer.parseInt(phrase[1]);
                hero.setHealth(hero.getHealth() + healthPoints); // The hero regenerates n healths points.
                break;
            case "trained":
                int attackPoints = Integer.parseInt(phrase[3]);
                hero.setAttackPoints(hero.getAttackPoints() + attackPoints); // The hero gains n attack points.
                break;
        }
        return true;
    }

}
