import math
def solution(n):
    yaksu = set()
    for i in range(1, int(math.sqrt(n)) + 1) :
        if n % i == 0 :
            yaksu.add(i)
            yaksu.add(n // i)
            
    answer = list(yaksu)
    answer.sort()
    return answer