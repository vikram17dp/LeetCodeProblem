class Solution {
    // O(N · α(N)) for DSU unions & finds  + O(M log M) for sorting emails inside groups => O(NlogN) and sc is O(N) for DSU arrays  O(N) for hash maps (email→id, email→name)  O(N) for grouping emails => O(3N) => O(N)


    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rank[px] < rank[py]){
                parent[px] = py;

            }else if(rank[px] > rank[py]){
                parent[py] = px;
            }else{
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String,Integer> emailToId = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        int id = 0;
        // Step 1: Assign IDs to all unique emails\
        for(List<String> acc : accounts){
            String name = acc.get(0);

            for(int i = 1;i<acc.size();i++){
                String email = acc.get(i);

                 if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id);
                    emailToName.put(email, name);
                    id++;
                }
            }
        }
        DSU dsu = new DSU(id);
         // Step 2: Union all emails in same account
        for (List<String> acc : accounts) {
            int firstEmailId = emailToId.get(acc.get(1));
            for (int i = 2; i < acc.size(); i++) {
                dsu.union(firstEmailId, emailToId.get(acc.get(i)));
            }
        }

 // Step 3: Group emails by their root parent
        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : emailToId.keySet()) {
            int parentId = dsu.find(emailToId.get(email));
            groups.computeIfAbsent(parentId, k -> new ArrayList<>()).add(email);
        }

        // Step 4: Prepare result
        List<List<String>> result = new ArrayList<>();

        for (List<String> groupEmails : groups.values()) {
            Collections.sort(groupEmails);
            String name = emailToName.get(groupEmails.get(0));

            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(groupEmails);

            result.add(list);
        }

        return result;
    }
}