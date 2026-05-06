class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public int[] findRedundantConnection(int[][] edges) {
        // union By Size

        // parent and size list
        int len = edges.length; 
        for(int i = 0; i <= len; i++ ){
            parent.add(i);
            size.add(1);
        }      

        for(int[] edge: edges){
            if(unionBySize(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }

    // find ultimate parent
    public int findUPar(int i){
        if(parent.get(i) == i){
            return i;
        }
        parent.set(i, findUPar(parent.get(i)));
        return parent.get(i);
    }

    // union by size method if having th esame parent remove that edge
    public boolean unionBySize(int u, int v){
        int uParU = findUPar(u);
        int uParV = findUPar(v);
        if(uParU == uParV) return true;
        if(size.get(uParU) > size.get(uParV)){
            parent.set(uParV, uParU);
        } else if( size.get(uParU) < size.get(uParV)){
            parent.set(uParU, uParV);
        } else {
            size.set(size.get(uParU), size.get(uParU) + size.get(uParV));
            parent.set(uParV, uParU);
        }
        return false;
    }
}


// TC: O(N * 4*Alpha)
// SC: O(len of Edges)