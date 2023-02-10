package task_1;
import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        summa();
        factor();
    }

    public static void summa() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        System.out.printf("Сумма чисел: %d \n", sum);
        in.close();
        
    }

    public static void factor() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        int multiplicat = 1;
        for(int i = 1; i <= num; i++) {
            multiplicat = multiplicat * i;
        }
        System.out.printf("Факториал числа: %d \n", multiplicat);
        in.close();
    }
    
}
