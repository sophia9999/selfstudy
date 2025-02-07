def solution(my_string):
    isExist = set()
    answer = ''
    for char in my_string :
        if char not in isExist :
            answer += char
            isExist.add(char)
    
    return answer