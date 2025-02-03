def solution(balls, share):
    def factorial(n) :
        dap = 1
        for i in range(n, 1, -1) :
            if  n != 0 :
                dap = dap * i
        return dap
            
    bunja = factorial(balls) 
    bunmo = factorial(balls-share) * factorial(share)
    return bunja // bunmo