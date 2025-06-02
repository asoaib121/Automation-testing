package selenium_java;

//import org.assertj.core.api.Assertions;
////import org.junit.Test;
//import org.assertj.core.data.Offset;
//import org.assertj.core.data.Percentage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import java.sql.DriverManager;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Testmethod1 {
//
//
//    static class Employee {
//        int id;
//        String name;
//        int age;
//
//        public Employee(int id, String name, int age) {
//            this.id = id;
//            this.name = name;
//            this.age = age;
//        }
//    }
//
//    @Test
//    public void customClassTest() {
//        Employee emp1 = new Employee(25, "sathin", 100);
//        Employee emp2 = new Employee(25, "sachin", 100);
//
//        Assertions.assertThat(emp1)
//                .isEqualToComparingFieldByField(emp2)
//                .isNotNull()
//                .isInstanceOf(Employee.class)
//                .hasFieldOrProperty("age")
//                .hasFieldOrPropertyWithValue("name", "sachin")
//                .extracting(e -> e.age).isNotEqualTo(24);
//    }
//
//    @Test
//    public void stringTest() {
//        String temp = "Hello World";
//        String a="";
//        String b=" ";
//
//        //use decleared variable like temp,a,b
//        Assertions.assertThat(temp)
//                .isNotNull()
//                .as("String is actually empty").isNotEmpty()
//                .as("String is actually blank").isNotBlank()
//                .isEqualTo("Hello World")
//                .contains("Hello")
//                .doesNotContain("Hi")
//                .containsWhitespaces()
//                .containsIgnoringCase("world")
//                .matches("\\w.* World")
//                .doesNotContainPattern("\\d.*")
//                .hasSize(11)
//                .hasSizeGreaterThan(10)
//                .hasSizeLessThan(20)
//                .hasSizeBetween(10, 20)
//                .endsWith("World");
//
//        System.out.println("All assertions passed!");
//    }
//
//    @Test
//    public void numbersTest() {
//        int a = 10;
//
//        Assertions.assertThat(a)
//                .isEqualTo(10)
//                .isCloseTo(16, Offset.offset(5)) // 10 +- 5 --> 5-15 (Should be 11-15, but there's a typo in the comment)
//                .isInstanceOf(Integer.class)
//                .isBetween(3, 15)
//                .isCloseTo(12, Percentage.withPercentage(30)) // 7 - 13
//                .isNotCloseTo(15, Percentage.withPercentage(30))
//                .isPositive()
//                .isEven()
//                .isGreaterThanOrEqualTo(5)
//                .isLessThanOrEqualTo(20);
//    }
//    @Test
//    public void listTest() {
//        List<String> list = Arrays.asList("Testing", "Mini", "Bytes");
//        List<String> list2 = Arrays.asList("Testing", "Mini");
//        List<String> list3 = Arrays.asList("Automation", "selenium");
//
//        Assertions.assertThat(list)
//                .hasSize(3)
//                .hasSizeBetween(2, 15)
//                .hasAtLeastOneElementOfType(String.class)
//                .isNotEmpty()
//                .contains("Testing")
//                .doesNotContain("Automation")
//                .startsWith("Testing")
//                .containsExactlyInAnyOrder("Mini", "Testing", "Bytes")
//                .withFailMessage(() -> "String is not having size less than 3").allMatch(s -> s.length() < 10) // Corrected the condition
//                .containsAll(list2)
//                .doesNotContainAnyElementsOf(list3);
//    }
//
//    @Test
//    public void mapTest() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("name", "Amuthan");
//        map.put("channel", "Testing mini bytes");
//        map.put("game", "cricket");
//
//        Assertions.assertThat(map)
//                .containsEntry("name", "Amuthan")
//                .hasSize(3)
//                .isNotEmpty()
//                .doesNotContainEntry("fav", "football")
//                .doesNotContainKey("Game")  // Corrected typo: doesNoi Containkey -> doesNotContainKey
//                .containsKey("channel")
//                .containsValue("cricket");
//    }
//
//    @Test
//    public void dateTimeTest() {
//        LocalDate date = new LocalDate(2000, 1, 1); // org.joda.time.LocalDate
//
//        Assertions.assertThat(date)
//                .hasYear(2000)
//                .hasMonthOfYear(1)
//                .hasDayOfMonth(1)
//                .isBefore(new LocalDate(2000, 1, 2))
//                .isBefore("2000-01-02")
//                .isBeforeOrEqualTo(new LocalDate(2000, 1, 1))
//                .isBeforeOrEqualTo("2000-01-01")
//                .isBeforeOrEqualTo(new LocalDate(2000, 1, 2))
//                .isBeforeOrEqualTo("2000-01-02")
//                .isEqualTo(new LocalDate(2000, 1, 1))
//                .isEqualTo("2000-01-01")
//                .isAfterOrEqualTo(new LocalDate(2000, 1, 1))
//                .isAfterOrEqualTo("2000-01-01")
//                .isAfterOrEqualTo(new LocalDate(1999, 12, 31))
//                .isAfterOrEqualTo("1999-12-31")
//                .isAfter(new LocalDate(1999, 12, 31))
//                .isAfter("1999-12-31")
//                .isNotEqualTo("2000-01-15")
//                .isNotEqualTo(new LocalDate(2000, 1, 15))
//                .isIn(new LocalDate(1999, 12, 31), new LocalDate(2000, 1, 1))
//                .isIn("1999-12-31", "2000-01-01")
//                .isNotIn(new LocalDate(1999, 12, 31), new LocalDate(2000, 1, 2))
//                .isNotIn("1999-12-31", "2000-01-02");
//    }
//    @Test
//    public void test3() {
//        // Assuming DriverManager.getDriver() returns a WebDriver instance
//        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes Youtube", Keys.ENTER);
//        String title = DriverManager.getDriver().getTitle();
//
//        Assertions.assertThat(title)
//                .as("Object is actually null").isNotNull()
//                .as("It does not contain expected text").containsIgnoringCase("google search")
//                .matches("\\w.*google search")
//                .hasSizeBetween(15, 100);
//
//        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
//        int checkElement=elements.size();
//        Assertions.assertThat(elements)
//                .hasSize(10)
//                .extracting(WebElement::getText) // Method reference to getText
//                .contains("Testing Mini Bytes YouTube");
//
//        Assertions.assertEquals(10, checkElement); // Use Assertions from JUnit 5
//
//        boolean isElementPresent = false;
//        for (WebElement element : elements) {
//            if (element.getText().equalsIgnoreCase("Testing Mini Bytes YouTube")) {
//                isElementPresent = true;
//                break;
//            }
//        }
//        Assertions.assertTrue(isElementPresent, "Testing mini bytes not found"); // Use Assertions from JUnit 5
//    }
//
//}