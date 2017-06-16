import pprint
import random
import timeit
from queue import Queue



start = timeit.default_timer()

STAY = -1
NEXT_R = -2
NEXT_U = -3
BACK_3 = -4

board = {x: 0 for x in range(40)}
go = 0
cc = [2, 17, 33]
ch = [7, 22, 36]
jail = 10
g2j = 30
c1 = 11
e3 = 24
h2 = 39
r1 = 5
r = [5, 15, 25, 35]
u = [12, 28]

chance_arr = [go, jail, c1, e3, h2, r1, NEXT_R, NEXT_R, NEXT_U, BACK_3] + [STAY]*6
random.shuffle(chance_arr)
chance = Queue()
for x in chance_arr:
    chance.put(x)


chest_arr = [go, jail] + [STAY] * 14
random.shuffle(chest_arr)
chest = Queue()
for x in chest_arr:
    chest.put(x)

position = 0
consec_doubles = 0
for i in range(1000000):
    die1 = random.randint(1, 4)
    die2 = random.randint(1, 4)

    if die1 == die2:
        consec_doubles += 1
    else:
        consec_doubles = 0

    if consec_doubles == 3:
        position = jail
        consec_doubles = 0
    else:
        position = (position + die1 + die2) % 40

        if position == g2j:
            position = jail
        elif position in ch:
            card = chance.get()
            if card == NEXT_R:
                while position not in r:
                    position = (position + 1) % 40
            elif card == NEXT_U:
                while position not in u:
                    position = (position + 1) % 40
            elif card == BACK_3:
                position -= 3
            elif card == STAY:
                pass
            else:
                position = card
            chance.put(card)
        elif position in cc:
            card = chest.get()
            if card == STAY:
                pass
            else:
                position = card
            chest.put(card)

    board[position] += 1

for key in board:
    board[key] /= 10000

modal_string = ''
for x in list(reversed(sorted(board.items(), key=lambda x: x[1])))[:3]:
    modal_string += str(x[0]).zfill(2)
print(modal_string)

stop = timeit.default_timer()
print('Runtime:', str(stop - start)[:5] + 's')
