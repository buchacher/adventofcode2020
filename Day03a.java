import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day03a {

    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();

        char tree = "#".toCharArray()[0];
        int treeCount = 0;

        int x = 3;
        for (int y = 1; y < parsedInput.length; y++) {
            if (parsedInput[y].charAt(x) == tree) {
                treeCount++;
            }
            x = x + 3;
        }

        System.out.println("Tree count:");
        System.out.println(treeCount);
    }

    private static String[] parseInput() throws IOException {
        File file = new File("src/in.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line.repeat(100));
            sb.append("\n");
        }
        fr.close();
        String[] stringArray;
        stringArray = sb.toString().split("\n");
        return stringArray;
    }
}
