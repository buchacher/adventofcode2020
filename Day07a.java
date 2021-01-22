import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day07a {

    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();

        ArrayList<String> validBags = new ArrayList<>();

        for (int i = 0; i < parsedInput.length; i++) {
            if (parsedInput[i].split("contain")[1].contains("shiny gold")) {
                validBags.add(parsedInput[i].split("contain")[0].split(" bag")[0]);
            }
        }

        for (int h = 0; h < 5; h++) {
            for (int i = 0; i < parsedInput.length; i++) {
                for (int j = 0; j < validBags.size(); j++) {
                    if (parsedInput[i].split("contain")[1].contains(validBags.get(j))) {
                        validBags.add(parsedInput[i].split("contain")[0].split(" bag")[0]);
                    }
                }
            }
        }

        // Remove duplicates from ArrayList
        Set<String> validDistinct = new LinkedHashSet<String>(validBags);
        // Answer is validDistinct size
        System.out.println(validDistinct.size());
    }

    private static String[] parseInput() throws IOException {
        File file = new File("src/in.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        fr.close();
        String[] stringArray;
        stringArray = sb.toString().split("\n");
        return stringArray;
    }
}
