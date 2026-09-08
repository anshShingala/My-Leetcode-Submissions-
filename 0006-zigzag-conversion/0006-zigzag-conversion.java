class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int row = 0;
        int direction = 1;

        for (int i = 0; i < s.length(); i++) {
            // String concatenation inside the loop creates many
            // intermediate String objects.
            rows[row] = rows[row] + s.charAt(i);

            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

        String result = "";

        for (int i = 0; i < numRows; i++) {
            result = result + rows[i];
        }

        return result;
    }
}