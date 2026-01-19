/**
 * Sidra + Abbas
 *
 * All the suspects in the game
 * Inspected marks that the player interacted with the suspect and got their evidence. This helps
 * avoid storing the same testimonies multiple times.
 * testimony is the dialog stored for the suspect.
 */

public class Suspect {
    private String name;
    private boolean inspected;
    private Conversation testimony;

    /**
     * Constructor for Suspect class
     * @param name
     */
    public Suspect(String name) {
        this.name = name;
        this.inspected = false;
    }

    /**
     * getter for the name of the suspect
     * @return
     */
    public String getName() {
        return name;
    }

    public void doneInspected() {
        this.inspected = true;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void addTestimony(Conversation conversation) {
        this.testimony = conversation;

    }
    public Conversation getTestimony() {
        return testimony;
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "name='" + name + '\'' +
                ", testimony=" + testimony +
                '}';
    }
}
