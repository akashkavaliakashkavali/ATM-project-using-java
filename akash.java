import java.util.Scanner;

class ATM {
    private double balance;
    private int pin = 1234;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

   
    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

   
    public void checkBalance() {
        System.out.println("Your current balance: ₹" + balance);
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid amount!");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
}

public class akash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(5000);  

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (atm.verifyPin(enteredPin)) {
            System.out.println("\n✅ Login Successful!\n");

            int choice;
            do {
                System.out.println("------ ATM MENU ------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = sc.nextDouble();
                        atm.deposit(depositAmt);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = sc.nextDouble();
                        atm.withdraw(withdrawAmt);
                        break;
                    case 4:
                        System.out.println("Thank you! Please take your card.");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
                System.out.println();

            } while (choice != 4);

        } else {
            System.out.println("❌ Incorrect PIN! Access Denied.");
        }

        sc.close();
    }
}
