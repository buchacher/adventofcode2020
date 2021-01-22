import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * References:
 * https://www.youtube.com/watch?v=AnScQq6vkEk&ab_channel=TurkeyDev
 * [Accessed 2020-12-31]
 */
public class Day07b {

    private static Map<String, List<BagInfo>> bags = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> parsedInput;
        parsedInput = parseInput();


        for (String s : parsedInput) {
            String[] split1 = s.substring(0, s.length()-1).split("bags contain");
            String outerBag = split1[0].trim();
            String[] innerBags = split1[1].split(",");
            List<BagInfo> bagInfos = new ArrayList<>();
            for (String innerbag : innerBags) {
                innerbag = innerbag.replace("bags", "").replace("bag", "").trim();
                int index = innerbag.trim().indexOf(" ");
                String quantityStr = innerbag.substring(0, index);
                if (!quantityStr.equalsIgnoreCase("no")) {
                    BagInfo bagInfo = new BagInfo();
                    bagInfo.quantity = Integer.parseInt(quantityStr);
                    bagInfo.bagName = innerbag.substring(index+1);
                    bagInfos.add(bagInfo);
                }
            }

            bags.put(outerBag, bagInfos);
        }

        int count = 0;
        for (String bag : bags.keySet()) {
            if (isGoldBagInBag(bag)) {
                count++;
            }
        }

        System.out.println("Part 1: " + count);
        System.out.println("Part 1: " + (countBagsInGoldBag("shiny gold") - 1));

    }

    private static boolean isGoldBagInBag(String bag) {
        for (BagInfo subBag : bags.get(bag)) {
            if (subBag.bagName.equalsIgnoreCase("shiny gold")) {
                return true;
            }
        }

        for (BagInfo subBag : bags.get(bag)) {
            if (isGoldBagInBag(subBag.bagName)) {
                return true;
            }
        }

        return false;
    }

    private static int countBagsInGoldBag(String bag) {
        List<BagInfo> bagList = bags.get(bag);
        int count = 1;
        for (BagInfo bagInfo : bagList) {
            count += (bagInfo.quantity * countBagsInGoldBag(bagInfo.bagName));
        }

        return count;
    }

    public static class BagInfo {
        public int quantity;
        public String bagName;
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
