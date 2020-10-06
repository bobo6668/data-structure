package dsa;

public class Main_Stack_Array {
    public static void main(String[] args) {
        Stack_Array stack_array = new Stack_Array(100);

        stack_array.push(new Person("ming"));
        System.out.println(stack_array.top().toString()); // 调用toString，让输出更有意义一些
        stack_array.push(11); // 可以混合不同的数据类型，因为父类都是Object
        System.out.println(stack_array.top().toString()); // 任何可以输出的东西后面加上“.sout”再回车，即可自动生成
        System.out.println(stack_array.pop().toString());
        System.out.println(stack_array.isEmpty());
    }
}
class Person {
    protected String name;

    public Person(String name) { // IDEA可以自动生成构造函数：右键“Generate”->“Constructor”
        this.name = name;
    }

    @Override  // 覆写toString，让输出更有意义一些 // IDEA可以自动生成：打出toString就会提示覆写了
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}