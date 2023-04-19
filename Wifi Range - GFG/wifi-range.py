#User function Template for python3
class Solution:
    def wifiRange(self, num_rooms: int, room_map: str, router_range: int) -> bool:
        # Initialize the end of the last covered range to be 0
        last_covered_end = 0
        
        # Iterate through each room in the map
        for i in range(num_rooms):
            # If the current room has wifi coverage
            if room_map[i] == '1':
                # Check if the previous router's coverage extends to the current room
                if i - router_range > last_covered_end:
                    # The current router's coverage does not extend to the current room
                    return False
                
                # Update the end of the last covered range to be the end of the current router's coverage
                last_covered_end = i + router_range + 1
        
        # Check if the last covered range extends to the end of the room map
        return last_covered_end >= num_rooms


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int(input())
    for _ in range(t):
        N,X = map(int,input().strip().split())
        S = input()
        ob = Solution()
        ans = ob.wifiRange(N, S, X)
        if ans:
            print(1)
        else:
            print(0)

# } Driver Code Ends