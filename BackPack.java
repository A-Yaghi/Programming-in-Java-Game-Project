import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sidra + Abbas
 * Description: Class used to store all the inspected suspects' testimonies to be presented to the sheriff.
 */
public class BackPack {
    private List<Suspect> inspectedSuspects;
    public BackPack() {
        inspectedSuspects = new ArrayList<>();
    }
    public void addTestimony(Suspect suspect){
        inspectedSuspects.add(suspect);
    }

    public List<Suspect> getInspectedSuspects() {
        return inspectedSuspects;
    }


    @Override
    public String toString() {
        StringBuilder temp= new StringBuilder("Here is whats in your BackPack: ");
        temp.append("\nSuspects: \n");

        for (int i=0; i<inspectedSuspects.size(); i++) {
            temp.append(i + 1).append(". : "+ inspectedSuspects.get(i).getName()).append("'s Testimony\n");
        }

        return temp.toString();
    }
}
