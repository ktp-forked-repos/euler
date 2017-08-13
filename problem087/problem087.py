"""The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28. In fact, there are exactly four numbers below fifty that can be expressed in such a way:

28 = 22 + 23 + 24
33 = 32 + 23 + 24
49 = 52 + 23 + 24
47 = 22 + 33 + 24

How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?
"""
import timeit

from bitarray import bitarray


def prime_sieve(n):
    is_composite = bitarray(n + 1)
    current_prime = 2

    while True:
        for i in range(2, int(n / current_prime) + 1):
            is_composite[i * current_prime] = True
        try:
            current_prime = next((i for i in range(current_prime + 1, n + 1) if not is_composite[i]))
        except StopIteration:
            return [i for i in range(2, n + 1) if not is_composite[i]]

start = timeit.default_timer()


primes = prime_sieve(7069)
sums_of_prime_powers = set()

for a in primes:
    for b in primes:
        for c in primes:
            sum_of_prime_powers = a**2 + b**3 + c**4
            if sum_of_prime_powers < 50000000:
                sums_of_prime_powers.add(sum_of_prime_powers)
            else:
                break
        if a**2 + b**3 + 16 > 50000000:
            break


print(len(sums_of_prime_powers))

stop = timeit.default_timer()
print('Runtime:', stop - start)




