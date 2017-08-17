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