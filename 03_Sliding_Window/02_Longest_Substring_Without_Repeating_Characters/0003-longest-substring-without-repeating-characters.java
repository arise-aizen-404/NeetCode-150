// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int left = 0;
//         int right = 0;
//         int max_len = 0;
//         StringBuilder sb = new StringBuilder();

//         while (right < s.length()) {
//             if (sb.indexOf(String.valueOf(s.charAt(right))) != -1) {
//                 max_len = Math.max(max_len, sb.length());
//                 sb.delete(0, sb.indexOf(s.substring(right, right + 1)) + 1);
//             }
//             sb.append(s.charAt(right));
//             right++;
//         }

//         // Check for the last substring
//         max_len = Math.max(max_len, sb.length());

//         return max_len;
//     }
// }


import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashSet<Character> charSet = new HashSet<>();

        while (right < s.length()) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
