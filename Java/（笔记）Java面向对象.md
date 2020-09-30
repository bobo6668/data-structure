# （笔记）Java面向对象

[TOC]

> [面向对象编程 - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1255943520012800)

Java是一种**面向对象**的编程语言。面向对象编程，英文是Object-Oriented Programming，简称OOP。

**面向过程**编程，是把模型分解成一步一步的过程。

**面向对象**编程，是一种通过对象的方式，把现实世界映射到计算机模型的一种编程方法。

---

**本章学习**：

面向对象的**基本概念**，包括：

- 类
- 实例
- 方法

面向对象的**实现方式**，包括：

- 继承
- 多态

**Java语言本身提供的机制**，包括：

- package
- classpath
- jar

以及 **Java标准库提供的核心类**，包括：

- 字符串
- 包装类型
- JavaBean
- 枚举
- 常用工具类



## 1 基础概念



### 1.1 [class和instance](https://www.liaoxuefeng.com/wiki/1252599548343744/1260451488854880)

在OOP中，`class`和`instance`是“模版”和“实例”的关系；

定义`class`就是定义了一种数据类型，对应的`instance`是这种数据类型的实例；

#### 1.1.1 定义Class

```java
class Person {
    public String name;
    public int age;
}
```

#### 1.1.2 创建实例

```java
Person ming = new Person();
```

#### 1.1.3 操作实例

```java
ming.name = "Xiao Ming"; // 对字段name赋值
ming.age = 12; // 对字段age赋值
System.out.println(ming.name); // 访问字段name
```

但是，直接操作`field`，容易造成逻辑混乱。



### 1.2 [方法](https://www.liaoxuefeng.com/wiki/1252599548343744/1260452774408320)

#### 1.2.0 简介

- **方法**可以让外部代码安全地访问实例字段；
  - 方法是一组执行语句，并且可以执行任意逻辑；
  - 方法内部遇到return时返回，void表示不返回任何值（注意和返回null不同）；
- 外部代码通过**public方法**操作实例，内部代码可以调用**private方法**；
- 理解**方法的参数绑定**。

#### 1.2.1 `private`字段

为了避免外部代码直接去访问`field`，我们可以用`private`修饰`field`，拒绝外部访问：

```java
class Person {
    private String name;
    private int age;
}
```

#### 1.2.2 方法

此时，我们需要使用**方法**（`method`）来让外部代码可以间接修改`field`：

```java
public class Main {
    public static void main(String[] args) {
        Person ming = new Person(); // 创建Person类的一个实例ming
        ming.setName("Xiao Ming"); // 设置name
        ming.setAge(12); // 设置age
        System.out.println(ming.getName() + ", " + ming.getAge()); // 获取name和age，并输出
    }
}

class Person { // 定义Person类
    private String name;
    private int age;

    public String getName() { // 获取name
        return this.name; // 【√】
    }

    public void setName(String name) { // 设置name
        if (name == null || name.isBlank()) { // 不允许传入null和空字符串
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip(); // 去掉首尾空格
    }

    public int getAge() { // 获取age
        return this.age;
    }

    public void setAge(int age) { // 设置age
        if (age < 0 || age > 100) { // 判断输入是否合理。若不合理抛出异常
            throw new IllegalArgumentException("invalid age value"); // 【√】
        }
        this.age = age;
    }

}
```

从上面的代码可以看出，**定义方法的语法**是：

```
修饰符 方法返回类型 方法名(方法参数列表) {
    若干方法语句;
    return 方法返回值;
}
```

如果没有返回值，返回类型设置为`void`，可以省略`return`

#### 1.2.3 `private`方法

有`public`方法，自然就有`private`方法。

`private`方法不允许外部调用，但内部方法是可以调用`private`方法的。

#### 1.2.4 `this`变量
在方法内部，可以使用一个隐含的变量`this`，它始终指向当前实例。因此，通过`this.field`就可以访问当前实例的字段。

如果没有命名冲突，可以省略`this`。例如：

```java
class Person {
    private String name;

    public String getName() {
        return name; // 相当于this.name
    }
}
```

但是，如果有局部变量和字段重名，那么<u>局部变量优先级更高</u>，就必须加上`this`：

```java
class Person {
    private String name;

    public void setName(String name) {
        this.name = name; // 前面的this不可少，少了就变成局部变量name了
    }
}
```

#### 1.2.5 方法参数

**基本类型参数的传递**，是调用方值的复制。所以双方各自的后续修改，<u>互不影响</u>。

**引用类型参数的传递**，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，<u>都会影响对方</u>（因为指向同一个对象嘛）。



### 1.3 [构造方法](https://www.liaoxuefeng.com/wiki/1252599548343744/1260454185794944)

#### 1.3.0 简介

实例在创建时通过**`new`操作符**会调用其对应的**构造方法**，构造方法<u>用于初始化实例</u>；

<u>没有定义构造方法时</u>，编译器会自动创建一个默认的无参数构造方法；

可以<u>定义多个构造方法</u>，编译器根据参数自动判断；

可以<u>在一个构造方法内部调用另一个构造方法</u>，便于代码复用。

#### 1.3.1 构造方法

构造方法：在创建对象实例时就把内部字段全部初始化为合适的值

```java
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Xiao Ming", 15); // 调用构造函数进行初始化
        System.out.println(p.getName()); // 输出
        System.out.println(p.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) { // 构造函数
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
```

构造方法**很特殊**：

* 构造方法的名称就是类名
* 构造方法的参数没有限制，在方法内部，也可以编写任意语句
* 但是，和普通方法相比
  * 构造方法没有返回值（也没有`void`）
  * 调用构造方法，必须用`new`操作符

#### 1.3.2 默认构造方法

任何`class`都有构造方法

如果一个类<u>没有定义</u>构造方法，编译器会<u>自动为我们生成</u>一个**默认构造方法**，它没有参数，也没有执行语句，类似这样：

```java
class Person {
    public Person() {
    }
}
```

要特别注意的是，<u>如果我们自定义了</u>一个构造方法，那么，编译器就<u>不再自动创建</u>默认构造方法

#### 1.3.3 多个构造方法

如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么可以**把多个构造方法都定义出来**。

在通过`new`操作符调用的时候，编译器通过构造方法的参数数量、位置和类型**自动区分**：

```java
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Xiao Ming", 15); // 既可以调用带2个参数的构造方法
        Person p2 = new Person("Xiao Ming"); // 既可以调用带1个参数的构造方法
        Person p3 = new Person(); // 也可以调用无参数的构造方法
        // 输出
        System.out.println(p1.getName() + " ," + p1.getAge()); // Xiao Ming ,15
        System.out.println(p2.getName() + " ," + p2.getAge()); // Xiao Ming ,12
        System.out.println(p3.getName() + " ," + p3.getAge()); // null ,0
    }
}

class Person {
    private String name;
    private int age;

    public Person() { // 无参数的构造方法
        // 此时，默认String类型的初值是null，int类型的初值是0
    }

    public Person(String name) { // 带1个参数的构造方法
        this.name = name;
        this.age = 12; // 注意这里要有一个默认值
    }

    public Person(String name, int age) { // 带2个参数的构造方法
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
```



### 1.4 [方法重载](https://www.liaoxuefeng.com/wiki/1252599548343744/1260454256258656)

方法重载是指<u>多个方法的方法名相同，但各自的参数不同</u>；

重载方法应该完成类似的功能，参考`String`的`indexOf()`；

重载方法返回值类型应该相同。

举个例子，`String`的`indexOf()`：

```java
public class Main {
    public static void main(String[] args) {
        String s = "Test string";
        int n1 = s.indexOf('t');    // 根据字符的Unicode码查找
        int n2 = s.indexOf('t', 4); // 根据字符查找，但指定起始位置
        int n3 = s.indexOf("st");    // 根据字符串查找
        int n4 = s.indexOf("st", 4); // 根据字符串查找，但指定起始位置
        System.out.println(n1); // 3，即Test的t
        System.out.println(n2); // 6，即string的t
        System.out.println(n3); // 2，即Test的st
        System.out.println(n4); // 5，即string的st
    }
}
```



## 2 面向对象的实现方式



### 2.1 [继承](https://www.liaoxuefeng.com/wiki/1252599548343744/1260454548196032)

#### 2.1.0 简介

- **继承**是面向对象编程的一种强大的代码复用方式；
  - Java只允许<u>单继承</u>，所有类最终的<u>根类</u>是`Object`；
- `protected`允许<u>子类访问父类的字段和方法</u>；
  - 子类的构造方法可以通过`super()` <u>调用父类的构造方法</u>；
- **转型**
  - 可以安全地<u>向上转型</u>为更抽象的类型；
  - 可以强制<u>向下转型</u>，最好借助`instanceof`判断；
- 子类和父类的关系是is，has关系不能用继承。

#### 2.1.1 `extends`关键字

Java使用`extends`关键字来实现继承。

当我们让`Student`从`Person`继承时，`Student`就获得了`Person`的所有功能，我们只需要为`Student`编写新增的功能：

```java
class Person {
    private String name;
    private int age;

    public String getName() {...}
    public void setName(String name) {...}
    public int getAge() {...}
    public void setAge(int age) {...}
}

class Student extends Person {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    private int score;

    public int getScore() { … }
    public void setScore(int score) { … }
}
```

**注意**：子类自动获得了父类的所有字段，**严禁定义与父类重名的字段**！

### 2.1.2 继承树

注意到我们在定义`Person`的时候，没有写`extends`。在Java中，没有明确写`extends`的类，编译器会自动加上`extends Object`。`Object`是**根类**。

**单继承**：Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有`Object`特殊，它没有父类。

下图是`Person`、`Student`的**继承树**：

![image-20200930210638056](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200930210638.png)

#### 2.1.3 `protected`

继承有个特点，就是子类无法访问父类的`private`字段或者`private`方法。例如，`Student`类就无法访问`Person`类的`name`和`age`字段。

为了让子类可以访问父类的字段，我们需要把`private`改为`protected`：

```java
public class Main {
    public static void main(String[] args) {
        Student ming = new Student(); // 创建实例
        System.out.println(ming.hello()); // 输出
    }
}

class Person {
    protected String name = "Alice"; // 改为protect，并给定一个默认值
    protected int age;
}

class Student extends Person { // 继承
    public String hello() {
        return "Hello, " + this.name; // Hello, Alice
    }
}
```

因此，`protected`关键字可以把字段和方法的访问权限控制在继承树内部，一个`protected`字段和方法可以被其子类，以及子类的子类所访问

#### 2.1.4 `super`

`super`关键字表示父类（超类）。

---

**子类引用父类的字段**时，可以用`super.fieldName`。例如：

```java
class Student extends Person {
    public String hello() {
        return "Hello, " + super.name;
    }
}
```

实际上，这里使用`super.name`，或者`this.name`，或者`name`，<u>效果都是一样的</u>。编译器会自动定位到父类的`name`字段。

---

但是，在某些时候，就<u>必须使用</u>`super`，如**调用父类的构造函数**。

在Java中，任何`class`的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们**自动**加一句`super();`

为了避免错误，我们要**自己调用**父类Person的构造方法`Person(String, int)`：

```java
package Main;

public class Main {
    public static void main(String[] args) {
        Student ming = new Student("xiao ming", 18, 100); // 调用构造函数进行初始化
        System.out.println(ming.getName()+ ", " +ming.getAge() + ", " +ming.getScore()); // xiao ming, 18, 100
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) { // 构造函数
        this.name = name;
        this.age = age;
    }

    protected String getName() {
        return this.name;
    }
    protected int getAge() {
        return this.age;
    }
}

class Student extends Person {
    protected int score;

    public Student(String name, int age, int score) { // 构造函数
        super(name, age); // 调用父类的构造方法Person(String, int)
        this.score = score;
    }

    protected int getScore() {
        return this.score;
    }
}
```

#### 2.1.5 转型

考虑继承树：`Student > Person > Object`

```java
Student s = new Student(); // 一般情况下
Person p = new Person();

Person p1 = new Student(); // ok，因为Person是Student的父类，向上转型(upcasting)是安全的
Student s1 = (Student) p1; // ok，因为Person类型p1实际指向Student实例

Person p2 = new Person(); // Person类型p2实际指向Person实例
Student s2 = (Student) p2; // runtime error! ClassCastException!
                     
```

**error:** 因为p2的实际类型是Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。

**因此，向下转型很可能会失败。**失败的时候，Java虚拟机会报`ClassCastException`。

为了**避免向下转型出错**，Java提供了`instanceof`操作符，可以先判断一个实例究竟是不是某种类型：

```java
Person p = new Student();
if (p instanceof Student) {
    // 只有判断成功才会向下转型:
    Student s = (Student) p; // 此时，转型一定会成功
}
```

#### 2.1.6 is关系、has关系

具有has关系不应该使用继承，而是使用组合，即`Student`可以持有一个`Book`实例：

```java
class Student extends Person { // Student类型继承Person类型（继承是is的关系）
    protected Book book; // Student拥有一个Book实例（组合是has的关系）
    protected int score;
}
```



### 2.2 [多态](https://www.liaoxuefeng.com/wiki/1252599548343744/1260455778791232)

#### 2.2.1 覆写

在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为**覆写**（Override）。

覆写要求：

* 方法名相同
* 方法参数相同
* 方法返回值相同

