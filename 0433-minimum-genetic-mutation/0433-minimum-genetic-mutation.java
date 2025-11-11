class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene))
            return -1;

        char[] geneChoices = new char[] {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int mutationCount = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            mutationCount++;
            for (int i = 0; i < size; i++){
                String gene = queue.poll();
                for (int c = 0; c < gene.length(); c++){
                    char oldChar = gene.charAt(c);
                    for (char ch : geneChoices){
                        gene = gene.substring(0, c) + ch + gene.substring(c + 1);
                        if (gene.equals(endGene))
                            return mutationCount;

                        if (bankSet.contains(gene)){
                            bankSet.remove(gene);
                            queue.offer(gene);
                        } 
                    }
                    gene = gene.substring(0, c) + oldChar + gene.substring(c + 1);;
                }
            }
        }
        return -1;

    }
}