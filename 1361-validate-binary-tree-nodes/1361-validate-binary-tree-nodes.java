class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] childvisit=new boolean[n];
        for(int child: leftChild){
            if(child!=-1) childvisit[child]=true;
        }

        for(int child: rightChild){
            if(child!=-1){
                if(childvisit[child]) return false;
                childvisit[child]=true;
            }
        }

        int root=-1;
        for(int i=0; i<n; i++){
            if(!childvisit[i]){
                if(root==-1) root=i;
                else return false;
            }
        }

        if(root==-1) return false;
        
        return binary(root, leftChild, rightChild);
    }

    public boolean binary(int root ,int[] leftChild, int[] rightChild){
        boolean[] visited=new boolean[leftChild.length];
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(root);
        visited[root]=true;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            if(leftChild[curr]!=-1){
                if(visited[leftChild[curr]]) return false;

                queue.offer(leftChild[curr]);
                visited[leftChild[curr]]=true;
            }
             
            if(rightChild[curr]!=-1){
                if(visited[rightChild[curr]]) return false;

                queue.offer(rightChild[curr]);
                visited[rightChild[curr]]=true;
            }
        }

        for(boolean visit: visited){
            if(!visit) return false;
        }

        return true;

    }

}