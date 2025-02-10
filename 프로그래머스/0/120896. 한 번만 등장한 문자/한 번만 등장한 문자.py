from collections import Counter
def solution(s):
    s_counts = Counter(s)
    return "".join(sorted([char for char, count in s_counts.items() if count == 1 ]))