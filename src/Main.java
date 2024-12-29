import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static boolean IdChecker(String id) {
        boolean flag = false;
        int sum =0;
        while(id.length() < 9){
            id = "0" + id;
        }
        System.out.println("The id you entered is " + id);
        if(id.length()!= 9){
            return false;
        }
        int [] digits = new int[9];
        for(int i = 0; i < 9; i++){
            digits[i] = id.charAt(i)-'0';
        }
        for(int i = 0; i < 9; i++){
            int number = digits[i];
            if(i % 2 == 1){
                number = number*2;
                if(number > 9){
                    number = number -9;
                }
            }
            sum = sum + number;
        }
        if(sum % 10 == 0){
            flag = true;
        }
        return flag;
    }
// works ^

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Enter your id");
            String id = sc.nextLine();
            if (IdChecker(id)) {
                System.out.println("your id is valid");
                flag = false;
            }
            else {
                System.out.println("your id is invalid");
            }
        }
    }
}
 //done with the id



