package event2022;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day01 {
    static String splitter = "\n\n";
    public static void main(String[] args) throws IOException {
        AocUtils.downloadFile(1);
        String inventory = AocUtils.fileContents(1);
        List<Integer> calories = getCalories(inventory);
        //part 1
        Integer max = calories.stream().max(Integer::compareTo).get();
        //part 2
        int sum = calories.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::intValue).sum();

    }
    private static List<Integer> getCalories(String inventory) {
        return Arrays.stream(inventory.split(splitter))
                .map(s -> s.lines().mapToInt(Integer::parseInt).sum())
                .toList();
    }
}
