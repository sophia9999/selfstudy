class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        a_list = s.split()

        index = len(a_list) -1

        return len(a_list[index])
