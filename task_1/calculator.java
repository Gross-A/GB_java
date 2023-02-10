// Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ; int b; String op (op!=”Stop”); (char != ’b’)

import java.util.Scanner;


public class calculator {
    public static void main(String[] args) {
        calculate();
    }

    public static void calculate() {
        Boolean runner = true;
        while(runner == true){
            Double result = 0.0;
            Scanner in = new Scanner(System.in);
            System.out.print("Введите перовое числочисло: ");

            Double num_1 = in.nextDouble();

            System.out.print("Введите второе числочисло: ");

            Double num_2 = in.nextDouble();

            System.out.print("Введите действие (+, -, *, /): ");

            String sign = in.next();
            // char sign = (char) x;

            // String sign = String.valueOf(in.read());

            if(sign.equals("+")){
                result = num_1 + num_2;
            }
            else if(sign.equals("-")){
                result = num_1 - num_2;
            }
            else if(sign.equals("*")){
                result = num_1 * num_2;
            }
            else if(sign.equals("/")){
                result = num_1 / num_2;
            }
            else{
                System.out.println("Неправильно введен знак");
            }

            System.out.println("Результат вычисления: " + result);

            System.out.println("Если хотите выполнить вычилсение нажмите любую клавишу, если хотите выйти - введите 'br'");
            String  action= in.next();

            if(action.equals("br")){
                runner = false;
            }
        }






        
    }
}
