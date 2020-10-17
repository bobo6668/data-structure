package bobo;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPolynomial {
    public static void main(String[] args) {
        // ��ȡ��1������ʽ
        Polynomial p1 = new Polynomial();
        p1.read();
        System.out.println(p1.toString());

//        Scanner scanner = new Scanner(System.in); // ���Բ����µ�һ��
//        p1.attach(scanner.nextInt(), scanner.nextInt());
//        System.out.println(p1.toString());

        // ��ȡ��2������ʽ
        Polynomial p2 = new Polynomial();
        p2.read();
        System.out.println(p2.toString());

        TestPolynomial testPolynomial = new TestPolynomial();
        // ����ʽ���
        Polynomial pMultiply = testPolynomial.multiply(p1, p2);
        System.out.println(pMultiply.toString());
        // ����ʽ���
        Polynomial pAdd = testPolynomial.add(p1, p2);
        System.out.println(pAdd.toString());
    }
    public Polynomial add (Polynomial p1, Polynomial p2){
        Polynomial pResult = new Polynomial();
        pResult.copy(p1); // �����p1��pResult

        // ��������ʽ��ӣ�����ָ���ݽ���ʽ
        for (int i = 0; i < p2.n; i++) {
            pResult.attach(p2.coef.get(i), p2.expo.get(i));
        }
        return pResult;
    }
    public Polynomial multiply (Polynomial p1, Polynomial p2){
        Polynomial pResult = new Polynomial();

        // ��������ʽ��ӣ�����ָ���ݽ���ʽ
        for (int i = 0; i < p1.n; i++) {
            for (int j = 0; j < p2.n; j++) {
                pResult.attach(p1.coef.get(i) * p2.coef.get(j), p1.expo.get(i) + p2.expo.get(j));
            }
        }
        return pResult;
    }
}

class Polynomial { // �ࣺ����ʽ
    int n; // ����
    ArrayList<Integer> coef = new ArrayList<>(); // ϵ������̬���飩
    ArrayList<Integer> expo = new ArrayList<>(); // ָ������̬���飩

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
        if (this.n == 0) {
            this.coef.add(coef);
            this.expo.add(expo);
            n++;
        }
        else {
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
                else if (i == n-1) { // ��������ָ�������е�����ָ����С����Ҫ���뵽�����
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
        // ���չ涨��ʽ�����
        // �����2�У��ֱ���ָ���ݽ���ʽ����˻�����ʽ�Լ��Ͷ���ʽ�������ϵ����ָ����
        // ���ּ��Կո�ָ�������β�����ж���ո�
        // �����ʽӦ���0 0��
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                sb.append(' ');
            }
            sb.append(this.coef.get(i)).append(' ').append(this.expo.get(i));
        }
        return sb.toString();
    }

    // �Լ�дһ����������
    protected void copy(Polynomial pOld) {
        this.n = pOld.n;
        for (int i = 0; i < this.n; i++) {
            this.coef.add(pOld.coef.get(i));
            this.expo.add(pOld.expo.get(i));
        }
    }
}

/* ���Խ�� 2020��10��15��23:11:18
4 3 4 -5 2  6 1  -2 0
Polynomial{n=4, coef=[3, -5, 6, -2], expon=[4, 2, 1, 0]}
3 5 20  -7 4  3 1
Polynomial{n=3, coef=[5, -7, 3], expon=[20, 4, 1]}
Polynomial{n=5, coef=[5, -4, -5, 9, -2], expon=[20, 4, 2, 1, 0]}
*/