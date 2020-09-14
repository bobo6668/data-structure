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