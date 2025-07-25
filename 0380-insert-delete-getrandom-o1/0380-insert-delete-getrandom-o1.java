class RandomizedSet {
    private Map<Integer, Integer> valToIndex;
    private List<Integer> numList;
    private Random random;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        numList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) return false;

        valToIndex.put(val, numList.size());
        numList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) return false;

        int idxToRemove = valToIndex.get(val);
        int lastVal = numList.get(numList.size() - 1);

        numList.set(idxToRemove, lastVal);
        valToIndex.put(lastVal, idxToRemove);

        numList.remove(numList.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(numList.size());
        return numList.get(randomIdx);
    }
    
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */