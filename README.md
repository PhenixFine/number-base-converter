# Number Base Converter
Stage 1 of 4 for JetBrains Academy - Kotlin - [Number Base Converter project](https://hyperskill.org/projects/165/stages/856/implement).   
This stage has us convert a given decimal number to a given base the user wants it converted to ( for this stage we are just to convert decimal numbers to base 2, 8, and 16 ). I did a similar project back in January, so I thought this time I'd try and complete it without using `num.toString(radix)`.
## Requirements
### Description
In daily life, we mostly use the decimal numeral system, but still, there are many other ways to represent numbers. For example, when working with computers, you'll probably deal with binary, octal, and hexadecimal numbers. It's really nice to have a tool that can help you easily and correctly convert numbers from one system to another: in this project, we will build such a tool step-by-step. 

In the first stage, you need to implement conversion from decimal to binary, octal, and hexadecimal. The program will read the user's decimal number and the user's target [radix](https://en.wikipedia.org/wiki/Radix) (or base). Then, it will output the given number in the corresponding base.

Converting from decimal to octal and hexadecimal isn't much different from converting to binary. The algorithm is really similar to binary conversion, only the base number is different with 8 or 16 in place of 2. See some examples of converting the number 110 from decimal to octal and hexadecimal below:    
| Quotient | Remainder of 8 |
| :---: | :---: |
| 110 | 6 |
| 13 | 5 |
| 1 | 1 | 

Result: 110<sub>10</sub> = 156<sub>8</sub>  
| Quotient | Remainder of 16 |
| :---: | :---: |
| 110 | 14 (E) |
| 6 | 6 |    

Result: 110<sub>10</sub> = 6E<sub>16</sub>
### Objectives
Your program's output should consist of the following three lines:
1. On the first line, the prompt `Enter number in decimal system:` is shown, and the user inputs a decimal number to be converted.
2. On the second one, the prompt `Enter target base:` is printed, and the user enters the target base (2, 8, or 16).
3. On the third one, the message `Conversion result:` is printed, followed by the correct number representation in the given base.
### Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.
#### Example 1:
```text
Enter number in decimal system: > 8
Enter target base: > 16
Conversion result: 8
```
#### Example 2:
```text
Enter number in decimal system: > 101
Enter target base: > 2
Conversion result: 1100101
```
#### Example 3:
```text
Enter number in decimal system: > 103
Enter target base: > 8
Conversion result: 147
```