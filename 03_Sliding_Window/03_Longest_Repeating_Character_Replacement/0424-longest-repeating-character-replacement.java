import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hMap = new HashMap<>();
        int left = 0;
        int right;
        int maxFreq = 0;
        int maxLength = 0;

        for (right = 0; right < s.length(); ++right) {
            hMap.put(s.charAt(right), hMap.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, hMap.get(s.charAt(right)));

            if ((right - left + 1 - maxFreq) > k) {
                hMap.put(s.charAt(left), hMap.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
