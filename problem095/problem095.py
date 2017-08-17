"""
The proper divisors of a number are all the divisors excluding the number itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As the sum of these divisors is equal to 28, we call it a perfect number.

Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper divisors of 284 is 220, forming a chain of two numbers. For this reason, 220 and 284 are called an amicable pair.

Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:

12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)

Since this chain returns to its starting point, it is called an amicable chain.

Find the smallest member of the longest amicable chain with no element exceeding one million.
"""

import timeit
from math import inf

start = timeit.default_timer()

divisor_sum = {i: 1 for i in range(1, 1000001)}
for i in range(2, 500001):
    multiple = 2 * i
    while multiple <= 1000000:
        divisor_sum[multiple] += i
        multiple += i

chains = {i: 0 for i in range(2, 1000001)}


for i in range(2, 1000001):
    chain = []
    current = i
    while current not in chain and current <= 1000000:
        chain.append(current)
        current = divisor_sum[current]

    if current <= 1000000 and divisor_sum[chain[-1]] == chain[0]:
        length = len(chain)
        for num in chain:
            chains[num] = len(chain)


longest_chain = 0
smallest_member = inf

for i in chains:
    if chains[i] > longest_chain:
        longest_chain = chains[i]
        smallest_member = i
    elif chains[i] == longest_chain:
        if i < smallest_member:
            smallest_member = i

print(smallest_member)
stop = timeit.default_timer()
print('Runtime:', stop - start)