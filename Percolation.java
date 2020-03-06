import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF unionFind ;
    private int openSites;
    private int n;
   /*
   * Initialize instance variables
􏰐   * Connect the sites corresponding to first and last rows of the percolation system with the source
    and sink sites respectively
􏰐    The N × N system with its top and bottom row sites connected to the source and sink sites respectively
   * */
    public Percolation(int n){
        openSites = 0;
        grid = new boolean[n][n];
        for (int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                grid[i][j] = false;
            }
        }
        unionFind = new WeightedQuickUnionUF(n*n + 2);
        // connect the first and the last row to the source side to the
        for (int i=0;i<n ;i++ ) {
            unionFind.union(0, encode(0, i)); // connect all element in the first row to the source
            unionFind.union(n*n -1, encode(n-1, i)); // connect all elements in the last row to the sink
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        /*
         Open the site (i, j) if it is not already open
􏰐         Increment openSites by one Check if any of the neighbors to the north,
         east, west, and south of (i, j) is open,and if so,
         connect the site corresponding to (i, j) with the site corresponding to that neighbor
         */
        if (!grid[row][col]){
        grid[row][col] = true;
        openSites +=1;
        boolean top = grid[row-1][col];
        boolean down = grid[row+1][col];
        boolean left = grid[row][col-1];
        boolean right = grid[row][col+1];
        if (top){
            unionFind.union(encode(row-1, col), encode(row, col) );
        }
        if(down){
            unionFind.union(encode(row+1, col), encode(row, col) );
        }
        if(left){
            unionFind.union(encode(row, col-1), encode(row, col) );
        }
        if(right){
            unionFind.union(encode(row, col+1), encode(row, col) );
        }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        /*
        * Return whether site (i, j) is full or not;
        * a site is full if it is open and its corresponding site is connected to the source site
        * */
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        /*
         * Return whether site (i, j) is full or not;
         * a site is full if it is open and its corresponding site is connected to the source site
         * */

        return isOpen(row, col) & unionFind.connected(0, encode(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        // should I loop again and count all open sides? is this efficient??? but let me do it
        return  openSites;
    }

    // does the system percolate?
    public boolean percolates(){
        // the system percolate if the sink is connected to the source......
        return unionFind.connected(0, n*n+1);
    }

    private int encode(int i, int j){
        // encode the element from the grid data structure to the site and map it to the array
        return (n * i) + (i + j) + 1;
    }

    // test client (optional)
    public static void main(String[] args){
        int n = StdIn.readInt();
        Percolation precolation = new Percolation(n);
        int[] i;
        int[] j = new int[0];
        String[] inputArrays = new String[0];
        while (!StdIn.isEmpty()){
            // parse the input and read the int form
            inputArrays  = StdIn.readAll().split(" ");
        }
        for (int k=0;k<inputArrays.length ; k++) {
            if ( k % 2 == 0){
                i[i.length - 1] = Integer.parseInt(inputArrays[k]);
            }else
            {
                j[j.length - 1] = Integer.parseInt(inputArrays[k]);
            }
        }
    }
}
