package bobo;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println("n = " + i + ": " + fibonacci.cal(i));
        }
    }
    protected int cal(int n){ // ��������cal��ʾcalculate
        if(n==0) return 0;
        if(n==1) return 1;
        return cal(n-1)+ cal(n-2);
    }
}
