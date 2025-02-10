def solution(my_string):
    answer = ''
    for char in my_string :
        if char in "abcdefghijklnmopqrstuvwxyz" :
            answer += char.upper()
        else :
            answer += char.lower()
    return answer