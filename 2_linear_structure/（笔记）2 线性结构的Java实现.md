# （笔记）2 线性结构的Java实现

[TOC]

## 1. 线性表

### 1.1 自己写单链表

* 例程中有**Node类**，`Node.java`

```java
/*
 * 单链表节点类
 */

package dsa;

public class Node implements Position {
   private Object element;//数据对象
   private Node next;//指向后继节点

/**************************** 构造函数 ****************************/
   public Node()
   {  this(null, null);  }//指向数据对象、后继节点的引用都置空

   public Node(Object e) // bobo改
   {  this(e, null); }//指定数据对象，指向后继节点的引用置空

   public Node(Object e, Node n)
   {  element = e;   next = n;  }//指定数据对象及后继节点

/**************************** Position接口方法 ****************************/
//返回存放于该位置的元素
   public Object getElem()    { return element; }

//将给定元素存放至该位置，返回此前存放的元素
   public Object setElem(Object e)
   { Object oldElem = element;    element = e;   return oldElem; }

/**************************** 单链表节点方法 ****************************/
//取当前节点的后继节点
   public Node getNext()
   { return next; }


//修改当前节点的后继节点
   public void setNext(Node newNext)
   { next = newNext; }
}
```

* 参考@Lin写的`LinkList.java`, **自己在`Node.java`的基础上写一个链表类**：`ListBobo.java`

```java
package bobo;

import dsa.Node;

public class ListBobo {
    dsa.Node head; // 头节点

    public ListBobo() {
        this.head = new dsa.Node(); // 初始化一个空链表
    }

    protected void addNode (dsa.Node node) {
        node.setNext(head.getNext());
        head.setNext(node); // 注意头节点是个虚的
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

    public static void main(String[] args) { // main函数
        ListBobo list_node = new ListBobo();
        System.out.println(list_node.deleteNode(10));
        list_node.addNode(new Node(10));
        System.out.println(list_node.toString());
        System.out.println(list_node.deleteNode(10));
        System.out.println(list_node.toString());
    }
}
```

### 1.2 试试Java自带的线性表

```java
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
```



## 2. 栈

### 2.1 自己写栈

#### 2.1.1 栈接口 `Stack.java`

```java
/*
 * 栈接口
 */

package dsa;

public interface Stack {
	public int getSize();//返回栈中元素数目
	public boolean isEmpty();//判断栈是否为空
	public Object top() throws ExceptionStackEmpty;//取栈顶元素（但不删除）
	public void push (Object ele);//入栈
	public Object pop() throws ExceptionStackEmpty;//出栈
}
```

#### 2.1.2 栈 `Stack_Array.java`

```java
/*
 * 借助定长数组实现Stack接口
 */

package dsa;

public class Stack_Array implements Stack {
   public static final int CAPACITY = 1024;//数组的默认容量
   protected int capacity;//数组的实际容量
   protected Object[] S;//对象数组
   protected int top = -1;//栈顶元素的位置

//按默认容量创建栈对象
   public Stack_Array()
   {  this(CAPACITY);    }

//按指定容量创建栈对象
   public Stack_Array(int cap) {
      capacity = cap;
      S = new Object[capacity];
   }

//获取栈当前的规模
   public int getSize()
   {  return (top + 1);  }

//测试栈是否为空
   public boolean isEmpty()
   {  return (top < 0);  }

//入栈
   public void push(Object obj) throws ExceptionStackFull {
      if (getSize() == capacity)
         throw new ExceptionStackFull("意外：栈溢出");
      S[++top] = obj;
   }
   
//取栈顶元素
   public Object top() throws ExceptionStackEmpty {
      if (isEmpty())
         throw new ExceptionStackEmpty("意外：栈空");
      return S[top];
   }

//出栈
   public Object pop() throws ExceptionStackEmpty {
      Object elem;
      if (isEmpty())
         throw new ExceptionStackEmpty("意外：栈空");
      elem = S[top];
      S[top--] = null;
      return elem;
   }
}
```

注意到异常是自己写的：

```java
/*
 * 当试图对空栈应用pop或top方法时，本意外将被抛出
 */

package dsa;

public class ExceptionStackEmpty extends RuntimeException {
   public ExceptionStackEmpty(String err) {
      super(err);
   }
}
```

```java
/*
 * 当试图对满栈应用push方法时，本意外将被抛出
 */

package dsa;

public class ExceptionStackFull extends RuntimeException {
   public ExceptionStackFull(String err) {
      super(err);
   }
}
```

#### 2.1.3 `Main_Stack_Array.java`

```java
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
```

### 2.2 试试Java自带的栈

> [Java Stack 类 - 菜鸟教程](https://www.runoob.com/java/java-stack-class.html)

```java
package bobo;

import java.util.Stack;
import java.util.EmptyStackException;

public class TestStack {

    static void showPush(Stack<Integer> st, int a) {
        st.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showPop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>(); // 新建一个Integer类型的栈
        System.out.println("stack: " + st);
        showPush(st, 42);
        showPush(st, 66);
        showPush(st, 99);
        showPop(st);
        showPop(st);
        showPop(st);
        try {
            showPop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
```

运行结果：

```java
stack: []
push(42)
stack: [42]
push(66)
stack: [42, 66]
push(99)
stack: [42, 66, 99]
pop -> 99
stack: [42, 66]
pop -> 66
stack: [42]
pop -> 42
stack: []
pop -> empty stack
```



## 3. 队列

### 3.1 Java自带的 `Queue`

> [Java 实例 - 队列（Queue）用法 - 菜鸟教程](https://www.runoob.com/java/data-queue.html)
>
> 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
>
> LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。

```java
// 这是一个List:
List<String> list = new LinkedList<>();
// 这是一个Queue:
Queue<String> queue = new LinkedList<>();
```




> [使用Queue - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1265121791832960)

队列`Queue`实现了一个先进先出（FIFO）的数据结构：

- 通过`add()`/`offer()`方法将元素添加到队尾；
- 通过`remove()`/`poll()`从队首获取元素并删除；
- 通过`element()`/`peek()`从队首获取元素但不删除。
- 前者抛出异常，后者不会

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>(); // 【√】
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // 队首永远都是apple，因为peek()不会删除它:
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
    }
}
```

### 3.1 Java自带的优先队列 `PriorityQueue`

> [使用PriorityQueue - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152)

`PriorityQueue`实现了一个优先队列：从队首获取元素时，总是获取优先级最高的元素。

`PriorityQueue`默认按元素比较的顺序排序（必须实现`Comparable`接口），也可以通过`Comparator`自定义排序算法（元素就不必实现`Comparable`接口）。