import math
def solution(n):
    answer = []
    # 10 이하의 숫자들의 약수의 개수가 3개 이상이면 answer에 넣는다
    for num in range(4, n+1):
        count = 0 
        for i in range(1, num+1):
            if num % i == 0 :
                count += 1
        if count >= 3 :
            answer.append(num)

    print(answer)
    return len(answer)