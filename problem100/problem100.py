"""
If a box contains twenty-one coloured discs, composed of fifteen blue discs and six red discs, and two discs were taken at random, it can be seen that the probability of taking two blue discs, P(BB) = (15/21)×(14/20) = 1/2.

The next such arrangement, for which there is exactly 50% chance of taking two blue discs at random, is a box containing eighty-five blue discs and thirty-five red discs.

By finding the first arrangement to contain over 1012 = 1,000,000,000,000 discs in total, determine the number of blue discs that the box would contain.
"""

import timeit

start = timeit.default_timer()


"""
From OEIS A011900: Solutions to b(b-1) = 2a(a-1) in natural numbers
"""
def a(n):
    if n == 0:
        return 1
    if n == 1:
        return 3

    return 6 * a(n-1) - a(n-2) - 2

n = 2

while True:
    if 2 * a(n) > 10**12:
        break
    n += 1

print(a(n))

stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 756872327473