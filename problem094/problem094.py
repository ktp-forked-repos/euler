import timeit

start = timeit.default_timer()

total = 0

x1 = 2
y1 = 1
n = 3

x = x1
y = y1

max_perimeter = 10**7000000

while True:
    x, y = x1*x + n*y1*y, x1*y + y1*x
    c1 = (2*x + 1) / 3
    c2 = (2*x - 1) / 3

    if 3 * c1 + 1 > max_perimeter:
        break

    if c1 == int(c1):
        total += 3*c1 + 1

    if c2 == int(c2):
        total += 3*c2 - 1

print(int(total))
stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 518408346
