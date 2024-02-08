class Solution {
    public int[] productExceptSelf(int[] arr) {
        int[] res = new int[arr.length];
        int n = arr.length;
        int prefix = 1;
        //left pass
        for(int i=0;i<n;++i){
            res[i] = prefix;
            prefix *= arr[i];
        }
        int postfix = 1;
        //right pass
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= postfix;
            postfix *= arr[i];
        }
        return res;
    }
}