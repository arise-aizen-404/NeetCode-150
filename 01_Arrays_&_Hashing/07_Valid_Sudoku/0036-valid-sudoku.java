class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Integer> hMap = new HashMap<>();
        for(int i=0;i<9;++i) {
            for(int j=0;j<9;++j) {
                char currVal = board[i][j];
                if(currVal != '.') {
                    if((hMap.get(currVal+"row"+i)!=null) || (hMap.get(currVal+"col"+j)!=null) || (hMap.get(currVal+"grid"+(i/3)+"-"+(j/3))!=null))
                        return false; // Already Exists
                    else {
                        hMap.put((currVal+"row"+i),1);
                        hMap.put((currVal+"col"+j),1);
                        hMap.put((currVal+"grid"+(i/3)+"-"+(j/3)),1);
                    }
                }
            }
        }
        return true;
    }
}