# （笔记）菜鸟教程 C语言 - 复习

[TOC]

## [0. 为什么要使用 C？](https://www.runoob.com/cprogramming/c-intro.html)

C 语言最初是用于系统开发工作，特别是组成操作系统的程序。由于 C 语言所产生的代码运行速度与汇编语言编写的代码运行速度几乎一样，所以采用 C 语言作为系统开发语言。



## [1. C 程序结构](https://www.runoob.com/cprogramming/c-program-structure.html)

C 程序主要**包括**以下部分：

- 预处理器指令
- 函数
- 变量
- 语句 & 表达式
- 注释

**Hello World 实例**

```c
#include <stdio.h>
 
int main()
{
   /* 我的第一个 C 程序 */
   printf("Hello, World! \n");
   
   return 0;
}
```



## [2. C 基本语法](https://www.runoob.com/cprogramming/c-basic-syntax.html)

C 程序由各种**令牌**(Token)组成，令牌可以是关键字、标识符、常量、字符串值，或者是一个符号。

例如，下面的 C 语句包括五个令牌：

```c
printf("Hello, World! \n");
```

这五个令牌分别是：

```c
printf               // 标识符
(                    // 符号
"Hello, World! \n"   // 字符串
)				     // 符号
;                    // 分号：语句结束符
```

* **标识符**
  * C 标识符是用来标识变量、函数，或任何其他用户自定义项目的名称。一个标识符以字母 A-Z 或 a-z 或下划线 _ 开始
* **注释**
  * C 语言有两种注释方式：
    * `//`：单行注释
    * `/* */` ：单行或多行
* **关键字**
  * 详见：https://www.runoob.com/cprogramming/c-basic-syntax.html



## [3. C 数据类型](https://www.runoob.com/cprogramming/c-data-types.html)

| 序号 | 类型与描述                                                   |
| :--- | :----------------------------------------------------------- |
| 1    | **基本类型：** 它们是算术类型，包括两种类型：**整数**类型和**浮点**类型。 |
| 2    | **枚举类型：** 它们也是算术类型，被用来定义在程序中只能赋予其一定的离散整数值的变量。 |
| 3    | **void 类型：** 类型说明符 *void* 表明没有可用的值。         |
| 4    | **派生类型：** 它们包括：指针类型、数组类型、结构类型、共用体类型和函数类型。 |

**常用基本数据类型占用空间**（64位机器为例）

- `char` ： 1个字节
- ` int `：4个字节
- ` float`：4个字节
- ` double`：8个字节

**字符型常量**

用英文单引号括起来，只保存一个字符'a'、'b' 、'*' ，还有转义字符 '\n' 、'\t'。

**字符串常量**

用英文的双引号引起来 可以保存多个字符："abc"。



## [4. C 变量](https://www.runoob.com/cprogramming/c-variables.html)

**定义**

```c
int    i, j, k;
char   c, ch;
float  f, salary;
double d;
```

**初始化**

变量可以在声明的时候被初始化（指定一个初始值）

```c
extern int d = 3, f = 5;    // d 和 f 的声明与初始化
int d = 3, f = 5;           // 定义并初始化 d 和 f
byte z = 22;                // 定义并初始化 z
char x = 'x';               // 变量 x 的值为 'x'
```

**声明**

```c
extern int i; //声明，不是定义 //声明变量 i 为外部变量【√】
int i; //声明，也是定义
```



## [5. C 常量](https://www.runoob.com/cprogramming/c-constants.html)

### 1）分类

* **整数常量**

  * **前缀**指定基数：

    * 0x 或 0X 表示十六进制
    * 0 表示八进制
    * 不带前缀则默认表示十进制

  * 可以带一个**后缀**，是 U 和 L 的组合

    * U 表示无符号整数（unsigned）
    * L 表示长整数（long）

  * 例子

    * ```c
      85         /* 十进制 */
      0213       /* 八进制 */
      0x4b       /* 十六进制 */
      30         /* 整数 */
      30u        /* 无符号整数 */
      30l        /* 长整数 */
      30ul       /* 无符号长整数 */
      ```

* **浮点常量**

  * **小数**形式

  * **指数**形式

  * 例子

    * ```c
      3.14159       /* 合法的 */
      314159E-5L    /* 合法的 */
      510E          /* 非法的：不完整的指数 */
      210f          /* 非法的：没有小数或指数 */
      .e55          /* 非法的：缺少整数或分数 */
      ```

* **字符常量**

  * 字符常量是括在单引号中，例如，'x' 可以存储在 **char** 类型的简单变量中。
  * 分类
    * 普通的字符（例如 'x'）
    * 转义序列（例如 '\t'）
    * 通用的字符（例如 '\u02C0'）

* **字符串常量**

  * 双引号 ""

  * 例子

    * ```c
      "hello, dear"
      
      "hello, \
      dear"
      ```

### 2）定义常量

在 C 中，有两种简单的定义常量的方式：

* 使用 `#define` 预处理器

  * ```c
    #define LENGTH 10   
    #define WIDTH  5
    #define NEWLINE '\n'
    ```

* 使用 `const` 关键字

  * ```c
    const int  LENGTH = 10;
    const int  WIDTH  = 5;
    const char NEWLINE = '\n';
    ```

* 请注意，把常量定义为**大写字母形式**



## [6. C 存储类](https://www.runoob.com/cprogramming/c-storage-classes.html)

- `auto`
  - 是所有**局部变量默认**的存储类
  - 只能修饰局部变量
- `register`
  - 用于定义存储在**寄存器**中而不是 RAM 中的局部变量
    - 变量的最大尺寸等于寄存器的大小（通常是一个词），且不能对它应用一元的 '&' 运算符（因为它没有内存位置）
    - 定义 `register` **并不意味**着变量将被存储在寄存器中，它意味着变量可能存储在寄存器中，这取决于硬件和实现的限制
  - 寄存器只用于需要快速访问的变量，比如计数器
- `static`
  - 使用 `static` 修饰局部变量可以在函数调用之间保持局部变量的值
    - 变得有点像“全局”
  - 当 `static` 修饰全局变量时，会使变量的作用域限制在声明它的文件内
- `extern`
  - 用来**在另一个文件中**声明一个全局变量或函数
  - 通常用于当有两个或多个文件**共享**相同的全局变量或函数的时候



## [7. C 判断](https://www.runoob.com/cprogramming/c-decision.html)

C 语言提供了以下类型的判断语句。点击链接查看每个语句的细节。

| 语句                                                         | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [if 语句](https://www.runoob.com/cprogramming/c-if.html)     | 一个 **if 语句** 由一个布尔表达式后跟一个或多个语句组成。    |
| [if...else 语句](https://www.runoob.com/cprogramming/c-if-else.html) | 一个 **if 语句** 后可跟一个可选的 **else 语句**，else 语句在布尔表达式为假时执行。 |
| [嵌套 if 语句](https://www.runoob.com/cprogramming/c-nested-if.html) | 您可以在一个 **if** 或 **else if** 语句内使用另一个 **if** 或 **else if** 语句。 |
| [switch 语句](https://www.runoob.com/cprogramming/c-switch.html) | 一个 **switch** 语句允许测试一个变量等于多个值时的情况。     |
| [嵌套 switch 语句](https://www.runoob.com/cprogramming/c-nested-switch.html) | 您可以在一个 **switch** 语句内使用另一个 **switch** 语句。   |

```c
if(boolean_expression 1)
{
   /* 当布尔表达式 1 为真时执行 */
}
else if( boolean_expression 2)
{
   /* 当布尔表达式 2 为真时执行 */
}
else 
{
   /* 当上面条件都不为真时执行 */
}

switch(expression){
    case constant-expression-1  :
       statement(s);
       break; /* 可选的 */
    case constant-expression-2  :
       statement(s);
       break; /* 可选的 */  
    /* 您可以有任意数量的 case 语句 */        
    default : /* 可选的 */
       statement(s);
}
```



`? : ` **条件运算符**(三元运算符)，可以用来替代 `if...else` 语句

```c
Exp1 ? Exp2 : Exp3;
```

![img](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200915224259.png)



## [8. C 循环](https://www.runoob.com/cprogramming/c-loops.html)

### 1）循环类型

C 语言提供了以下几种循环类型。点击链接查看每个类型的细节。

| 循环类型                                                     | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [while 循环](https://www.runoob.com/cprogramming/c-while-loop.html) | 当给定条件为真时，重复语句或语句组。它会在执行循环主体之前测试条件。 |
| [for 循环](https://www.runoob.com/cprogramming/c-for-loop.html) | 多次执行一个语句序列，简化管理循环变量的代码。               |
| [do...while 循环](https://www.runoob.com/cprogramming/c-do-while-loop.html) | 除了它是在循环主体结尾测试条件外，其他与 while 语句类似。    |
| [嵌套循环](https://www.runoob.com/cprogramming/c-nested-loops.html) | 您可以在 while、for 或 do..while 循环内使用一个或多个循环。  |

```c
while(condition)
{
   statement(s);
}

for ( init; condition; increment )
{
   statement(s);
}

do
{
   statement(s);

}while( condition );
```

### 2）循环控制语句

循环控制语句改变你代码的执行顺序。通过它你可以实现代码的跳转。

C 提供了下列的循环控制语句。点击链接查看每个语句的细节。

| 控制语句                                                     | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [break 语句](https://www.runoob.com/cprogramming/c-break-statement.html) | 终止**循环**或 **switch** 语句，程序流将继续执行紧接着循环或 switch 的下一条语句。 |
| [continue 语句](https://www.runoob.com/cprogramming/c-continue-statement.html) | 告诉一个循环体立刻停止本次循环迭代，重新开始下次循环迭代。   |
| [goto 语句](https://www.runoob.com/cprogramming/c-goto-statement.html) | 将控制转移到被标记的语句。但是**不建议**在程序中使用 goto 语句。 |

* `break`

![img](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200915224641.jpeg)

* `continue`

![img](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200915224819.jpeg)

* `goto`

![img](https://raw.githubusercontent.com/bobo6668/markdown-pictures-bobo/master/img/data-structure/20200915224907.png)



## [9. C 函数](https://www.runoob.com/cprogramming/c-functions.html)

每个 C 程序都至少有一个函数，即主函数 **main()** 

函数**声明**告诉编译器函数的名称、返回类型和参数。

函数**定义**提供了函数的实际主体。

C 标准库提供了大量的程序可以调用的**内置函数**。例如，函数 **strcat()** 用来连接两个字符串

```c
//【函数声明】
return_type function_name( parameter list );

//【函数定义】
// 返回类型   // 函数名称    // 参数
return_type function_name( parameter list )
{
   body of the function  // 函数
}
```

| 调用类型                                                     | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [传值调用](https://www.runoob.com/cprogramming/c-function-call-by-value.html) | 该方法把参数的实际值复制给函数的形式参数。在这种情况下，修改函数内的形式参数不会影响实际参数。 |
| [引用调用](https://www.runoob.com/cprogramming/c-function-call-by-pointer.html) | 通过指针传递方式，形参为指向实参地址的指针，当对形参的指向操作时，就相当于对实参本身进行的操作。 |