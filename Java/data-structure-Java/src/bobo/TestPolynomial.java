package bobo;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPolynomial {
    public static void main(String[] args) {
        // 读取第1个多项式
        Polynomial p1 = new Polynomial();
        p1.read();
        System.out.println(p1.toString());

//        Scanner scanner = new Scanner(System.in); // 测试插入新的一项
//        p1.attach(scanner.nextInt(), scanner.nextInt());
//        System.out.println(p1.toString());

        // 读取第2个多项式
        Polynomial p2 = new Polynomial();
        p2.read();
        System.out.println(p2.toString());

        TestPolynomial testPolynomial = new TestPolynomial();
        // 多项式相乘
        Polynomial pMultiply = testPolynomial.multiply(p1, p2);
        System.out.println(pMultiply.toString());
        // 多项式相加
        Polynomial pAdd = testPolynomial.add(p1, p2);
        System.out.println(pAdd.toString());
    }
    public Polynomial add (Polynomial p1, Polynomial p2){
        Polynomial pResult = new Polynomial();
        pResult.copy(p1); // 先深拷贝p1到pResult

        // 两个多项式相加，按照指数递降形式
        for (int i = 0; i < p2.n; i++) {
            pResult.attach(p2.coef.get(i), p2.expo.get(i));
        }
        return pResult;
    }
    public Polynomial multiply (Polynomial p1, Polynomial p2){
        Polynomial pResult = new Polynomial();

        // 两个多项式相加，按照指数递降形式
        for (int i = 0; i < p1.n; i++) {
            for (int j = 0; j < p2.n; j++) {
                pResult.attach(p1.coef.get(i) * p2.coef.get(j), p1.expo.get(i) + p2.expo.get(j));
            }
        }
        return pResult;
    }
}

class Polynomial { // 类：多项式
    int n; // 项数
    ArrayList<Integer> coef = new ArrayList<>(); // 系数（动态数组）
    ArrayList<Integer> expo = new ArrayList<>(); // 指数（动态数组）

    public Polynomial() {
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取项数
        this.n = n;
        for (int i = 0; i < n; i++) { // 按照指数递降形式
            coef.add(scanner.nextInt());
            expo.add(scanner.nextInt());
        }
    }

    public void attach(int coef, int expo) { // 按照指数递降形式，插入新的一项
        if (this.n == 0) {
            this.coef.add(coef);
            this.expo.add(expo);
            n++;
        }
        else {
            for (int i = 0; i < n; i++) {
                int thisExpo = this.expo.get(i);
                int thisCoef = this.coef.get(i);

                if ( thisExpo == expo) { // 如果指数相等
                    int tmp = thisCoef + coef; // 系数相加
                    if (tmp != 0) {  // 如果系数相加不为0，则更新系数即可
                        this.coef.set(i, tmp);
                    }
                    else {  // 如果系数相加为0，则要删掉这一项
                        this.coef.remove(i);
                        this.expo.remove(i);
                    }
                    break; // 别忘了要break
                }
                else if (thisExpo < expo) { // 如果当前指数小于输入的指数，因为是指数递降形式，所以需要插入新的一项
                    this.coef.add(i, coef);
                    this.expo.add(i, expo);
                    n++;
                    break;
                }
                else if (i == n-1) { // 如果输入的指数比已有的所有指数都小，需要插入到最后面
                    this.coef.add(coef);
                    this.expo.add(expo);
                    n++;
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
//        return "Polynomial{" +
//                "n=" + n +
//                ", coef=" + coef +
//                ", expon=" + expo +
//                '}';
        // 按照规定格式输出：
        // 输出分2行，分别以指数递降方式输出乘积多项式以及和多项式非零项的系数和指数。
        // 数字间以空格分隔，但结尾不能有多余空格。
        // 零多项式应输出0 0。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                sb.append(' ');
            }
            sb.append(this.coef.get(i)).append(' ').append(this.expo.get(i));
        }
        return sb.toString();
    }

    // 自己写一个拷贝函数
    protected void copy(Polynomial pOld) {
        this.n = pOld.n;
        for (int i = 0; i < this.n; i++) {
            this.coef.add(pOld.coef.get(i));
            this.expo.add(pOld.expo.get(i));
        }
    }
}

/* 测试结果 2020年10月15日23:11:18
4 3 4 -5 2  6 1  -2 0
Polynomial{n=4, coef=[3, -5, 6, -2], expon=[4, 2, 1, 0]}
3 5 20  -7 4  3 1
Polynomial{n=3, coef=[5, -7, 3], expon=[20, 4, 1]}
Polynomial{n=5, coef=[5, -4, -5, 9, -2], expon=[20, 4, 2, 1, 0]}
*/