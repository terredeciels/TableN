package p;

import static java.lang.String.valueOf;

public class C {

    private final int[][] T;
    private final int n;

    public C(int N) {
        n = N;
        T = new int[N][N];
        for (int i = 2; i < N; i++) {
            for (int j = i; j < N; j++) {
                T[i][j] = i * j;
            }
        }
    }

    public static void main(String[] args) {
        int N = 20;
        N++;
        System.out.print(new C(N));
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 2; i < n; i++) {
            buffer.append("\n").append("     ".repeat(i));
            for (int j = i; j < n; j++) {
                buffer.append(T[i][j]);
                switch (valueOf((T[i][j])).length()) {
                    case 1 -> buffer.append(" ".repeat(4));
                    case 2 -> buffer.append(" ".repeat(3));
                    case 3 -> buffer.append(" ".repeat(2));
                }
            }
        }
        return buffer.toString();
    }
}
