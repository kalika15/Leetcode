class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] answer=new int[people.length];
        int[] peoples=new int[people.length];
        for(int i=0; i<people.length; i++){
            peoples[i]=people[i];
        }
        Arrays.sort(peoples);
        Arrays.sort(flowers, Comparator.comparingInt(flower->flower[0]));

        HashMap<Integer,Integer> CountMap=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int index=0;

        for(int time: peoples){
            while(index<flowers.length && flowers[index][0]<=time){
                pq.offer(flowers[index][1]);
                index++;
            }
            while(!pq.isEmpty() && pq.peek()<time){
                pq.poll();
            }
            CountMap.put(time, pq.size());
        }

        for(int i=0; i<people.length; i++){
            answer[i]=CountMap.get(people[i]);
        }
        return answer;
    }
}