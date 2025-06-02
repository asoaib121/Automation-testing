package OrangeHRM.com.tmb.dataprovider.latest;

import org.testng.annotations.DataProvider;

public class Employee {

    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @DataProvider
    public static Employee[] getData3() {
        return new Employee[]{
                new Employee("amuthan", "1234"),
                new Employee("testingminibytes", "2345")
        };
    }

}
