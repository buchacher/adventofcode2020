import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Day08a {



    public static void main(String[] args) throws IOException {
        List<String> parsedInput;
        parsedInput = parseInput();

        Map<Integer, String[]> idxInstr = new HashMap<>();
        // Build HashMap
        for (int i = 0; i < parsedInput.size(); i++) {
            String line = parsedInput.get(i);
            String[] instr = new String[3];
            // [opp][+/-][val]
            instr[0] = line.split(" ")[0];
            instr[1] = line.split(" ")[1].substring(0, line.split(" ")[1].length()-(line.split(" ")[1].length()-1));
            instr[2] = line.split(" ")[1].substring(1);

            idxInstr.put(i, instr);
        }

        ArrayList<Integer> visited = new ArrayList<>();
        int pointer = 0;
        int acc = 0;
        while (!visited.contains(pointer)) { // Will break before instruction is visited a second time
            visited.add(pointer);
            String[] instr = idxInstr.get(pointer);

            if (instr[0].equals("acc")) {
                if (instr[1].equals("+")) {
                    acc += Integer.parseInt(instr[2]);
                }
                else {
                    acc -= Integer.parseInt(instr[2]);
                }

                pointer++;
            }
            else if (instr[0].equals("jmp")) {
                if (instr[1].equals("+")) {
                    pointer += Integer.parseInt(instr[2]);
                }
                else {
                    pointer -= Integer.parseInt(instr[2]);
                }
            }
            else { // instr[0] == "nop"
                pointer++;
            }
        }

        System.out.println("Part 1: " + acc);
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
