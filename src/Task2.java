import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() + 1, m = in.nextInt();

        String[] glass = new String[n];
        for (int i = 0; i < n; i++) {
            glass[i] = in.nextLine();
        }

        int liquid = n - 2;
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            in.next();
            int size = in.nextInt();
            String symb = in.next();

            for (int j = liquid; j > liquid - size; j--) {
                int start = glass[j].indexOf("\\");
                int start1 = glass[j].lastIndexOf("\\");
                int end = glass[j].indexOf("/");
                int end1 = glass[j].lastIndexOf("/");

                int start2 = glass[j].indexOf("|");
                int end2 = glass[j].lastIndexOf("|");

                int beginning = -1;
                int ending = -1;

                if (start != -1 && end != -1 && start < end) {
                    beginning = start;
                    ending = end;
                } else if (start2 != -1 && start2 != end2) {
                    beginning = start2;
                    ending = end2;
                } else if (start != -1 && end2 != -1 && start < end2) {
                    beginning = start;
                    ending = end2;
                } else if (start2 != -1 && end != -1 && start2 < end) {
                    beginning = start2;
                    ending = end;
                } else if (start2 != -1 && start != -1 && start2 < start) {
                    beginning = start2;
                    ending = start;
                } else if (end != -1 && start2 != -1 && end < end2) {
                    beginning = end;
                    ending = start2;
                } else if (start != -1 && end != -1 && start > end) {
                    beginning = end;
                    ending = start;
                } else if (start != -1 && start < start1) {
                    beginning = start;
                    ending = start1;
                } else if (end != -1 && end < end1) {
                    beginning = end;
                    ending = end1;
                }

                StringBuilder newLiquid = new StringBuilder();
                int liquidSize = glass[j].substring(beginning, ending).length();
                for (int l = 0; l < liquidSize - 1; l++) {
                    newLiquid.append(symb);
                }
                String newStr = glass[j].substring(0, beginning + 1) +
                        newLiquid +
                        glass[j].substring(ending);
                glass[j] = newStr;
            }
            liquid -= size;
        }

        for (int i = 1; i < n; i++) {
            System.out.println(glass[i]);
        }
    }
}
