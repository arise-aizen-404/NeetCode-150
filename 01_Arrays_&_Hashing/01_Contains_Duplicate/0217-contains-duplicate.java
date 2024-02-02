class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for(int x : nums) {
            if(hmap.get(x)!=null) return true;
            else hmap.put(x, true);
        }
        return false;
    }
}