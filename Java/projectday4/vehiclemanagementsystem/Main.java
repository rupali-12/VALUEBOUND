import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleInsuranceSystem system = new VehicleInsuranceSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vehicle Insurance Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Add Policy");
            System.out.println("4. Add Claim");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. Find Vehicle by Registration Number");
            System.out.println("7. Find Policy by Number");
            System.out.println("8. Find Claim by Number");
            System.out.println("9. Print all Customers");
            System.out.println("10. Print all Vehicles");
            System.out.println("11. Print all Policies");
            System.out.println("12. Print all Claims");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Customer Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    Customer customer = new Customer(id, name, address, phoneNumber);
                    system.addCustomer(customer);
                    break;
                case 2:
                    System.out.print("Enter Vehicle Registration Number: ");
                    String regNumber = scanner.nextLine();
                    System.out.print("Enter Vehicle Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Vehicle Manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    Vehicle vehicle = new Vehicle(regNumber, model, manufacturer);
                    system.addVehicle(vehicle);
                    break;
                case 3:
                    System.out.print("Enter Policy Number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter Customer ID: ");
                    int custId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer cust = system.findCustomerById(custId);
                    System.out.print("Enter Vehicle Registration Number: ");
                    String vehRegNumber = scanner.nextLine();
                    Vehicle veh = system.findVehicleByRegNumber(vehRegNumber);
                    System.out.print("Enter Policy Start Date (YYYY-MM-DD): ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Policy End Date (YYYY-MM-DD): ");
                    LocalDate endDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Premium Amount: ");
                    double premium = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    InsurancePolicy policy = new InsurancePolicy(policyNumber, cust, veh, startDate, endDate, premium);
                    system.addPolicy(policy);
                    break;
                case 4:
                    System.out.print("Enter Claim Number: ");
                    String claimNumber = scanner.nextLine();
                    System.out.print("Enter Policy Number: ");
                    String polNumber = scanner.nextLine();
                    InsurancePolicy pol = system.findPolicyByNumber(polNumber);
                    System.out.print("Enter Claim Date (YYYY-MM-DD): ");
                    LocalDate claimDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Claim Amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Claim Status: ");
                    String status = scanner.nextLine();
                    InsuranceClaim claim = new InsuranceClaim(claimNumber, pol, claimDate, claimAmount, status);
                    system.addClaim(claim);
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    int custIdToFind = scanner.nextInt();
                    Customer foundCustomer = system.findCustomerById(custIdToFind);
                    if (foundCustomer != null) {
                        System.out.println(foundCustomer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Vehicle Registration Number: ");
                    String vehRegNumberToFind = scanner.nextLine();
                    Vehicle foundVehicle = system.findVehicleByRegNumber(vehRegNumberToFind);
                    if (foundVehicle != null) {
                        System.out.println(foundVehicle);
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter Policy Number: ");
                    String polNumberToFind = scanner.nextLine();
                    InsurancePolicy foundPolicy = system.findPolicyByNumber(polNumberToFind);
                    if (foundPolicy != null) {
                        System.out.println(foundPolicy);
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter Claim Number: ");
                    String claimNumberToFind = scanner.nextLine();
                    InsuranceClaim foundClaim = system.findClaimByNumber(claimNumberToFind);
                    if (foundClaim != null) {
                        System.out.println(foundClaim);
                    } else {
                        System.out.println("Claim not found.");
                    }
                    break;
                case 9:
                    system.printAllCustomers();
                    break;
                case 10:
                    system.printAllVehicles();
                    break;
                case 11:
                    system.printAllPolicies();
                    break;
                case 12:
                    system.printAllClaims();1
                    
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
