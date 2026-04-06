public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) 
            return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        Map<String, Integer> visited = new HashMap<>();
        visited.put(startGene, 0);

        while (!queue.isEmpty()) {
            String gene = queue.poll();
            int steps = visited.get(gene);

            if (gene.equals(endGene)) {
                return steps;
            }

            for (String nextGene : bankSet) {
                if (!visited.containsKey(nextGene) && isOneMutation(gene, nextGene)) {
                    visited.put(nextGene, steps + 1);
                    queue.add(nextGene);
                }
            }
        }

        return -1; 
    }

    private boolean isOneMutation(String gene1, String gene2) {
        int diff = 0;
        for (int i = 0; i < gene1.length(); i++) {
            if (gene1.charAt(i) != gene2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

}