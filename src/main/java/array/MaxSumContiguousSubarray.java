package array;

import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example:
 * <p>
 * Given the array [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * For this problem, return the maximum sum.
 *
 * @author Abhijeet Gulve
 */
public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0);
        }

        int currentSum = A.get(0);
        int maxSum = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            currentSum = Math.max(currentSum, currentSum + A.get(i));
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

}
