def solution(inputNum):    
    #약수 : 나머지 없이 나눌 수 있는 자연수
    answer = [n for n in range(1, inputNum+1) if inputNum % n == 0]
    return sum(answer)