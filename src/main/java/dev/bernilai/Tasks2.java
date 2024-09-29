package dev.bernilai;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Tasks2 {

    public static void main (String[] args) {

        int[] numbers = {1,3, 4, 5, 9, 12, 15, 18, 21};

        double[] numbers2 = {3.0, 5.0, 1.0, 9.0, 7.0};

        double[] array = {1.6, 0, 212.3, 34.8, 0, 27.5};

        int[] nums = {3, 5, 8, 1, 2, 4};

        System.out.println("Difference: " + duplicateChar("aaaaaacvcc", "ac"));
        System.out.println("Count: " + dividedByThree(numbers));
        System.out.println("Initials: " + getInitials("SiMoNov sErgey evgEnievIch"));
        System.out.println("Normalized: " + Arrays.toString(normalizator(numbers2)));
        System.out.println("Compressed array: " + Arrays.toString(compressedNums(array)));
        System.out.println("Snake: " + camelToSnake("CamelCase"));
        System.out.println("Second biggest: " + secondBiggest(nums));
        System.out.println("Local reverse: " + localReverse("Hello, I’m under the water, please help me", 'e'));
        System.out.println("Equal: " + equal(5, 5, 1));
        System.out.println("Anagram: " + isAnagram("11 plus 2?", "12 plus 1!"));
    }

    public static String duplicateChar (String s1, String s2) {

        StringBuilder sb = new StringBuilder();

        for (char c : s1.toCharArray()) {

            if (s2.indexOf(c) == -1) {

                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static int dividedByThree (int[] numbers) {

        int count = 0;

        for (int i : numbers) {
            if (i % 3 == 0 && i % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    public static String getInitials (String fullName) {

        String[] parts = fullName.trim().split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Input must contain exactly three parts: surname, name, and patronymic.");
        }

        String surname = parts[0];
        String name = parts[1];
        String patronymic = parts[2];

        return name.substring(0, 1).toUpperCase() + "." + patronymic.substring(0, 1).toUpperCase() + ". " +
                surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
    }

    public static double[] normalizator (double[] numbers) {

        if (numbers.length == 0) {

            return new double[0];
        }

        double min = numbers[0];
        double max = numbers[0];

        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        double[] normalized = new double[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            normalized[i] = (numbers[i] - min) / (max - min);
        }

        return normalized;
    }

    public static int[] compressedNums (double[] array) {

        return DoubleStream.of(array).filter(n -> n != 0).sorted().mapToInt(n -> (int) n).distinct().toArray();
    }

    public static String camelToSnake (String str) {

        return str
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }

    public static int secondBiggest(int[] nums) {

        if (nums.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least two elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second biggest number.");
        }

        return second;
    }

    public static String localReverse (String str, char marker) {

        StringBuilder result = new StringBuilder();
        int start = 0;
        int end;

        while ((end = str.indexOf(marker, start)) != -1) {

            result.append(str, start, end + 1);
            start = end + 1;
            end = str.indexOf(marker, start);

            if (end != -1) {

                String toReverse = str.substring(start, end);
                result.append(new StringBuilder(toReverse).reverse());
                result.append(marker);
                start = end + 1;
            }
        }

        result.append(str.substring(start));

        return result.toString();
    }

    public static int equal (int a, int b, int c) {

        if (a == b && b == c) {
            return 3;
        } else if (a == b || a == c || b == c) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean isAnagram (String s1, String s2) {

        String cleanedString1 = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanedString2 = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] charArray1 = cleanedString1.toCharArray();
        char[] charArray2 = cleanedString2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
