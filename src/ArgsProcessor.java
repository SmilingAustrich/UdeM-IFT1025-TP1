public class ArgsProcessor {
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);
        //TODO : Handle the phrase and output the result

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


        int arraySize = phrase.length - 1;
        // We substract 3 from the arraySize to start right after the first 3 arguments
        // which are the Hero's name, health and attack points
        int heroActionsIdx = arraySize - 3;

        if (heroName.toLowerCase().startsWith("a")) {

            currentHero = new HeroAttack(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);

        } else if (heroName.toLowerCase().startsWith("d")) {

            currentHero = new HeroDefense(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);
        } else {
            currentHero = new HeroEquilibre(heroName, heroHealth, heroAttackPoint, MAXHEALTH, EXPERIENCE, LEVEL, ENNEMIESKILLED, isAlive);
        }

        for (int actions = heroActionsIdx; actions < phrase.length; actions++) {
            if (currentHero.IsAlive()) {
                doAction(phrase[actions], currentHero);
            }
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

                Play.fight(nbrEnemiesToFight, hero);

                break;
            case "rested":

                Play.rested(hero);
                break;
            case "healed":
                int healthPoints = Integer.parseInt(phrase[1]);

                Play.healed(healthPoints, hero);
                break;
            case "trained":
                int attackPoints = Integer.parseInt(phrase[3]);

                Play.trained(attackPoints,hero);
                break;
        }
        return true;
    }

}
