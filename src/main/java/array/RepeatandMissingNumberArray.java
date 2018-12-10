package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a read only array of n integers from 1 to n.
 * <p>
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * <p>
 * Return A and B.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Note that in your output A should precede B.
 * <p>
 * Example:
 * <p>
 * Input:[3 1 2 5 3]
 * <p>
 * Output:[3, 4]
 * <p>
 * A = 3, B = 4
 * Seen this question in a real interview before
 *
 * @author Abhijeet Gulve
 */
public class RepeatandMissingNumberArray {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A.size() == 0) {
            return res;
        }
        int sum = 0;
        // long actualSum=0;
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            sum += (A.get(i) - i);
            if (!check.add(A.get(i))) {
                res.add(A.get(i));
            }
        }
        res.add(sum);
        return res;
    }
}
