def solution(cards):
    def dfs(node):
        """dfs로 사이클 크기를 계산"""
        size = 0
        while not visited[node]:
            visited[node] = True
            size += 1
            node = cards[node] - 1
        return size
    
    visited = [False] * len(cards)
    group_sizes = []
    
    for i in range(len(cards)):
        if not visited[i]:
            group_sizes.append(dfs(i))
            
    group_sizes.sort(reverse=True)
    
    if len(group_sizes) < 2:
        return 0
    return group_sizes[0] * group_sizes[1]

#솔직히 문제자체를 이해를 못했음.. 로직보니까 이런거구나 싶었는데 문제를 이해하는게 넘 어려웠다 ㅠ__ㅠ.....
#내일다시 츄라이
