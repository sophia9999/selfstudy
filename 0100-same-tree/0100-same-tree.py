# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        
        # 들어온 노드가 없으면 true
        if not p and not q :
            return True
        
        # 둘 다 있고 값이 같으면 자식 트리를 비교하도록 재귀함수로 작성. 
        if p and q and p.val == q.val :
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

        # 같지않아서 넘어오면 다른값이란 의미.
        return False
            