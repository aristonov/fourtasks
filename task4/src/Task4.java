import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Указываем путь к файлу
        System.out.print("Введите путь к файлу ");
        String filename = console.nextLine();
        List<Integer> list = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(filename))) {
            while (scan.hasNextInt()) {
                list.add(scan.nextInt());
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
            return;
        }

        // конвертируем и сортируем наш массив
        int[] nums = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(nums);

        int n = nums.length;
        int median = nums[n / 2 - 1];

        // считаем кол-во ходов
        int moves = 0;
        for (int x : nums) {
            moves += Math.abs(x - median);
        }

        // проверяем на ограничение в 20 ходов
        if (moves > 20) {
            System.out.println("20 ходов недостаточно для приведения всех элементов массива к одному числу");
        } else {
            System.out.println(moves);
        }
    }
}
