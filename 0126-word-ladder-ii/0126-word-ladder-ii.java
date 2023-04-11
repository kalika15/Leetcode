class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList<>();

        HashMap<String,List<String>> neighbour=new HashMap<>();

        if(!wordList.contains(beginWord)) wordList.add(beginWord);

        HashSet<String> wordSet=new HashSet<>(wordList);

        for(String word: wordList){
            char[] current=word.toCharArray();
            for(int i=0;i<current.length;i++){
                char ch=current[i];
                for(char k='a';k<='z';k++){
                    char temp = current[i];
                    current[i] = k;
                    String neigh=new String(current);
                    current[i]=temp;
                    if(wordList.contains(neigh)){
                        List<String> words=neighbour.getOrDefault(word,new ArrayList<>());
                        if(!words.contains(neigh)) words.add(neigh);
                        neighbour.put(word,words);
                    }
                }
            }
        }


        // System.out.println(neighbour);
        wordSet.remove(beginWord);

        Queue<String> queue=new LinkedList<>();

        queue.add(beginWord);

        HashSet<String> newseen=new HashSet<>();

        HashMap<String,List<String>> reverse_neighbour=new HashMap<>();

        while(!queue.isEmpty()){
            newseen.clear();
            int size=queue.size();
            for(int i=0;i<size;i++){
                String word=queue.poll();
                char[] current=word.toCharArray();
                for(int j=0;j<current.length;j++){
                    for(char k='a';k<='z';k++){
                        char temp=current[j];
                        current[j]=k;
                        String neigh=new String(current);
                        if(neighbour.containsKey(neigh) && wordSet.contains(neigh)){
                            List<String> words=reverse_neighbour.getOrDefault(neigh, new ArrayList<>());
                            words.add(word);
                            reverse_neighbour.put(neigh,words);
                            // reverse_neighbour.get(neigh).add(word);
                            newseen.add(neigh);
                        }
                        current[j]=temp;
                    }
                }
            }
            queue.addAll(newseen);
            wordSet.removeAll(newseen);
            if (reverse_neighbour.containsKey(endWord)) {
                break;
            }

        }
        if(!reverse_neighbour.containsKey(endWord)){
            return new ArrayList<>();
        }
        List<List<String>> paths = new ArrayList<>();
        List<String> initialPath = new ArrayList<>();
        initialPath.add(endWord);
        paths.add(initialPath);

        while (true) {
            List<List<String>> newPaths = new ArrayList<>();
            for (List<String> path : paths) {
                String lastNode = path.get(path.size() - 1);
                List<String> reverseNeighbors = reverse_neighbour.get(lastNode);
                for (String reverseNeighbor : reverseNeighbors) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(reverseNeighbor);
                    newPaths.add(newPath);
                }
            }
            paths = newPaths;
            if (paths.get(0).get(paths.get(0).size() - 1).equals(beginWord)) {
                break;
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> path : paths) {
            Collections.reverse(path);
            result.add(path);
        }

        return result;
    }
}