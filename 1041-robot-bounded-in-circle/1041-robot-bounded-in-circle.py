class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # Directions: North, East, South, West (clockwise)
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        # Start position and facing direction (0 = North)
        x, y, direction = 0, 0, 0
        
        # Iterate through the instructions once
        for instruction in instructions:
            if instruction == 'G':
                # Move in the current direction
                x += directions[direction][0]
                y += directions[direction][1]
            elif instruction == 'L':
                # Turn left (counter-clockwise)
                direction = (direction - 1) % 4
            elif instruction == 'R':
                # Turn right (clockwise)
                direction = (direction + 1) % 4
        
        # Check if the robot is at the origin or facing a different direction
        return (x == 0 and y == 0) or direction != 0