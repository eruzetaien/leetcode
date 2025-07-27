class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        // Thousands
        int thousands = num / 1000;
        for (int i = 0; i < thousands; i++) sb.append("M");
        num %= 1000;

        // Hundreds
        sb.append(getRoman(num / 100, "C", "D", "M"));
        num %= 100;

        // Tens
        sb.append(getRoman(num / 10, "X", "L", "C"));
        num %= 10;

        // Units
        sb.append(getRoman(num, "I", "V", "X"));

        return sb.toString();
    }

    private String getRoman(int digit, String one, String five, String ten) {
        if (digit == 9) return one + ten;
        if (digit >= 5) return five + one.repeat(digit - 5);
        if (digit == 4) return one + five;
        return one.repeat(digit);
    }
}