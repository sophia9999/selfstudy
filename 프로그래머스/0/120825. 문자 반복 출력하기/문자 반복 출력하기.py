def solution(my_string, n):
    my = list(my_string)
    answer = list()
    for i in my_string :
        answer.append(i * n)
    return "".join(answer)