public class Percolation {
    private int[][] grid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        grid = new int[n][n];
        for (int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                grid[i][j] = i+j;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        // need to check the definition of is open
        if (!grid[row][col]){
        grid[row][col] = true;}
    }

    public  void union(int[][] a, int[][]b){
        // make a site
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        /*A full site is an open site that can be connected to
         an open site in the top row via a chain of neighboring
        (left, right, up, down) open sites.*/
        int currentItem = grid[row][col];
       int top = grid[row-1][col];
       int down = grid[row+1][col];
       int left = grid[row][col-1];
       int right = grid[row][col+1];
       return top == currentItem || down==currentItem || left==currentItem || right==currentItem;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        // should I loop again and count all open sides? is this efficient??? but let me do it
        int count = 0;
        for (boolean[] i : grid) {
            for (boolean j : i) {
                if (j) {
                    count += 1;
                }
            }
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates(){}

    // test client (optional)
    public static void main(String[] args){}
}
