import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        double temp, weight, age;
//
//        int months=2, days, years=3;
//
//        int a, b;
//        char c;

//        b = a + 2;
//        a = b * 4;
//        b = a / 3.14;
//        a = b - 8;
//        c = 'K';
//        c = 'B';

//        int w=5, x=4, y=8, z=2;
//        int result = x + y;
//        int result2 = z * 2;
//        int result3 = y/x;
//        int result4 = w % 2;
//
//
//        System.out.println(result);
//        System.out.pjn
//        rintln(result2);
//        System.out.println(result3);
//        System.out.println(result4);
//
//        System.out.println("Hearing in the distance ");
//        System.out.println("Two mandolins like creatures in the "); System.out.print("dark");
//        System.out.println(" Creating the agony of ecstasy.");
//        System.out.println(" - George Barker");
//
//        10 20 1
//        12
//        UpperCase

//        int speed =20, time = 10;
//        int distant = speed * time;
////
////        String message = "Have a great day!";
////        System.out.println(message.toUpperCase());

        //PROGRAMMING CHALLENGE
//        getUserInformation();
//        getNames();
//    if (True)
//    {
//
//    }
//    else if()
//    {
//
    }

    static void getUserInformation()
    {
        String name;
        int age;
        double annualPay;

        Scanner print = new Scanner(System.in);

        System.out.println("What is your name?");
        name = print.nextLine();

        System.out.print("How old are you? ");
        age = print.nextInt();

        System.out.print("What is your desired annual income? ");
        annualPay = print.nextDouble();

        System.out.printf("My name is %s, my age is %d and I hope to earn .2%f.", name, age, annualPay);

        print.close();

    }

    static void getNames(){
        String firstName, middleName, lastName;

        Scanner print = new Scanner(System.in);

        System.out.println("What is your first name? ");
        firstName = print.nextLine();

        System.out.println("What is your middle name and last name? ");
        lastName = print.nextLine();

        System.out.printf("%s, %s", firstName, lastName);
        print.close();

    }
}