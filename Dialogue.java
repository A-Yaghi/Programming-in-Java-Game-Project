/**
 * Author: Sidra + Abbas
 * Description: Represents a single line of dialogue.
 */
class Dialogue {
    private final String speaker;
    private final String message;

    public Dialogue(String speaker, String message) {
        this.speaker = speaker;
        this.message = message;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getMessage() {
        return message;
    }
}
