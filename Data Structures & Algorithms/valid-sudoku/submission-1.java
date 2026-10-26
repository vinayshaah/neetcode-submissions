class Solution {
    public boolean isValidSudoku(char[][] board) {
    int boardRow = board.length;
    int boardColumn = board[0].length;
    boolean isBoardValid = true;
    Set<Character> uniqueChecker = null;
    Map<String,Set<Character>> subMatrixChecker = new HashMap<>();
    for(int i=0;i<boardRow;i++){
        uniqueChecker = new HashSet<Character>();
        for(int j=0;j<boardColumn;j++){
            if(board[i][j]!='.' && !uniqueChecker.add(board[i][j])){
                isBoardValid = false;
                break;
            }
            int subMatrixRow = i/3;
            int subMatrixColumn = j/3;
            //create the key for the map subMatrixChecker
            Set<Character> subMatrixUniqueChecker = subMatrixChecker.get(subMatrixRow+","+subMatrixColumn);
            if(subMatrixUniqueChecker==null){
                subMatrixUniqueChecker = new HashSet<Character>();
            }
            if(board[i][j]!='.' && !subMatrixUniqueChecker.add(board[i][j])) {
                isBoardValid = false;
                break;
            } else {
                subMatrixChecker.put(subMatrixRow+","+subMatrixColumn,subMatrixUniqueChecker);
            }
        }
        if(!isBoardValid){
            break;
        }
    }

    if(isBoardValid) {
        for(int j=0;j<boardColumn;j++){
            uniqueChecker = new HashSet<Character>();
            for(int i=0;i<boardRow;i++){
                if(board[i][j]!='.' && !uniqueChecker.add(board[i][j])){
                    isBoardValid = false;
                    break;
                }
            }
        }
    }
    return isBoardValid;

        
        
    }
}
