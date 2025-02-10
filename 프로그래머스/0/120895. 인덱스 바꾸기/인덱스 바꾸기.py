def solution(my_string, num1, num2):
    answer = ""
    a, b = my_string[num1:num1+1], my_string[num2:num2+1]
    for i in range(len(my_string)) :
        if num1 == i :
            answer += b
        elif num2 == i :
            answer += a
        else :
            answer += my_string[i]
    return answer