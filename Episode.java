import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Sidra + Abbas
 * Episode class represents the levels of the game For current game player needs to pass the episode to win the game
 */
public class Episode {
    private String title;
    private String description;
    private List<Area> areas;
    private List<Suspect> correctSuspectsTestimony;
    private Suspect culprit;
    private Scanner scanner;

    /**
     * Constructor for class Episode
     * @param title
     * @param description
     * @param areas
     * @param correctEvidence
     */
    public Episode(String title, String description, List<Area> areas, List<Suspect> correctEvidence , Suspect culprit) {
        this.title = title;
        this.description = description;
        this.areas = areas;
        this.correctSuspectsTestimony = correctEvidence;
        this.culprit = culprit;
        scanner = new Scanner(System.in);
    }

    /**
     * Getter for title of the episode
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter for details of the episode
     */
    public void getDetails() {
        System.out.println(description);
    }

    /**
     * getter for the correct evidence
     * @return correctSuspectsTestimony
     */
    public List<Suspect> getCorrectSuspectsTestimony() {
        return correctSuspectsTestimony;
    }

    /**
     * The moveLocation method which is used to allow the player to move from one area to the
     * next and question the suspects of the area or get items in from that area.
     * @param scanner
     * @param sholmes
     */
    public void moveLocation(Scanner scanner, Player sholmes){
        System.out.println("Choose an Area to Move:");
        for (int i = 0; i < areas.size(); i++) {
            System.out.println((i + 1) + ". " + areas.get(i).getName());
        }

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

        if (choice > 0 && choice <= areas.size()) {
            Area selectedArea = areas.get(choice - 1);
            Utilities.displayDialog("Moved to: " + selectedArea.getName(),selectedArea.getName(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);


            System.out.println("\nChoose an action: ");
            System.out.println("1. Question a suspect");
            System.out.println("2. Look Around");
            int choice2 = -1;
            while (true) {
                try {
                    choice2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    break; // Exit the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number from the above choices.");
                    scanner.nextLine(); // Clear the invalid input from the scanner
                }
            }

            switch (choice2) {
                case 1  -> this.questionSuspect(scanner, sholmes, selectedArea);
                case 2 -> this.findItems(scanner, sholmes, selectedArea);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        else {
            System.out.println("Invalid choice. Please select a number between 1 and " + areas.size() + ".");

        }

    }

    /**
     * The method is used to create the concept of the player inspecting an area
     * and find usable items and add them to the player's items collection.
     * @param scanner
     * @param sholmes
     * @param selectedArea
     */
    public void findItems(Scanner scanner, Player sholmes, Area selectedArea) {
        if(selectedArea.findReward()){
            System.out.println("You have found a Hero's Reward. Adding it to your items collection.");
            sholmes.addItem("Hero's Reward");
            selectedArea.lookedAround();
        }
        else if(selectedArea.getInstinct() && selectedArea.getName().equals("Uccle")){
            System.out.println("You have found a Detective's Instinct: Uccle" );
            sholmes.addItem("Detective's Instinct: Uccle");
            selectedArea.lookedAround();
        }
        else if(selectedArea.getInstinct() && selectedArea.getName().equals("Ixelles")){
            System.out.println("You have found a Detective's Instinct: Ixelles" );
            sholmes.addItem("Detective's Instinct: Ixelles");
            selectedArea.lookedAround();
        }

        else System.out.println("*There is nothing around here*");
    }

    /**
     * Method to question suspect by choosing suspects from each episode
     * @param scanner
     * @param sholmes
     */
    public void questionSuspect(Scanner scanner, Player sholmes, Area area) {
        System.out.println("Choose a suspect to question:");
        for (int i = 0; i < area.getSuspects().size(); i++) {
            System.out.println((i + 1) + ". " + area.getSuspects().get(i).getName());
        }

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

        if (choice > 0 && choice <= area.getSuspects().size()) {
            Suspect suspect = area.getSuspects().get(choice - 1);
                    suspect.getTestimony().getDialogueHistory();
                    if (!suspect.isInspected()){
                        sholmes.getBackPack().addTestimony(suspect);
                        suspect.doneInspected();
                    }
        } else {
            System.out.println("Invalid choice. Please select a number between 1 and " + area.getSuspects().size() + ".");
        }
    }

}
