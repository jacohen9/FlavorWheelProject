import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args)  throws IOException {
        // First, read in the flavor wheel and build the list of flavors
        FlavorWheelParser parser = new FlavorWheelParser();
        parser.parseWheelInput();

        // Next, parse the input
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        for (String line : lines) {
            List<List<String>> outStrArray = Flavor.parseTastingNote(line);
            System.out.println("Output: " + outStrArray.toString());
        }
    }
}
