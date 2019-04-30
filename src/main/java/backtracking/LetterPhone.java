package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Abhijeet Gulve
 */
public class LetterPhone {

    static List<String> letters = new ArrayList<>(Arrays.asList("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));

    public static void main(String[] args) {
        TreeSet<String> res = new TreeSet<>();
        getAllCombinations(res, new StringBuilder(), 0, "034");
        System.out.println(res);
    }

    static void getAllCombinations(TreeSet<String> res, StringBuilder tempString, int digit, String dig) {
        if (digit == dig.length()) {
            res.add(tempString.toString());
            return;
        }
        int index = dig.charAt(digit)-'0';
        for (int i = 0; i < letters.get(index).length(); i++) {
            getAllCombinations(res, tempString.append(letters.get(index).charAt(i)), digit+1, dig);
            tempString.deleteCharAt(tempString.length()-1);
        }
    }
}
