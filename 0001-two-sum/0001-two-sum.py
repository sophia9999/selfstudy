class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        '''
        # 결과를 담을 리스트선언
        result = list()
        size = len(nums)

        for i in range(size):
            # You may assume that each input would have exactly one solution
            # 정답은 1쌍이므로 result의 사이즈가 2면 끝낸다.
            if len(result) == 2:
                break
            for j in range(size):
                # 본인인덱스는 사용하지 않는다.  you may not use the same element twice.
                # 1, 0의 경우 이미 0, 1으로 검사했기 때문에 건너 뛰어야 한다. 즉, i보다 큰 수만 체크한다.
                if j > i:
                    if nums[i] + nums[j] == target:
                        result.append(i)
                        result.append(j)

        return result
        '''

        # 다른 방법으로 try
        size = len(nums)
        result = list()
        map = {}

        for i in range(size):
            map[nums[i]] = i

        for i in range(size):
            # 넘겨받은 리스트에서 target이 되는 두 값을 찾기위한 x값 설정
            x = target - nums[i]
            # 본인 인덱스는 사용하지 않고 중복제거를 위해 큰 수만 체크
            try:
                if map.get(x) > i: 
                    result.append(i)
                    result.append(map.get(x))
                    break
            except:
                continue


        return result