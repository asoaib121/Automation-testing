//package Amazon.exceptions;
//
//public class ExceptionDemoTest {
//
//    public static void main(String[] args) {
//        checkPin();
//        withdrawMoney();
//    }
//
//    private static void withdrawMoney() {
//        if(checkSufficientMoneyInAtm() && checkDenominationAvailable() && checkBalanceAvailableInAccount()) {
//            System.out.println("cash dispensed");
//        }else {
//            throw new RuntimeException("Denomination of 100 is not available");
//        }
//    }
//
//    private static boolean checkSufficientMoneyInAtm() {
//return true;
//    }
//
//    private static boolean checkDenominationAvailable() {
//  return false;
//    }
//
//    private static boolean checkBalanceAvailableInAccount() {
//       return true;
//    }
//
//    private static void  checkPin() {
//        throw new RuntimeException("Incorrect password");
//    }
//}
