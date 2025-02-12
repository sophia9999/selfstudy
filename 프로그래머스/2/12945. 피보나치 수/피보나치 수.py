def solution(n):
    def fibo(k) :
        fibo = [0, 1]
        for i in range(2, k) :
            a = fibo[i-2]
            b = fibo[i-1]
            fibo.append(a+b)
            if len(fibo) -1 == k :
                break
        return fibo
    
    lst = fibo(n)
    answer = (lst[n-2] + lst[n-1]) % 1234567
    return answer