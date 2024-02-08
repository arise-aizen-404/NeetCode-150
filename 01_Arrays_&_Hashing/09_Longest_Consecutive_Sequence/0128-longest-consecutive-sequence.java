class Solution{
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val : nums)
            map.put(val, true);
        
        for(int val : nums) 
            if(map.containsKey(val - 1))
                map.put(val, false);
        
        for(int val : nums) {
            if(map.get(val)) {
                int length = 1, start = val;
                
                while(map.containsKey(start + length))
                    length++;
                
                if(length > maxLength)
                    maxLength = length;
            }
        }
        
        return maxLength;     
    }
}