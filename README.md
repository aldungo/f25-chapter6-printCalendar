# Programming Fundamentals I - Fall 2025

## Lab Assignment #10: Compound Interest Calculator

*Due at 11:59 pm the night before the next lab session*

---

## Purpose

A real estate agent wants to develop an application to calculate the value of purchased homes over time. The application will compute the compound interest of a house given a principal amount (initial cost), interest rate, and number of years after the purchase. This lab focuses on the following concepts:

• Implementing void methods

• Implementing value-returning methods

---

## In-Class 10 Lesson

To get started, let's consider another program using multiple custom methods. Refactor (rewrite) the tipping application from **Lab 4** so that the main method makes requests for user input while two other methods outside of main handle:

• Calculating the final cost of a meal (including tax and tip)

• Printing the output to the program with proper formatting

---

## Lab 10 Task

Create a project called `CompoundInterest_FirstName_LastName` or `Lab10_FirstName_LastName`. Remember to include comments describing your program. A key component of this lab should be comments describing the methods used.

The steps provided are broken down into a bottom-up implementation. Methods implemented in earlier steps will be used in later steps.

### Step 1: Implement the Compound Interest Calculation Method

Implement a method that will handle the calculation of the compound interest. This method will take a double for the principal amount, a double for the interest rate, and an int for the number of years. This method will return a double for the final amount. Use the following formula to calculate compound interest:

**A = P(1 + r)^t**

Where:
- **P** is the principal amount
- **r** is the interest rate
- **t** is the number of years
- **A** is the final amount

*Be careful about the order of operations in this formula.*

### Step 2: Implement the Output Formatting Method

Implement a method that will handle printing the output to the console with proper formatting. This method will take a double for the principal amount, a double for the interest rate, an int for the number of years, and a double for the final amount. This method will not return anything. 

**Formatting requirements:**
- The principal amount and final amount must be formatted to two decimal places
- The interest rate must be formatted to three decimal places

### Step 3: Implement the Main Method

In the main method, do the following:

• Construct an object of the Scanner class to handle user input

• Declare variables for the principal amount, interest rate, number of years, and final amount. The data types should match what is expected for the other methods in this program

• Make requests to the user to enter the principal amount, interest rate, and number of years. The interest rate will be requested as a percent, so make sure this is converted to a decimal before performing any calculations

• Call the method implemented in Step 1 to calculate the final amount

• Call the method implemented in Step 2 to print the output to the console

---

## Example Output

```
Please enter the principal amount: 137000
Please enter the interest rate (as a percent): 2.175
Please enter the number of elapsed years: 15

Given a principal amount of $137000.00, an interest rate of  2.1750% and 15 years, the final amount is $189186.55.
```

---

## Running Your Program

### Method 1: Using the Terminal
1. Open the terminal in your codespace (Terminal → New Terminal)
2. Compile your program:
   ```bash
   javac Lab10_YourFirstName_YourLastName.java
   ```
3. Run your program:
   ```bash
   java Lab10_YourFirstName_YourLastName
   ```

Replace `Lab10_YourFirstName_YourLastName.java` with your actual file name. If you are running the in-class exercise, use the corresponding file name instead.

💡 **Remember:** After running your program, take a screenshot of your console output and add it to your file directory on the left as part of your submission.

---

## Grading Criteria

This lab is worth 100 points total, distributed as follows:

• Comments describing the program: 5 points

• The method to handle calculations: 35 points

• The method to handle the properly formatted output: 35 points

• The main method: 25 points
  - Scanner and other variable declarations: 5 points
  - Requests to the user: 10 points
  - Calls to the other two methods: 10 points 

---

## Commit Your Changes

### Step 1: Use VS Code's Source Control panel
   - Click the Source Control icon in the left sidebar
   - Type a commit message describing your changes
   - Click "Commit" then "Sync Changes" to push your code

### Step 2: Verify Submission
After pushing your changes, visit your assignment repository on GitHub Classroom. Confirm that your latest code and commit message appear, and that your files are named correctly. 

### Step 3: Submit to Blackboard Assignment
Once you have verified your submission on GitHub Classroom, copy the URL of your assignment repository and submit this GitHub repository link to Blackboard as confirmation that you are DONE.

---



**Excellent work!** You've reached Lab 10, and this assignment introduces you to implementing custom methods in Java. Working with value-returning methods and void methods will help you understand how to modularize your code and create reusable components. This compound interest calculator demonstrates a practical application of methods in a real-world scenario, helping you understand how to break down complex problems into smaller, manageable functions. Remember to include detailed comments describing what each method does!

**Important:** Focus on completing the lab assignment. Do NOT edit or tamper with any test files, markdown files, or class files if they appear in your repository.

