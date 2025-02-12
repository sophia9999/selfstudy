from collections import deque
def solution(quiz):
    answer = []
    for statement in quiz :
        stmt = deque(statement.split(" "))
        x = int(stmt.popleft())
        z = stmt.popleft()
        y = int(stmt.popleft())
        stmt.popleft()
        rst = int(stmt.popleft())
        if z == '+' and x + y == rst:
                answer.append("O")
        elif z == '-' and x - y == rst:
                answer.append("O")
        else :
            answer.append("X")
            
    return answer