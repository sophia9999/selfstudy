def solution(my_str, n):
    answer = []
    for i in range(0, len(my_str), n) :
        answer.append(my_str[i:i+n])
    return answer

# 리스트 컴프리헨션으로는 이런 버전도 가능
def solution(my_str, n):
    return [my_str[i:i+n] for i in range(0, len(my_str), n)]
