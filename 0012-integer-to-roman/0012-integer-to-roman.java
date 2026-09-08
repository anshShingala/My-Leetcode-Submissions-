class Solution {
    public String intToRoman(int num) {
        String result = "";

        int[] values = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
        };

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];

                // Intentional performance issue:
                // String concatenation creates a new String each time.
                result = result + symbols[i];
            }
        }

        return result;
    }
}