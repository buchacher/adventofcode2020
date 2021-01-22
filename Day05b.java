import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * References:
 * https://www.youtube.com/watch?v=wa0VcQugEsI&ab_channel=JonathanPaulson
 * [Accessed 2020-12-30]
 */
public class Day05b {

    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();
        ArrayList<Integer> seatIdArr = new ArrayList<>();

        for (int i = 0; i < parsedInput.length; i++) {
            seatIdArr.add(parseRow(parsedInput[i]));
        }

//        int max = Collections.max(seatIdArr);
//        System.out.println(max);

        Collections.sort(seatIdArr);

        ArrayList<Integer> nonExist = new ArrayList<>();

        for (int i = 0; i < seatIdArr.size() - 1; i++) { // -1 because last id will not have id + 1
            int id = seatIdArr.get(i);
            if (!seatIdArr.contains(id + 1)) {
                nonExist.add(id + 1);
            }
        }

        System.out.println(nonExist);
    }

    private static int parseRow(String rowStr) {
        char[] chArr = rowStr.toCharArray();

        int seatId = 0;

        int row = 0;
        int rp = 64;

        int col = 0;
        int cp = 4;

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == 'B') {
                row += rp;
                rp /= 2;
            }
            else if (chArr[i] == 'F') {
                rp /= 2;
            }

            if (chArr[i] == 'R') {
                col += cp;
                cp /= 2;
            }
            else if (chArr[i] == 'L') {
                cp /= 2;
            }

            seatId = row * 8 + col;
        }

        return seatId;
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
