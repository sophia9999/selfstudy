import math
def solution(n):
    answer = 1
    for i in range(10, 0, -1) :
        if math.factorial(i) <= n :
            return i