class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n: int = len(rooms)
        
        visited: set[int] = {0}
        stack: List[int] = rooms[0]

        while stack:
            room: int = stack.pop()
            if (room not in visited):
                visited.add(room)

            for room_key in rooms[room]:
                if (room_key not in visited):
                    stack.append(room_key)

        return len(visited) == n