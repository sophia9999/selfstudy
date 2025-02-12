def solution(num, k):
    nums = str(num)
    kk = str(k)

    index = -1
    for i in range(len(nums)) : 
        if index == -1 and nums[i] == kk :
            index = i + 1

    return index