package bobo;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestList {
    public static void main(String[] args) {
        // ���� linkedList ����
        // https://www.runoob.com/java/java-linkedlist.html
        // �������ʹ�� LinkedList :
            //����Ҫͨ��ѭ�������������б��е�ĳЩԪ�ء�
            //��ҪƵ�������б�ͷ���м䡢ĩβ��λ�ý�����Ӻ�ɾ��Ԫ�ز�����
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(12);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.add(100);
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.toString());

        // ����ArrayList ��̬����
        // https://www.runoob.com/java/java-arraylist.html
        //�������ʹ�� ArrayList :
            //Ƶ�������б��е�ĳһ��Ԫ�ء�
            //ֻ��Ҫ���б�ĩβ������Ӻ�ɾ��Ԫ�ز�����
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(11.1);
        arrayList.add(12.2);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.remove(1));
        System.out.println(arrayList.toString());
    }
}
