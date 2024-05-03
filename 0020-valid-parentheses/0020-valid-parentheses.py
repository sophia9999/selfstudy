class Solution:
    def isValid(self, s: str) -> bool:

        stack = list()

        open_brackets  = ['(', '{', '[']
        close_brackets = [')', '}', ']']

        # ([]) == true
        for i in range(0, len(s)):
            if s[i] in open_brackets:
                stack.append(s[i])
            else: # 닫는괄호기호의 경우
                if len(stack) > 0 :
                    open_bracket = stack.pop()
                    if open_brackets.index(open_bracket) == close_brackets.index(s[i]):
                        pass
                    else:
                        return False
                else :
                    return False

        if len(stack) > 0 :
            return False
        else :
            return True

            