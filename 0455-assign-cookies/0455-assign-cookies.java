class Solution { // tc is O(nlogn+mlogm) and sc is O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i =0,j=0;

        while(i<g.length&&j<s.length){
            if(s[j]>=g[i]){
                i++;// move to the next child
            }
            j++;// move to the next coookies
        }
        return i;
    }
}