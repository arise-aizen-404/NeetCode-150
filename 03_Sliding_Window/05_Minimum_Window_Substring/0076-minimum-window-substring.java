class Solution {
    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}



// class Solution {
//     public String minWindow(String s, String t) {
//         if (s.isEmpty() || t.isEmpty()) {
//             return "";
//         }
//         Map<Character, Integer> targetMap = new HashMap<>();
//         Map<Character, Integer> windowMap = new HashMap<>();
//         for(char x : t.toCharArray()) {
//             targetMap.put(x, targetMap.getOrDefault(x, 0) + 1);
//             windowMap.put(x, 0);
//         }
//         String windowStr = "";
//         int left = 0;
//         for(int right = 0; right < s.length(); right++) {
//             char x = s.charAt(right);
//             if(windowMap.containsKey(x)) {
//                 windowMap.put(x, windowMap.get(x) + 1);
//             }
//             if(windowMap.equals(targetMap)) {
                
//             }
//         }
//     }
// }


// class Solution {
//     public String minWindow(String s, String t) {
//         if (s.isEmpty() || t.isEmpty()) {
//             return "";
//         }

//         Map<Character, Integer> dictT = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             int count = dictT.getOrDefault(c, 0);
//             dictT.put(c, count + 1);
//         }

//         int required = dictT.size();
//         int l = 0, r = 0;
//         int formed = 0;

//         Map<Character, Integer> windowCounts = new HashMap<>();
//         int[] ans = { -1, 0, 0 };

//         while (r < s.length()) {
//             char c = s.charAt(r);
//             int count = windowCounts.getOrDefault(c, 0);
//             windowCounts.put(c, count + 1);

//             if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
//                 formed++;
//             }

//             while (l <= r && formed == required) {
//                 c = s.charAt(l);

//                 if (ans[0] == -1 || r - l + 1 < ans[0]) {
//                     ans[0] = r - l + 1;
//                     ans[1] = l;
//                     ans[2] = r;
//                 }

//                 windowCounts.put(c, windowCounts.get(c) - 1);
//                 if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
//                     formed--;
//                 }

//                 l++;
//             }

//             r++;
//         }

//         return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//     }
// }