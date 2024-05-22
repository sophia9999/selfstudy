# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # 트리 순회: 중위 순회알고리즘
        # 중위 순회는 트리의 왼쪽을 먼저 방문하고 오른쪽 노드 방문 전에 부모노드를 방문한다.
        result = []
        visitedNode = []
        
        while root or visitedNode:
            while root : # 트리의 왼쪽으로 가기 전에 방문한 parentNode를 저장해둔다.
                visitedNode.append(root)
                root = root.left #제일마지막 노드에 방문하면 root는 끝 / 밑에서 root.right로 돌아왔을 때 left가 있으면 여기를 탐.
            
            # 방문 했던 노드의 값을 꺼낸다. 
            # 그리고 오른쪽에있는 node로 위치를 옮긴다.
            root = visitedNode.pop()
            result.append(root.val)

            root = root.right

        return result