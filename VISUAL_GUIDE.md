# 🎨 Visual Learning Guide - Print Calendar

## 📊 The Big Picture: Problem Decomposition

```
                        🎯 MAIN GOAL
                   Print a Calendar
                         |
           +-------------+-------------+
           |                           |
       Get Input                  Print Calendar
       from User                  (printMonth)
           |                           |
     +-----+-----+            +--------+--------+
     |           |            |                 |
   Enter       Enter      Print Title      Print Body
   Year        Month   (printMonthTitle)  (printMonthBody)
                              |                 |
                              |        +--------+--------+
                              |        |                 |
                         Get Month   Get Start        Get Days
                          Name       Day (0-6)       in Month
                              |        |                 |
                              |        |                 |
                       (getMonthName)  |          (getNumberOfDaysInMonth)
                                       |                 |
                                  Calculate              |
                                  Total Days        Is Leap Year?
                                       |                 |
                              (getTotalNumberOfDays)     |
                                       |                 |
                                  +----+----+       (isLeapYear)
                                  |         |
                              Is Leap   Get Days
                               Year?   in Month
                                  |         |
                           (isLeapYear) (getNumberOfDaysInMonth)
```

---

## 🏗️ Building Blocks: Bottom-Up Implementation

Imagine building a house - you start with the foundation, not the roof!

```
        🏠 MAIN METHOD
        └─ 🏛️ printMonth
            ├─ 🎨 printMonthTitle
            │   └─ 🏷️ getMonthName
            │
            └─ 📅 printMonthBody
                ├─ 📍 getStartDay
                │   └─ ➕ getTotalNumberOfDays
                │       ├─ 🧮 isLeapYear
                │       └─ 📊 getNumberOfDaysInMonth
                │           └─ 🧮 isLeapYear
                │
                └─ 📊 getNumberOfDaysInMonth
                    └─ 🧮 isLeapYear

LEVEL 1 (Foundation):     🧮 isLeapYear
LEVEL 2:                  📊 getNumberOfDaysInMonth, 🏷️ getMonthName
LEVEL 3:                  ➕ getTotalNumberOfDays
LEVEL 4:                  📍 getStartDay
LEVEL 5:                  🎨 printMonthTitle, 📅 printMonthBody
LEVEL 6:                  🏛️ printMonth
LEVEL 7 (Roof):          🏠 main
```

---

## 🔄 Method Call Flow

When you run the program with input (2025, 11), here's what happens:

```
1. main(String[] args)
   ↓
2. Scanner reads: year = 2025, month = 11
   ↓
3. printMonth(2025, 11)
   ↓
4. printMonthTitle(2025, 11)
   ↓
5. getMonthName(11) → returns "November"
   ↓
6. Prints: " November 2025"
   ↓
7. printMonthBody(2025, 11)
   ↓
8. getStartDay(2025, 11)
   ↓
9. getTotalNumberOfDays(2025, 11)
   ↓
10. Loop through years 1800-2024:
    • For each year, call isLeapYear(year)
    • Add 365 or 366 days to total
   ↓
11. Loop through months 1-10 of 2025:
    • For each month, call getNumberOfDaysInMonth(2025, month)
    • getNumberOfDaysInMonth calls isLeapYear(2025)
    • Add days to total
   ↓
12. Returns total days = 82,348 (example)
   ↓
13. getStartDay calculates: (82,348 + 3) % 7 = 6 (Saturday)
   ↓
14. getNumberOfDaysInMonth(2025, 11) → returns 30
   ↓
15. printMonthBody prints the calendar:
    • Pads 6 spaces (for Sat start)
    • Prints days 1-30
    • New line after every 7th position
   ↓
16. Program complete! ✅
```

---

## 📅 Visual: How Days Align

### Example: November 2025 starts on Saturday (day 6)

```
Day of Week:    0    1    2    3    4    5    6
             [Sun][Mon][Tue][Wed][Thu][Fri][Sat]
                                              [1]

Position count: 0    1    2    3    4    5    6
                                              ↑
                                        Nov 1 is here
```

When we print:
- Day 1 is at position 6 (Saturday)
- Day 2 is at position 7 → 7 % 7 = 0 → NEW LINE!
- Day 2 appears at position 0 (Sunday)

```
Printing logic:
for i = 1 to 30:
    print i
    if (i + 6) % 7 == 0:  // 6 is startDay
        print newline

i=1: position 7 (1+6), 7%7=0 → newline after 1
i=2: position 8 (2+6), 8%7=1 → no newline
...
i=7: position 13 (7+6), 13%7=6 → no newline
i=8: position 14 (8+6), 14%7=0 → newline after 8
```

---

## 🔢 Understanding Total Days Calculation

### Example: Total days from 1/1/1800 to 11/1/2025

**Step 1: Count complete years (1800 to 2024)**
```
Years 1800-2024 = 225 years

Leap years in this range: 
• Divisible by 400: 1600, 2000 → 1 in range (2000)
• Divisible by 4 but not 100: 1804, 1808, ..., 2024
  → 56 leap years total

Regular years: 225 - 56 = 169 years

Total: (56 × 366) + (169 × 365) = 20,496 + 61,685 = 82,181 days
```

**Step 2: Count complete months in 2025 (Jan to Oct)**
```
January:    31 days
February:   28 days (2025 is not a leap year)
March:      31 days
April:      30 days
May:        31 days
June:       30 days
July:       31 days
August:     31 days
September:  30 days
October:    31 days
          --------
Total:     304 days
```

**Step 3: Add them up**
```
82,181 + 304 = 82,485 total days from 1/1/1800 to 11/1/2025
```

**Step 4: Calculate start day**
```
January 1, 1800 was Wednesday (day 3)
(82,485 + 3) % 7 = 82,488 % 7 = 6

Day 6 = Saturday ✅
```

---

## 🎯 Pattern Recognition: Modulo 7

Think of a clock with 7 positions instead of 12:

```
        0 (Sunday)
    6       1
  (Sat)   (Mon)
    5       2
  (Fri)   (Tue)
    4   3
  (Thu) (Wed)
```

Examples:
- 0 days later → 0 % 7 = 0 (Sunday)
- 1 day later → 1 % 7 = 1 (Monday)
- 7 days later → 7 % 7 = 0 (back to Sunday!)
- 10 days later → 10 % 7 = 3 (Wednesday)
- 82,488 days later → 82,488 % 7 = 6 (Saturday)

**Key insight:** Every 7 days, we cycle back to the same day of the week!

---

## 🎨 Visual: Month Days Distribution

```
       31 DAYS                30 DAYS              SPECIAL
    ┌──────────┐           ┌──────────┐         ┌──────────┐
    │ January  │           │  April   │         │ February │
    │  March   │           │   June   │         │  28/29   │
    │   May    │           │ September│         │  days    │
    │   July   │           │ November │         └──────────┘
    │  August  │           └──────────┘
    │ October  │
    │ December │
    └──────────┘
```

**Mnemonic:** "30 days has September, April, June, and November..."

---

## 📈 Testing Strategy: Progressive Verification

```
Step 1: Test isLeapYear
├─ 2000 → true ✓
├─ 1900 → false ✓
├─ 2024 → true ✓
└─ 2025 → false ✓

Step 2: Test getNumberOfDaysInMonth
├─ Feb 2024 → 29 ✓
├─ Feb 2025 → 28 ✓
├─ Apr 2025 → 30 ✓
└─ Jan 2025 → 31 ✓

Step 3: Test getTotalNumberOfDays
└─ Jan 1, 1800 → 0 ✓

Step 4: Test getStartDay
└─ Jan 1, 1800 → 3 (Wed) ✓

Step 5: Test getMonthName
├─ 1 → "January" ✓
└─ 11 → "November" ✓

Step 6-9: Test complete calendar
└─ Nov 2025 → Visual check ✓
```

---

## 🧩 Code Reusability Visualization

Notice how `isLeapYear` is used multiple times:

```
isLeapYear(year)
    ↑           ↑
    │           │
    │           └──────────────────┐
    │                              │
getNumberOfDaysInMonth      getTotalNumberOfDays
    ↑           ↑                  ↑
    │           │                  │
    │           └──────────────────┤
    │                              │
printMonthBody              getTotalNumberOfDays
```

**Without methods:** We'd write the leap year logic 3+ times!  
**With methods:** We write it once, use it everywhere! 🎉

---

## 💡 The Aha! Moment

```
BEFORE (one big mess):
┌────────────────────────────────────────────┐
│ 200 lines of tangled code                 │
│ Hard to read, debug, or modify             │
└────────────────────────────────────────────┘

AFTER (organized methods):
┌──────────────┐ ┌──────────────┐ ┌──────────────┐
│ isLeapYear   │ │ getMonthName │ │ printMonth   │
│ (15 lines)   │ │ (18 lines)   │ │ (5 lines)    │
└──────────────┘ └──────────────┘ └──────────────┘
     Easy to read    Easy to test    Easy to debug
```

**This is the power of method abstraction!** 🚀

---

## 🎓 Remember

> "Any fool can write code that a computer can understand.  
> Good programmers write code that humans can understand."  
> — Martin Fowler

Your calendar program demonstrates this principle beautifully! ✨
