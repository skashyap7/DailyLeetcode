class SparseVector {
    Map<Integer,Integer> sparse = new HashMap<>();
    SparseVector(int[] nums) {
        for(int i =0; i < nums.length; i++) {
            if(nums[i] != 0) {
                sparse.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for ( int i : vec.sparse.keySet()) {
            if(sparse.containsKey(i)) {
                result += sparse.get(i) * vec.sparse.get(i);
            }
        }
        return result;
    }
}
