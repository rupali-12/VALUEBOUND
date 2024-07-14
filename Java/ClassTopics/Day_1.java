
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

// // Exercise 5 - Prime number from 1 to n
// import java.util.*;

// public class Day_1 {
//     static void seive(boolean[] isPrime, int n) {
//         isPrime[0] = false;
//         isPrime[1] = false;
//         for (int i = 2; i * i <= n; i++) {
//             if (isPrime[i]) {
//                 for (int j = i * i; j <= n; j += i) {
//                     isPrime[j] = false;
//                 }
//             }
//         }
//         return;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         boolean isPrime[] = new boolean[n + 1];
//         Arrays.fill(isPrime, true);
//         seive(isPrime, n);
//         for (int i = 1; i <= n; i++) {
//             if (isPrime[i]) {
//                 System.out.println(i + " ");
//             }
//         }
//     }

// }

// **************************************SECTION_6 ******************************************** 
// // 24. Exercise 6 - Sum of Array Elements

// import java.util.ArrayList;
// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         // ArrayList<Integer> arraylist = new ArrayList<>();
//         // while (sc.hasNextInt()) {
//         // int num = sc.nextInt();
//         // arraylist.add(num);
//         // }

//         // Integer[] arr = arraylist.toArray(new Integer[0]);
//         // for (int n : arr) {
//         // System.out.println(n + " ");
//         // }
//         int n = sc.nextInt();
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += sc.nextInt();
//         }
//         System.out.println(sum);

//     }
// }

// // 25. Exercise 7 - Average of Array Elements
// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += sc.nextInt();
//         }
//         System.out.println(sum/n);

//     }
// }

// // 26. Exercise 8 - Remove Element from Array
// import java.lang.reflect.Array;
// import java.util.*;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         int indexToRemove = sc.nextInt();
//         if (indexToRemove >= n || indexToRemove < 0) {
//             System.out.println("Enter between 0 to n-1");
//             indexToRemove = sc.nextInt();
//         }
//         int newArray[] = new int[n - 1];

//         // Print before removal
//         System.out.println("Before - " + Arrays.toString(arr));

//         for (int i = 0, j = 0; i < arr.length; i++) {
//             if (i != indexToRemove) {
//                 newArray[j++] = arr[i];
//             }
//         }
//         System.out.println("After - " + Arrays.toString(newArray));
//     }
// }

// // 27. Exercise 9 - Insert Element into Array
// import java.lang.reflect.Array;
// import java.util.*;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         int indexToRemove = sc.nextInt();
//         if (indexToRemove > n || indexToRemove < 0) {
//             System.out.println("Enter between 0 to n");
//             indexToRemove = sc.nextInt();
//         }
//         int elementToBeInserted = sc.nextInt();
//         int newArray[] = new int[n + 1];

//         // Print before removal
//         System.out.println("Before - " + Arrays.toString(arr));

//         for (int i = 0, j = 0; i < n+1; i++) {
//             if (i== indexToRemove) {
//                 newArray[i] = elementToBeInserted;
//             }
//             else{
//                 newArray[i] =  arr[j++];
//             }
//         }
//         System.out.println("After - " + Arrays.toString(newArray));
//     }
// }

// // 28. Exercise 10 - Min & Max in Array
// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         int mxElement = Integer.MIN_VALUE, mnElement = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//             mxElement = Math.max(mxElement, arr[i]);
//             mnElement = Math.min(mnElement, arr[i]);
//         }
//         System.out.println("Min = " + mnElement);
//         System.out.println("Max = " + mxElement);
//     }
// }

// // 29. Exercise 11 - Reverse Array Elements
// import java.util.Arrays;
// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         for (int i = 0; i < n / 2; i++) {
//             int temp = arr[i];
//             arr[i] = arr[n - i - 1];
//             arr[n - i - 1] = temp;
//         }
//         System.out.println(Arrays.toString(arr));
//     }
// }

// 30. Exercise 12- Find Duplicates in Array
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Scanner;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         HashMap<Integer, Integer> mp = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//             if (!mp.containsKey(arr[i])) {
//                 mp.put(arr[i], 0);
//             }
//             mp.put(arr[i], mp.get(arr[i]) + 1);
//         }

//         for (Integer key : mp.keySet()) {
//             if (mp.get(key) == 2) {
//                 System.out.println(key);
//             }
//         }
//     }
// }

// // 31. Exercise 13 - Rotate Array ClockWise
// import java.util.*;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         int k = sc.nextInt();
//         int aux[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             aux[(i + k) % n] = arr[i];
//         }

//         System.out.println(Arrays.toString(aux));

//     }
// }

// // 32. Exercise 14 - Count spaces, digits and char in String
// import java.util.*;

// public class Day_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String str = sc.nextLine();
//         int countSpace = 0, countDigit = 0, countChar = 0;
//         for (int i = 0; i < str.length(); i++) {
//             char ch = str.charAt(i);
//             if (ch == ' ')
//                 countSpace++;
//             else if (Character.isDigit(ch))
//                 countDigit++;
//             else if (Character.isLetter(ch))
//                 countChar++;
//         }
//         System.out.println("Spaces = " + countSpace);
//         System.out.println("Characters = " + countChar);
//         System.out.println("Digits = " + countDigit);
//     }
// }

// 33. Exercise 15 - Reverse String

import java.util.Scanner;

public class Day_1 {
    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // Approach -1
        // String revString = "";
        // for (int i = str.length() - 1; i >= 0; i--) {
        // revString += str.charAt(i);
        // }
        // System.out.println(revString);

        // Approach-2: using String builder
        System.out.println(reverseString(str));
    }
}
