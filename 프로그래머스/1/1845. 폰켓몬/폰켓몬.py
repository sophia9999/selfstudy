from collections import Counter
def solution(nums):
    counts = Counter(nums)
    can_choose = len(nums) // 2
    
    #폰켓몬번호:폰켓몬마리 수
    answer = 0

    if can_choose < len(counts) :
        answer = can_choose
    elif len(counts) <= can_choose:
        answer = len(counts)
    
    return answer