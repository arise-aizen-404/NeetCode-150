import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> hMap1 = new HashMap<>();
        HashMap<Character, Integer> hMap2 = new HashMap<>();
        for (char x : s1.toCharArray()) {
            hMap1.put(x, hMap1.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            char x = s2.charAt(i);
            hMap2.put(x, hMap2.getOrDefault(x, 0) + 1);
        }
        if (hMap1.equals(hMap2)) {
            return true;
        }
        // Slide the window and update the HashMaps
        for (int right = s1.length(); right < s2.length(); right++) {
            char x = s2.charAt(right);
            hMap2.put(x, hMap2.getOrDefault(x, 0) + 1);

            char y = s2.charAt(right - s1.length()); // it is a left pointer
            if (hMap2.get(y) == 1) {
                hMap2.remove(y); // see down comment
            } else {
                hMap2.put(y, hMap2.get(y) - 1);
            }
            // Check if the current window is a permutation of s1
            if (hMap1.equals(hMap2)) { // it checks based on keys thats why we have to remove it if it has 1 feq
                return true;
            }
        }

        return false;
    }
}
