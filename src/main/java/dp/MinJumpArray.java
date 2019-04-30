package dp;

import java.util.Arrays;

/**
 * @author Abhijeet Gulve
 */
public class MinJumpArray {
    public static void main(String[] args) {
        int[] a = {2, 0, 1, 0, 4};
        System.out.println(getMinJump(a, 0,0));
//        System.out.println(getMinJump(a));

    }

    private static int getMinJump(int[] a, int currentIndex,int steps) {
        if (currentIndex >= a.length) {
            return 99999;
        }
        if (currentIndex == a.length - 1) {
            return steps;
        }
        int min = 99999;
        for (int i = a[currentIndex]; i > 0; i--) {
            int minJump =  getMinJump(a, currentIndex + (i),steps+1);
            if (minJump < min) {
                min = minJump;
            }
        }
        return min;
    }

    private static int getMinJump(int[] a) {
        int[] temp = new int[a.length];

        for (int i = 1; i < temp.length; i++) {
           temp[i]= Integer.MAX_VALUE;
            for (int j = 0; j < a[i]; j++) {
                if (i <= j + a[j] && temp[j] != Integer.MAX_VALUE) {
                    temp[i] = Math.min(temp[i], temp[j] + 1);
                    break;
                }
            }
        }
        return temp[a.length-1];
    }

}
