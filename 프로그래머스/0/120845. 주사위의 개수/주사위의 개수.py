def solution(box, n):
    answer = [ i // n for i in box ]
    dap = 1
    for i in answer :
        dap *= i
    return dap