def solution(array):
    answer = 0
    for i in array :
        for char in str(i) :
            if '7' == char :
                answer += 1
    return answer