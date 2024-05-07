class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        
        # target이 i에 나열된 숫자리스트의 범주에 있는 경우
        for i in range(0, len(nums)):
            if nums[i] >= target:
                return i
        
        # 없으면 길이에 맨 뒤에 insert
        return len(nums)