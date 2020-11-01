package bobo;

public class Symbol<Key, Value> { // 用<T>表示泛型
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
        Symbol<String, Integer> symbol = new Symbol<>(); // 指定泛型<T>的具体数据类型
        symbol.key = "Paul";
        symbol.value = 18;
        System.out.println(symbol.toString());
    }
}
