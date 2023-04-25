package task_1;
import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        summa(sc);
        factor(sc);

        sc.close();

    }

    public static void summa(Scanner scan) {

        System.out.println("Введите число для вычисления суммы: ");

        int num = scan.nextInt();
        int sum = 0;

        for(int i = 1; i <= num; i++) {
            sum = sum + i;
        }

        System.out.printf("Сумма чисел: %d \n", sum);
       

        
    }

    static void factor(Scanner scan) {

        System.out.println("Введите число для вычисления факториала: ");
        int number = scan.nextInt();
        int multiplicat = 1;

        for(int i = 1; i <= number; i++) {
            multiplicat = multiplicat * i;
        }

        System.out.printf("Факториал числа: %d \n", multiplicat);
    }
    
}
