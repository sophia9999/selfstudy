def solution(my_str, n):
    answer = []
    quotient = int(len(my_str) / n)
    remainder = len(my_str) % n
    
    if remainder != 0 :
        quotient += 1

    for t in range(quotient) :
        answer.append(my_str[ n*t : n+(n*t)])
    
    return answer