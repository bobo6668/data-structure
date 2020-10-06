package bobo;

public class LinkList {
    Node head; // 链表只需要知道一个头【√】

    public LinkList() {
        this.head = new Node();
    } // 构造函数，一个空链表（头结点也是空节点）【√】

    //  添加一个节点，采用头插法添加，即新节点添加到链表头部【√】
    public void addNode(Node node) {
        node.next = head.next;
        head.next = node;
    }

    public boolean deleteNode(Object val) {
//      如果只有一个空的头节点，只需要将头指针置空
        if (head.next == null) head = null;

        Node preNode = head;
        Node current = head.next;
        while (current != null) {
            if (current.val.equals(val)) { //【√】
                preNode.next = current.next;
//                System.out.println("delete succeed!");
                return true;
            }
            preNode = current;
            current = current.next;
        }
//        System.out.println("delete failed...");
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head");
        Node current = head.next;
        while (current != null) {
            sb.append("->").append(current.val.toString());
            current = current.next;
        }
        return "LinkList{" + sb.toString() + '}';
    }

    public static void main(String[] args) {
        LinkList linklist = new LinkList();
        System.out.println(linklist); // 调用to String方法
        linklist.addNode(new Node(10)); // 在头部插入新节点
        linklist.addNode(new Node(2));
        linklist.addNode(new Node(30));
        System.out.println(linklist);

        System.out.println(linklist.deleteNode(2)); // 删除特定值的节点，并输出返回值
        System.out.println(linklist);

        linklist.addNode(new Node("hello"));
        linklist.addNode(new Node("world"));
        System.out.println(linklist);

        System.out.println(linklist.deleteNode("hello"));
        System.out.println(linklist.deleteNode("hello"));
        System.out.println(linklist);
    }
}

class Node {
    Object val; // 用Object类，这样val可以是任意类型的数据
    Node next; // 用一个引用，起到类似指针的功能

    public Node() {
    }

    public Node(Object val) {
        this.val = val;
    }
}