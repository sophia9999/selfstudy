def solution(n):
    cd = list()
    # 약수구하기 
    for i in range(2, n+1) :
        if n % i == 0 :
            cd.append(i)
    # 약수 중에 소수 구하기
    prime = set()
    for i in cd :
        if is_prime(i) :
            prime.add(i)

    return sorted(list(prime))

def is_prime(n) :
    count = 1
    for i in range(2, n+1) :
        if n % i == 0 :
            count += 1
        if count >= 3 :
            return False
    if count == 2 :
        return True
    else : 
        return False