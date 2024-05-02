class Solution:
    def isPalindrome(self, x: int) -> bool:

        #길이가 한자리면 무조건 true
        if len(str(x)) == 1:
            return True

        #음수면 -가 붙어서 회문이 되지 않으므로 false처리
        if x < 0: 
            return False
        
        #string으로 형변환
        num_str = str(x)
        
        #return할 기본값 설정
        result = False
        
        #문자열을 반으로 나누어 앞뒤비교
        length = len(num_str)
        for i in range(length // 2):
            if num_str[i] != num_str[length-1-i]:
                return False

        #위 for문을 수행하면서 다르면 False를 리턴하므로 통과했으면 True 이다.
        return True


        

        
        

        
        