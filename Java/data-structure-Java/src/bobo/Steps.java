package bobo;

public class Steps {
    public static void main(String[] args) {
        Steps steps = new Steps();
        for (int i = 0; i < 10; i++) {
            System.out.println("Steps = " + i + ": " + steps.cal(i));
        }
    }
    protected int cal(int n){ // ��������cal��ʾcalculate
        if (n==0) return 1;
        if(n==1) return 1;
        return cal(n-1)+cal(n-2);
    }
}
