class Solution:
    def isValid(self, s: str) -> bool:
        pair = {
            ']' : '[',
            ')' : '(',
            '}' : '{'
        }

        stack = []

        for c in s:
            if c not in pair:
                stack.append(c)
            else:
                if not stack or stack[-1] != pair[c]:
                    return False
                else:
                    stack.pop()
        
        return len(stack) == 0;