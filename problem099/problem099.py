import timeit

from math import log

start = timeit.default_timer()

with open('p099_base_exp.txt') as f:
    pairs = [tuple(map(int, line.strip().split(','))) for line in f.readlines()]

largest = 0
largest_line = 0
for index, (base, exp) in enumerate(pairs):
    x = exp * log(base)
    if x > largest:
        largest = x
        largest_line = index + 1

print(largest_line)

stop = timeit.default_timer()
print('Runtime:', stop - start)