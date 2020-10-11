# （作业）斐波那契 (Fibonacci) 数列 + 青蛙跳台阶

## 1. 斐波那契 (Fibonacci) 数列

**要求**：

```java
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// F(0) = 0,   F(1) = 1
// F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
```

**分析**：用递归，很容易写

**代码**：`Fibonacci.java`

```java
package bobo;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println("n = " + i + ": " + fibonacci.cal(i));
        }
    }
    protected int cal(int n){ // 函数名用cal表示calculate
        if(n==0) return 0;
        if(n==1) return 1;
        return cal(n-1)+ cal(n-2);
    }
}
```

**输出**：

```java
n = 0: 0
n = 1: 1
n = 2: 1
n = 3: 2
n = 4: 3
n = 5: 5
n = 6: 8
n = 7: 13
n = 8: 21
n = 9: 34
```

## 2. 青蛙跳台阶

**要求**：

```java
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
```

**分析**：

用递归求解

基例：只有0级，则1种；只有1级，则1种；

递归链条：step(n-1) + step(n-2)

**代码**：`Steps.java`

```java
package bobo;

public class Steps {
    public static void main(String[] args) {
        Steps steps = new Steps();
        for (int i = 0; i < 10; i++) {
            System.out.println("Steps = " + i + ": " + steps.cal(i));
        }
    }
    protected int cal(int n){ // 函数名用cal表示calculate
        if (n==0) return 1;
        if(n==1) return 1;
        return cal(n-1)+cal(n-2);
    }
}
```

**输出**：

```java
Steps = 0: 1
Steps = 1: 1
Steps = 2: 2
Steps = 3: 3
Steps = 4: 5
Steps = 5: 8
Steps = 6: 13
Steps = 7: 21
Steps = 8: 34
Steps = 9: 55
```
