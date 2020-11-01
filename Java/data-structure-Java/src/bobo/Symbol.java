package bobo;

public class Symbol<Key, Value> { // ��<T>��ʾ����
    Key key;
    Value value;
    Symbol(){}

    @Override
    public String toString() {
        return "Symbol{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Symbol<String, Integer> symbol = new Symbol<>(); // ָ������<T>�ľ�����������
        symbol.key = "Paul";
        symbol.value = 18;
        System.out.println(symbol.toString());
    }
}
