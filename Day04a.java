import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day04a {


    public static void main(String[] args) throws IOException {
        String[] parsedInput;
        parsedInput = parseInput();

        int validCount = 0;
        for (int i = 0; i < parsedInput.length; i++) {
            if (checkValidity(parsedInput[i])) {
                validCount++;
            }
        }

        System.out.println(validCount);
    }

    private static boolean checkValidity(String creds) {
        boolean byr = creds.contains("byr");
        boolean iyr = creds.contains("iyr");
        boolean eyr = creds.contains("eyr");
        boolean hgt = creds.contains("hgt");
        boolean hcl = creds.contains("hcl");
        boolean ecl = creds.contains("ecl");
        boolean pid = creds.contains("pid");

        return byr && iyr && eyr && hgt && hcl && ecl && pid;
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
