import java.util.Scanner;

public class Account {
    double Balance;
    double previousTransaction;
    String CustName;
    String CustId;

    Account(String cname, String cid) {
        CustName = cname;
        CustId = cid;
    }

    void Deposit(double amount) {
        if (amount > 0) {
            Balance = amount + Balance;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount) {
        if (Balance >= amount) {
            Balance -= amount;
            previousTransaction = -amount;
        }
        else{
            System.out.println("You don't have sufficient balance!!!");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deosited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction Occured");
        }
    }

    void calculateInterest(int years) {
        double rate = 0.0123;
        double newbalance = (Balance * rate * years) + Balance;
        System.out.println("The current interets rate is: " + (100 * rate));
        System.out.println();
        System.out.println("After " + years + "years,your balance will be " + newbalance);
    }

    void mainMenu() {
        char option = '\0';
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome," + CustName + "!");
            System.out.println("Your ID is" + CustId);
            System.out.println();
            System.out.println("what would you like to do?");
            System.out.println();
            System.out.println("A. Check your Account Balance");
            System.out.println("B. Make a withdrawl");
            System.out.println("C. Make a deposit");
            System.out.println("D. View your Previous Transaction");
            System.out.println("E. Calculate Interest");
            System.out.println("F. Exit");
            System.out.println();

            do {
                System.out.println("Enter an option: ");
                char option1 = scanner.next().charAt(0);
                option = Character.toUpperCase(option1);
                System.out.println();
                switch (option) {
                    case 'A':
                        System.out.println("=============================");
                        System.out.println("Balance =$" + Balance);
                        System.out.println("=============================");
                        System.out.println();
                        break;

                    case 'B':
                        System.out.println("Enter an amount to deposit:");
                        double amount = scanner.nextDouble();
                        Deposit(amount);
                        System.out.println();
                        break;

                    case 'C':
                        System.out.println("Enter an amount to withdraw");
                        double amount2 = scanner.nextDouble();
                        withdraw(amount2);
                        System.out.println();
                        break;

                    case 'D':
                        System.out.println("==============================");
                        getPreviousTransaction();
                        System.out.println("==============================");
                        System.out.println();
                        break;

                    case 'E':
                        System.out.println("Enter the number of years");
                        int years = scanner.nextInt();
                        calculateInterest(years);
                        System.out.println();
                        break;

                    case 'F':
                        System.out.println("===============================");
                        break;

                    default:
                        System.out.println("Invalid option!!Please enter the valid options A,B,C,D,E,F");
                        break;
                }

            } while (option != 'F');
        }
        System.out.println("ThankYou for banking with us!");
    }
}
