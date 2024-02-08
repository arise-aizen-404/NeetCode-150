class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hmap = new HashMap<>();
        for (String x : strs) {
            char[] charArray = x.toCharArray();
            Arrays.sort(charArray);
            String sortedX = new String(charArray);
            if (!hmap.containsKey(sortedX)) {
                hmap.put(sortedX, new ArrayList<>());
            }
            hmap.get(sortedX).add(x);
        }
        List<List<String>> res = new ArrayList<>(hmap.values());
        return res;
    }
}