import timeit
import math
from queue import PriorityQueue


start = timeit.default_timer()

with open('p083_matrix.txt') as matrix_file:
    matrix = [list(map(int, line.split(','))) for line in matrix_file.readlines()]


size = len(matrix)
distances = [[math.inf]*size for _ in range(size)]
unvisited = PriorityQueue()
unvisited.put((matrix[0][0], 0, 0))

while not unvisited.empty():
    dist, row, col = unvisited.get()

    if (row, col) == (size-1, size-1):
        print(dist)
        break

    if dist >= distances[row][col]:
        continue

    distances[row][col] = dist

    if row != 0:
        unvisited.put((dist + matrix[row-1][col], row-1, col))
    if col != 0:
        unvisited.put((dist + matrix[row][col-1], row, col-1))
    if row != size-1:
        unvisited.put((dist + matrix[row+1][col], row+1, col))
    if col != size-1:
        unvisited.put((dist + matrix[row][col+1], row, col+1))

stop = timeit.default_timer()
print('Runtime:', stop - start)



