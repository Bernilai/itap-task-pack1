package dev.bernilai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tasks3 {

    public static void main(String[] args) {

        List<List<Object>> products = new ArrayList<>();
        products.add(List.of("Laptop", 124200));
        products.add(List.of("Phone", 51450));
        products.add(List.of("Headphones", 13800));

        Object[][] inventory = {
                {"Jump rope", 550, 8},
                {"Helmet", 3750, 4},
                {"Ball", 2900, 10}
        };

        System.out.println("Prices of discounted products: " + sale(products, 25));
        System.out.println("Is strange pair?: " + isStrangePair("sparkling", "groups"));
        System.out.println("Successful shot?: " + successfulShot(0, 0, 5, 2, 2));
        System.out.println("Parity analisys: " + parityAnalisys(243));
        System.out.println("RPS: " + rps("scissors", "rock"));
        System.out.println("Bugger: " + bugger(999));
        System.out.println("The most expensive product: " + mostExpensive(inventory));
        System.out.println("Longest unique: " + longestUnique("abcba"));
        System.out.println("Is prefix: " + isPrefix("automation", "auto-"));
        System.out.println("Is suffix: " + isSuffix("automation", "-tion"));
        System.out.println("Does brick fit?: " + doesBrickFit(10, 30, 20, 20, 20));
    }

    //1
    public static boolean isStrangePair (String str1, String str2) {

        return (str1.charAt(str1.length() - 1) == str2.charAt(0) || str1.charAt(0) == str2.charAt(str2.length() - 1));
    }

    //2
    public static List<List<Object>> sale (List<List<Object>> products, int discount) {

        List<List<Object>> discountedProducts = new ArrayList<>();

        for (List<Object> product : products) {

            int price = (int) product.get(1);
            int discountedPrice = (int) Math.round(price - price * discount / 100.0);

            if (discountedPrice < 1) {
                discountedProducts.add(new ArrayList<>(product));
            }

            List<Object> discountedProduct = new ArrayList<>();
            discountedProduct.add(product.get(0));
            discountedProduct.add(discountedPrice);
            discountedProducts.add(discountedProduct);

        }

        return discountedProducts;
    }

    //3
    public static boolean successfulShot (int x, int y, int r, int m, int n) {

        double distance = Math.sqrt(Math.pow(x - m, 2) + Math.pow(y - n, 2));
        return distance <= r;
    }

    //4
    public static boolean parityAnalisys (int n) {

        int sum = 0;
        int temp = n;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return (sum % 2 == 0) == (n % 2 == 0);
    }

    //5
    public static String rps(String player1, String player2) {

        if (player1.equals(player2)) {
            return "It's a tie!";
        } else if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("paper") && player2.equals("rock")) ||
                (player1.equals("scissors") && player2.equals("paper"))) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }

    //6
    public static int bugger (int n) {

        int count = 0;

        while (n >= 10) {

            int product = 1;

            while (n > 0) {
                product *= n % 10;
                n /= 10;
            }

            n = product;
            count++;
        }

        return count;
    }

    //7
    public static String mostExpensive (Object[][] products) {

        int maxCost = 0;
        String mostExpensiveProduct = "";

        for (Object[] product : products) {

            int totalPrice = (int) product[1] * (int) product[2];

            if (totalPrice > maxCost) {
                maxCost = totalPrice;
                mostExpensiveProduct = (String) product[0];
            }
        }

        return mostExpensiveProduct + " with total cost of " + maxCost;
    }

    //8
    public static String longestUnique(String str) {

        Set<Character> seen = new HashSet<>();

        int start = 0;
        int end = 0;
        String longest = "";

        while (end < str.length()) {

            char currentChar = str.charAt(end);
            if (seen.contains(currentChar)) {
                seen.remove(str.charAt(start));
                start++;
            } else {
                seen.add(currentChar);
                if (end - start + 1 > longest.length()) {
                    longest = str.substring(start, end + 1);
                }
                end++;
            }

        }

        return longest;
    }

    //9
    public static boolean isPrefix (String word, String prefix) {

        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix (String word, String suffix) {

        return word.endsWith(suffix.substring(1));
    }

    //10
    public static boolean doesBrickFit (int a, int b, int c, int w, int h) {

        return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) ||
                (a <= h && c <= w) || (b <= w && c <= h) || (b <= h && c <= w);
    }

}
