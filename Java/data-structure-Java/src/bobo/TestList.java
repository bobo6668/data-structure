package bobo;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestList {
    public static void main(String[] args) {
        // 试试 linkedList 链表
        // https://www.runoob.com/java/java-linkedlist.html
        // 以下情况使用 LinkedList :
            //你需要通过循环迭代来访问列表中的某些元素。
            //需要频繁的在列表开头、中间、末尾等位置进行添加和删除元素操作。
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(12);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.add(100);
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.toString());

        // 试试ArrayList 动态数组
        // https://www.runoob.com/java/java-arraylist.html
        //以下情况使用 ArrayList :
            //频繁访问列表中的某一个元素。
            //只需要在列表末尾进行添加和删除元素操作。
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(11.1);
        arrayList.add(12.2);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.remove(1));
        System.out.println(arrayList.toString());
    }
}
