class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int node , List<List<Integer>> adj, int[] visited){
        visited[node] = 1;

        for(int neighbour : adj.get(node)){
            if(visited[neighbour]==1){
                return true;
            }

            if(visited[neighbour]==0){
                if(dfs(neighbour,adj,visited)){
                    return true;
                }
            }
        }

        visited[node]=2;
        return false;
    }
}