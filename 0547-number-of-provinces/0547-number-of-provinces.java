class Solution {

        public void dfs(int[][] isConnected,boolean[] vis,int node){
            vis[node] =true;
            for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
                if(isConnected[node][neighbor] == 1 && !vis[neighbor]){
                    dfs(isConnected, vis, neighbor);
                }
            }

        }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for(int i = 0;i < n; i++){
            if(!vis[i]){
                dfs(isConnected, vis, i);
                provinces++;
            }
        }
        return provinces;
    }

}