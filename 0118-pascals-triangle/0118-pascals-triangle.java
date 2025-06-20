class Solution { // TC is O(N)
    
    public int nCr(int n,int r){
         long res = 1;
        
        for(int i = 0;i<r;i++){
            res = res*(n-i)/(i+1);
            
        }

        return (int) res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for(int n = 0;n<numRows;n++){
            List<Integer> row = new ArrayList<>();
            
        
        for(int r =0;r<=n;r++){
            row.add(nCr(n,r));
        }
        triangle.add(row);
    }
        return triangle;
}
    
    
}