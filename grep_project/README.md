# Grep Clone in Java: Pattern Matching with Regex

## 📂 Opening and Scanning the Text Files

### 1. Open the Test Files
Start by opening the provided `.txt` test files.

Use a `File` object to open all five text files sequentially, from `TestFile1.txt` to `TestFile5.txt`.

> 💡 This step can be done using a `for` loop to avoid repetitive code.

### 2. Scan the Test Files
Next, scan each file to ensure they're being read correctly.

Use a `Scanner` object to read the content of each file as it's opened.

> 💡 A `while` loop with `hasNextLine()` can be used inside the `for` loop to read each line.

---

## 🔍 Implementing Regex

### 3. Understand the Grep Behavior
The `grep` command searches for matches using regular expressions. For example:

`grep -P '\d+' TestFile*.txt`

This command searches through all matching files and returns any lines containing one or more digits.

In your program, replicate this by creating a `Pattern` object that defines a regular expression to match one or more digits.

### 4. Use a Matcher to Compare Text
The `Matcher` object is used to apply the pattern to each line of text.

Use the `Scanner` to retrieve each line from the files, and apply the `Matcher` to check if the line matches the pattern.

### 5. Print Matches
If a match is found using the `find()` method:

- Print the name of the file where the match occurred.
- Follow the filename with a colon (`:`).
- Print the entire line of text containing the match.

This output should replicate what the `grep` command would return.

---

## ✅ Expected Output

When executed, the output should look like the following:

TestFile1.txt:te5ting
TestFile3.txt:testin117g
TestFile4.txt:testing special te5ting special testing
TestFile5.txt:te115sting
TestFile5.txt:t357esting


Each line includes the filename and the full line where the digit match was found.

---

## 🎉 Congratulations!

You've successfully mimicked the basic functionality of the `grep` command using Java.

### 🔧 Optional Extensions
- Try modifying the regular expression to search for different patterns.
- Update the test files with new content to experiment further with pattern matching.

