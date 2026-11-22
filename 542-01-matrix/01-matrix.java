class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m=mat[0].length;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(i*m+j);
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }

        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int r = cur/m;
            int c = cur%m;

            for(int i=0;i<4;i++){
                int newrow = r+delrow[i];
                int newcol = c+delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && mat[newrow][newcol]==-1){
                    mat[newrow][newcol] = mat[r][c]+1;
                    queue.add(newrow*m + newcol);
                }
            }
        }

        return mat;
    }
}