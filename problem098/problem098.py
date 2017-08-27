"""
By replacing each of the letters in the word CARE with 1, 2, 9, and 6 respectively, we form a square number: 1296 = 362. What is remarkable is that, by using the same digital substitutions, the anagram, RACE, also forms a square number: 9216 = 962. We shall call CARE (and RACE) a square anagram word pair and specify further that leading zeroes are not permitted, neither may a different letter have the same digital value as another letter.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, find all the square anagram word pairs (a palindromic word is NOT considered to be an anagram of itself).

What is the largest square number formed by any member of such a pair?

NOTE: All anagrams formed must be contained in the given text file.
"""

from itertools import combinations, permutations
from math import sqrt
from string import ascii_lowercase

import timeit

start = timeit.default_timer()

with open('p098_words.txt') as f:
    words = f.read().replace('"', '').lower().split(',')

letter_counts = {}
for word in words:
    letter_counts[word] = {}
    for letter in ascii_lowercase:
        letter_counts[word][letter] = word.count(letter)

pairs = sorted([(a, b) for a in words for b in words if letter_counts[a] == letter_counts[b]
         and words.index(a) < words.index(b)], key=lambda x: -len(x[0]))

maximum = 0

for pair in pairs:
    letters = list(set(pair[0]))
    if len(pair[0]) < len(str(maximum)):
        break
    for comb in combinations(range(10), len(letters)):
        for perm in permutations(comb):
            int1, int2 = pair
            mapping = {letters[i]: str(perm[i]) for i in range(len(letters))}

            if mapping[pair[0][-1]] not in ('0', '1', '5', '6', '9') or mapping[pair[1][-1]] not in ('0', '1', '5', '6', '9'):
                continue

            for letter in mapping:
                int1 = int1.replace(letter, mapping[letter])
                int2 = int2.replace(letter, mapping[letter])

            if int1[0] == '0' or int2[0] == '0':
                continue

            int1, int2 = int(int1), int(int2)

            if sqrt(int1).is_integer() and sqrt(int2).is_integer():
                if int1 > maximum:
                    maximum = int1
                if int2 > maximum:
                    maximum = int2


print(maximum)

stop = timeit.default_timer()
print('Runtime:', stop - start)

# Answer: 18769