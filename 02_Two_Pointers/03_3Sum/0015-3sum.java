class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i) {
            int low = i+1;
            int high = nums.length-1;
            while(low < high) {
                int summ = nums[i] + nums[low] + nums[high];
                if(summ == 0) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while(low<high && nums[low-1]==nums[low]) low++;
                    while(low<high && nums[high+1]==nums[high]) high--;
                }
                else if(summ < 0)
                    low++;
                else
                    high--;
            }
            while((i+1)<nums.length && nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
}