# （Bugs）整理

1. `[Warning] incompatible implicit declaration of built-in function ‘scanf’ [enabled by default]`

   原因：未声明 `#include<stdio.h>` 头文件，就使用头文件中的 `printf` 函数。

2. `cannot open output file xxx.exe: Permission denied`

   `[Error] ld returned 1 exit status`

   原因：忘了关掉上一次运行的shell窗口

3. `[error] expected declaration or statement at end of input in c`

   Normally that error occurs when a `}` was missed somewhere in the code

4. 

