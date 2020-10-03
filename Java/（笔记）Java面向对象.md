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

#### 1.1.1 定义`class`

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

// 父类
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

// 子类
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

#### 2.2.0 简介

- 子类可以**覆写**父类的方法（Override），覆写在子类中改变了父类方法的行为；
- Java的方法调用总是作用于运行期对象的实际类型，这种行为称为**多态**；
- `final`修饰符有多种作用：
  - `final`修饰的方法可以**阻止被覆写**；
  - `final`修饰的class可以**阻止被继承**；
  - `final`修饰的field必须在创建对象时初始化，随后不可修改。

#### 2.2.1 覆写

在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为**覆写**（Override）。

覆写要求：

* 方法名相同
* 方法参数相同
* 方法返回值相同

加上`@Override`可以让编译器帮助检查是否进行了正确的覆写。希望进行覆写，但是不小心写错了方法签名，编译器会报错。

```java
public class Main {
    public static void main(String[] args) {
    }
}

class Person {
    public void run() {}
}

public class Student extends Person {
    @Override // Compile error!
    public void run(String s) {} // 需要删掉传入的参数String s
}
```

#### 2.2.2 多态

多态是指，针对某个类型的方法的调用，其真正执行的方法<u>取决于运行时期实际类型</u>的方法。

多态具有一个非常强大的功能，就是<u>允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码</u>。

```java
public class Main {
    public static void main(String[] args) {
        // 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        Income[] incomes = new Income[] { // 创建Income类型的数组，里面有不同的子类的实例
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes)); // 输出
    }

    // 计算总税收
    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income: incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

// 父类：普通收入及税收
class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }
}

// 子类1：工资收入及税收
class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

// 子类2：国务院特殊津贴及税收
class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
```

观察`totalTax()`方法：**利用多态**，`totalTax()`方法只需要和父类`Income`打交道，它完全不需要知道子类`Salary`和`StateCouncilSpecialAllowance`的存在，就可以正确计算出总的税。

如果我们要新增一种稿费收入，只需要从`Income`派生，然后正确覆写`getTax()`方法就可以。把新的类型传入`totalTax()`，不需要修改任何代码。

#### 2.2.3 覆写`Object`方法

因为所有的`class`最终都继承自`Object`，而`Object`定义了几个重要的方法：

- `toString()`：把instance输出为`String`；
- `equals()`：判断两个instance是否逻辑相等；
- `hashCode()`：计算一个instance的哈希值。

在必要的情况下，我们可以覆写`Object`的这几个方法。例如：

```java
package Main;

public class Main {
    public static void main(String[]args){
        Person ming = new Person("xiao ming");
        Person hong = new Person("xiao hong");
        System.out.println(ming.toString()); // Person:name = xiao ming
        System.out.println(ming.equals(hong)); // false
        System.out.println(ming.hashCode()); // -435428106
    }
}

//定义：Person类
class Person {

    protected String name;
    Person(String name){
        this.name = name;
    }

    // 显示更有意义的字符串:
    @Override
    public String toString() {
        return "Person:name = " + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person类型:
        if (o instanceof Person) {
            Person p = (Person) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
```

#### 2.2.4 `final`

继承可以允许子类覆写父类的方法。如果一个父类不允许子类对它的某个方法进行覆写，可以把该方法标记为`final`。**用`final`修饰的方法**不能被`Override`：

```java
class Person {
    protected String name;
    public final String hello() {
        return "Hello, " + name;
    }
}

class Student extends Person {
    ...
    // compile error: 不允许覆写
    @Override
    public String hello() {
        ...
    }
}
```

如果一个类不希望任何其他类继承自它，那么可以把这个类本身标记为`final`。**用`final`修饰的类**不能被继承：

```java
final class Person {
    protected String name;
}

// compile error: 不允许继承自Person
Student extends Person {
}
```

对于一个类的实例字段，同样可以用`final`修饰。**用`final`修饰的字段**在初始化后不能被修改。例如：

```java
class Person {
    public final String name = "Unamed";
}
```

对`final`字段<u>重新赋值会报错</u>：

```java
Person p = new Person();
p.name = "New Name"; // compile error!
```

可以在构造方法中<u>初始化</u>`final`字段：

```java
class Person {
    public final String name;
    public Person(String name) {
        this.name = name;
    }
}
```

这种方法更为常用，因为可以保证实例一旦创建，其`final`字段就不可修改。

### 2.3 [`abstract`](https://www.liaoxuefeng.com/wiki/1252599548343744/1260456371027744)

#### 2.3.1 抽象方法、抽象类

如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为**抽象方法**。必须把`Person`类本身也声明为**`abstract`类**，才能正确编译它：

```java
abstract class Person {
    public abstract void run();
}
```

我们无法实例化一个抽象类：

```java
Person p = new Person(); // 编译错误
```

无法实例化的抽象类**有什么用？**

因为抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，<u>抽象方法实际上相当于定义了“规范”</u>。

例如，`Person`类定义了抽象方法`run()`，那么，在实现子类`Student`的时候，就必须覆写`run()`方法。

#### 2.3.2 面向抽象编程

当我们定义了抽象类`Person`，以及具体的`Student`、`Teacher`子类的时候，我们可以通过抽象类`Person`类型去引用具体的子类的实例：

```java
Person s = new Student();
Person t = new Teacher();
```

这种引用抽象类的好处在于，我们对其进行方法调用，并不关心`Person`类型变量的具体子类型：

```java
// 不关心Person变量的具体子类型:
s.run();
t.run();
```

这种<u>尽量引用高层类型，避免引用实际子类型</u>的方式，称之为**面向抽象编程**。

面向抽象编程的**本质**就是：

- 上层代码只定义规范（例如：`abstract class Person`）；
- 不需要子类就可以实现业务逻辑（正常编译）；
- 具体的业务逻辑由不同的子类实现，调用者并不关心。

### 2.4 [接口](https://www.liaoxuefeng.com/wiki/1252599548343744/1260456790454816)

#### 2.4.1 `interface`

在抽象类中，**抽象方法本质上是定义接口规范**：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。

如果<u>一个抽象类没有字段，所有方法全部都是抽象方法</u>：

```java
abstract class Person {
    public abstract void run();
    public abstract String getName();
}
```

就可以把该抽象类改写为**接口**：`interface`（比抽象类还要抽象）

在Java中，使用`interface`可以声明一个接口：

```java
interface Person {
    void run();
    String getName();
}
```

当一个具体的`class`去实现一个`interface`时，需要使用`implements`关键字。举个例子：

```java
              // 【√】
class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override // 覆写
    public void run() {
        System.out.println(this.name + " run");
    }

    @Override // 覆写
    public String getName() {
        return this.name;
    }
}
```

我们知道，在Java中，一个类只能继承自另一个类，不能从多个类继承。**但是**，一个类可以实现多个`interface`，例如：

```java
class Student implements Person, Hello { // 实现了两个interface
    ...
}
```

#### 2.4.2 区分

**注意区分术语：**

* **Java的接口**特指`interface`的定义，表示一个接口类型和一组方法签名
* **编程接口**泛指接口规范，如方法签名，数据格式，网络协议等

**抽象类和接口的对比**：

|            | abstract class       | interface                   |
| :--------- | :------------------- | :-------------------------- |
| 继承       | 只能extends一个class | 可以implements多个interface |
| 字段       | 可以定义实例字段     | 不能定义实例字段            |
| 抽象方法   | 可以定义抽象方法     | 可以定义抽象方法            |
| 非抽象方法 | 可以定义非抽象方法   | 可以定义default方法         |

#### 2.4.3 接口继承

一个`interface`可以**继承**自另一个`interface`。`interface`继承自`interface`使用`extends`，它<u>相当于扩展了接口的方法</u>。

```java
interface Hello {
    void hello();
}

interface Person extends Hello {
    void run();
    String getName();
}
```

`Person`接口现在实际上有3个抽象方法签名，其中一个来自继承的`Hello`接口。

#### 2.4.4 `default`方法

当我们需要给接口新增一个方法时，会涉及到修改全部子类（<u>因为需要覆写</u>）

如果新增的是`default`方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。例如：

```java
package Main;

public class Main {
    public static void main(String[] args) {
        Person p = new Student("Xiao Ming"); // 用更高层次的Person引用Student实例
        p.run();
    }
}

// 接口
interface Person {
    String getName();
    default void run() { // default方法，子类可以不用覆写【√】
        System.out.println(getName() + " run");
    }
}

// 类
class Student implements Person {
    private String name; // 字段

    public Student(String name) { // 构造函数
        this.name = name;
    }

    public String getName() { // 方法
        return this.name;
    }
}
```

### 2.4 包

#### 2.4.0 简介

Java内建的`package`机制是为了避免`class`命名冲突；

JDK的核心类使用`java.lang`包，编译器会自动导入；

JDK的其它常用类定义在`java.util.*`，`java.math.*`，`java.text.*`，……；

包名推荐使用倒置的域名，例如`org.apache`。

#### 2.4.1 `package`包

在Java中，我们使用`package`来**解决名字冲突**。

Java定义了一种名字空间，称之为包：`package`。一个类总是属于某个包，类名（比如`Person`）只是一个简写，真正的完整类名是`包名.类名`。

例如：

* 不同人写的Person类

  * 小明的`Person`类存放在包`ming`下面，因此，完整类名是`ming.Person`；

    * 小明的`Person.java`文件：

      ```java
      package ming; // 申明包名ming
      
      public class Person {
      }
      ```

  * 小红的`Person`类存放在包`hong`下面，因此，完整类名是`hong.Person`；

* 不同人写的Arrays类

  * 小军的`Arrays`类存放在包`mr.jun`下面，因此，完整类名是`mr.jun.Arrays`；
  * JDK的`Arrays`类存放在包`java.util`下面，因此，完整类名是`java.util.Arrays`。

在Java虚拟机执行的时候，JVM只看完整类名，因此，**只要包名不同，类就不同**。

#### 2.4.2 文件结构

包可以是**多层结构**，用`.`隔开。例如：`java.util`。

要**特别注意**：包没有父子关系。java.util和java.util.zip是不同的包，两者没有任何继承关系。

我们还需要**按照包结构把上面的Java文件组织起来**。假设以`package_sample`作为<u>根目录</u>，`src`作为<u>源码目录</u>，那么所有文件结构就是：

![image-20201003212436531](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20201003212436.png)

即所有Java文件对应的目录层次要和包的层次一致。

#### 2.4.3 包作用域

位于同一个包的类，可以访问**包作用域**的字段和方法。<u>不用`public`、`protected`、`private`修饰的字段和方法就是包作用域</u>。例如，`Person`类定义在`hello`包下面：

```java
package hello;

public class Person {
    // 包作用域: 
    void hello() {
        System.out.println("Hello!");
    }
}
```

`Main`类也定义在`hello`包下面：

```java
package hello;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.hello(); // 可以调用，因为Main和Person在同一个包
    }
}
```

文件结构：

![image-20201003213502842](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20201003213502.png)

#### 2.4.4 `Import`

在一个`class`中，我们总会引用其他的`class`。例如，小明的`ming.Person`类，如果要引用小军的`mr.jun.Arrays`类，他有三种写法：

* 第一种，直接写出完整类名（显然很麻烦）

* 第二种写法是用`import`语句，导入小军的`Arrays`，然后写简单类名：

  ```java
  // Person.java
  package ming;
  
  // 导入完整类名:
  import mr.jun.Arrays;
  
  public class Person {
      public void run() {
          Arrays arrays = new Arrays();
      }
  }
  ```

  * 在写`import`的时候，可以使用`*`，表示把这个包下面的所有`class`都导入进来（但不包括子包的`class`）

    ```java
    // 导入mr.jun包的所有class:
    import mr.jun.*;
    ```

    * 我们<u>一般不推荐这种写法</u>，因为在导入了多个包后，很难看出`Arrays`类属于哪个包。

编写class的时候，编译器会**自动**帮我们做两个import动作：

- 默认自动`import`当前`package`的其他`class`；
- 默认自动`import java.lang.*`。

#### 2.4.5 倒置的域名

为了避免名字冲突，我们需要确定唯一的包名。推荐的做法是使用**倒置的域名**来确保唯一性。例如：

- org.apache
- org.apache.commons.log
- com.liaoxuefeng.sample

子包就可以根据功能自行命名。

要注意不要和`java.lang`包的类重名，即自己的类不要使用这些名字：

- String
- System
- Runtime
- ...

要注意也不要和JDK常用类重名：

- java.util.List
- java.text.Format
- java.math.BigInteger
- ...



好的，先学到这里吧，去多多实战一下~     ——2020年10月3日21:44:27

