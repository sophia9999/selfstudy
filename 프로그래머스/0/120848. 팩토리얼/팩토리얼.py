import math
def solution(n):
    for i in range(10, 0, -1) :
        if math.factorial(i) <= n :
            return i


# def solution(n):
#     for i in range(10, 0, -1) :
#         if factorial(i) <= n :
#             return i

# def factorial(num) :
#     answer = 1
#     for i in range(num, 0, -1) :
#         answer *= i
    
#     return answer
