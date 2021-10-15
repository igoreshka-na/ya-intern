import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int place = in.nextInt();
        int menSize = in.nextInt();

        ArrayList<Long> placeSize = new ArrayList<>(place);
        TreeSet<Long> treeMen = new TreeSet<>((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        });
        TreeSet<Long> treeSun = new TreeSet<>((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        });

        for (int i = 0; i < place; i++) {
            placeSize.add(in.nextLong());
        }
        for (int i = 0; i < menSize; i++) {
            treeMen.add(in.nextLong());
        }
        for (int i = 0; i < placeSize.size() - 1; i++) {
            long exit = placeSize.get(i) - placeSize.get(i + 1);
            treeSun.add(exit);
        }

        int result = 0;

        for (Long man : treeMen) {
            for (Long space: treeSun) {
                if (space >= man) {
                    treeMen.remove(man);
                    treeSun.remove(space);
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
