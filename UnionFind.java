public class UnionFind {
    public  UnionFind(int[][] grid){

    }
    public int encode(int i, int j, int n){
        // encode the element from the grid data structure to the site and map it to the array
        return (n * i) + (i + j) + 1;
    }
}
