class Solution {
    private int getMaxEle(int[] arr) {
        int maxEle = Integer.MIN_VALUE;
        for(int x : arr) {
            maxEle = Math.max(maxEle, x);
        }
        return maxEle;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMaxEle(piles);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            double totalHours = 0;
            for(int x : piles) {
                totalHours += Math.ceil((double)x / (double)mid);
            }
            if(totalHours <= h) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}