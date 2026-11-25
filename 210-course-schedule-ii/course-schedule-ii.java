class Solution {
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
        }

        int[] visited = new int[numCourses];
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited,ans)){
                    return new int[0];
                }
            }
        }

        int left = 0;
        int right = numCourses-1;

        while(left<right){
            int temp = ans[left];
            ans[left]=ans[right];
            ans[right]=temp;

            left++;
            right--;
        }

        return ans;
    }

    boolean dfs(int node , List<List<Integer>> adj, int[] visited,int[] ans){
        visited[node] = 1;

        for(int neighbour : adj.get(node)){
            if(visited[neighbour]==1){
                return true;
            }

            if(visited[neighbour]==0){
                if(dfs(neighbour,adj,visited,ans)){
                    return true;
                }
            }
        }

        visited[node]=2;
        ans[index++]=node;
        return false;
    }
    
}