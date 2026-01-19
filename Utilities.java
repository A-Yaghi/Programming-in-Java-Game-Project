import java.util.Scanner;
/**
 * Author: Sidra + Abbas
 * Description: We decided to make this class to make the displayDialog method usable in
 * every class with creating an instance of it as it is needed a lot.
 * The stringDisplaySpeed controls the speed of the displayed text.
 * Default is 13. More is slower.
 */
public class Utilities {

    public static Scanner scanner=new Scanner(System.in);

    public static final long stringDisplaySpeed=13;

    // Private constructor to prevent instantiation
    private Utilities() {
        throw new UnsupportedOperationException("Utility class");
    }


    /**
     * THis method was made to display text in dialog manner
     * with a speaker
     * change color
     * change speed with which txt can be displayed
     * @param text
     * @param speaker
     * @param speed
     * @param colorAnsi
     */
    public static void displayDialog(String text, String speaker, long speed, String colorAnsi){
        System.out.println(Constants.ANSI_GREEN + speaker +":"+ Constants.ANSI_RESET);
        System.out.println(colorAnsi);
        String[] lines = text.split("\n"); // Split by newline character

        for (String line : lines) {
            // Display one line character by character
            for (int i = 0; i < line.length(); i++) {
                System.out.printf("%c", line.charAt(i));
                try {
                    Thread.sleep(speed); // Pause between characters
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Constants.ANSI_RESET);
            waitForUserInput();
            System.out.println(colorAnsi);
        }

        System.out.println(Constants.ANSI_RESET);
    }

    /**
    * Private helper method for the displayDialog method above to make it wait
     * for the user's input and take any input even just pressing Enter.
    */
    private static void waitForUserInput() {
        System.out.println("Press Enter or input anything to continue...");
        scanner.nextLine(); // Waits for the user to press Enter
    }


}
