class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 결과를 담을 리스트선언
        result = list()
        size = len(nums)
        # print(size) # output: 4
        # 0
        for i in range(size):
            # You may assume that each input would have exactly one solution 
            # 정답은 1쌍이므로 result의 사이즈가 2면 끝낸다.
            if len(result) == 2: 
                break
            # 0
            for j in range(size):
                # 본인인덱스는 사용하지 않는다.  you may not use the same element twice.
                # 1, 0의 경우 이미 0, 1으로 검사했기 때문에 건너 뛰어야 한다. 즉, i보다 큰 수만 체크한다.
                if i!=j and j>i :
                    if nums[i]+nums[j] == target:
                        result.append(i)
                        result.append(j)

        # 함수니까 return을 줘야한다.
        return result