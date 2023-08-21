// o(n^2) time complexity using queue
class Solution1 {
    HashMap<Integer,List<Integer>> path;
    int[] answer;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        answer=new int[quiet.length];
        Arrays.fill(answer,-1);
        if(richer.length==0){
            for(int i=0;i<quiet.length;i++){
                answer[i]=i;
            }
            return answer;
        }
        path=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<quiet.length; i++){
            queue.add(i);
        }
        for(int rich=0; rich<richer.length; rich++){
            List<Integer> p=path.getOrDefault(richer[rich][1],new ArrayList<Integer>());
            p.add(richer[rich][0]);
            path.put(richer[rich][1],p);
        }
        while(!queue.isEmpty()){
            Integer curr=queue.poll();
            Queue<Integer> persons=new LinkedList<>();
            persons.add(curr);
            answer[curr]=curr;
            // if(!path.conatinsKey(curr)) continue;
            while(!persons.isEmpty()){
                int person=persons.poll();
                if(quiet[answer[curr]]>quiet[person]){
                    answer[curr]=person;
                }
                List<Integer> p=path.getOrDefault(person,new ArrayList<Integer>());
               
                for(int ele:p){
                    persons.add(ele);
                }
                
            }
        }
        return answer;
    }
}

class Solution{
    HashMap<Integer,List<Integer>> graph;
    int[] answer;
    public void solve(int curr, int[] quiet){
        if(graph.getOrDefault(curr,new ArrayList<>()).size()==0){
            answer[curr]=curr;
            return;
        }
        else{
            int current=curr;
            for(int x: graph.get(curr)){
                if(answer[x]==Integer.MAX_VALUE) solve(x,quiet);
                if(quiet[answer[x]]<quiet[current]) current=answer[x];
            }
            answer[curr]=current;
        }

    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int people=quiet.length;
        graph=new HashMap<>();
        answer=new int[people];
        Arrays.fill(answer,Integer.MAX_VALUE);
        for(int[] rich: richer){
            List<Integer> connection=graph.getOrDefault(rich[1],new ArrayList<>());
            connection.add(rich[0]);
            graph.put(rich[1],connection);
        }
        for(int i=0; i<people; i++){
            if(answer[i]==Integer.MAX_VALUE) solve(i,quiet);
        }
        return answer;
    }
}