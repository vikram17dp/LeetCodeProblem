class Solution { // tc is O(n+m) + O(n*m) * O(n*m) = O(ncube) and sc is O(1)
private void markRow(int[][] matrix,int row){ // tc is O(n)
int n = matrix[0].length;
for(int j = 0;j<n;j++){
if(matrix[row][j] != 0){
matrix[row][j] = -1;
}
}
}
private void markCol(int[][] matrix,int col){ // tc is O(m)
int m = matrix.length;
for(int i = 0;i<m;i++){
if(matrix[i][col] != 0){
matrix[i][col] = -1;
}
}
}
// for both markrow and markcol function tc is o(n+m)
public void setZeroes(int[][] matrix) { // tc is O(n*m) * O(n*m)
int m = matrix.length, n = matrix[0].length;
for(int i = 0;i<m;i++){
for(int j = 0;j<n;j++){
if(matrix[i][j] == 0){
markRow(matrix,i);
markCol(matrix,j);
}
}
}
for(int i = 0;i<m;i++){
for(int j = 0;j<n;j++){
if(matrix[i][j] == -1){
matrix[i][j] = 0;
}
}
}
}
}