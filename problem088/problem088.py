"""
A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers, {a1, a2, ... , ak} is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.

For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.

For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number. The minimal product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.

k=2: 4 = 2 × 2 = 2 + 2
k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6

Hence for 2≤k≤6, the sum of all the minimal product-sum numbers is 4+6+8+12 = 30; note that 8 is only counted once in the sum.

In fact, as the complete set of minimal product-sum numbers for 2≤k≤12 is {4, 6, 8, 12, 15, 16}, the sum is 61.

What is the sum of all the minimal product-sum numbers for 2≤k≤12000?
"""

from operator import mul
from math import inf
import timeit
from functools import reduce


start = timeit.default_timer()

all_factors = []
for n in range(2, 14):
    factors = [2] * n
    done = False
    while not done:
        i = 0
        while reduce(mul, factors) <= 24000:
            all_factors.append(factors[:])
            factors[i] += 1

        while not done:
            i += 1
            if i >= n:
                done = True
            else:
                tentative = [factors[i] + 1] * (i + 1) + factors[i+1:]
                if reduce(mul, tentative) <= 24000:
                    factors = tentative
                    break

min_prod_sum = {i: inf for i in range(2, 12001)}
for factors in all_factors:
    p = reduce(mul, factors)
    k = p - sum(factors) + len(factors)
    if k > 12000:
        continue
    if min_prod_sum[k] > p:
        min_prod_sum[k] = p


print(sum(set(min_prod_sum.values())))

stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 7587457