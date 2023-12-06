import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> intToDigits(int num) {

        List<Integer> output = new ArrayList<>();
        while (num != 0) {
            output.add(num % 10);
            num /= 10;
        }
        return output.reversed();
    }

    public static char powerToFullRoman(int power) {
        return switch (power) {
            case 3 -> 'M';
            case 2 -> 'C';
            case 1 -> 'X';
            case 0 -> 'I';
            default -> ' ';
        };
    }

    public static char powerToHalfRoman(int power) {
        return switch (power) {
            case 2 -> 'D';
            case 1 -> 'L';
            case 0 -> 'V';
            default -> ' ';
        };
    }

    public static void digitAndPowerToRoman(StringBuilder inputBuilder, int digit, int power) {

        if (digit < 0 || digit > 9) {
            throw new RuntimeException("digit should be in range 1-9");
        }

        if (digit == 1) {
            inputBuilder.append(powerToFullRoman(power));
        } else if (digit == 5) {
            inputBuilder.append(powerToHalfRoman(power));
        } else if (digit < 4) {
            char c = powerToFullRoman(power);
            for (int i = 0; i < digit; i++) {
                inputBuilder.append(c);
            }
        } else if (digit == 4) {
            inputBuilder.append(powerToFullRoman(power));
            inputBuilder.append(powerToHalfRoman(power));
        } else if (digit < 9) {
            inputBuilder.append(powerToHalfRoman(power));
            int count = digit - 5;
            var c = powerToFullRoman(power);
            for (int i = 0; i < count; i++) {
                inputBuilder.append(c);
            }
        } else {
            inputBuilder.append(powerToFullRoman(power));
            inputBuilder.append(powerToFullRoman(power + 1));
        }
    };

    public static String intToRoman(int num) {

        List<Integer> digits = intToDigits(num);
        int currPower = digits.size() - 1;
        var builder = new StringBuilder();
        for (Integer digit : digits) {
            digitAndPowerToRoman(builder, digit, currPower--);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1993));
    }
}
