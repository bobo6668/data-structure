package dsa;

public class Main_Stack_Array {
    public static void main(String[] args) {
        Stack_Array stack_array = new Stack_Array(100);

        stack_array.push(new Person("ming"));
        System.out.println(stack_array.top().toString()); // ����toString���������������һЩ
        stack_array.push(11); // ���Ի�ϲ�ͬ���������ͣ���Ϊ���඼��Object
        System.out.println(stack_array.top().toString()); // �κο�������Ķ���������ϡ�.sout���ٻس��������Զ�����
        System.out.println(stack_array.pop().toString());
        System.out.println(stack_array.isEmpty());
    }
}
class Person {
    protected String name;

    public Person(String name) { // IDEA�����Զ����ɹ��캯�����Ҽ���Generate��->��Constructor��
        this.name = name;
    }

    @Override  // ��дtoString���������������һЩ // IDEA�����Զ����ɣ����toString�ͻ���ʾ��д��
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}