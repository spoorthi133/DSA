class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){

            if(grid[i][0]==1){
                queue.add(i*m);
                grid[i][0]=0;
            }

            if(grid[i][m-1]==1){
                queue.add(i*m + (m-1));
                grid[i][m-1]=0;
            }
        }

        for(int i=0;i<m;i++){
            if(grid[0][i]==1){
                queue.add(i);
                grid[0][i]=0;
            }

            if(grid[n-1][i]==1){
                queue.add((n-1)*m+i);
                grid[n-1][i]=0;
            }
        }

        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};

        while(!queue.isEmpty()){

            int cur =  queue.poll();

            int r = cur/m;
            int c = cur%m;

            for(int i=0;i<4;i++){
                int newrow = r+delrow[i];
                int newcol = c+delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol <m && grid[newrow][newcol]==1){
                    grid[newrow][newcol]=0;
                    queue.add(newrow*m + newcol);
                    
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }
}