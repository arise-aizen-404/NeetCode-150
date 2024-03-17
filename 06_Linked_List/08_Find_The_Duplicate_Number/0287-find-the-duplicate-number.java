package 06_Linked_List.08_Find_The_Duplicate_Number;

public class 0287-find-the-duplicate-number {
    
}
import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;

        // BETTER SOLUTION
        // HASHMAP because it involves in counting

        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int num : arr){
        //     if(map.containsKey(num)) return num;
        //     int currval = map.getOrDefault(num,0);
        //     map.put(num,currval+1);
        // }
        // return -1;
    }
}