import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day06b {

    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();

        int[] answeredByAllInGroup = new int[parsedInput.length];

        for (int i = 0; i < parsedInput.length; i++) {
            String[] persons = parsePersons(parsedInput[i]);

            ArrayList<String> alphabet = new ArrayList<>();
            alphabet.add("a");
            alphabet.add("b");
            alphabet.add("c");
            alphabet.add("d");
            alphabet.add("e");
            alphabet.add("f");
            alphabet.add("g");
            alphabet.add("h");
            alphabet.add("i");
            alphabet.add("j");
            alphabet.add("k");
            alphabet.add("l");
            alphabet.add("m");
            alphabet.add("n");
            alphabet.add("o");
            alphabet.add("p");
            alphabet.add("q");
            alphabet.add("r");
            alphabet.add("s");
            alphabet.add("t");
            alphabet.add("u");
            alphabet.add("v");
            alphabet.add("w");
            alphabet.add("x");
            alphabet.add("y");
            alphabet.add("z");

            int inAll = 0;
            for (int j = 0; j < alphabet.size(); j++) {
                int count = 0;
                for (int k = 0; k < persons.length; k++) {
                    if (persons[k].contains(alphabet.get(j))) {
                        count++;
                    }
                }
                if (count == persons.length) {
                    inAll++;
                }
            }
            answeredByAllInGroup[i] = inAll;
        }

        int sum = 0;
        for (int i = 0; i < answeredByAllInGroup.length; i++) {
            sum += answeredByAllInGroup[i];
        }
        System.out.println(sum);
    }

    private static String[] parsePersons(String gr) {
        return gr.split("\n");
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
        stringArray = sb.toString().split("\n\n");
        return stringArray;
    }
}

