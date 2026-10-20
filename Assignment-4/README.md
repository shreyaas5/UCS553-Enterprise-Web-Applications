# Assignment 4: Collections Framework & Generics

## UCS553: Enterprise Web Applications

**Student Name:** Shreyaas Sachdeva  
**Roll Number:** 1024030891  
**Course:** UCS553: Enterprise Web Applications  

This folder contains the Java implementation and submission document for Assignment 4 on Collections Framework & Generics.

---

### Questions

- **Q1:** Course Registration Portal combining `HashMap`, `HashSet`, `ArrayList`, and `LinkedList` for prerequisites tracking, capacity checks, and automated waitlist promotion.
- **Q2:** Media Player Queue Engine utilizing `LinkedList<Song>`, `HashSet`, and `ListIterator` for priority queueing, efficient duplicate removal, history tracking, and bidirectional navigation.

---

### Structure

```text
Assignment-4/
├── Assignment 4.pdf
├── README.md
├── Assignment_4_Shreyaas_Sachdeva.pdf
└── src/
    ├── q1/
    │   └── Question1.java
    └── q2/
        └── Question2.java
```

---

### How to Compile and Run

From the `Assignment-4/` directory:

```bash
# Compile all programs
javac -d bin $(find src -name "*.java")

# Run Question 1
java -cp bin q1.Question1

# Run Question 2
java -cp bin q2.Question2
```
