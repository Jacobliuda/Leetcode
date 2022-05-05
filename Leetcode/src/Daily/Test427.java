package Daily;

/**
 * @author Jacob
 * @creator 2022/4/29-15:09
 * @description
 */
public class Test427 {
    int[][] grid;

    public Node construct(int[][] grid) {

        this.grid = grid;
        return recur(0, grid.length, 0, grid.length);

    }

    public Node recur(int row_start, int row_end, int col_start, int col_end){
        // 当当前区域已是最小区域，不能再被划分，对区域内的四个结点进行分配，并设置其为叶子结点
        if(isSame(row_start, row_end, col_start, col_end)){
            return new Node(grid[row_start][col_start] == 1, true);
        }

        return new Node(
                false,
                false,
                recur(row_start, (row_start + row_end)/2, col_start, (row_start + row_end)/2),
                recur(row_start, (row_start + row_end)/2, (row_start + row_end)/2, col_end),
                recur((row_start + row_end)/2, row_end, col_start, (row_start + row_end)/2),
                recur((row_start + row_end)/2, row_end, (row_start + row_end)/2, col_end)
                );

    }

    // 判断整个区域是否都是相同的
    public boolean isSame(int row_start, int row_end, int col_start, int col_end){
        int com = grid[row_start][col_start];
        for(int i = row_start; i < row_end; i++){
            for(int j = col_start; j < col_end; j++){
               if(grid[i][j]!=com)
                   return false;
            }
        }
        return true;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
