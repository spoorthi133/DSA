class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    if(grid[0][0] == 1 || grid[n-1][n-1]==1){
        return -1;
    }

    int[][] vis = new int[n][n];

    int[] delrow = {-1,-1,-1,0,0,1,1,1};
    int[] delcol = {-1,0,1,-1,1,-1,0,1};

    Queue<int[]> q =new LinkedList<>();
    q.add(new int[]{0,0,1});
    vis[0][0]=1;

    while(!q.isEmpty()){
        int[] cur = q.poll();
        int row = cur[0];
        int col = cur[1];
        int dist = cur[2];

        if(row==n-1 && col == n-1){
            return dist;
        }

        for(int i=0;i<8;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && vis[nrow][ncol]==0){
                vis[nrow][ncol]=1;
                q.add(new int[]{nrow,ncol,dist+1});
            }
            
        }
    }
    return -1;
    }
}