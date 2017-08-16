"""
The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and are joined to the origin, O(0,0), to form ΔOPQ.


There are exactly fourteen triangles containing a right angle that can be formed when each co-ordinate lies between 0 and 2 inclusive; that is,
0 ≤ x1, y1, x2, y2 ≤ 2.


Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?

"""

import timeit

count = 0
coord_range = range(0, 51)

start = timeit.default_timer()

for P in ((x, y) for x in coord_range for y in coord_range):
    if P == (0, 0):
        continue
    for Q in ((x, y) for x in coord_range for y in coord_range):
        if P == Q or Q == (0, 0):
            continue

        PQ = (Q[0] - P[0], Q[1] - P[1])

        if P[0] * Q[0] + P[1] * Q[1] == 0:
            count += 1
        elif P[0] * PQ[0] + P[1] * PQ[1] == 0:
            count += 1
        elif Q[0] * PQ[0] + Q[1] * PQ[1] == 0:
            count += 1


print(count // 2)

stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 14234
