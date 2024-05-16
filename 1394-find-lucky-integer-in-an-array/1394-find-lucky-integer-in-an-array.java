class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int ele = arr[i];
            if(hm.containsKey(ele)==true){
                hm.put(ele,hm.get(ele)+1);
            }else{
                hm.put(ele,1);
            }
        }
        int ans = -1;
        for(Integer key: hm.keySet()){
            if(hm.get(key)==key){ // here only it will find the lucky number if the key is equal to the value then only it is a lucky number
                ans= Math.max(ans,key);
            }
        }
        return ans;
    }
}