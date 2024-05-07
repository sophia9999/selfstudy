class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:

        # # target이 i에 나열된 숫자리스트의 범주에 있는 경우
        # for i in range(0, len(nums)):
        #     if nums[i] >= target:
        #         return i

        # # 없으면 리스트 길이 맨 뒤에
        # return len(nums)

        # 가운데값부터 찾아나가는 경우
        # 해당 방법은 이진 탐색으로 이미 정렬되어있는 데이터가 주어졌을 때 사용
        index = 0
        list_length = len(nums) -1
        while index <= list_length:
            mid = (index + list_length) // 2
            if nums[mid] < target:
                index = mid + 1
            elif nums[mid] > target: # [1, 3, 5, 7], [9, 11, 13, 15] 라고 본다면 7이 (target:2)보다 크니까 5를 검사해야하므로 list_length-1
                list_length = mid - 1
            else : # 같으면 해당 인덱스.
                return mid

        return index