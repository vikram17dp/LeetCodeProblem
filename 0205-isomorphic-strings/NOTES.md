class Solution { // brute force tc and sc is O(n)
public boolean isIsomorphic(String s, String t) {
// base case
if(s.length()!=t.length()) return false;
HashMap<Character,Character> mapStoT = new HashMap<>();
HashMap<Character,Character> mapTtoS = new HashMap<>();
for(int i = 0;i<s.length();i++){
char charS = s.charAt(i);
char charT = t.charAt(i);
// checking for the first set
if(mapStoT.containsKey(charS)){
if(mapStoT.get(charS)!= charT)
return false;
}else{
mapStoT.put(charS,charT);
}
// checking for the second set
if(mapTtoS.containsKey(charT)){
if(mapTtoS.get(charT)!=charS){
return false;
}
}else{
mapTtoS.put(charT,charS);
}
}
return true;
}
}
​