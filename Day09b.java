import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * References:
 * https://www.youtube.com/watch?v=qwzAHTIo0r0&ab_channel=TurkeyDev
 * [Accessed 2021-01-01]
 */
public class Day09b {

    static final int PREAMBLE_LEN = 25;

    public static void main(String[] args) throws IOException {
        List<String> parsedInput;
        parsedInput = parseInput();

        int badNum = 0;
        int badNumIndex = 0;
        List<Integer> prev = new ArrayList<>();
        for (int index = 0; index < PREAMBLE_LEN; index++) {
            prev.add(Integer.parseInt(parsedInput.get(index)));
        }

        for (int i = PREAMBLE_LEN; i < parsedInput.size(); i++) {
            int num = Integer.parseInt(parsedInput.get(i));
            boolean found = false;
            for (int j = 0; j < prev.size(); j++) {
                if (found) {
                    break;
                }
                for (int k = j + 1; k < prev.size(); k++) {
                    int prev1 = prev.get(j);
                    int prev2 = prev.get(k);
                    if (prev1 + prev2 == num) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                prev.remove(0);
                prev.add(num);
            }
            else {
                badNum = num;
                badNumIndex = i;
                System.out.println("Part 1: " + badNum);
                break;
            }
        }

        boolean found = false;
        for (int i = 0; i < badNumIndex-2; i++) {
            if (found) {
                break;
            }
            for (int j = i+1; j < badNumIndex; j++) {
                int sum = 0;
                int smallest = Integer.MAX_VALUE;
                int largest = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int num = Integer.parseInt(parsedInput.get(k));
                    sum += num;
                    if (num < smallest) {
                        smallest = num;
                    }
                    else if (num > largest) {
                        largest = num;
                    }
                }

                if (sum == badNum) {
                    found = true;
                    System.out.println("Part 2: " + (smallest + largest));
                    break;
                }
            }
        }
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
