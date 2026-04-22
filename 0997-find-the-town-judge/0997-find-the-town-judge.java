class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> trustCount = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            trustCount.put(i, 0);
        }

        for (int[] t : trust) {
            int a = t[0]; // person who trusts
            int b = t[1]; // person who is trusted

            // a trusts someone -> decrement a's count
            trustCount.put(a, trustCount.get(a) - 1);

            // b is trusted by someone -> increment b's count
            trustCount.put(b, trustCount.get(b) + 1);
        }

        for (int person : trustCount.keySet()) {
            if (trustCount.get(person) == n - 1) {
                return person;
            }
        }

        return -1;
    }

}