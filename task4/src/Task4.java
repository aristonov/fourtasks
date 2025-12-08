import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);

        // Выбираем наш файл
        System.out.print("Введите путь к файлу (для проверки в корне программы есть файл numbers.txt): ");
        String filename = console.nextLine();

        // Считаем кол-во чисел в файле
        Scanner scan = new Scanner(new File(filename));
        int count = 0;
        while (scan.hasNextInt()) {
            scan.nextInt();
            count++;
        }
        scan.close();

        // Создаём наш массив с числами из файла
        int[] nums = new int[count];
        scan = new Scanner(new File(filename));
        for (int i = 0; i < count; i++) {
            nums[i] = scan.nextInt();
        }
        scan.close();

        // Сортируем массив и находим медиану
        Arrays.sort(nums);
        int median = nums[count / 2];

        // Считаем кол-во наших ходов к медиане
        int moves = 0;
        for (int x : nums) {
            moves += Math.abs(x - median);
        }

        // Проверяем, если больше 20 ходов то выводим сообщение, если нет то выводим кол-во шагов
        if (moves > 20) {
            System.out.println("20 ходов недостаточно для приведения всех элементов массива к одному числу");
        } else {
            System.out.println(moves);
        }
    }
}
