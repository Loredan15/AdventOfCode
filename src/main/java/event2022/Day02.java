package event2022;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day02 {
    public static void main(String[] args) {
        try {
            AocUtils.downloadFile(2);
            String input = AocUtils.fileContents(2);
            List<String> strings = Arrays.stream(input.split("\n")).toList();
            int countPart1 = 0;
            int countPart2 = 0;
            for (String string : strings) {
                /*

                A - Камень
                B - Бумага
                C - Ножницы

                X - Камень (1)
                Y - Бумага (2)
                Z - Ножницы (3)

                Победа - 6
                Ничья - 3
                Поражение - 0

                X - Проигрыш
                Y - Ничья
                Z - Победа
                 */
                if (string.charAt(0) == 'A' && string.charAt(2) == 'X') {
                    countPart1 += 4;
                    countPart2 += 3;
                }
                if (string.charAt(0) == 'B' && string.charAt(2) == 'X') {
                    countPart1 += 1;
                    countPart2 += 1;
                }
                if (string.charAt(0) == 'C' && string.charAt(2) == 'X') {
                    countPart1 += 7;
                    countPart2 += 2;
                }
                if (string.charAt(0) == 'A' && string.charAt(2) == 'Y') {
                    countPart1 += 8;
                    countPart2 += 4;
                }
                if (string.charAt(0) == 'B' && string.charAt(2) == 'Y') {
                    countPart1 += 5;
                    countPart2 += 5;
                }
                if (string.charAt(0) == 'C' && string.charAt(2) == 'Y') {
                    countPart1 += 2;
                    countPart2 += 6;
                }
                if (string.charAt(0) == 'A' && string.charAt(2) == 'Z') {
                    countPart1 += 3;
                    countPart2 += 8;
                }
                if (string.charAt(0) == 'B' && string.charAt(2) == 'Z') {
                    countPart1 += 9;
                    countPart2 += 9;
                }
                if (string.charAt(0) == 'C' && string.charAt(2) == 'Z') {
                    countPart1 += 6;
                    countPart2 += 7;
                }
            }
            System.out.println(countPart1);
            System.out.println(countPart2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
