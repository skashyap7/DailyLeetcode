class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for ( int[] p : prerequisites) {
            map.computeIfAbsent(p[1], a -> new ArrayList()).add(p[0]);
            // increase indegree
            indegree[p[0]] += 1;
        }
        Queue<Integer> courses = new LinkedList<>();
        for ( int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                courses.add(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!courses.isEmpty()) {
            int course = courses.remove();
            result[index++] = course;
            if(map.containsKey(course)) {
               for ( int c : map.get(course)) {
                    indegree[c]--;
                    if (indegree[c] == 0) {
                        courses.add(c);
                    }
                } 
            }   
        }
        if(index == numCourses) {
            return true;
        }
        return false;
    }
}
