package mapper.Object;

@SuppressWarnings("All")
public class Employee { //POJO Class

   /* Conditions :-
    * Class must have a default constructor
    * Keys of Json String must match the Class
    * All fields must have a getter method
    * Same case of class fields and json keys
    */
    private String name;
    private String age;
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}
