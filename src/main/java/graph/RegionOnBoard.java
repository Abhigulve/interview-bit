package graph;

import java.util.ArrayList;

/**
 * @author Abhijeet Gulve
 */
public class RegionOnBoard {
    public static void main(String[] args) {
        char mat[][] = {
                {
                        'X', 'O', 'X', 'X', 'X', 'X'
                },
                {
                        'X', 'O', 'X', 'X', 'O', 'X'
                },
                {
                        'X', 'X', 'X', 'O', 'O', 'X'
                },
                {
                        'O', 'X', 'X', 'X', 'X', 'X'
                },
                {
                        'X', 'X', 'X', 'O', 'X', 'O'
                },
                {
                        'O', 'O', 'X', 'O', 'O', 'O'
                },
        };

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (mat[i][j] == 'O')
                    mat[i][j] = '-';

        for (int i = 0; i < 6; i++)
            if (mat[i][0] == '-')
                replaceInternalChars(mat, i, 0);

        for (int i = 0; i < 6; i++) {
            if (mat[0][i] == '-') {
                replaceInternalChars(mat, i, 0);
            }
        }
        for (int i = 1; i < 6; i++) {
            if (mat[5][i] == '-') {
                replaceInternalChars(mat, i, 5);
            }
        }


        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (mat[i][j] == '-')
                    mat[i][j] = 'X';

    }

    private static void replaceInternalChars(char mat[][], int row, int col) {
        if (row == mat.length || mat[0].length == col) {
            return;
        }
        if (mat[row][col] != '-') {
            return;
        }
        mat[row][col] = 'O';
        replaceInternalChars(mat, row, col + 1);
        replaceInternalChars(mat, row, col - 1);
        replaceInternalChars(mat, row + 1, col);
        replaceInternalChars(mat, row - 1, col);
    }


    public void solve(ArrayList<ArrayList<Character>> a) {

        RigionOnBoardList.ReplaceChars(a);
    }
}
