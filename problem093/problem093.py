"""
By using each of the digits from the set, {1, 2, 3, 4}, exactly once, and making use of the four arithmetic operations (+, −, *, /) and brackets/parentheses, it is possible to form different positive integer targets.

For example,

8 = (4 * (1 + 3)) / 2
14 = 4 * (3 + 1 / 2)
19 = 4 * (2 + 3) − 1
36 = 3 * 4 * (2 + 1)

Note that concatenations of the digits, like 12 + 34, are not allowed.

Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the maximum, and each of the numbers 1 to 28 can be obtained before encountering the first non-expressible number.

Find the set of four distinct digits, a < b < c < d, for which the longest set of consecutive positive integers, 1 to n, can be obtained, giving your answer as a string: abcd.
"""

import timeit
from itertools import combinations_with_replacement, combinations, permutations
from operator import add, sub, mul


def div(a, b):
    if b == 0:
        return 0
    return a / b

start = timeit.default_timer()
op_combos = [perm for comb in combinations_with_replacement((add, sub, mul, div), 3) for perm in permutations(comb)]
hits = {}
for comb in combinations(range(10), 4):
    hits[comb] = set()
    for d1, d2, d3, d4 in permutations(comb):
        for op1, op2, op3 in op_combos:
            expressions = (
                op1(d1, op2(d2, op3(d3, d4))),
                op1(d1, op3(op2(d2, d3), d4)),
                op2(op1(d1, d2), op3(d3, d4)),
                op3(op1(d1, op2(d2, d3)), d4),
                op3(op2(op1(d1, d2), d3), d4)
            )

            for value in expressions:
                if 0 < value == int(value):
                    hits[comb].add(int(value))

max_comb = ()
max_streak = 0
for comb in hits:
    i = 1
    while i in hits[comb]:
        i += 1
    i -= 1

    if i > max_streak:
        max_streak = i
        max_comb = comb


print(''.join(map(str, sorted(max_comb))))

stop = timeit.default_timer()
print('Runtime:', stop - start)