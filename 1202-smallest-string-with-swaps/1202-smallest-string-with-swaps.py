class Solution:
    # def swap(self,s,i,j):
    #     l=list(s)
    #     l[i],l[j]=l[j],l[i]
    #     return "".join(l)
    # def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
    #     if len(pairs)==0 or len(s)==0:
    #         return s
    #     pairList=[[] for i in range(len(s))]
    #     # it stores the parent element of the pair
    #     HashMap={}
    #     for pair in pairs:
    #         if pair[1] not in HashMap:
    #             HashMap[pair[1]]=[pair[0]]
    #         else:
    #             HashMap[pair[1]].append(pair[0])
    #     print(HashMap)
    #     for pair in pairs:
    #         pairList[pair[0]].append(pair[1])
    #         if pair[0] in HashMap:
    #             for i in HashMap[pair[0]]:
    #                 pairList[i].append(pair[1])

    #     print(pairList)
    #     # for pair in pairs:
    #     #     if pair[0] not in HashMap:
    #     #         HashMap[pair[0]]=[]
    #     #     if pair[1] not in HashMap:
    #     #         HashMap[pair[1]]=[]
    #     #     HashMap[pair[0]].append(pair[1])
    #     #     HashMap[pair[1]].append(pair[0])
    #     visited=set()
    #     # heappush(visited,s)
    #     Queue=deque()
    #     Queue.append(s)
    #     ans=s
    #     while(Queue):
    #         temp=Queue.popleft()
    #         for i in range(len(pairList)):
    #             for j in pairList[i]:
    #                 if temp[i]>temp[j]:
    #                     a=self.swap(temp,i,j)
    #                     if a not in visited:
    #                         if a<ans:
    #                             ans=a
    #                         visited.add(a)
    #                         Queue.append(a)
    #     return ans
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        n=len(s)
        visited=[False]*n
        graph=defaultdict(list)
        pathList=[]

        for i,j in pairs:
            graph[i].append(j)
            graph[j].append(i)

        def dfs(node,path):
            visited[node]=True
            path.append(node)
            for nbr in graph[node]:
                if visited[nbr]==False:
                    dfs(nbr,path)
        
        for i in range(n):
            if visited==True:
                continue
            path=[]
            dfs(i,path)
            pathList.append(path)
        
        for lst in pathList:
            lst.sort()
            temp=[s[i] for i in lst]
            temp.sort()
            for i in range(len(lst)):
                s=s[:lst[i]]+temp[i]+s[lst[i]+1:]
        return s