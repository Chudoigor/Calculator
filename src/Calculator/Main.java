package Calculator;

import java.util.Scanner;
import java.util.Set;

public class Main {
    static int result;
    static int num1;
    static int num2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Vvedite Primer: ");
        String s = sc.nextLine();
        String[] parts = s.split(" ");
        if (parts.length != 3) throw new RuntimeException("формат математической операции не удовлетворяет заданию -" +
                                                          " два операнда и один оператор (+, -, /, *)");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        Set<String> rom = Set.of("O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        if ((rom.contains(part1) && !rom.contains(part3)) || (!rom.contains(part1) && rom.contains(part3))) {
            throw new RuntimeException("Используются разные системы счислений");
        }
        num1 = romanToNumber(part1);
        num2 = romanToNumber(part3);
        if (num1 < 0 && num2 < 0) {
        } else {
            if (num1 > 10 || num2 > 10) {
                throw new RuntimeException("введено недопустимое значение");
            }
            result = calc(part2, num1, num2);
            String resultRoman = RomToArb(result);
            System.out.println("rezultat roman: " + resultRoman);
            return;
        }

        try {
            num1 = Integer.parseInt(part1);
            num2 = Integer.parseInt(part3);
        } catch (NumberFormatException ignore) {
        }
        if (num1 > 10 || num2 > 10) {
            throw new RuntimeException("введено недопустимое значение");
        }

        result = calc(part2, num1, num2);
        System.out.println("rezultat arb: " + result);

    }

    public static int calc(String part2, int num1, int num2) {
        int result = 0;
        switch (part2) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("nevernyi operator");
        }
        return result;
    }

    private static String RomToArb(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        try {
            final String s = roman[numArabian];
            return s;
        } catch (ArrayIndexOutOfBoundsException ignore) {
            throw new RuntimeException("в римской системе нет отрицательных чисел");
        }


    }

    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return -1;
    }
}


