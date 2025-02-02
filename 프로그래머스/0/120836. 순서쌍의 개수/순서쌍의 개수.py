import math
def solution(n):
    answer = []
    #약수구하기...
    for i in range(1, n+1) :
        if n % i == 0 :
            answer.append(i)
    
    return len(answer)