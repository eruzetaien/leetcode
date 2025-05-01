class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        radiant = collections.deque()
        dire = collections.deque()
        n = len(senate)
        
        for idx, party in enumerate(senate):
            if party == 'R':
                radiant.append(idx)
            else:
                dire.append(idx)
        
        while radiant and dire:
            r = radiant.popleft()
            d = dire.popleft()
            if r < d:
                radiant.append(r + n)
            else:
                dire.append(d + n)
        
        return "Radiant" if radiant else "Dire"