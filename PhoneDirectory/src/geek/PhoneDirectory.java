package geek;

import java.io.*;
import java.util.*;

public class PhoneDirectory {

    private static HashMap<String, String> pd = new HashMap<String, String>();

    //addSub - добавляет запись по заданным фамилии и номеру
    private static void addSub(String name, String phone) {
        pd.put(name, phone);
    }

    //delPD - удаляет запись по номеру телефона
    private static void delPD(String phone) {
        pd.remove(phone);
    }

    //savePD - сохраняет БД в файле phone.txt
    private static void savePD() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for(Map.Entry<String,String> k: pd.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }

    //loadPD - загружает БД из файла phone.txt
    //производит проверку на наличие файла
    public static void loadPD() throws IOException {
        File file = new File("phone.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                pd.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    public static void PrintPhoneDir(){
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,String> k: pd.entrySet()){
            System.out.println(k.getKey()+": "+ k.getValue());
        }
    }

    //FindSurname - производит поиск фамилии по номеру телефона заданому в качестве аргумента
    //возвращает строку
    public static String FindSurname(String number){
        String result = pd.get(number);

//        сюда нужно добавить разбор намбер на массив значений если телефонов больше одного

        if (result == null) return "абонент с таким номером не найдей";
        return result;
    }

    //FindNumberPhone - производит поиск списка номеров по фамилии заданой в качестве аргумента
    //возвращает массив строк
    public static String[] FindNumberPhone(String surname){
        List<String> result = new ArrayList<String>();
        for (Map.Entry entry : pd.entrySet()) {
            if (surname.equalsIgnoreCase((String)entry.getValue())){
                result.add((String)entry.getKey());
            }
        }
        if (result.size() == 0) result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        //переменная описывает вызываемое действие
        String act;

        //загрузка БД
        loadPD();
        //вывод записей на экран
        PrintPhoneDir();

        //вывод на екран описания возможных действий с указанием команд
        System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (number) найти номера по фамилии, (surname)найти фамилию, (phDir) вывести справочник" +
                "(save)сохранить, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while(!act.equals("exit")){
            //добавление записи
            if(act.equals("add")){
                System.out.println("Введите фамилию:");
                String name = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                addSub(name, phone);
            }else{
                //удаление записи
                if(act.equals("del")){
                    System.out.println("Введите телефон:");
                    String phone = bf.readLine();
                    delPD(phone);
                }else{
                    //поиск номеров по фамилии
                    if (act.equals("number")){
                        System.out.println("Введите фамилию:");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {
                        //поиск фамилии по номеру
                        if (act.equals("surname")) {
                            System.out.println("Введите номер:");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        } else {
                            if(act.equals("phDir")) {
                                PrintPhoneDir();
                            } else {

                                //сохранение БД в файл

                                if (act.equals("save")) {
                                    savePD();
                                }
                            }
                        }
                    }
                }

            }
            //запрос на следующее действие
            System.out.println("выборите действие: (add)добавить абонента, (number) найти номера по фамилии, (surname) найти фамилию, (save)сохранить, (exit)выход");
            act=bf.readLine();
        }
    }
//    private static Logger LOG = Logger.getLogger(calculator.class.getName());
//
//    FileHandler fh = new FileHandler("calc_log.txt", true);
//    SimpleFormatter sf = new SimpleFormatter();
//        fh.setFormatter(sf);
//        LOG.addHandler(fh);
//
//    public static void add(String name, Integer phoneNumber){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Ведите данные абонента в формате 'ФИО, +7хххххххххх': ");
//
//    }
}
