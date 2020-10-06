package bobo;

import dsa.Node;

public class ListBobo {
    dsa.Node head; // ͷ�ڵ�

    public ListBobo() {
        this.head = new dsa.Node(); // ��ʼ��һ��������
    }

    protected void addNode (dsa.Node node) {
        node.setNext(head.getNext());
        head.setNext(node); // ע��ͷ�ڵ��Ǹ����
    }

    protected boolean deleteNode (Object e) {
        dsa.Node preNode = head;
        dsa.Node current = head.getNext();
        while(current != null) {
            if(current.getElem() == e) {
                preNode.setNext(current.getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head");
        dsa.Node current = head.getNext();
        while(current != null) {
            sb.append("->");
            sb.append(current.getElem());
            current = current.getNext();
        }

        return "ListBobo{" +
                sb.toString() +
                '}';
    }

    public static void main(String[] args) { // main����
        ListBobo list_node = new ListBobo();
        System.out.println(list_node.deleteNode(10));
        list_node.addNode(new Node(10));
        System.out.println(list_node.toString());
        System.out.println(list_node.deleteNode(10));
        System.out.println(list_node.toString());
    }
}
