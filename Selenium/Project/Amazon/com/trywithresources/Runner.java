//package Amazon.com.trywithresources;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class Runner {
//    public static void main(String[] args) {
//        readExcelData();
//    }
//
//    private static void readExcelData() {
//        FileInputStream fip=null;
//        try {
//            fip =new FileInputStream("");
//            //writing some code to read from excel --> exception //io exception
//        } catch (FileNotFoundException e) {
//           e.printStackTrace();
//        }finally {
//            try {
//                fip.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
