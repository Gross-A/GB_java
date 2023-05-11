// import java.lang.reflect.Array;
// import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

// import java.util.logging.Logger;
// import java.util.logging.Level;

// import java.util.logging.SimpleFormatter;

public class sort {

    private static Logger log = Logger.getLogger(sort.class.getName());

  
    public static void main(String[] args) throws IOException{
       
        FileHandler fh = new FileHandler("log.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        log.addHandler(fh);

        arraySort();

    }

    public static void arraySort() {

        //запрашиваем у пользователя ввод данных
        System.out.println("введите массив чисел через запятую: ");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        log.info("user entered data"); // логируем окончание ввода
        
        String[] textArray = text.split(","); // переводим введенную строку в массив строк, разделенных ,
        int[] finArray; 
        finArray = new int[textArray.length]; // назначаем переменную - массив с длиной, равной длине массива строк
        
        // каждый элемент массива строк пытаемся преобразовать к числу и присвоить число
        // элементу массива чисел.
        // при удачной попытке идет запись в массив, при исключении - записсывается в лог

        for(int i = 0; i < textArray.length; i++) {
           try {
            finArray[i] = Integer.parseInt(textArray[i]);//Character.digit(textArray[i], 10);
           } catch (Exception e) {
            log.log(Level.INFO,"Got an exeption", e);
           } 
        }
        log.log(Level.INFO, "data converted into an array of numbers");

        int b;
        int a;
        int count = finArray.length - 1;
        
        // для пузырьковой сортировки проходимся по массиву длина-2 раза 

        while(count != 0) {
            for (int i = 1; i <= count; i++) {
                b = finArray[i];
                a = finArray[i-1];
                if (b < a) {
                
                    finArray[i-1] = b;
                    finArray[i] = a;
                }
            String str = "check" + i;
            log.log(Level.INFO, str);

            }
            count = count - 1;
        }

        log.log(Level.INFO, "array sorted");

        for(int j=0; j< finArray.length; j++) {
            System.out.println(finArray[j]);
        }
        scanner.close();

    }

}
