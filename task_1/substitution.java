//  Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком 
// вопроса, например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
//  Предложить хотя бы одно решение или сообщить, что его нет. 24 45 //24 + 45 = 69 (n=4)

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class substitution {
    public static void main(String[] args) {
        equation();
    }

    public static void equation() {
        String descript = "введите математическое выражение вида x+y=z,\n которое может иметь вид 5?+?3=98: ";
        System.out.print(descript);
        Scanner in = new Scanner(System.in);
        String name = in.next();

        in.close();

        int finalNumber = 0;
        String resultExpression = "";// переменная для хранения результирующего выражения 
        boolean check = false;// переменная для хранения результата проверки на наличие правлиьного равенства
    
        for (int i=0; i <=9; i++) { //цикл для подстановки цифры вместо знака вопроса и перебора вариантов
    
            char str = (char) (i + '0'); //перевод int в char
            // System.out.println(str);
            resultExpression = name.replace('?', str ); //подмена ? на переменную со значением i
    
            Pattern pattern = Pattern.compile("\\d+"); // переменная с регуляркой для сравнения
            Matcher matcher = pattern.matcher(resultExpression); // задание искомого выражения где искать совпадения
    
            String[] operandArray = new String[3]; // массив для записи совпадений
            
            int num = 0; // переменная для прохода по циклу while и записи в массив с определнным индексом
       
            while(matcher.find()) { //пока совпадение находится (true), то выполняется условие
                operandArray[num] = matcher.group();
                num +=1;
            }
    
            int a = Integer.parseInt(operandArray[0]); //переменные с переведенным в int  значением элементов массива
            int b = Integer.parseInt(operandArray[1]);
            int c = Integer.parseInt(operandArray[2]);
            
            if (a + b == c) { // если условие выполняется то check - истина и подходящее число - finalNumber, и прерывание цикла
                check = true;
                finalNumber = i;
                break;
            }
        }
    
        if (check) { //если check - истина, то выводим этот результат
            System.out.println("Число при котором выполняется равенство: " + finalNumber);
            System.out.println("Верное равенство: " + resultExpression);

        }
    
        else { // если нет подходящего значения, то
            System.out.println("Число, при котором верно равенство, не найдено. ");
    
        }
    
    
    
    }
    
    
    
}
