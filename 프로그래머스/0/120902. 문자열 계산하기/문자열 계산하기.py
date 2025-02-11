from collections import deque
def solution(my_string):
    queue = deque(my_string.split(" "))
    answer = int(queue.popleft())
    while len(queue) > 0 :
        buho = queue.popleft()
        if buho == '+' :
            answer += int(queue.popleft())
        elif buho == "-" :
            answer -= int(queue.popleft())
    return answer