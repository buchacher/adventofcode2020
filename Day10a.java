import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day10a {

    public static void main(String[] args) throws IOException {
        List<String> parsedInput;
        parsedInput = parseInput();

        ArrayList<Integer> adapters = new ArrayList<>();
        for (String s : parsedInput) {
            adapters.add(Integer.parseInt(s));
        }
        adapters.add(0); // Add charging outlet (joltage 0) to adapters
        Collections.sort(adapters);

        int count1 = 0;
        int count3 = 1; // Internal adapter is largest+3, so will always be an additional 3-jolt difference
        for (int i = 0; i < adapters.size()-1; i++) { // No need to compare last to next element
            if (adapters.get(i+1) - adapters.get(i) == 1) {
                count1++;
            }
            else if (adapters.get(i+1) - adapters.get(i) == 3) {
                count3++;
            }
        }

        System.out.println("Part 1: " + (count1 * count3));
    }

    private static List<String> parseInput() throws IOException {
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
        List<String> stringArray;
        stringArray = Arrays.asList(sb.toString().split("\n"));
        return stringArray;
    }
}
