import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * References:
 * https://www.youtube.com/watch?v=ZSGTr55gmIs&ab_channel=JonathanPaulson
 * [Accessed 2021-01-01]
 */
public class Day08b {

    public static void main(String[] args) throws IOException {
        List<String> parsedInput;
        parsedInput = parseInput();

        // Original HashMap
        Map<Integer, String[]> idxInstrOld = new HashMap<>();
        for (int i = 0; i < parsedInput.size(); i++) {
            String lineOld = parsedInput.get(i);
            String[] instrOld = new String[3];
            // [opp][+/-][val]
            instrOld[0] = lineOld.split(" ")[0];
            instrOld[1] = lineOld.split(" ")[1].substring(0, lineOld.split(" ")[1].length()-(lineOld.split(" ")[1].length()-1));
            instrOld[2] = lineOld.split(" ")[1].substring(1);

            idxInstrOld.put(i, instrOld);
        }

        for (int j = 0; j < idxInstrOld.size(); j++) {
            // New HashMap for every change
            Map<Integer, String[]> idxInstrNew = new HashMap<>();
            for (int k = 0; k < parsedInput.size(); k++) {
                String line = parsedInput.get(k);
                String[] instr = new String[3];
                // [opp][+/-][val]
                instr[0] = line.split(" ")[0];
                instr[1] = line.split(" ")[1].substring(0, line.split(" ")[1].length()-(line.split(" ")[1].length()-1));
                instr[2] = line.split(" ")[1].substring(1);

                idxInstrNew.put(k, instr);
            }
            if (idxInstrNew.get(j)[0].equals("nop")) {
                idxInstrNew.put(j, new String[]{"jmp", idxInstrNew.get(j)[1], idxInstrNew.get(j)[2]});
            }
            else if (idxInstrNew.get(j)[0].equals("jmp")) {
                idxInstrNew.put(j, new String[]{"nop", idxInstrNew.get(j)[1], idxInstrNew.get(j)[2]});
            }

            int t = 0;
            int ip = 0;
            int acc = 0;
            while (ip >= 0 && ip < idxInstrNew.size() && t < 1000) {
                t += 1;
                String[] instr = idxInstrNew.get(ip);
                if (instr[0].equals("acc")) {
                    if (instr[1].equals("+")) {
                        acc += Integer.parseInt(instr[2]);
                    }
                    else {
                        acc -= Integer.parseInt(instr[2]);
                    }
                    ip++;
                }
                else if (instr[0].equals("nop")) {
                    ip++;
                }
                else if (instr[0].equals("jmp")) {
                    if (instr[1].equals("+")) {
                        ip += Integer.parseInt(instr[2]);
                    }
                    else {
                        ip -= Integer.parseInt(instr[2]);
                    }
                }
            }

            if (ip == idxInstrNew.size()) {
                System.out.println(acc);
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
