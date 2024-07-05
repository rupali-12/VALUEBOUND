
// // ****************SECTION_2 ********************************* 

// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         // System.out.println("mdkmc");
//         // int a = 10;
//         // System.out.println(a >> 2);
//         // System.out.println(a << 2);

//         float weight, height;
//         Scanner sc = new Scanner(System.in);
//         weight = sc.nextFloat();
//         height = sc.nextFloat();

//         float bmi = weight / (height * height);
//         System.out.println(bmi);
//     }
// }

// ************************SECTION_4 ************************************
// // Exercise 1 - Factorial of Number

// import java.util.Scanner;

// public class Day_1 {
//     static int fact(int num) {
//         if (num == 0 || num == 1)
//             return 1;
//         return fact(num - 1) * num;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num = sc.nextInt();
//         System.out.println(fact(num));

//     }
// }

// // Exercise 2 - Compare 2 numbers

// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = sc.nextInt();
//         int b = sc.nextInt();
//         boolean ans = a < b;
//         System.out.println("Is a less than b - " + ans);
//     }
// }

// // Exercise 3 - Sum of Digits
// import java.util.Scanner;

// public class Day_1 {
//     static int getSumOfDigit(int num){
//         int sum=0;
//         while(num!=0){
//            sum+= num%10;
//            num/=10;
//         }
//         return sum;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num = sc.nextInt();
//         System.out.println(getSumOfDigit(num));
//     }
// }

// // Exercise 4 - String to int and int to String conversion
// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num = sc.nextInt();
//         // consume nextline
//         sc.nextLine();
//         String str = sc.nextLine();
//         String numAsString = Integer.toString(num);
//         int StringAsNum = Integer.parseInt(str);
//         System.out.println(numAsString);
//         System.out.println(StringAsNum);
//     }
// }

// Exercise 5 - Prime number from 1 to n
import java.util.*;

public class Day_1 {
    static void seive(boolean[] isPrime, int n) {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        seive(isPrime, n);
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i + " ");
            }
        }
    }

}
