
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        buildGraph(recipes, ingredients, graph, indegree);
        Queue<String> queue=new LinkedList<>();
        List<String> result=new ArrayList<>();
        System.out.print(graph);
        for(String ing: supplies){
            queue.add(ing);
        }
        while(!queue.isEmpty()){
            String curr=queue.poll();
            for(String nbr: graph.getOrDefault(curr, new ArrayList<>())){
                indegree.put(nbr,indegree.get(nbr)-1);
                if(indegree.get(nbr)==0){
                    queue.add(nbr);
                    result.add(nbr);
                }

            }

        }
        return result;
    }

    public void buildGraph(String[] recipes, List<List<String>> ingredients, Map<String, List<String>> graph, Map<String, Integer> indegree) {
        for (int i = 0; i <ingredients.size(); i++) {
            indegree.put(recipes[i], 0);
            List<String> ing=ingredients.get(i);
            for (String ingredient : ing){
                List<String> ings=graph.getOrDefault(ingredient,new ArrayList<>());
                ings.add(recipes[i]);
                graph.put(ingredient,ings);
            }
            
            
        }
        for (int i=0; i<ingredients.size(); i++) {
            List<String> ing=ingredients.get(i);
            for (String ingredient : ing) {
                indegree.put(recipes[i], indegree.get(recipes[i]) + 1);
            }
        }
    }
}
