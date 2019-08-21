public class Problem45 {
    public static void main(String... args) {
        int[] test1 = {2,3,1,1,4};
        int[] test2 = {2,3,0,1,4};


        Solution sol = new Problem45().new Solution();
        System.out.println(sol.jump(test2));
    }

    class Solution {
        public int jump(int[] nums) {
            int[] numJumpsReq = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                numJumpsReq[i] = Integer.MAX_VALUE;
            }
            int lastIndex = nums.length-1;
            numJumpsReq[lastIndex] = 0;
            for(int i=lastIndex-1;i>=0;i--){
                int jumpsAvail = nums[i];
                if(i+jumpsAvail>=lastIndex){
                    numJumpsReq[i] = 1;
                }
                else{
                    int minJumps = Integer.MAX_VALUE;
                    for(int j=1;j<=jumpsAvail;j++){
                        minJumps = Math.min(minJumps, Math.max(numJumpsReq[i+j],numJumpsReq[i+j]+1));
                    }
                    numJumpsReq[i] = minJumps;
                }
            }
            return numJumpsReq[0];
        }
    }
}
