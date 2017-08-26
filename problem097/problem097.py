import timeit

start = timeit.default_timer()

print((28433 * (2 << 7830456) + 1) % 10000000000)


stop = timeit.default_timer()
print('Runtime:', stop - start)