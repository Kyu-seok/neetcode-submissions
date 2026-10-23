class MinStack:

    def __init__(self):
        self.stack = []
        self.min_value = float('inf')

    def push(self, val: int) -> None:
        self.stack.append((val, self.min_value))
        self.min_value = min(self.min_value, val)

    def pop(self) -> None:
       value, prev_min = self.stack.pop() 
       self.min_value = prev_min
       return value

    def top(self) -> int:
        value, _ = self.stack[-1]
        return value

    def getMin(self) -> int:
        return self.min_value
