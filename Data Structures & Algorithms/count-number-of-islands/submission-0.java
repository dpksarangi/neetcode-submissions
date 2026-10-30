class Solution {
    public int numIslands(char[][] grid) {
        int rows= grid.length;
        int cols= grid[0].length;
        int islands=0;

        for(int i=0; i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(grid,i,j);
                }
            }
        }
        return islands;
    }

    public static void bfs(char[][] grid,int i,int j){
        grid[i][j]='0';
        if(j<grid[0].length-1 && grid[i][j+1]=='1'  ){
            bfs(grid,i,j+1);
        }if(j>0 && grid[i][j-1]=='1' ){
            bfs(grid,i,j-1);
        }if(i<grid.length-1 && grid[i+1][j]=='1' ){
            bfs(grid,i+1,j);
        }if(i>0 && grid[i-1][j]=='1' ){
            bfs(grid,i-1,j);
        }
    }
}
