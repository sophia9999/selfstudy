def solution(n, numlist):
    answer = []
    for i, value in enumerate(numlist) :
        if value % n == 0 :
            answer.append(value)
    
    return answer