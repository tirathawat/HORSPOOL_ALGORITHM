import java.util.HashMap;

public class Horspool {

    private static HashMap<Character, Integer> table = new HashMap<>();

    private static int matchingString (String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        shiftTable(pattern);
        int i = m - 1;
        while (i <= n - 1) {
            int k = 0;
            while (k <= m - 1 && pattern.charAt(m - 1 - k) == text.charAt(i - k))
                k++;
            if (k == m) return i - m + 1;
            else {
                if (table.containsKey(text.charAt(i))) i += table.get(text.charAt(i));
                else i += pattern.length();
            }
        }
        return -1;
    }

    private static void shiftTable(String pattern) {
        for (int i = 0; i < pattern.length() - 2; i++)
            table.put(pattern.charAt(i), pattern.length() - 1 - i);
    }

    public static void main (String[] args) {
        String text = "JIM_SAW_ME_IN_A_BARBARBAR_BARBERSHOP";
        String pattern = "BARBER";
        System.out.println(matchingString(pattern, text));
    }
}
