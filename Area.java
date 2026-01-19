import java.util.ArrayList;
import java.util.List;

/**
 * Sidra + Abbas
 * Area Class represents different areas where a player can move to investigate or talk to the suspects.
 * suspects list stores the suspects in an area.
 * reward indicates there's a Hero's Reward item in the area.
 * instinct indicates there is a Detective's Instinct item in the area.
 */
public class Area {
    private String name;
    private List<Suspect> suspects;
    private boolean reward;
    private boolean instinct;

    /**
     * Constructor for class Area
     * @param name
     */
    public Area(String name) {
        this.name = name;
        this.suspects = new ArrayList<>();
        this.reward = false;
    }

    /**
     * getters and setters for the Area class.
     */
    public String getName() {
        return name;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public void addSuspect(Suspect suspect) {
        this.suspects.add(suspect);
    }

    /**
     * indicates that the area has a Hero's Reward item.
     */
    public void setReward() {
        this.reward = true;
    }

    /**
     * @return true if the area has a Hero's Reward item.
     */
    public boolean findReward () {
        return reward;
    }


    public void setRewardTaken() {
        this.reward = false;
    }

    /**
     * indicates that the area has a Detective's Instinct item.
     */
    public void setInstinct() {
        this.instinct = true;
    }

    /**
     * @return true if the area has a Detective's Instinct item.
     */
    public boolean getInstinct() {
        return instinct;
    }

    /**
     * clears the area of any items.
     */
    public void lookedAround(){
        reward = false;
        instinct = false;
    }

}
//make a separate class jus for constant