class Solution {
    public HashMap<String,List<String>> buildGraph(List<List<String>> tickets, HashMap<String,List<String>> Graph){
        // HashMap<String,List<String>> Graph=new HashMap<>();
        for(List<String> route: tickets){
            String from=route.get(0);
            String to=route.get(1);
            List<String> temp=Graph.getOrDefault(from,new ArrayList<>());
            temp.add(to);
            Graph.put(from,temp);
        }
        return Graph;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> Graph=new HashMap<>();
        List<String> result=new ArrayList<>();
        buildGraph(tickets,Graph);
        // System.out.print(Graph);

        Stack<String> stack=new Stack<>();
        stack.push("JFK");

        while(!stack.isEmpty()){
            String position=stack.peek();
            List<String> routes=Graph.getOrDefault(position, new ArrayList<>());
            if(routes.size()==0){
                String des=stack.pop();
                result.add(des);
                continue;
            }
            Collections.sort(routes);
            for(String route: routes){
                stack.push(route);
                routes.remove(route);
                Graph.put(position, routes);
                break;
            }
            
            
        }

        Collections.reverse(result);
        return result;
        
    }
}