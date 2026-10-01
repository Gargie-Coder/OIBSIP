# ATM Interface (Java)

An interactive console based ATM in Java which is built using Object Oriented Programming approach where the user logs in with a User ID and a PIN and performs various banking functions from a session menu.

This project has been developed as Task 3 of the internship at Oasis Infobyte for Java Development.

## Features
- Login with User ID and PIN (with 3 attempts, after which the user is blocked)
- Transaction history for the current session
- Withdraw cash (with a check if the balance is sufficient or not)
- Deposit cash
- Transfer money
- Input validation for amount (should not be negative)

## Project Structure
File Description
Main.java This file is used to create the bank, add test users, and open the ATM
ATM.java This class is used for logging in the user, and displaying the menu
Bank.java This class is used for storing the accounts, finding the account, checking the login details, and transferring money
Account.java This class stores the account ID, PIN, balance, and transaction history, and contains methods for depositing and withdrawing money
Transaction.java This class stores the transaction details like type, amount, additional notes, and time when the transaction occured

## How To Use
Make sure you have Java (preferably JDK 8 or above) installed on your system. Open the terminal or command prompt and navigate to this project's folder and run the following commands:
```
javac *.java
java Main
```

## Test Accounts
UserID PIN  Starting Balance
user1  1234  Rs.5000
user2  4321  Rs.3000
user3  1111  Rs.10000

## Sample Run
```
===== Welcome to the ATM =====
Enter User ID: user1
Enter PIN: 1234
Login successful!

----- MENU -----
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option: 2
Enter amount: 500
Please collect your cash. Balance: Rs.4500.0

----- MENU -----
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option: 1

--- Transaction History ---
01-10-2026 14:32:10 | Withdraw | Rs.500.0 | Cash withdrawn
```

## Concepts Used
- Encapsulation
- ArrayList
- switch case loop
- Exception Handling

## Notes
- The data is stored in memory, and it resets when the program is closed
- Transaction History is only visible for the current session

## Author
Gargie Gupta