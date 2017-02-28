import java.util.ArrayList;
import java.util.List;

public class Flavor {
    private String flavorName;
    private Flavor parent = null;
    private int compositeLength = 0;

//    public Flavor getParent() {
//        return parent;
//    }
//
//    public void setParent(Flavor parent) {
//        this.parent = parent;
//    }

    public static List<Flavor> allFlavors = new ArrayList<Flavor>();


    public Flavor(String flavorName, Flavor parent){
        this.flavorName = flavorName;
        this.parent = parent;
        String[] nameAsArray = flavorName.split("\\s+");
        if (nameAsArray.length > 1)
            this.compositeLength = nameAsArray.length;
        allFlavors.add(this);
    }

    public void buildTastingString(List<String> flavorNote) {
        flavorNote.add(this.flavorName);
        if (this.parent != null)
            this.parent.buildTastingString(flavorNote);
    }

    public static List<List<String>> parseTastingNote(String note) {
        String[] noteAsArray = note.split("\\s+");
        List<List<String>> resultArray = new ArrayList<List<String>>();

        for (int index = 0; index < noteAsArray.length; index++) {
            String nextString = index >= noteAsArray.length - 1 ? "" : noteAsArray[index+1];
            Flavor currFlavor = findFlavor(noteAsArray[index], nextString);
            if (currFlavor != null) {
                List<String> flavorNote = new ArrayList<String>();
                currFlavor.buildTastingString(flavorNote);
                resultArray.add(flavorNote);
                if (currFlavor.compositeLength > 0)
                    index++;
            }
        }

        return resultArray;
    }

    public static Flavor findFlavor(String flavorName, String nextString) {
        String compositeFlavor = flavorName + " " + nextString;
        for(Flavor flavor : allFlavors){
            // Simplistic approach, exact match on name
            if (flavor.flavorName.equalsIgnoreCase(flavorName)) {
                return flavor;
            }
            // 2 word composite
            if (flavor.compositeLength == 2) {
                if (flavor.flavorName.equalsIgnoreCase(compositeFlavor) ) {
                    return flavor;
                }
            }
        }
        return null;
    }
}
