import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
        }
        boolean[] flags = new boolean[3];

        for (int i = 0; i < 3; i++) {
            int[] c = a.clone();
            Arrays.sort(c);
            if (!flags[i]) {
                flags[i] = a[i] == c[1];
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int[] b = a.clone();
                    b[i] -= b[j];
                    int sub = b[i];
                    Arrays.sort(b);

                    for (int k = 0; k < 3; k++) {
                        if (k == i) {
                            if (sub == b[1])  {
                                flags[k] = true;
                            }
                        } else {
                            if (a[k] == b[1]) {
                                flags[k] = true;
                            }
                        }
                    }

                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(flags[i] ? "YES" : "NO");
        }
    }
}
