/*Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.

Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */


import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class request {


    public static void main(String[] args) {
        setRequest();
    }

    public static void setRequest(){

        String str = "select * from students where";

        StringBuilder req = new StringBuilder(str);
        JSONParser parser = new JSONParser();

        try( FileReader reader = new FileReader("request.json")) {
            JSONObject requestJsonObject = (JSONObject) parser.parse(reader);
            String name = (String) requestJsonObject.get("name");
            System.out.println(name);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Parsing error" + e.toString());
        }
       
        
        // FileReader fr = new FileReader("request.json");
        // Object obj = new JSONParser().parse(fr);

        // Object obj = new JSONParser().parse(new FileReader("request.json"));
        // System.out.println(obj);


    }


    
}
