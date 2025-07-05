//package Amazon.exceptions;
//
//import lombok.SneakyThrows;
//
//import javax.imageio.stream.FileImageInputStream;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class ExceptionDemo {
//    public static void main(String[] args) { //testmanager  // top level logging
//        a();
//    }
//    private static void a() {   //test lead //medium level logging
//        b();
//        c();
//    }
////sneaky use one time,,this line not use video course
//    @SneakyThrows
//    private static void b() {   //fresher1  //bottom level logging
//        try {
//            FileImageInputStream file = new FileImageInputStream(new File(""));//2nd new file system use one time
//        }catch (FileNotFoundException e) {
//           throw new RuntimeException();
//        }
//    }
//
//    private static void c() {   //fresher2
//            throw new RuntimeException();
//
//    }
//}