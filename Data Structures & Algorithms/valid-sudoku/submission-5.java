class Solution {
    public boolean isValidSudoku(char[][] board) {
// first check for rows 
for(int i = 0;i<9;i++){
    HashSet<Character>set= new HashSet<>();
    for(int j= 0;j<9;j++){
if(board[i][j] == '.'){continue;}
else if(set.contains(board[i][j])){
    return false;
}
set.add(board[i][j]);
    }
}
//check for columns
for(int i=0 ;i<9;i++){
    HashSet<Character>set= new HashSet<>();
    for(int j=0;j<9;j++){
if(board[j][i] == '.'){continue;}
else if(set.contains(board[j][i])){
    return false;
}
set.add(board[j][i]);
    }
}
// check for all the small boxes
for(int k=0;k<9;k++){
    HashSet<Character>set = new HashSet<>();
    for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
    int row =(k/3)*3+i;
    int column=(k%3)*3+j;
    if(board[row][column] == '.'){continue;}
else if(set.contains(board[row][column])){
    return false;
}
set.add(board[row][column]);
}
    }
}
   return true;
}
}
