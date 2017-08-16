"""
ach of the six faces on a cube has a different digit (0 to 9) written on it; the same is done to a second cube. By placing the two cubes side-by-side in different positions we can form a variety of 2-digit numbers.

For example, the square number 64 could be formed:


In fact, by carefully choosing the digits on both cubes it is possible to display all of the square numbers below one-hundred: 01, 04, 09, 16, 25, 36, 49, 64, and 81.

For example, one way this can be achieved is by placing {0, 5, 6, 7, 8, 9} on one cube and {1, 2, 3, 4, 8, 9} on the other cube.

However, for this problem we shall allow the 6 or 9 to be turned upside-down so that an arrangement like {0, 5, 6, 7, 8, 9} and {1, 2, 3, 4, 6, 7} allows for all nine square numbers to be displayed; otherwise it would be impossible to obtain 09.

In determining a distinct arrangement we are interested in the digits on each cube, not the order.

{1, 2, 3, 4, 5, 6} is equivalent to {3, 6, 4, 1, 2, 5}
{1, 2, 3, 4, 5, 6} is distinct from {1, 2, 3, 4, 5, 9}

But because we are allowing 6 and 9 to be reversed, the two distinct sets in the last example both represent the extended set {1, 2, 3, 4, 5, 6, 9} for the purpose of forming 2-digit numbers.

How many distinct arrangements of the two cubes allow for all of the square numbers to be displayed?
"""
import timeit
from itertools import combinations

start = timeit.default_timer()

distinct = []
for d1 in (set(x) for x in combinations(range(10), 6)):
    for d2 in (set(x) for x in combinations(range(10), 6)):

        def they_contain(a, b):
            return (a in d1 and b in d2) or (b in d1 and a in d2)

        valid = all([
            they_contain(0, 1),
            they_contain(0, 4),
            they_contain(0, 9) or they_contain(0, 6),
            they_contain(1, 6) or they_contain(1, 9),
            they_contain(2, 5),
            they_contain(3, 6) or they_contain(3, 9),
            they_contain(4, 9) or they_contain(4, 6),
            they_contain(8, 1)
        ])

        if valid and (d1, d2) not in distinct and (d2, d1) not in distinct:
            distinct.append((d1, d2))

print(len(distinct))
stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 1217
