from collections import deque
import heapq

class Solution:
    def maximumSafenessFactor(self, grid):
        n = len(grid)

        # Step 1: Distance from nearest thief
        dist = [[float('inf')] * n for _ in range(n)]
        q = deque()

        # Put all thief cells into queue
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    dist[i][j] = 0
                    q.append((i, j))

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        # Multi-source BFS
        while q:
            x, y = q.popleft()

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < n and 0 <= ny < n:
                    if dist[nx][ny] > dist[x][y] + 1:
                        dist[nx][ny] = dist[x][y] + 1
                        q.append((nx, ny))

        # Step 2: Max Heap for safest path
        max_heap = [(-dist[0][0], 0, 0)]  # negative because heapq is min-heap
        best = [[-1] * n for _ in range(n)]
        best[0][0] = dist[0][0]

        while max_heap:
            safe, x, y = heapq.heappop(max_heap)
            safe = -safe

            if x == n - 1 and y == n - 1:
                return safe

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < n and 0 <= ny < n:
                    new_safe = min(safe, dist[nx][ny])

                    if new_safe > best[nx][ny]:
                        best[nx][ny] = new_safe
                        heapq.heappush(max_heap, (-new_safe, nx, ny))

        return 0