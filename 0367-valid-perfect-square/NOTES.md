class Solution { // tc is O(sqrt(num)) and sc is O(1)
public boolean isPerfectSquare(int num) {
for(long i = 1;i*i<=num;i++){
if(num == i*i){
return true;
}
}
return false;
}
}