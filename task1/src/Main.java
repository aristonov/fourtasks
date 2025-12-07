import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n1, m1, n2, m2;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите 4 положительных числа через пробел, пример: 6 3 5 4");
        String line = scan.nextLine();
        String[] nums = line.trim().split("\\s+");

        n1 = Integer.parseInt(nums[0]);
        m1 = Integer.parseInt(nums[1]);
        n2 = Integer.parseInt(nums[2]);
        m2 = Integer.parseInt(nums[3]);

        String path1 = buildPath(n1, m1); // путь 1 массива
        String path2 = buildPath(n2, m2); // путь 2 массива

        System.out.println(path1 + path2); // соединяем пути
    }

    // Наш метод для построения пути
    public static String buildPath(int n, int m) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        String result = "";
        int index = 0;
        while (true) {
            result += array[index];
            int end = index;
            for (int i = 0; i < m - 1; i++) {
                end = (end + 1) % n;
            }
            if (end == 0) {
                break;
            }
            index = end;
        }
        return result;
    }
}
