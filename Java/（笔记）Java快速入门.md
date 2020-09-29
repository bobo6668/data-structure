# （笔记）Java快速入门

[TOC]

## 0 第一个Java程序

> [第一个Java程序 - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1255876875896416)
>
> [Java程序基本结构 - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1255884132971296)

了解基本结构

```java
/**
 * 可以用来自动创建文档的注释
 * 
 * @auther liaoxuefeng
 */
// class的定义
public class Hello {
    // 方法的定义
    public static void main(String[] args) {
        System.out.println("Hello, world!"); // 向屏幕输出文本
    }
} 
```

目前，我们只需要知道，**Java入口程序**规定的方法必须是静态方法 `static`，方法名必须为 `main`

**命名规则**

* **类名**：
  * 类名必须以英文字母开头，后接字母，数字和下划线的组合
  * 习惯以<u>大写字母开头</u>，如 `Hello`

* **方法名**：
  * 命名和`class`一样，但是<u>首字母小写</u>，如 `main`

**输出**

* `System.out.println("Hello, world!"); // 向屏幕输出文本`

## 1 数据类型

> [变量和数据类型 - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1255883729079552)

### 1.1 基本数据类型

是CPU可以直接进行运算的类型。Java定义了以下几种基本数据类型：

- 整数类型：byte，<u>short</u>，int，<u>long</u>
- 浮点数类型：float，double
- 字符类型：char
- 布尔类型：<u>boolean</u>
  - 只有`true`和`false`两个值。

![image-20200929213144715](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200929213144.png)

### 1.2 引用类型

除了上述基本类型的变量，剩下的都是引用类型。例如，引用类型最常用的就是`String`字符串：

```java
String s = "hello";
```

【√】引用类型的变量**类似于C语言的指针**，它内部存储一个“**地址**”，指向某个对象在内存的位置

### 1.3 常量

**变量**可重新赋值，等号是赋值语句，不是数学意义的等号。

定义变量的时候，如果加上`final`修饰符，这个变量就变成了**常量**：

```java
final double PI = 3.14; // PI是一个常量
double r = 5.0;
double area = PI * r * r;
PI = 300; // compile error!
```

常量在初始化后<u>不可重新赋值</u>，使用常量便于理解程序意图。

## 2 基本运算

### 2.1 [整数运算](https://www.liaoxuefeng.com/wiki/1252599548343744/1255888634635520)

遵循四则运算规则

**注意**：

整数的除法对于**除数为0**时运行时将报错，但编译不会报错。

两个整数相除只能得到结果的整数部分

**溢出**

要特别注意，整数由于存在范围限制，如果计算结果超出了范围，就会产生溢出，而**溢出不会出错**，却会得到一个奇怪的结果

### 2.2 [浮点数运算](https://www.liaoxuefeng.com/wiki/1252599548343744/1255887847679616)

浮点数运算在**除数为`0`时，不会报错**，但会返回几个**特殊值**：

- `NaN`表示Not a Number
- `Infinity`表示无穷大
- `-Infinity`表示负无穷大

```java
double d1 = 0.0 / 0; // NaN
double d2 = 1.0 / 0; // Infinity
double d3 = -1.0 / 0; // -Infinity
```

这三种特殊值<u>在实际运算中很少碰到</u>，我们只需要了解即可。

### 2.3 [布尔运算](https://www.liaoxuefeng.com/wiki/1252599548343744/1255938640048480)

布尔运算的一个重要特点是**短路运算**。如果一个布尔运算的表达式能提前确定结果，则后续的计算不再执行，直接返回结果。**与**运算和**或**运算是短路运算。

Java还提供一个**三元运算符** `b ? x : y`，它根据第一个布尔表达式的结果，分别返回后续两个表达式之一的计算结果

## 3 [字符、字符串](https://www.liaoxuefeng.com/wiki/1252599548343744/1255938912141568)

在Java中，字符和字符串是两个不同的类型。

### 3.1 字符类型`char`

是基本数据类型，它是`character`的缩写。一个`char`保存一个Unicode字符

```java
char c1 = 'A';
char c2 = '中';
```

因为Java在内存中总是使用Unicode表示字符，所以，一个英文字符和一个中文字符都用一个`char`类型表示，它们都占用两个字节。

要显示一个字符的Unicode编码，只需将`char`类型直接赋值给`int`类型即可：

```java
int n1 = 'A'; // 字母“A”的Unicodde编码是65
int n2 = '中'; // 汉字“中”的Unicode编码是20013
```

### 3.2 字符串类型 `String`

和`char`类型不同，**字符串类型**`String`是引用类型，我们用双引号`"..."`表示字符串。

```java
String s = ""; // 空字符串，包含0个字符
String s1 = "A"; // 包含一个字符
String s2 = "ABC"; // 包含3个字符
String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格
```

Java的编译器对字符串做了特殊照顾，<u>可以使用`+`连接任意字符串和其他数据类型</u>，这样极大地方便了字符串的处理

如果用`+`连接字符串和其他数据类型，会<u>将其他数据类型先自动转型为字符串</u>：

```java
public class Main {
    public static void main(String[] args) {
        int age = 25;
        String s = "age is " + age;
        System.out.println(s);
    }
}
```

从Java 13开始，字符串可以用`"""..."""`表示多行字符串（Text Blocks）了

```java
public class Main {
    public static void main(String[] args) {
        String s = """
                   SELECT * FROM
                     users
                   WHERE id > 100
                   ORDER BY name DESC
                   """;
        System.out.println(s);
    }
}
```

上述多行字符串实际上是5行，在最后一个`DESC`后面还有一个`\n`。

## 4 [数组](https://www.liaoxuefeng.com/wiki/1252599548343744/1255941599809248)

数组元素可以是值类型（如int）或引用类型（如String），但**数组本身是引用类型**

**定义方式**： 

```java
// int数组
int[] ns1 = new int[5]; // 基本形式
int[] ns2 = new int[] { 68, 79, 91, 85, 62 }; // 不写大小，直接初始化
int[] ns3 = { 68, 79, 91, 85, 62 }; // 进一步简写

//字符串数组
String[] names = {
    "ABC", "XYZ", "zoo"
};
```

Java的数组有几个**特点**：

- 数组所有元素初始化为默认值，整型都是`0`，浮点型是`0.0`，布尔型是`false`；
- 数组一旦创建后，大小就不可改变。

## 5 流程控制

### 5.1 [输出、输入](https://www.liaoxuefeng.com/wiki/1252599548343744/1255887264020640)

#### 5.1.1 输出

**基本方法**

```java
System.out.println("hello world"); // println是print line的缩写，表示输出并换行
System.out.print("a"); // 输出后不换行
```

Java还提供了**格式化输出**的功能

```java
public class Main {
    public static void main(String[] args) {
        double d = 3.1415926;
        System.out.printf("%.2f\n", d); // 显示两位小数3.14
        System.out.printf("%.4f\n", d); // 显示4位小数3.1416
    }
}
```

#### 5.1.2 输入

和输出相比，Java的输入就要复杂得多。

我们先看一个从控制台读取一个字符串和一个整数的例子：

```java
import java.util.Scanner; //【√】

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象【√】
        
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串【√】
        
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数【√】
        
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }
}
```

直接使用`System.in`读取用户输入虽然是可以的，但需要更复杂的代码。

而通过`Scanner`就可以简化后续的代码，读取对应的类型可以使用：`scanner.nextLine()` / `nextInt()` / `nextDouble()` / ...

### 5.2 几种程序结构

和C很像耶

### 5.2.1 [if 判断](https://www.liaoxuefeng.com/wiki/1252599548343744/1259539352677728)

```javascript
// 从小到大依次判断：
if (n < 60) {
    // ...
} else if (n < 90) {
    // ...
} else {
    // ...
}
```

不推荐忽略花括号的写法

**判断相等？**

在Java中，**判断值类型的变量是否相等**，可以使用`==`运算符。

但是，**判断引用类型的变量是否相等**，`==`表示“<u>引用</u>是否相等”，或者说，是否指向同一个对象。

要判断引用类型的变量<u>内容</u>是否相等，必须使用`equals()`方法：

```java
public class Main {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
    }
}
```

注意：执行语句`s1.equals(s2)`时，如果变量`s1`为`null`，会报`NullPointerException`；要避免`NullPointerException`错误，可以利用短路运算符`&&`：

```java
public class Main {
    public static void main(String[] args) {
        String s1 = null;
        if (s1 != null && s1.equals("hello")) {
            System.out.println("hello");
        }
    }
}
```

### 5.2.2 [switch多重选择](https://www.liaoxuefeng.com/wiki/1252599548343744/1259541030848864)

对于多个`==`判断的情况，使用`switch`结构更加清晰。

```java
public class Main {
    public static void main(String[] args) {
        int option = 99;
        switch (option) {
        case 1:
            System.out.println("Selected 1");
            break; // 记得别漏写【√】
        case 2:
            System.out.println("Selected 2");
            break;
        case 3:
            System.out.println("Selected 3");
            break;
        default:
            System.out.println("Not selected");
            break;
        }
    }
}
```

### 5.2.3 [while循环](https://www.liaoxuefeng.com/wiki/1252599548343744/1259539701691232)

```java
while (条件表达式) {
    循环语句
}
// 继续执行后续代码
```

### 5.2.4 [do while循环](https://www.liaoxuefeng.com/wiki/1252599548343744/1259541649945472)

```java
do {
    执行循环语句
} while (条件表达式);
```

可见，`do while`循环会至少循环一次。

### 5.2.5 [for循环](https://www.liaoxuefeng.com/wiki/1252599548343744/1259540152578912)

```java
for (初始条件; 循环检测条件; 循环后更新计数器) {
    // 执行语句
}
```

使用`for`循环时，千万不要在循环体内修改计数器！在循环体中修改计数器常常导致莫名其妙的逻辑错误。

`for`循环还可以缺少初始化语句、循环条件和每次循环更新语句，通常不推荐这样写，但是，某些情况下，是可以省略`for`循环的某些语句的。

Java还提供了另一种`for each`循环，它可以更简单地遍历数组：

```java
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) { // 【√】
            System.out.println(n);
        }
    }
}
```

### 5.2.6 [break和continue](https://www.liaoxuefeng.com/wiki/1252599548343744/1259542531392800)

* `break`语句可以跳出当前循环；
  * `break`语句通常配合`if`，在满足条件时提前结束整个循环；
  * `break`语句总是跳出最近的一层循环；

* `continue`语句可以提前结束本次循环；
  * `continue`语句通常配合`if`，在满足条件时提前结束本次循环。

## 6 数组操作

### 6.1 遍历数组

**法1：for**

```java
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }
}
```

**法2：for each**

```java
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }
}
```

注意：在`for (int n : ns)`循环中，变量`n`直接拿到`ns`数组的元素，而不是索引。

显然`for each`循环更加简洁。但是，`for each`循环无法拿到数组的索引，因此，到底用哪一种`for`循环，取决于我们的需要。

**快速打印数组内容**

`Arrays.toString()`

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 1, 2, 3, 5, 8 };
        System.out.println(Arrays.toString(ns)); // 【√】
    }
}
```

### 6.2 [数组排序](https://www.liaoxuefeng.com/wiki/1252599548343744/1259543088592672)

对数组进行排序是程序中非常基本的需求。

常用的排序算法有冒泡排序、插入排序和快速排序等。

**冒泡排序的特点**是，每一轮循环后，最大的一个数被交换到末尾，因此，下一轮循环就可以“刨除”最后的数，每一轮循环都比上一轮循环的结束位置靠前一位。

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        // 冒泡排序
        for (int i = 0; i < ns.length - 1; i++) { // 循环
            for (int j = 0; j < ns.length - i - 1; j++) { // 把最大的一个数交换到末尾
                if (ns[j] > ns[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
    }
}
```

实际上，Java的标准库已经**内置**了排序功能，我们只需要调用JDK提供的`Arrays.sort()`就可以排序：

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        Arrays.sort(ns); // 【√】
        System.out.println(Arrays.toString(ns));
    }
}
```

必须注意，对数组排序实际上修改了数组本身。

### 6.3 [多维数组](https://www.liaoxuefeng.com/wiki/1252599548343744/1259544232593792)

最常见的多维数组是**二维数组**

```java
int[][] ns = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }
        };
```

![image-20200929225252873](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200929225252.png)

访问二维数组的某个元素需要使用`array[row][col]`，例如：

```java
System.out.println(ns[1][2]); // 7
```

要打印一个二维数组，可以使用两层嵌套的for循环：

```java
for (int[] arr : ns) {
    for (int n : arr) {
        System.out.print(n);
        System.out.print(', ');
    }
    System.out.println();
}
```

或者使用Java标准库的`Arrays.deepToString()`：

```java
System.out.println(Arrays.deepToString(ns));
```