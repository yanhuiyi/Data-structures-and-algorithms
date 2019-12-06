package com.leetcode.problems;

public class Problems79 {
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(find(board, visited, word.toCharArray(), 0, j, i))
                    return true;
            }
        }
        return false;
    }

    private boolean find(char[][] board, boolean[][] visited, char[] word, int index, int col, int row) {
        if(index == word.length) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(visited[row][col] == true || board[row][col] != word[index]) return false;
        visited[row][col] = true;

        boolean exist = find(board, visited, word, index + 1, col + 1, row);
        if(exist) return true;

        exist = find(board, visited, word, index + 1, col - 1, row);
        if(exist) return true;

        exist = find(board, visited, word, index + 1, col , row + 1);
        if(exist) return true;

        exist = find(board, visited, word, index + 1, col , row - 1);
        if(exist) return true;

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B' ,'C' , 'E'}, {'S','F' ,'C' ,'S' }, {'A','D' , 'E', 'E'}};

        //System.out.println(new Problems79().exist(board, "ABCCED"));
        System.out.println(new Problems79().exist(board, "SEE"));
    }
}
