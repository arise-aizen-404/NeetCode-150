class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end){
            int sum = nums[start] + nums[end];
            if(sum == target) break;
            else if(sum>target) end--;
            else start++;
        }
        return new int[] {start+1,end+1};
    }
}