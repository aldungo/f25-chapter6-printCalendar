# Quick Reference Guide - Print Calendar Program

## 📋 Method Call Chain

This shows how methods depend on each other (top calls bottom):

```
main()
  └─ printMonth()
      ├─ printMonthTitle()
      │   └─ getMonthName()
      │
      └─ printMonthBody()
          ├─ getStartDay()
          │   └─ getTotalNumberOfDays()
          │       ├─ isLeapYear()
          │       └─ getNumberOfDaysInMonth()
          │           └─ isLeapYear()
          │
          └─ getNumberOfDaysInMonth()
              └─ isLeapYear()
```

---

## 🔢 Important Constants

```java
// Day of week for January 1, 1800
final int START_DAY_FOR_JAN_1_1800 = 3; // Wednesday

// Days of the week (for reference)
// 0 = Sunday
// 1 = Monday
// 2 = Tuesday
// 3 = Wednesday
// 4 = Thursday
// 5 = Friday
// 6 = Saturday
```

---

## 💡 Helpful Code Snippets

### Leap Year Logic
```java
year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
```

### Checking Multiple Conditions with OR
```java
if (month == 1 || month == 3 || month == 5 || month == 7 || 
    month == 8 || month == 10 || month == 12) {
    return 31;
}
```

### Ternary Operator (Conditional Expression)
```java
// Format: condition ? valueIfTrue : valueIfFalse
if (month == 2) {
    return isLeapYear(year) ? 29 : 28;
}
```

### For Loop Patterns
```java
// Loop through years from 1800 to year (not including year)
for (int i = 1800; i < year; i++) {
    // Do something with i
}

// Loop through months before the target month
for (int i = 1; i < month; i++) {
    // Do something with i
}

// Loop through days in a month
for (int i = 1; i <= numberOfDaysInMonth; i++) {
    // Do something with i
}
```

### Print Formatting
```java
// Print with specific width (4 characters wide)
System.out.printf("%4d", dayNumber);

// Print multiple spaces
System.out.print("    "); // 4 spaces

// Print and move to new line
System.out.println();
```

### Checking if We Need a New Line
```java
// After every 7 days (considering start day offset)
if ((dayNumber + startDay) % 7 == 0) {
    System.out.println(); // Move to next line
}
```

---

## 🧪 Testing Your Methods

### Test isLeapYear
```java
// In main, temporarily add:
System.out.println("2000 is leap year: " + isLeapYear(2000)); // Should be true
System.out.println("1900 is leap year: " + isLeapYear(1900)); // Should be false
System.out.println("2024 is leap year: " + isLeapYear(2024)); // Should be true
System.out.println("2025 is leap year: " + isLeapYear(2025)); // Should be false
```

### Test getNumberOfDaysInMonth
```java
// In main, temporarily add:
System.out.println("Days in Feb 2024: " + getNumberOfDaysInMonth(2024, 2)); // Should be 29
System.out.println("Days in Feb 2025: " + getNumberOfDaysInMonth(2025, 2)); // Should be 28
System.out.println("Days in Jan 2025: " + getNumberOfDaysInMonth(2025, 1)); // Should be 31
System.out.println("Days in Apr 2025: " + getNumberOfDaysInMonth(2025, 4)); // Should be 30
```

### Test getStartDay
```java
// In main, temporarily add:
System.out.println("Start day for Nov 2025: " + getStartDay(2025, 11)); // Should be 6 (Saturday)
System.out.println("Start day for Jan 1800: " + getStartDay(1800, 1)); // Should be 3 (Wednesday)
```

### Test getMonthName
```java
// In main, temporarily add:
System.out.println("Month 1: " + getMonthName(1)); // Should be "January"
System.out.println("Month 11: " + getMonthName(11)); // Should be "November"
```

---

## 🎯 Common Mistakes to Avoid

### 1. Off-by-One Errors
```java
// WRONG: This includes the target year
for (int i = 1800; i <= year; i++)

// CORRECT: Stop before the target year
for (int i = 1800; i < year; i++)
```

### 2. Leap Year Logic Order
```java
// WRONG: Doesn't check divisibility by 400 first
year % 4 == 0 && year % 100 != 0

// CORRECT: Check 400 first, then 4 and not 100
year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
```

### 3. Forgetting Parentheses
```java
// WRONG: Will not work as expected due to operator precedence
year % 4 == 0 && year % 100 != 0 || year % 400 == 0

// CORRECT: Use parentheses to be explicit
year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
```

### 4. Switch Statement Missing Breaks
```java
// WRONG: Falls through to next case
switch (month) {
    case 1: monthName = "January";  // Missing break!
    case 2: monthName = "February"; // Will also execute if month is 1
    // ...
}

// CORRECT: Include break or return
switch (month) {
    case 1: return "January";
    case 2: return "February";
    // ...
}
```

### 5. Not Resetting Line After Saturday
```java
// Make sure to start a new line after every 7 days
if ((i + startDay) % 7 == 0) {
    System.out.println();
}
```

---

## 📊 Example Calculations

### Why January 1, 1800 is Day 3?
- We define Sunday = 0, Monday = 1, ..., Saturday = 6
- January 1, 1800 was a Wednesday
- Wednesday is the 4th day of the week, but we count from 0
- So Wednesday = 3

### Calculating Start Day for November 2025
1. Total days from 1/1/1800 to 11/1/2025
2. Days in complete years (1800-2024)
3. Days in months before November 2025 (Jan-Oct)
4. (totalDays + 3) % 7 = start day

### Why We Use Modulo 7?
- There are 7 days in a week
- After 7 days, we're back to the same day of the week
- Modulo 7 gives us the remainder when divided by 7
- This remainder tells us which day of the week it is (0-6)

---

## 🎨 Expected Output Format

```
 November 2025
-----------------------------
 Sun Mon Tue Wed Thu Fri Sat
                          1
   2   3   4   5   6   7   8
   9  10  11  12  13  14  15
  16  17  18  19  20  21  22
  23  24  25  26  27  28  29
  30
```

Notice:
- One space before the month name
- 29 dashes for the separator
- One space before "Sun"
- Each day takes up 4 characters (right-aligned)
- First day (1) appears under "Sat" because Nov 1, 2025 is a Saturday

---

## 🚦 Compilation and Running

### Compile
```bash
javac F25_PrintCalendar_FirstName_LastName.java
```

### Run
```bash
java F25_PrintCalendar_FirstName_LastName
```

### If You Get Errors
- Check for missing semicolons (`;`)
- Check that all braces `{}` are balanced
- Check that method names are spelled correctly
- Check that you're returning the correct data types

---

## ✅ Checklist

Before you submit, make sure:
- [ ] Your name is in the file header
- [ ] All TODO comments are addressed
- [ ] The program compiles without errors
- [ ] You've tested with at least 3 different months/years
- [ ] February works correctly for both leap years and non-leap years
- [ ] The calendar aligns correctly (days under correct day-of-week)
- [ ] Comments are clear and explain what each method does

---

**Good luck! Remember: Work step-by-step, test frequently, and ask questions! 🎉**
