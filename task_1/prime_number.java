import java.sql.Array;
import java.util.ArrayList;

// Вывести все простые числа от 1 до 1000 




public class prime_number {
    public static void main(String[] args) {
        simple();
    }
    
    public static void simple() {
        // int count = 0;
        ArrayList simple_number_array = new ArrayList();
        for (int i = 1; i <= 1000; i ++) {
            int count = 0;
            for (int x = 1; x <= i; x ++) {
                if(i % x == 0) {
                    count += 1;
                }
            }
            if(count == 2){
                simple_number_array.add(i);

            }
        }
        System.out.println(simple_number_array);
    }
}
