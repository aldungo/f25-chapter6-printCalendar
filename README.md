# Chapter 6: Print Calendar - Method Abstraction and Stepwise Refinement

## 📅 What We're Building This Week (Week 11)

**Note:** The link to this repository must be turned in no later than the end of the week on Friday, November 7 @ 11:59 p.m. 

A calendar application that:
- Asks the user for a **year** and a **month**
- Prints a formatted calendar for that month

**Example Output:**
```
Enter full year (e.g., 2012): 2025
Enter month as a number between 1 and 12: 11

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

---

## 🎯 Learning Objectives

By the end of this activity, you'll understand:
- **Method Abstraction**: Breaking complex problems into smaller, manageable pieces
- **Stepwise Refinement**: Top-down design and bottom-up implementation
- **Code Reusability**: Writing methods that can be used multiple times
- **Modular Programming**: Making code easier to read, debug, and test

---

## 🧩 The Big Picture: Breaking Down the Problem

### Level 1: The Main Problem
```
Print a calendar for a given month and year
```

### Level 2: Two Main Tasks
1. **Get input** from the user (year and month)
2. **Print the calendar** for that month

### Level 3: Breaking Down "Print Calendar"
The `printMonth` method needs to:
- Print the **month title** (month name, year, and day headers)
- Print the **month body** (the actual dates)

### Level 4: Breaking Down "Print Month Title"
- Get the **month name** (convert number to string like "November")

### Level 5: Breaking Down "Print Month Body"
- Get the **start day** of the week (is the 1st a Sunday? Monday?)
- Get the **number of days** in the month (28, 29, 30, or 31?)

### Level 6: Breaking Down "Get Start Day"
- Calculate the **total number of days** since a known reference date

### Level 7: Breaking Down "Get Total Days"
- Determine if a year is a **leap year**
- Get the **number of days in each month**

---

## 🏗️ Implementation Strategy: Bottom-Up Approach

We'll build from the **bottom up**, starting with the smallest helper methods and working our way up to the main program.

### Implementation Order:
1. ✅ **isLeapYear** - The foundation (we did this in Chapter 3!)
2. ✅ **getNumberOfDaysInMonth** - Uses isLeapYear
3. ✅ **getTotalNumberOfDays** - Uses the above two methods
4. ✅ **getStartDay** - Uses getTotalNumberOfDays
5. ✅ **getMonthName** - Converts month number to name
6. ✅ **printMonthTitle** - Uses getMonthName
7. ✅ **printMonthBody** - Uses getStartDay and getNumberOfDaysInMonth
8. ✅ **printMonth** - Uses printMonthTitle and printMonthBody
9. ✅ **main** - Puts it all together!

---

## 📝 Key Concepts to Remember

### Reference Date
- **January 1, 1800** was a **Wednesday** (day 3 of the week, where Sunday = 0)
- We calculate all dates relative to this known point

### Days in Each Month
- **31 days**: January, March, May, July, August, October, December
- **30 days**: April, June, September, November
- **28/29 days**: February (depends on leap year)

### Leap Year Rules
A year is a leap year if:
- It's divisible by 400, OR
- It's divisible by 4 AND NOT divisible by 100

Examples:
- 2000 = leap year (divisible by 400)
- 2024 = leap year (divisible by 4, not by 100)
- 1900 = NOT a leap year (divisible by 100, but not 400)

---

## 🚀 Getting Started

1. Open the file `F25_PrintCalendar_FirstName_LastName.java`
2. Replace `FirstName_LastName` with your actual name
3. Follow along with the instructor or video
4. Complete each `TODO` section as we work through it together
5. Test your program frequently!

### Testing Your Program
After completing each method, you can test it by:
- Uncommenting the test code in `main`
- Running the program
- Verifying the output matches expected results

---

## 💡 Tips for Success

1. **Work step-by-step**: Don't try to write everything at once
2. **Test frequently**: After writing each method, test it!
3. **Use the textbook**: This follows the example exactly
4. **Ask questions**: If you're stuck, raise your hand or ask in chat
5. **Collaborate**: Discuss with classmates, but write your own code
6. **Think about reusability**: Notice how we use smaller methods in bigger ones

---

## 🎓 Benefits of This Approach

### Simpler Program
- Each method has ONE clear purpose
- Easy to read and understand

### Code Reusability
- Methods like `isLeapYear` and `getNumberOfDaysInMonth` are used multiple times
- No redundant code!

### Easier Development & Debugging
- Test one method at a time
- If something breaks, you know exactly where to look

### Better Teamwork
- Different programmers could work on different methods
- As long as the method signatures match, everything works together

---

## 📚 Additional Resources

- Textbook: Chapter 6 - Methods
- Lecture slides (provided in class)
- Previous class video recording
- Java API Documentation: [Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)

---

**Remember**: Programming is a skill that improves with practice. Work through this carefully, and you'll understand how professional programmers break down complex problems into manageable pieces! 🌟

