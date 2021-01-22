import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day06a {

    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();

        int[] arrNUniques = new int[parsedInput.length];

        for (int i = 0; i < parsedInput.length; i++) {
            String group = parseGroup(parsedInput[i]);
            char[] grChArr = group.toCharArray();
            ArrayList<String> grUnique = new ArrayList<>();
            for (int j = 0; j < grChArr.length; j++) {
                if (!grUnique.contains(String.valueOf(grChArr[j]))) {
                    grUnique.add(String.valueOf(grChArr[j]));
                }
                arrNUniques[i] = grUnique.size();
            }
        }

        int sum = 0;
        for (int i = 0; i < arrNUniques.length; i++) {
            sum += arrNUniques[i];
        }

        System.out.println(sum);

    }

    private static String parseGroup(String gr) {
        return gr.replace("\n", "").strip();
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

