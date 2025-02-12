def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    real_reserve = [x for x in reserve if x not in lost] # 자신이 잃어버린 사람을 제외
    real_lost = [x for x in lost if x not in reserve]
    
    # 일단 안빌려도 참여할 수 있는 학생들
    can_attend_sum = n - len(real_lost)
    
    for i in real_reserve :
        if i-1 in real_lost :
            real_lost.remove(i-1)
            can_attend_sum += 1
        elif i+1 in real_lost :
            real_lost.remove(i+1)
            can_attend_sum += 1
            
    return can_attend_sum