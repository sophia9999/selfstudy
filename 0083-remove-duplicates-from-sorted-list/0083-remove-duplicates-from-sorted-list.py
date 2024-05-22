# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:

        # 해당 List의 next가 없는 경우엔 head를 바로 return 한다.
        if not head or not head.next :
            return head

        current = head

        # 현재 node의 next가 존재하면 계속 진행. 
        while current.next : # current를 통해 수행된 변경 작업은 head와 current둘 다 적용됨. 동일객체 참조.
            if current.val == current.next.val : # 같은 값이면 next를 건너뛰고 그 다음 값으로
                current.next = current.next.next
            else :
                current = current.next

        # 함수가 반환될 때 수정된 LinkedList의 시작점을 반환해야한다. head가 시작점을 참조하고 있다.
        # current는 List의 시작점을 가리키는 변수가 아니므로 head를 반환해야한다.
        return head