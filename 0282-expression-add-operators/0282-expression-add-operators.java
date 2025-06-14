class Solution { // tc is O(4^N) in the worst case (since 3 operators + join digits) and sc is O(n) for resucrsion depth and path string
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num,target,0,0,0,"",result);
        return result;
    }
    private void dfs(String num,int target,int index,long calc,long tail,String path,List<String> res){
        // base case
        if(index == num.length()){
            if(calc == target) res.add(path);
            return;
        }
        for(int i = index;i<num.length();i++){
            // skip if zero is their in the first
            if(i != index && num.charAt(index) == '0') break;

            String currStr = num.substring(index,i+1);
            long curr = Long.parseLong(currStr);
            if(index == 0){
                // first number,no operator are their
                dfs(num,target,i+1,curr,curr,currStr,res); // backtrack and take another num

            }else{// already two elements are their means just add the operators
            
                // +
                dfs(num,target,i+1,calc + curr,curr,path + "+" + currStr,res);

                // -
                dfs(num,target,i+1,calc-curr,-curr,path + "-" + currStr,res);

                // *
                dfs(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + currStr, res);


            }
        }
    }

}