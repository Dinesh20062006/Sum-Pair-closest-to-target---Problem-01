package GeeksForGeeks;
import java.util.*;

public class Sum_Pair_closest_to_target_01 {
    public static int[] closestPair(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{};
        }
        int minDiff = Integer.MAX_VALUE;
        int maxAbsDiff = -1;
        int[] ans = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                int diff = Math.abs(target - sum);

                int a = Math.min(arr[i], arr[j]);
                int b = Math.max(arr[i], arr[j]);
                if (diff < minDiff ||(diff == minDiff && Math.abs(a - b) > maxAbsDiff)) 
                {
                    minDiff = diff;
                    maxAbsDiff = Math.abs(a - b);

                    ans[0] = a;
                    ans[1] = b;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 28, 29, 30, 40};
        int target = 54;
        int[] result = closestPair(arr, target);
        if (result.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(result));
        }
    }
}