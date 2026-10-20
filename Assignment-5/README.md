# Assignment 5: Generics & Utility Classes

## UCS553: Enterprise Web Applications (Week 7)

**Student Name:** Shreyaas Sachdeva  
**Roll Number:** 1024030891  
**Course:** UCS553: Enterprise Web Applications  

This folder contains the Java implementation and submission document for Assignment 5 (Week 7) on Generics & Utility Classes.

---

### Questions

- **Q1:** Generic Method for Calculating Array Sum using Bounded Type Parameter `<T extends Number>`.
- **Q2:** Student Email Storage and Handling using `Optional<String>`.
- **Q3:** Generic Class `Result<T extends Number>` with Input Validation using `Objects.requireNonNull()`.
- **Q4:** Event Management System using `LocalDate`, `LocalTime`, and `Optional<String>`.
- **Q5:** Generic Utility Class with `isEqual()`, `getDefault()`, `max()`, and `isNull()`.

---

### Structure

```text
Assignment-5/
├── Assignment 5.pdf
├── README.md
├── Assignment_5_Shreyaas_Sachdeva.pdf
└── src/
    ├── q1/
    │   └── Question1.java
    ├── q2/
    │   └── Question2.java
    ├── q3/
    │   └── Question3.java
    ├── q4/
    │   └── Question4.java
    └── q5/
        └── Question5.java
```

---

### How to Compile and Run

From the `Assignment-5/` directory:

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
```
