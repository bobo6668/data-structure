package bobo;

public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value> {

    private Node first;

    private class Node { // ���ű���Ľڵ���(��ֵ��)
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public int size() { // ͨ�����������õ����ű���ܽڵ�(��ֵ��)��
        int cnt = 0;
        Node cur = first;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }

    @Override
    public void put(Key key, Value value) {
        Node cur = first;
        // ������������ҵ��ڵ�(��ֵ��)�ļ����� key �͸�������ڵ�(��ֵ��)��ֵΪ value
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        // ����ʹ��ͷ�巨����һ���½ڵ�(��ֵ��)
        first = new Node(key, value, first);
    }

    @Override
    public void delete(Key key) { // ɾ���ڵ�(��ֵ��)
        if (first == null)
            return;
        if (first.key.equals(key)){
            first = first.next;
            return; // debug: ����һ��return
        }
        Node pre = first, cur = first.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                pre.next = cur.next;
                return;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }

    @Override
    public Value get(Key key) { // ��ѯ��ֵ�Զ�Ӧ��ֵ
        Node cur = first;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur.value;
            cur = cur.next;
        }
        return null;
    }


    public static void main(String[] args) { // д��main��������һ��
        ListUnorderedST<String, Integer> st = new ListUnorderedST<>();
        st.put("Paul", 18);
        System.out.println(st.get("Paul"));
        st.delete("Paul");
        System.out.println(st.get("Paul"));
    }
}

