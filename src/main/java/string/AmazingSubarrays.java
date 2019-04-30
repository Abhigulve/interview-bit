package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Abhijeet Gulve
 */
public class AmazingSubarrays {
    public int solve(String A) {
        int res = 0;
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Set<Character> chs = new HashSet<>(characters);
        for (int i = 0; i < A.length(); i++) {
            if (chs.contains(A.charAt(i))) {
                res += (A.length() - i);
            }
        }
        return res;
    }
}
