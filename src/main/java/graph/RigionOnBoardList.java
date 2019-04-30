package graph;

import java.util.ArrayList;

/**
 * @author Abhijeet Gulve
 */
public class RigionOnBoardList {
    private static void replaceInternalChars(ArrayList<ArrayList<Character>> a, int row, int col) {
        if (row < 0 || row >= a.size() || col < 0 || col >= a.get(0).size())
            return;
        if (a.get(row).get(col) != '-') {
            return;
        }
        a.get(row).set(col, 'O');
        ;
        replaceInternalChars(a, row, col + 1);
        replaceInternalChars(a, row, col - 1);
        replaceInternalChars(a, row + 1, col);
        replaceInternalChars(a, row - 1, col);
    }

    static void ReplaceChars(ArrayList<ArrayList<Character>> a) {
        for (ArrayList<Character> characters : a)
            for (int j = 0; j < a.get(0).size(); j++)
                if (characters.get(j) == 'O')
                    characters.set(j, '-');
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        ArrayList<Character> a1 = new ArrayList<>();
        a1.add('X');
        a1.add('O');
        a1.add('O');
        a1.add('O');
        a1.add('O');
        a1.add('O');
        a1.add('O');
        a1.add('X');
        a.add(a1);

        ArrayList<Character> a2 = new ArrayList<>();
        a2.add('X');
        a2.add('X');
        a2.add('O');
        a2.add('O');
        a2.add('X');
        a2.add('O');
        a2.add('O');
        a2.add('X');
        a.add(a2);

        ArrayList<Character> a3 = new ArrayList<>();
        a3.add('O');
        a3.add('X');
        a3.add('X');
        a3.add('O');
        a3.add('X');
        a3.add('O');
        a3.add('X');
        a3.add('X');
        a.add(a3);

//        ArrayList<Character> a4 = new ArrayList<>();
//        a4.add('O');
//        a4.add('X');
//        a4.add('X');
//        a4.add('X');
//        a4.add('X');
//        a4.add('X');
//        a.add(a4);
//
//
//        ArrayList<Character> a5 = new ArrayList<>();
//        a5.add('X');
//        a5.add('X');
//        a5.add('X');
//        a5.add('O');
//        a5.add('X');
//        a5.add('O');
//        a.add(a5);
//
//        ArrayList<Character> a6 = new ArrayList<>();
//        a6.add('O');
//        a6.add('O');
//        a6.add('X');
//        a6.add('O');
//        a6.add('O');
//        a6.add('O');
//        a.add(a6);

        solve(a);
        for (ArrayList<Character> characters : a) {
            for (int j = 0; j < a.get(0).size(); j++) {
                System.out.print(characters.get(j) + " ");
            }
            System.out.println();
        }

    }

    public static void solve(ArrayList<ArrayList<Character>> a) {

        if (a.get(0).size() == 1) {
            return;
        }

        for (int i = 0; i < a.size(); i++)
            for (int j = 0; j < a.get(0).size(); j++)
                if (a.get(i).get(j) == 'O')
                    a.get(i).set(j, '-');

        // 1st row
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == '-') {
                replaceInternalChars(a, 0, i);
            }
        }
        //1st coloumn
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(0) == '-') {
                replaceInternalChars(a, i, 0);
            }
        }
        //last col
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(a.get(0).size() - 1) == '-') {
                replaceInternalChars(a, i, a.get(0).size() - 1);
            }
        }
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(a.size() - 1).get(i) == '-') {
                replaceInternalChars(a, a.size() - 1, i);
            }
        }
        for (int i = 0; i < a.size(); i++)
            for (int j = 0; j < a.get(0).size(); j++)
                if (a.get(i).get(j) == '-')
                    a.get(i).set(j, 'X');

    }

}
