import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Sidra + Abbas
 * this is the class where the entire game will be set up , the dialogs, episodes and areas
 */
public class Game {
    private List<Episode> episodes;
    private Player sholmes;
    private Sheriff sheriff;
    private Scanner scanner;

    /**
     * Constructor for class Game, where the basic structure for the game will
     * be laid put basically all the episodes and areas players sherrif will be initialized here
     */
    public Game() {
        scanner = new Scanner(System.in);
        sholmes = new Player("Herlock Sholmes", 3);
        sheriff = new Sheriff("Simon De Rook");
        episodes = new ArrayList<>();


        // Add episodes to the game
        episodes.add(createEpisode1());
    }

    /**
     * as the name suggests this method will be used to start the game, it also checks the coupons count.
     */
    public void startGame() {

        Utilities.displayDialog(Constants.gameIntro,"Assistant",Utilities.stringDisplaySpeed, Constants.ANSI_RED);
        /*
        For each episode passed check if the player has enough coupons to play with
         */
        for (Episode episode : episodes) {
            if (!sholmes.hasCoupons()) {
                System.out.println("You've run out of coupons. Game over!");
                break;
            }
            playEpisode(episode);
        }

        /*
        the user has played all the episodes and still has lives / coupons /chances the he wins
         */
    }

    /**
     * this method will start each episode that was created by create eisode method Player can question
     * the suspect or present evidence to the Sheriff in this one
     * @param episode
     */
    private void playEpisode(Episode episode) {
        System.out.println("Starting " + episode.getTitle());
        episode.getDetails();

        while (sholmes.hasCoupons() && sholmes.getCorrectEvidenceCount() < 3) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Move to Areas");
            System.out.println("2. Present evidence to the sheriff");
            System.out.println("3. Check your backpack");
            System.out.println("4. Check your items collection");
            int choice = -1;
            while (true) {
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    break; // Exit the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number from the above choices.");
                    scanner.nextLine(); // Clear the invalid input from the scanner
                }

            }

            switch (choice) {
                case 1 -> episode.moveLocation(scanner, sholmes);
                case 2 -> sheriff.reviewEvidence(scanner, sholmes, episode.getCorrectSuspectsTestimony());
                case 3 -> System.out.println(sholmes.getBackPack());
                case 4 -> sholmes.itemsCollection(scanner, sholmes);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * This methos is used to create Episode 1 of the game ALl the dialog between SHeriff and Player
     * Creation of suspects
     * Establishing the culprit <-- todo define culprit
     * and the list of correct evidence to be presented by Player to sherrif
     * @return Episode
     */

    private Episode createEpisode1() {

        Utilities.displayDialog(Constants.sholmesIntro, sholmes.getName(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
        Utilities.displayDialog(Constants.sheriffEpisode1Dialog1, sheriff.getName(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
        Utilities.displayDialog(Constants.sholmesEpisode1Dialog1, sholmes.getName(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
        Utilities.displayDialog(Constants.sheriffEpisode1Dialog2, sheriff.getName(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
        Utilities.displayDialog(Constants.sholmesEpisode1Dialog2, sholmes.getName(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);


        // adding suspects and their testimonies

        //adding Jacques as a suspect and his testimony
        Suspect Jacques = new Suspect("Jacques Tibarinos");

        Conversation JacquesTestimony = new Conversation(this.sholmes);

        JacquesTestimony.addDialogue(sholmes.getName(),Constants.sholmesJaqcuesDialog1);
        JacquesTestimony.addDialogue(Jacques.getName(),Constants.JaqcuesDialog1);
        JacquesTestimony.addDialogue(sholmes.getName(),Constants.sholmesJaqcuesDialog2);
        JacquesTestimony.addDialogue(Jacques.getName(),Constants.JaqcuesDialog2);
        JacquesTestimony.addDialogue(sholmes.getName(),Constants.sholmesJaqcuesDialog3);
        JacquesTestimony.addDialogue(Jacques.getName(),Constants.JaqcuesDialog3);
        JacquesTestimony.addDialogue(sholmes.getName(),Constants.sholmesJaqcuesDialog4);
        JacquesTestimony.addDialogue(Jacques.getName(),Constants.JaqcuesDialog4);
        JacquesTestimony.addDialogue(sholmes.getName(),Constants.sholmesJaqcuesDialog5);

        Jacques.addTestimony(JacquesTestimony);



        //adding Nathalie as a suspect and her testimony
        Suspect Nathalie = new Suspect("Nathalie Dubois");

        Conversation NathalieTestimony = new Conversation(this.sholmes);
        NathalieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNathalieDialog1);
        NathalieTestimony.addDialogue(Nathalie.getName(),Constants.NathalieDialog1);
        NathalieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNathalieDialog2);

        Nathalie.addTestimony(NathalieTestimony);



        //adding Noemie as a suspect and her testimony
        Suspect Noemie = new Suspect("Noemie Dubois");
        Conversation NoemieTestimony = new Conversation(this.sholmes);

        NoemieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNoemieDialog1);
        NoemieTestimony.addDialogue(Noemie.getName(),Constants.noemieDialog1);
        NoemieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNoemieDialog2);
        NoemieTestimony.addDialogue(Noemie.getName(),Constants.noemieDialog2);
        NoemieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNoemieDialog3);
        NoemieTestimony.addDialogue(Noemie.getName(),Constants.noemieDialog3);
        NoemieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNoemieDialog4);
        NoemieTestimony.addDialogue(Noemie.getName(),Constants.noemieDialog4);
        NoemieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNoemieDialog5);
        NoemieTestimony.addDialogue(Noemie.getName(),Constants.noemieDialog5);
        NoemieTestimony.addDialogue(sholmes.getName(),Constants.sholmesNoemieDialog5);

        Noemie.addTestimony(NoemieTestimony);


        //adding Beat as a suspect and his testimony
        Suspect Beat= new Suspect("Beat Tinker");
        Conversation BeatTestimony = new Conversation(this.sholmes);

        BeatTestimony.addDialogue(sholmes.getName(),Constants.sholmesBeatDialog1);
        BeatTestimony.addDialogue(Beat.getName(),Constants.beatDialog1);
        BeatTestimony.addDialogue(sholmes.getName(),Constants.sholmesBeatDialog2);

        Beat.addTestimony(BeatTestimony);

        //adding Sophie as a suspect and his testimony
        Suspect Sophie = new Suspect("Sophie Lambert");
        Conversation SophieTestimony = new Conversation(this.sholmes);
        SophieTestimony.addDialogue(sholmes.getName(), Constants.sholmesSophieDialog1);
        SophieTestimony.addDialogue(Sophie.getName(), Constants.SophieDialog1);
        SophieTestimony.addDialogue(sholmes.getName(), Constants.sholmesSophieDialog2);
        SophieTestimony.addDialogue(Sophie.getName(), Constants.SophieDialog2);
        SophieTestimony.addDialogue(sholmes.getName(), Constants.sholmesSophieDialog3);
        SophieTestimony.addDialogue(Sophie.getName(), Constants.SophieDialog3);
        SophieTestimony.addDialogue(sholmes.getName(), Constants.sholmesSophieDialog4);
        Sophie.addTestimony(SophieTestimony);

        //adding Diana as a suspect and his testimony
        Suspect Diana = new Suspect("Diana Draconia");
        Conversation DianaTestimony = new Conversation(this.sholmes);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog1);
        DianaTestimony.addDialogue(Diana.getName(), Constants.DianaDialog1);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog2);
        DianaTestimony.addDialogue(Diana.getName(), Constants.DianaDialog2);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog3);
        DianaTestimony.addDialogue(Diana.getName(), Constants.DianaDialog3);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog4);
        DianaTestimony.addDialogue(Diana.getName(), Constants.DianaDialog4);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog5);
        DianaTestimony.addDialogue(Diana.getName(), Constants.DianaDialog5);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog6);
        DianaTestimony.addDialogue(Diana.getName(), Constants.DianaDialog6);
        DianaTestimony.addDialogue(sholmes.getName(), Constants.sholmesDianaDialog7);
        Diana.addTestimony(DianaTestimony);

        //adding Leslito as a suspect and his testimony
        Suspect Leslito = new Suspect("Leslito De La Cruz");
        Conversation LeslitoTestimony = new Conversation(this.sholmes);
        LeslitoTestimony.addDialogue(sholmes.getName(), Constants.sholmesLeslitoDialog1);
        LeslitoTestimony.addDialogue(Leslito.getName(), Constants.LeslitoDialog1);
        LeslitoTestimony.addDialogue(sholmes.getName(), Constants.sholmesLeslitoDialog2);
        LeslitoTestimony.addDialogue(Leslito.getName(), Constants.LeslitoDialog2);
        LeslitoTestimony.addDialogue(sholmes.getName(), Constants.sholmesLeslitoDialog3);
        LeslitoTestimony.addDialogue(Leslito.getName(), Constants.LeslitoDialog3);
        LeslitoTestimony.addDialogue(sholmes.getName(), Constants.sholmesLeslitoDialog4);
        LeslitoTestimony.addDialogue(Leslito.getName(), Constants.LeslitoDialog4);
        LeslitoTestimony.addDialogue(sholmes.getName(), Constants.sholmesLeslitoDialog5);
        Leslito.addTestimony(LeslitoTestimony);

        //adding Yannick as a suspect and his testimony
        Suspect Yannick = new Suspect("Yannick Delacroix");
        Conversation YannikTestimony = new Conversation(this.sholmes);
        YannikTestimony.addDialogue(sholmes.getName(), Constants.sholmesYannickDialog1);
        YannikTestimony.addDialogue(Yannick.getName(), Constants.YannickDialog1);
        YannikTestimony.addDialogue(sholmes.getName(), Constants.sholmesYannickDialog2);
        YannikTestimony.addDialogue(Yannick.getName(), Constants.YannickDialog2);
        YannikTestimony.addDialogue(sholmes.getName(), Constants.sholmesYannickDialog3);
        Yannick.addTestimony(YannikTestimony);

        //adding Laurent as a suspect and his testimony
        Suspect Laurent = new Suspect("Laurent Dupont");
        Conversation LaurentTestimony = new Conversation(this.sholmes);
        LaurentTestimony.addDialogue(sholmes.getName(), Constants.sholmesLaurentDialog1);
        LaurentTestimony.addDialogue(Laurent.getName(), Constants.LaurentDialog1);
        LaurentTestimony.addDialogue(sholmes.getName(), Constants.sholmesLaurentDialog2);
        LaurentTestimony.addDialogue(Laurent.getName(), Constants.LaurentDialog2);
        LaurentTestimony.addDialogue(sholmes.getName(), Constants.sholmesLaurentDialog3);
        LaurentTestimony.addDialogue(Laurent.getName(), Constants.LaurentDialog3);
        LaurentTestimony.addDialogue(sholmes.getName(), Constants.sholmesLaurentDialog4);
        Laurent.addTestimony(LaurentTestimony);

        //adding Liesbeth as a suspect and his testimony
        Suspect Liesbeth = new Suspect("Liesbeth De Winter");
        Conversation LiesbethTestimony = new Conversation(this.sholmes);
        LiesbethTestimony.addDialogue(sholmes.getName(), Constants.sholmesLiesbethDialog1);
        LiesbethTestimony.addDialogue(Liesbeth.getName(), Constants.LiesbethDialog1);
        LiesbethTestimony.addDialogue(sholmes.getName(), Constants.sholmesLiesbethDialog2);
        LiesbethTestimony.addDialogue(Liesbeth.getName(), Constants.LiesbethDialog2);
        LiesbethTestimony.addDialogue(sholmes.getName(), Constants.sholmesLiesbethDialog3);
        LiesbethTestimony.addDialogue(Liesbeth.getName(), Constants.LiesbethDialog3);
        LiesbethTestimony.addDialogue(sholmes.getName(), Constants.sholmesLiesbethDialog4);
        Liesbeth.addTestimony(LiesbethTestimony);

        //adding Jeroen as a suspect and his testimony
        Suspect Jeroen = new Suspect("Jeroen Maes");
        Conversation JeroenTestimony = new Conversation(this.sholmes);
        JeroenTestimony.addDialogue(sholmes.getName(), Constants.sholmesJeroenDialog1);
        JeroenTestimony.addDialogue(Jeroen.getName(), Constants.JeroenDialog1);
        JeroenTestimony.addDialogue(sholmes.getName(), Constants.sholmesJeroenDialog2);
        JeroenTestimony.addDialogue(Jeroen.getName(), Constants.JeroenDialog2);
        JeroenTestimony.addDialogue(sholmes.getName(), Constants.sholmesJeroenDialog3);
        JeroenTestimony.addDialogue(Jeroen.getName(), Constants.JeroenDialog3);
        JeroenTestimony.addDialogue(sholmes.getName(), Constants.sholmesJeroenDialog4);
        Jeroen.addTestimony(JeroenTestimony);


        //adding areas and the respective suspects


         List<Area> areas = new ArrayList<>();

         Area Uccle = new Area("Uccle");
         Uccle.setInstinct();
         Uccle.addSuspect(Jacques);
         Uccle.addSuspect(Nathalie);
         Uccle.addSuspect(Noemie);
         Uccle.addSuspect(Beat);
         areas.add(Uccle);

         Area Ixelles = new Area("Ixelles");
         Ixelles.setInstinct();
         Ixelles.addSuspect(Sophie);
         Ixelles.addSuspect(Diana);
         Ixelles.addSuspect(Leslito);
         Ixelles.addSuspect(Yannick);
         areas.add(Ixelles);

         //Please note the dialogs in the following area "Forest" are AI generated.
         Area Forest = new Area("Forest");
         Forest.setReward(); // this function will hide heros reward in an area
         Forest.addSuspect(Laurent);
         Forest.addSuspect(Liesbeth);
         Forest.addSuspect(Jeroen);
         areas.add(Forest);

         //add all the suspects whose testimonies will be correct to make a culprit guilty

        List<Suspect> correctEvidence = List.of(Jacques, Sophie, Diana);

        return new Episode("A Swing and a Hit",
                "Hugo De Smet was attacked by a mysterious perpetrator. Can you find the evidence?",
                areas,
                correctEvidence, Diana);
    }

}
