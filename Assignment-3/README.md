# Assignment 3: Exception Handling & Debugging

## UCS553: Enterprise Web Applications (Week 5)

**Student Name:** Shreyaas Sachdeva  
**Roll Number:** 1024030891  
**Course:** UCS553 - Enterprise Web Applications  

This folder contains the Java implementation and submission document for Assignment 3 (Week 5) on Exception Handling & Debugging.

---

### Questions

- **Q1:** Exception Hierarchy Demonstration (`ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException`)
- **Q2:** Nested Try-Catch Blocks
- **Q3:** Calculator with Separate Exception Handlers
- **Q4:** Student Result Processing with `InvalidMarksException`
- **Q5:** Banking Application with Exception Propagation
- **Q6:** Login System with Account Lockout
- **Q7:** Shopping Cart Application with Custom Exception Hierarchy

---

### Structure

```text
Assignment-3/
├── Lab_Exception.pdf
├── README.md
├── Assignment_3_Shreyaas_Sachdeva.pdf
└── src/
    ├── q1/
    │   └── Question1.java
    ├── q2/
    │   └── Question2.java
    ├── q3/
    │   └── Question3.java
    ├── q4/
    │   └── Question4.java
    ├── q5/
    │   └── Question5.java
    ├── q6/
    │   └── Question6.java
    └── q7/
        └── Question7.java
```

---

### How to Compile and Run

From the `Assignment-3/` directory:

```bash
# Compile all programs
javac -d bin $(find src -name "*.java")

# Run Question 1
java -cp bin q1.Question1

# Run Question 2
java -cp bin q2.Question2

# Run Question 3
java -cp bin q3.Question3

# Run Question 4
java -cp bin q4.Question4

# Run Question 5
java -cp bin q5.Question5

# Run Question 6
java -cp bin q6.Question6

# Run Question 7
java -cp bin q7.Question7
```
