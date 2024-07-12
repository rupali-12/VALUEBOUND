
// // ***************Exercise - 20 : Milliseconds to Days, Hours, Min**************************

// import java.util.Scanner;

// public class AllCodingProblems {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         long t, hours, mins, seconds, millis;
//         final long max = 9999999999L;
//         do {
//             System.out.println("Enter number in milliseconds (between 0 and " + max + "):");
//             t = sc.nextLong();
//         } while (t < 0 || t > max);

//         // Closing the Scanner object
//         sc.close();
//         millis = t % 1000;
//         t /= 1000; // t in seconds

//         seconds = t % 60;
//         t /= 60; // t in mins

//         mins = t % 60;
//         t /= 60; // t in hours

//         hours = t % 24;
//         long days = t / 24; // t in days

//         System.out.println("Days: " + days);
//         System.out.println("Milliseconds: " + millis);
//         System.out.println("seconds: " + seconds);
//         System.out.println("Minutes: " + mins);
//         System.out.println("Hours: " + hours);
//     }
// }

// // Exercise 21 - Data Validation

// import java.util.Scanner;

// public class AllCodingProblems {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num = sc.nextInt();

//         int year = num % 10000;
//         num /= 10000;
//         int month = num % 100;
//         num /= 100;
//         int date = num;
//         System.out.println("Date: " + date + "-" + month + "-" + year);
//     }
// }

// Excersie - 25 

// import java.util.Scanner;

// public class AllCodingProblems {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num1 = sc.nextInt();
//         int num2 = sc.nextInt();
//         if (num1 % num2 != 0) {
//             System.out.println("-1");
//             return;
//         }
//         int count = 0;
//         while (num1/num2!=0 && num1 % num2 == 0) {
//             count++;
//             num1 = num1 / num2;
//         }
//         System.out.println(count);
//     }
// }

// Exercise: Sum triangle  
// import java.util.Arrays;
// import java.util.Scanner;

// public class AllCodingProblems {
//     public static void printTriangle(int[] arr) {
//         if (arr.length < 1)
//             return;

//         int temp[] = new int[arr.length - 1];
//         for (int i = 0; i < arr.length - 1; i++) {
//             temp[i] = arr[i] + arr[i + 1];
//         }

//         printTriangle(temp);
//         System.out.println(Arrays.toString(arr));

//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         printTriangle(arr);

//     }
// }

// Exercise : Reverse 
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class AllCodingProblems {

    public static void Insert_At_Bottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int a = st.peek();
        st.pop();
        Insert_At_Bottom(st, x);
        st.push(a);
    }

    public static void reverse(Stack<Integer> st) {
        if (st.size() > 0) {
            int a = st.peek();
            st.pop();
            reverse(st);

            Insert_At_Bottom(st, a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }
}