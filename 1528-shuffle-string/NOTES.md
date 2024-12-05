HashMap<Integer,Character> map = new HashMap<>(); // tc and sc is o(n)
for(int i =0;i<s.length();i++){
map.put(indices[i],s.charAt(i));
}
StringBuilder result = new StringBuilder(s.length());
for(int i =0;i<s.length();i++){
result.append(map.get(i));
}
return result.toString();