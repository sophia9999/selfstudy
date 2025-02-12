def solution(s):
    answer = False
    if len(s) == 4 or len(s) ==6 :
        for char in s :
            if char not in "1234567890" :
                return answer
        answer = True
    return answer