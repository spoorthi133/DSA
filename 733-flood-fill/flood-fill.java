class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int original = image[sr][sc];
        Queue<Integer> queue = new LinkedList<>();

        if(original==color){return image;}

        image[sr][sc] = color;
        queue.add(sr*m+sc);

        int[] delrow ={-1,1,0,0};
        int[] delcol={0,0,-1,1};

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int r = cur/m;
            int c = cur%m;
            for(int i=0;i<4;i++){
                int newrow = r+delrow[i];
                int newcol = c+delcol[i];

                if(newrow>=0 && newrow<n && newcol >=0 && newcol<m && image[newrow][newcol]==original){
                    image[newrow][newcol]=color;
                    queue.add(newrow*m+newcol);
                }
            }
        }
return image; 
    }
}