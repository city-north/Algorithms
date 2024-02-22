class ListNode:
    def __init__(self, val: int):
        self.val: int = val
        self.next: ListNode | None = None


def insert(n0: ListNode, p: ListNode):
    """在链表的节点 n0 之后插入节点 P"""
    n1 = n0.next
    p.next = n1
    n0.next = p


def print_list(mylist: ListNode):
    while mylist is not None:
        print(mylist.val)
        mylist = mylist.next


def remove(listNode: ListNode):
    if not listNode.next:
        return
    next = listNode.next
    n1 = next.next
    n0.next = n1


if __name__ == '__main__':
    n0 = ListNode(1)
    n1 = ListNode(3)
    n2 = ListNode(2)
    n3 = ListNode(5)
    n4 = ListNode(4)
    # 构建节点之间的引用
    n0.next = n1
    n1.next = n2
    n2.next = n3
    n3.next = n4
    print_list(n0)
    insert(n1, ListNode(-1))
    print("--insert--")
    print_list(n0)
    print("--remove--")
    remove(n0)
    print_list(n0)

