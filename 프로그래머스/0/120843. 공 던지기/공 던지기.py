from collections import deque
def solution(numbers, k):
    people = deque(numbers)
    
    for i in range(1, k) :
        people.append(people.popleft())
        people.append(people.popleft())
        
    return people.popleft()
