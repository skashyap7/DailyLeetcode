class Solution {
    
    Map<Integer,List<Integer>> map = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        process(adjacentPairs);
        int f =  map.entrySet().stream()
            .filter( e -> e.getValue().size() == 1)
            .map( map -> map.getKey())
            .findFirst()
            .get();
        int[] result = new int[adjacentPairs.length + 1];
        int i = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(f);
        visited.add(f);
        while (!q.isEmpty()) {
            int val = q.remove();
            visited.add(val);
            result[i++] = val;
            if (map.containsKey(val)) {
                List<Integer> c = map.get(val);
                for ( int e : c) {
                    if (!visited.contains(e)) {
                        q.add(e);        
                    }
                }
            }
        }
        return result;
    }
    
    
    public void process(int[][] pairs) {
        for (int i =0; i < pairs.length; i++) {
            int[] element = pairs[i];
           map.computeIfAbsent(element[1], k -> new ArrayList<>()).add(element[0]);
           map.computeIfAbsent(element[0], k -> new ArrayList<>()).add(element[1]);
        }
    }
}
