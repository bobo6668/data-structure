package bobo;

public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value> {

    private Node first;

    private class Node { // 符号表里的节点类(键值对)
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
    public int size() { // 通过遍历链表，得到符号表的总节点(键值对)数
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
        // 如果在链表中找到节点(键值对)的键等于 key 就更新这个节点(键值对)的值为 value
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        // 否则使用头插法插入一个新节点(键值对)
        first = new Node(key, value, first);
    }

    @Override
    public void delete(Key key) { // 删除节点(键值对)
        if (first == null)
            return;
        if (first.key.equals(key)){
            first = first.next;
            return; // debug: 补了一句return
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
    public Value get(Key key) { // 查询键值对对应的值
        Node cur = first;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur.value;
            cur = cur.next;
        }
        return null;
    }


    public static void main(String[] args) { // 写个main函数测试一下
        ListUnorderedST<String, Integer> st = new ListUnorderedST<>();
        st.put("Paul", 18);
        System.out.println(st.get("Paul"));
        st.delete("Paul");
        System.out.println(st.get("Paul"));
    }
}

