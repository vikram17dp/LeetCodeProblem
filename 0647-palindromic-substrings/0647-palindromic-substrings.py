class Solution:
    # TC: O(n^2)
    # SC: O(1)
    # Expand around center
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        count = 0

        for i in range(n):
            count += self.expand(s,i,i) # odd length
            count += self.expand(s,i,i+1) # even length
        return count
    
    def expand(self,s,start,end):
        count = 0
        while(start >= 0 and end < len(s) and s[start] == s[end]):
            count += 1
            start -= 1
            end += 1
        return count