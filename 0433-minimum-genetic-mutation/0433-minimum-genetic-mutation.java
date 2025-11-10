class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) 
            return -1; 

        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) 
                    return mutations;
                
                char[] arr = gene.toCharArray();
                for (int pos = 0; pos < arr.length; pos++) {
                    char old = arr[pos];
                    for (char c : choices) {
                        if (c == old) continue;
                        arr[pos] = c;
                        String mutated = new String(arr);
                        if (bankSet.contains(mutated)) {
                            queue.offer(mutated);
                            bankSet.remove(mutated);
                        }
                    }
                    arr[pos] = old;
                }
            }
            mutations++;
        }

        return -1;

    }
}