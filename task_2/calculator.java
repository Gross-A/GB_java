// Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ; int b; String op (op!=”Stop”); (char != ’b’)

// import java.lang.System.Logger;
// import java.lang.System.Logger.Level;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;



public class calculator {

    private static Logger LOG = Logger.getLogger(calculator.class.getName());

    public static void main(String[] args) throws IOException {

        FileHandler fh = new FileHandler("calc_log.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        LOG.addHandler(fh);

        calculate();
    }

    public static void calculate() {
        Boolean runner = true;
        while(runner == true){
            Double result = 0.0;
            Scanner in = new Scanner(System.in);
            System.out.print("Введите перовое числочисло: ");

            Double num_1 = in.nextDouble();

            LOG.log(Level.INFO, "user enterd number 1");

            System.out.print("Введите второе числочисло: ");

            Double num_2 = in.nextDouble();
            LOG.log(Level.INFO, "user enterd number 2");


            System.out.print("Введите действие (+, -, *, /): ");

            String sign = in.next();

            LOG.log(Level.INFO, "user enterd action");



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

            LOG.log(Level.INFO, "output result");


            System.out.println("Если хотите выполнить вычилсение нажмите любую клавишу, если хотите выйти - введите 'br'");
            String  action= in.next();
            in.close();


            if(action.equals("br")){
                runner = false;
                LOG.log(Level.INFO, "user logged out");

            }
        }






        
    }
}
