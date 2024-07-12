import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// public class July_9 {
//   public static void main(String[] args) {
//     // Set<String> set = new LinkedHashSet<>();
//     // set.add("Apple");
//     // set.add("Banana");
//     // set.add("Cherry");
//     // set.add("Apple"); // Duplicate element

//     // System.out.println("Set contains: " + set);
//     // System.out.println("Set size: " + set.size());
//     // System.out.println("Set contains 'Banana': " + set.contains("Banana"));

//     // set.remove("Banana");
//     // System.out.println("Set after removing 'Banana': " + set);

//     // set.clear();
//     // System.out.println("Set after clear: " + set);

//     // LinkedList
//     LinkedList<String> linkedList = new LinkedList<>();

//     // // Adding elements to the linked list
//     // linkedList.add("Apple");
//     // linkedList.add("Banana");
//     // linkedList.add("Cherry");
//     // linkedList.add("Date");

//     // Displaying the linked list
//     // System.out.println("Linked List:");
//     // System.out.println(linkedList);

//     // Adding elements at specific positions
//     // linkedList.add(2, "Grape");
//     // linkedList.addFirst("Kiwi");

//     // // Displaying the updated linked list
//     // System.out.println("\nUpdated Linked List:");
//     // System.out.println(linkedList);

//     // // Removing elements
//     // linkedList.remove("Banana");
//     // linkedList.removeFirst();
//     // linkedList.removeLast();

//     // // Displaying the final linked list
//     // System.out.println("\nFinal Linked List:");
//     // System.out.println(linkedList);

//     // Deque<String> queue = new ArrayDeque<>();

//     // // Adding elements to the queue
//     // queue.push("Apple");
//     // queue.offer("Banana");
//     // queue.offer("Cherry");
//     // System.out.println(queue);

//   }
// }

// ***********************************************************************************************************
public class July_9 {

  public static int fact(int n) {
    if (n == 0 || n == 1)
      return 1;

    return fact(n - 1) * n;
  }

  public static int fib(int n){
      if(n==1 || n==2) return n-1;
      return fib(n-1)+fib(n-2);
  }

  public static void main(String[] args) {
    // Recursion Example- 1 Factorial of Number Recursively

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    // System.out.println(fact(n));

    // Print n terms of fibanacci series 
       for(int i=1; i<=n; i++){
        System.out.println(fib(i));
       }
  }
}