class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = set()

        available_rooms = [0]
        pointer = 0
        while (pointer < len(available_rooms)):
            room_number = available_rooms[pointer]
            visited.add(room_number)

            room = rooms[room_number]
            for number in room:
                if (number not in visited ):
                    available_rooms.append(number)

                
            pointer += 1

        return len(visited) == len(rooms)