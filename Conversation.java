/**
 * Author: Sidra + Abbas
 * Description: class used to display conversations.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a conversation between Sholmes and a suspect.
 */
public class Conversation {
    private final List<Dialogue> dialogueHistory = new ArrayList<>();
    private Player sholmes;

    public Conversation(Player player) {
        this.sholmes = player;
    }
    /**
     * Adds a line of dialogue to the conversation.
     *
     * @param speaker The speaker (e.g., "Sholmes" or the suspect's name).
     * @param message The message spoken by the speaker.
     */
    public void addDialogue(String speaker, String message) {

        dialogueHistory.add(new Dialogue(speaker, message));
    }

    /**
     * Retrieves the entire dialogue history as a formatted string.
     *
     * @return The formatted dialogue history.
     */
    public String getDialogueHistory() {
        StringBuilder history = new StringBuilder();
        for (Dialogue d : dialogueHistory) {
            //color the dialog blue in case othe speaker is sholmes else CYAN
            if (d.getSpeaker().equals(sholmes.getName())){
                Utilities.displayDialog(d.getMessage(), d.getSpeaker(), Utilities.stringDisplaySpeed, Constants.ANSI_BLUE);
            }
            else{
                Utilities.displayDialog(d.getMessage(), d.getSpeaker(), Utilities.stringDisplaySpeed, Constants.ANSI_CYAN);
            }


            history.append(d.getSpeaker()).append(": ").append(d.getMessage()).append("\n");
        }
        return history.toString();
    }
}

