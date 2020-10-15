package bobo;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPolynomial {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.read();
        System.out.println(p1.toString());

//        Scanner scanner = new Scanner(System.in); // ���Բ����µ�һ��
//        p1.attach(scanner.nextInt(), scanner.nextInt());
//        System.out.println(p1.toString());

        Polynomial p2 = new Polynomial();
        p2.read();
        System.out.println(p2.toString());

        TestPolynomial testPolynomial = new TestPolynomial();
        Polynomial p3 = testPolynomial.add(p1, p2);
        System.out.println(p3.toString());
    }
    public Polynomial add (Polynomial p1, Polynomial p2){
        Polynomial pResult = p1;

        // ��������ʽ��ӣ�����ָ���ݽ���ʽ
        int i = 0;
        while (i < p2.n) {
            pResult.attach(p2.coef.get(i), p2.expo.get(i));
            i++;
        }
        return pResult;
    }
}

class Polynomial {
    int n;
    ArrayList<Integer> coef = new ArrayList<>();
    ArrayList<Integer> expo = new ArrayList<>();

    public Polynomial() {
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // ��ȡ����
        this.n = n;
        for (int i = 0; i < n; i++) { // ����ָ���ݽ���ʽ
            coef.add(scanner.nextInt());
            expo.add(scanner.nextInt());
        }
    }

    public void attach(int coef, int expo) { // ����ָ���ݽ���ʽ�������µ�һ��
        for (int i = 0; i < n; i++) {
            int thisExpo = this.expo.get(i);
            int thisCoef = this.coef.get(i);

            if ( thisExpo == expo) { // ���ָ�����
                int tmp = thisCoef + coef; // ϵ�����
                if (tmp != 0) {  // ���ϵ����Ӳ�Ϊ0�������ϵ������
                    this.coef.set(i, tmp);
                }
                else {  // ���ϵ�����Ϊ0����Ҫɾ����һ��
                    this.coef.remove(i);
                    this.expo.remove(i);
                }
                break; // ������Ҫbreak
            }
            else if (thisExpo < expo) { // �����ǰָ��С�������ָ������Ϊ��ָ���ݽ���ʽ��������Ҫ�����µ�һ��
                this.coef.add(i, coef);
                this.expo.add(i, expo);
                n++;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "n=" + n +
                ", coef=" + coef +
                ", expon=" + expo +
                '}';
    }
}

/* ���Խ�� 2020��10��15��23:11:18
4 3 4 -5 2  6 1  -2 0
Polynomial{n=4, coef=[3, -5, 6, -2], expon=[4, 2, 1, 0]}
3 5 20  -7 4  3 1
Polynomial{n=3, coef=[5, -7, 3], expon=[20, 4, 1]}
Polynomial{n=5, coef=[5, -4, -5, 9, -2], expon=[20, 4, 2, 1, 0]}
*/