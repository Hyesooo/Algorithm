package Level2;

import java.util.Arrays;

public class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (Character.isAlphabetic(sb.charAt(0))) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        for (int i = 1; i < sb.length(); i++) {
            if (Character.isAlphabetic(sb.charAt(i))) {
                if (!Character.isLetterOrDigit(sb.charAt(i - 1))) {
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                } else {
                    sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
                }
            }
        }

        return sb.toString();
    }
}
