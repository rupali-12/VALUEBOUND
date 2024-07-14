ublic class Day_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // consume nextline
        sc.nextLine();
        String str = sc.nextLine();
        String numAsString = Integer.toString(num);
        int StringAsNum = Integer.parseInt(str);
        System.out.println(numAsString);
        System.out.println(StringAsNum);
    }
}