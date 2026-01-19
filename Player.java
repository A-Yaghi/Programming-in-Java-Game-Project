import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Sidra + Abbas
 * There will be only one player in each game in our case the player is Herlock Sholmes which is assumed to be the player playing the game.
 * Coupons are the "attempts" in this game, which is how many mistakes is the player allowed.
 * The backpack stores all the testimonies Herlock takes.
 * The items store all usable items Herlock finds.
 */
public class Player {
    private String name;
    private int coupons;
    private int correctEvidenceCount;
    private BackPack backPack;
    private List<String> items;

    /**
     * Constructor for the Player class
     * @param name
     * @param coupons
     */
    public Player(String name, int coupons) {
        this.name = name;
        this.coupons = coupons;
        this.correctEvidenceCount = 0;
        backPack = new BackPack();
        items = new ArrayList<>();
    }

    /**
     * getter for the players name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the players coupons
     * @return coupons
     */
    public int getCoupons() {
        return coupons;
    }

    /**
     * Checks if the player has enough coupons to play further
     * @return true if coupons are higher than 0
     */
    public boolean hasCoupons() {
        return coupons > 0;
    }


    /**
     * decreases coupon count by 1 whenever a player provides wrong evidence
     */
    public void loseCoupon() {
        coupons--;
        System.out.println("You lost a coupon! Remaining: " + coupons);
    }

    /**
     * get the count for the evidences presented correctly
     * @return correctEvidenceCount
     */
    public int getCorrectEvidenceCount() {
        return correctEvidenceCount;
    }

    /**
     * adds to the correct evidence count.
     */
    public void addCorrectEvidence() {
        correctEvidenceCount++;
        System.out.println("Correct evidence found! Total: " + correctEvidenceCount);
    }

    /**
     * adds to the coupons count.
     */
    public void addCoupon(){
        coupons++;
    }

    /**
     * gets the backpack with all the collected testimonies.
     * @return backPack
     */
    public BackPack getBackPack() {
        return backPack;
    }

    /**
     * gets the items collection with all the collected usable items.
     * @return items
     */
    public List<String> getItems(){return items;}

    /**
     * adds an item to the collected usable items collection.
     */
    public void addItem(String item){
        items.add(item);
    }

    /**
     * removes an item from the collected usable items collection.
     */
    public void removeItem(String item){
        items.remove(item);
    }

    /**
     * The method used to create the entire structure of interactable items.
     * We didn't find a need to create a separate items class as in this game, it can all be done with strings.
     * The method displays the items collections and allows the user to either use the items or drop them.
     */
    public void itemsCollection(Scanner scanner, Player sholmes) {
        System.out.println("Here is what you have in your items collection:");
        System.out.println(sholmes.getItems());
        for (int i = 0; i < sholmes.getItems().size(); i++) {
            System.out.println((i + 1) + ". " + sholmes.getItems().get(i));
        }
        System.out.println("Choose an item or input anything else to continue if your collection is empty");
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
        if (!sholmes.getItems().isEmpty()){
            if (choice > 0 && choice <= sholmes.getItems().size()) {
                String item = sholmes.getItems().get(choice -1);
                if (item.equals("Hero's Reward")){
                    System.out.println("Hero's Reward: Gives you one Beginner’s Mercy Coupon");
                    System.out.println("Choose what to do: 1. Use   2. Drop");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 :
                            sholmes.addCoupon();
                            System.out.println("You have a total of "+ sholmes.getCoupons()+" coupons");
                            sholmes.removeItem("Hero's Reward");
                            break;
                        case 2 :
                            sholmes.removeItem("Hero's Reward");
                            System.out.println("Hero's Reward was dropped from your items Collection");
                            break;
                        default: System.out.println("Invalid choice. Try again.");
                    }
                }
                else if (item.equals("Detective's Instinct: Uccle")){
                    System.out.println("Detective's Instinct: Uccle: Gives you one hint regarding the Uccle area");
                    System.out.println("Choose what to do: 1. Use   2. Drop");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 :
                            System.out.println("Jacques seems to have relevant information.");
                            sholmes.removeItem("Detective's Instinct: Uccle");
                            break;
                        case 2 :
                            sholmes.removeItem("Detective's Instinct: Uccle");
                            System.out.println("Detective's Instinct: Uccle was dropped from your items Collection");
                            break;
                        default: System.out.println("Invalid choice. Try again.");
                    }
                }
                else if (item.equals("Detective's Instinct: Ixelles")){
                    System.out.println("Detective's Instinct: Ixelles: Gives you one hint regarding the Ixelles area");
                    System.out.println("Choose what to do: 1. Use   2. Drop");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 :
                            System.out.println("Sophie seems to have relevant information.");
                            sholmes.removeItem("Detective's Instinct: Ixelles");
                            break;
                        case 2 :
                            sholmes.removeItem("Detective's Instinct: Ixelles");
                            System.out.println("Detective's Instinct: Ixelles was dropped from your items Collection");
                            break;
                        default: System.out.println("Invalid choice. Try again.");
                    }
                }
            } else  {
                System.out.println("Invalid choice. Please select a number between 1 and " + sholmes.getItems().size() + ".");
            }
        }
    }
}
