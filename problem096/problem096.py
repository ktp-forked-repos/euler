"""
Su Doku (Japanese meaning number place) is the name given to a popular puzzle concept. Its origin is unclear, but credit must be attributed to Leonhard Euler who invented a similar, and much more difficult, puzzle idea called Latin Squares. The objective of Su Doku puzzles, however, is to replace the blanks (or zeros) in a 9 by 9 grid in such that each row, column, and 3 by 3 box contains each of the digits 1 to 9. Below is an example of a typical starting puzzle grid and its solution grid.

A well constructed Su Doku puzzle has a unique solution and can be solved by logic, although it may be necessary to employ "guess and test" methods in order to eliminate options (there is much contested opinion over this). The complexity of the search determines the difficulty of the puzzle; the example above is considered easy because it can be solved by straight forward direct deduction.

The 6K text file, sudoku.txt (right click and 'Save Link/Target As...'), contains fifty different Su Doku puzzles ranging in difficulty, but all with unique solutions (the first puzzle in the file is the example above).

By solving all fifty puzzles find the sum of the 3-digit numbers found in the top left corner of each solution grid; for example, 483 is the 3-digit number found in the top left corner of the solution grid above.
"""

import re
import timeit

start = timeit.default_timer()


boxes = [
    {(x, y) for x in range(3) for y in range(3)},
    {(x, y) for x in range(3) for y in range(3, 6)},
    {(x, y) for x in range(3) for y in range(6, 9)},
    {(x, y) for x in range(3, 6) for y in range(3)},
    {(x, y) for x in range(3, 6) for y in range(3, 6)},
    {(x, y) for x in range(3, 6) for y in range(6, 9)},
    {(x, y) for x in range(6, 9) for y in range(3)},
    {(x, y) for x in range(6, 9) for y in range(3, 6)},
    {(x, y) for x in range(6, 9) for y in range(6, 9)},
]

box_mapping = {}
for i in range(9):
    for spot in boxes[i]:
        box_mapping[spot] = boxes[i]


def conflicts(grid, x, y):
    num = grid[x][y]

    for test in range(9):
        if num == grid[x][test] and test != y:
            return True
        elif num == grid[test][y] and test != x:
            return True

    for spot in box_mapping[(x, y)]:
        if spot == (x, y):
            continue
        if num == grid[spot[0]][spot[1]]:
            return True

    return False


def find_next(grid, x, y):
    found = False

    while not found:
        if y == 8:
            if x == 8:
                return None, None

            y = 0
            x += 1
        else:
            y += 1

        if grid[x][y] == 0:
            found = True

    return x, y


with open('p096_sudoku.txt') as f:
    raw_grids = re.sub('\n*Grid [0-9]+\n', '_', f.read()).split('_')

grids = [[[int(num) for num in line] for line in raw_grid.split('\n')] for raw_grid in raw_grids if raw_grid]

for grid in grids:
    solved = False
    changed_spots = []
    x, y = find_next(grid, 0, -1)

    while not solved:
        num = grid[x][y]

        if num == 9:
            grid[x][y] = 0
            x, y = changed_spots.pop()
            continue

        grid[x][y] += 1
        if not conflicts(grid, x, y):

            changed_spots.append((x, y))
            x, y = find_next(grid, x, y)

            if x is None:
                solved = True

print(sum((int(''.join((str(num) for num in grid[0][0:3]))) for grid in grids)))

stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 24702