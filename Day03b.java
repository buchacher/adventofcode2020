import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day03b {


    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();

        System.out.println(treeCountAtSlope(1, 1, parsedInput));
        System.out.println(treeCountAtSlope(3, 1, parsedInput));
        System.out.println(treeCountAtSlope(5, 1, parsedInput));
        System.out.println(treeCountAtSlope(7, 1, parsedInput));
        System.out.println(treeCountAtSlope(1, 2, parsedInput));

        int a = treeCountAtSlope(1, 1, parsedInput);
        int b = treeCountAtSlope(3, 1, parsedInput);
        int c = treeCountAtSlope(5, 1, parsedInput);
        int d = treeCountAtSlope(7, 1, parsedInput);
        int e = treeCountAtSlope(1, 2, parsedInput);
        long s = (long) a * b * c * d * e;

        System.out.println("Product:");
        System.out.println(s);
    }

    private static int treeCountAtSlope(int xDir, int yDir, String[] parsedInput) {
        char tree = "#".toCharArray()[0];
        int treeCount = 0;

        int x = xDir;
        for (int y = yDir; y < parsedInput.length; y = y + yDir) {
            if (parsedInput[y].charAt(x) == tree) {
                treeCount++;
            }
            x = x + xDir;
        }
        return treeCount;
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
