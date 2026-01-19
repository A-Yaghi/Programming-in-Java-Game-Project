import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Sidra + Abbas
 * this is mr. Sheriff he would basically review the evidences if they are  correct or not.  He is basically the boss of
 * Herlock Sholmes.
 */
public class Sheriff {
    private String name;
    private Scanner scanner;
    private List<Suspect> presentedCorrectSuspects;
    /**
     * Constructor for the Sheriff
     * @param name
     */
    public Sheriff(String name) {
        this.name = name;
        scanner = new Scanner(System.in);
        presentedCorrectSuspects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Checks if the provided evidence by the player is correct or not. If all the correct evidence is presented,
     * the final dialogue is played and the game is won. If the player runs out of attempts (coupons), the game is lost.
     * @param scanner
     * @param player
     * @param correctEvidence
     */

    public void reviewEvidence(Scanner scanner, Player player, List<Suspect> correctEvidence) {
        String evidencePresentation ="Enter the evidence you want to present:";
        Utilities.displayDialog(evidencePresentation ,name, Utilities.stringDisplaySpeed, Constants.ANSI_YELLOW);
        int biggerThanBagSize = player.getBackPack().getInspectedSuspects().size()+1;
        System.out.println("Choose the evidence you want to present or press " + biggerThanBagSize + " to exit and go back:");
        System.out.println(player.getBackPack());

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
        while ( choice != player.getBackPack().getInspectedSuspects().size()+1 && player.hasCoupons() ){
            if (choice > 0 && choice <= player.getBackPack().getInspectedSuspects().size()) {
                Suspect suspect = player.getBackPack().getInspectedSuspects().get(choice-1);
                if (correctEvidence.contains(suspect) && !presentedCorrectSuspects.contains(suspect)) {
                    System.out.println("Sheriff: This is a solid piece of evidence! Not bad, kid!");
                    player.addCorrectEvidence();
                    presentedCorrectSuspects.add(suspect);
                    if (presentedCorrectSuspects.size() == 3){
                        Utilities.displayDialog( Constants.finalDialog1, this.name, Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
                        Utilities.displayDialog( Constants.finalDialog2, "Herlock Sholmes", Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
                        Utilities.displayDialog( Constants.finalDialog3, this.name, Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
                        Utilities.displayDialog( Constants.finalDialog4, "", Utilities.stringDisplaySpeed, Constants.ANSI_WHITE);
                        Utilities.displayDialog( Constants.finalDialog5, "", Utilities.stringDisplaySpeed, Constants.ANSI_WHITE);
                        Utilities.displayDialog( Constants.finalDialog6, "Diana Draconia", Utilities.stringDisplaySpeed, Constants.ANSI_RED);
                        Utilities.displayDialog( Constants.finalDialog7, "Diana Draconia", Utilities.stringDisplaySpeed, Constants.ANSI_RED);
                        Utilities.displayDialog( Constants.finalDialog8, "Herlock Sholmes", Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
                        Utilities.displayDialog( Constants.finalDialog9, this.name, Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
                        Utilities.displayDialog( Constants.finalDialog10, "Herlock Sholmes", Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
                        System.out.println("You win! Thank you for playing!");
                        System.exit(0);
                    }
                    System.out.println("Choose the evidence you want to present or press " + biggerThanBagSize + " to exit and go back:");
                    System.out.println(player.getBackPack());
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else if (correctEvidence.contains(suspect) && presentedCorrectSuspects.contains(suspect)) {
                    System.out.println("You can't present the same correct evidence twice! Try again");
                    System.out.println("Choose the evidence you want to present or press " + biggerThanBagSize + " to exit and go back:");
                    System.out.println(player.getBackPack());
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
                else {
                    System.out.println("Sheriff: This evidence is incorrect. How disappointing!");
                    player.loseCoupon();
                    if (player.hasCoupons()){
                        System.out.println("Choose the evidence you want to present or press " + biggerThanBagSize + " to exit and go back:");
                        System.out.println(player.getBackPack());
                        choice = scanner.nextInt();
                        scanner.nextLine();
                    }
                }
            }
            else {
                System.out.println("The input is incorrect. Try again");
                System.out.println("Choose the evidence you want to present or press " + biggerThanBagSize + " to exit and go back:");
                System.out.println(player.getBackPack());
                choice = scanner.nextInt();
                scanner.nextLine();
            }
        }
        if (!player.hasCoupons()){
            System.out.println("Herlock Sholmes: Everyone was right. I am completely useless.");
            System.out.println("I’ll go back home and wallow in self pity, IF my parents allow me back home. This dream is over.");
            System.out.println("I’m a dumbass and nothing but a dumbass. Maybe they allow dumbasses to work at a fast food chain or something. We’ll see..");
            System.out.println("You lost! HAHA! The end!");
            System.exit(0);
        }
    }



}
