package mapper.Object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ObjectMappers {
    private static final String JSON = "{\"name\":\"shubham\",\"age\":\"28\",\"department\":\"software\"}";
    private static final String JSON_COLLECTION = "[{\"name\":\"shubham\",\"age\":\"28\",\"department\":\"software\"}," +
                                                  "{\"name\":\"lovely\",\"age\":\"26\",\"department\":\"accounts\"}]";

    public static void main(String[] args) throws IOException {
        //Map to an object
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(JSON, Employee.class);
        System.out.println(employee);

        //Map to an Array
        Employee[] employees = objectMapper.readValue(JSON_COLLECTION, Employee[].class);
        for (Employee emp : employees) { System.out.println(emp); }
        //Map to a List
        List<Employee> newEmployees = objectMapper.readValue(JSON_COLLECTION, new TypeReference<>() {});
        for (Employee emp : newEmployees) { System.out.println(emp); }
        //Map to a map
        Map<String, String> employeeMap = objectMapper.readValue(JSON, new TypeReference<>() {});//use to map to a collection
        employeeMap.keySet().forEach( key -> {
            System.out.println("Key:"+key);
            System.out.println("Value:"+employeeMap.get(key));
        });
        //Json File to List of Employees
        InputStream iS = new FileInputStream("Employee.json");
        List<Employee> allEmployees = objectMapper.readValue(iS, new TypeReference<List<Employee>>() {});
        for (Employee emp : allEmployees) {
            System.out.println(emp);
        }
    }
}