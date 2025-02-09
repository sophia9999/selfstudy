import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0
    
    if K <= scoville[0] :
        return count

    c = 0
    while len(scoville) >= 2 :
        a= heapq.heappop(scoville)
        b= heapq.heappop(scoville)
        c = a + (b * 2)
        
        heapq.heappush(scoville, c)
        count += 1
        
        if K <= scoville[0] :
            break

    if K > c :
        return -1

    return count