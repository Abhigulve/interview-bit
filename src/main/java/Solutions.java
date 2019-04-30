import java.util.ArrayList;

/**
 * @author Abhijeet Gulve
 */
public class Solutions {
    public static void solve(int A, ArrayList<ArrayList<Integer>> arr) {
        if (A == 0) {
            return;
        }
        ArrayList<Integer> previousRow;
        ArrayList<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        arr.add(0, currentRow);
        previousRow = currentRow;
        for (int i = 2; i <= A; i++) {
            currentRow = new ArrayList<>(i);
            currentRow.set(0, 1);
            currentRow.set(i - 1, 1);
            for (int j = 0; j <= i - 3; j++) {
                currentRow.set(j + 1, previousRow.get(j) + previousRow.get(j + 1));
            }
            arr.set(i - 1, currentRow);
            previousRow = currentRow;
        }
//        return arr;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(3);
        solve(3, list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                System.out.println(list.get(i).get(j));
            }
        }
    }
}
