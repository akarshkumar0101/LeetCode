import java.util.*;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndices = new HashMap<>();
        for(int i=0 ; i<nums.length;i++){
            int val = nums[i];
            int reqVal = target - val;
            if(valueToIndices.containsKey(reqVal)) {
                return new int[]{valueToIndices.get(reqVal), i};
            }
            valueToIndices.put(nums[i], i);
        }

        return null;
    }
    /*
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
     */
    public static void main(String... args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = new Problem1().twoSum(nums,target);
        System.out.println(Arrays.toString(ans));
    }

}
