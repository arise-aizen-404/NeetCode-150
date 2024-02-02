class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char x : s.toCharArray())
            hmap.put(x, hmap.getOrDefault(x, 0) + 1);
        for(char x :  t.toCharArray()) {
            if(hmap.get(x) != null && hmap.get(x) != 0)
                hmap.put(x, hmap.get(x) - 1); 
            else {
                return false;
            }
        }
        return true;
    }
}