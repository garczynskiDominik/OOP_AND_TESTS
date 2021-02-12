package edu.domgie.sda.homework2;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) throws IOException {
        Bank loyds = new Bank("Loyds Bank UK");
        Scanner scanner = new Scanner(System.in);
        Path inputPath = Paths.get("C:\\Users\\xxx\\Desktop\\Customers.txt");

        //String giveFirstName = "Please give your first name.";
        // String giveLastName = "Please give me your last name";


        new ReaderCustomerFromFile().readCustomerFromFile(loyds, inputPath);
        //new ReaderCustomerFromFile().readCustomerFromFileV2(loyds, inputPath);

        System.out.println("Hello in Loyds Bank UK. How Can i Help You?\n");
        String answerBackToMainMenu;
        do {
            System.out.println(
                    "1. Add new customer to The Bank.\n" +
                            "2. Open a new account customer.\n" +
                            "3. Deposit money to account.\n" +
                            "4. Withdraw money from account.\n" +
                            "5. Delete customer without money\\acount.\n" +
                            "6. Show details.");
            int answerToMainMenu = scanner.nextInt();

            switch (answerToMainMenu) {
                case 1: {
                    addNewCustomer(loyds, scanner);
                    break;
                }
                case 2: {
                    openNewAccount(loyds, scanner);
                    break;
                }
                case 3: {
                    depositMoney(loyds, scanner);
                    break;
                }
                case 4: {
                    withdrawMoney(loyds, scanner);
                    break;
                }
                case 5: {
                    deleteCustomerOrAccount(loyds, scanner);
                    break;

                }
                case 6: {
                    System.out.println("What you want to display?");
                    System.out.println(
                            "1. All customers with details,\n" +
                                    "2. All customers without balance.\n" +
                                    "3. Customer accounts with details.\n" +
                                    "4. Customer account without balance.\n" +
                                    "5. All accounts in Bank with details.\n" +
                                    "6. All accounts in bank without balance.");
                    int answerToShowMenu = scanner.nextInt();
                    switch (answerToShowMenu) {
                        case 1: {
                            loyds.showCustomersAccountsWithBalance(true);
                            break;
                        }
                        case 2: {
                            loyds.showCustomersAccountsWithBalance(false);
                            break;
                        }
                        case 3: {
                            showCustomerDetails(loyds, scanner, true);
                            break;
                        }
                        case 4: {
                            showCustomerDetails(loyds, scanner, false);
                            break;
                        }
                        case 5: {
                            loyds.showAllAccountsFromBankWithBalance(true);
                            break;
                        }
                        case 6: {
                            loyds.showAllAccountsFromBankWithBalance(false);
                            break;
                        }
                        default: {
                            System.out.println("Wrong choice1111");
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Wrong choice222");
                }
            }
            System.out.println("Do You want back to Main menu? Y/N");
            answerBackToMainMenu = scanner.next();
        } while (answerBackToMainMenu.equalsIgnoreCase("Y"));
    }

    private static void showCustomerDetails(Bank loyds, Scanner scanner, boolean b) {
        System.out.println("Please give your first name.");
        String firstname = scanner.next();
        System.out.println("Please give me your last name");
        String lastName = scanner.next();
        loyds.showAccountOneCustomer(firstname, lastName, b);

    }

    private static void deleteCustomerOrAccount(Bank loyds, Scanner scanner) {
        System.out.println("Who you want to delete?");
        System.out.println("Please give your first name.");
        String firstname = scanner.next();
        System.out.println("Please give me your last name");
        String lastName = scanner.next();
        System.out.println("If " + firstname + " " + lastName + " don't have money on account or don't have account, will be delete");
        loyds.removeCustomerWihoutAccountsFromBank(firstname, lastName);
        loyds.removeAccountWithoutMoneyFromCustomer(firstname, lastName);

    }

    private static void withdrawMoney(Bank loyds, Scanner scanner) {
        System.out.println("From whose account you want to withdraw money?");
        System.out.println("Please give your first name.");
        String firstname = scanner.next();
        System.out.println("Please give me your last name");
        String lastName = scanner.next();
        System.out.println("Which account you want to withdraw money from? (Personal, Saving)");
        String typeOfAccount = scanner.next();
        System.out.println("What amount do you withdraw?");
        BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());
        loyds.withDraw(firstname, lastName, typeOfAccount, amount);

    }

    private static void depositMoney(Bank loyds, Scanner scanner) {
        System.out.println("Who you want to deposit money to?");
        System.out.println("Please give your first name.");
        String firstname = scanner.next();
        System.out.println("Please give me your last name");
        String lastName = scanner.next();
        System.out.println("To which account you want to deposit money(Personal, Saving)");
        String typeOfAccount = scanner.next();
        System.out.println("What amount do you want to pay?");
        BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());
        loyds.isDeposit(firstname, lastName, typeOfAccount, amount);
    }

    private static void openNewAccount(Bank loyds, Scanner scanner) {
        System.out.println("Please give your first name.");
        String firstname = scanner.next();
        System.out.println("Please give me your last name");
        String lastName = scanner.next();
        System.out.println("What kind of account do you want to open? (PN- Personal, SN- Saving)");
        String typeOfAccount = scanner.next();
        loyds.addAccountToCustomerList(firstname, lastName, typeOfAccount);

    }

    private static void addNewCustomer(Bank loyds, Scanner scanner) {
        System.out.println("Please give your first name.");
        String firstname = scanner.next();
        System.out.println("Please give me your last name");
        String lastName = scanner.next();
        loyds.createNewCustomer(firstname, lastName);

    }

}
