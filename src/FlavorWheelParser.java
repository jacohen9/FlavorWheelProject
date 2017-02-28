import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FlavorWheelParser {
    // Iterate thru the flavor wheel input
    public void parseWheelInput() {
        String contents = "{}";
        try {
            contents = Files.lines(Paths.get("scaa_flavor_wheel.json")).collect(Collectors.joining("\n"));
            // System.out.println("Input: " + contents);
        }
        catch (java.io.IOException e) {
            System.out.println("Unable to read wheel input file");
            return;
        }

        JSONObject mainWheel = new JSONObject(contents);
        JSONArray allItems = mainWheel.getJSONArray("children");
        fillFlavor(null, allItems);

        List<Flavor> flavors = Flavor.allFlavors;
    }

    private void fillFlavor(Flavor currFlavor, JSONArray flavorChildren)
    {
        for (int i = 0; i < flavorChildren.length(); i++) {
            JSONObject obj = flavorChildren.getJSONObject(i);
            Flavor thisFlavor = new Flavor(obj.getString("flavor"), currFlavor);
            if (obj.has("children")) {
                JSONArray children = obj.getJSONArray("children");
                fillFlavor(thisFlavor, children);
            }
        }
    }
}
