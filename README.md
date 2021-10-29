# Number Base Converter
Stage 2 of 4 for JetBrains Academy - Kotlin - [Number Base Converter project](https://hyperskill.org/projects/165/stages/857/implement).   
This stage has us add the option to convert binary, octal, and hexadecimal to decimal, and to loop until the user types `/exit`. I did a similar project back in January, so I thought this time I'd try and complete it without using `num.toString(radix)`.
## Requirements
### Description
At this point, the user needs to restart the program each time after converting just one number, which is very inconvenient. Let's fix that and make your program prompt the user for more numbers until the user is ready to quit.

Also, we will add the reverse conversion: from binary, octal, and hexadecimal systems to decimal. Converting from octal, hexadecimal, or any other system to decimal works almost the same way as with binary numbers, only the base is different. See for yourself:    
#### 1726<sub>8</sub> = 1 * 512 + 7 * 64 + 2 ∗ 8 + 6 * 1 = 982<sub>10</sub>
#### A3C<sub>16</sub> = 10 * 256 + 3 * 16 + 12 * 1 = 2620<sub>10</sub>
### Objectives
Your program should output the prompt `Do you want to convert /from decimal or /to decimal? (To quit type /exit)` to prompt the user for their next move. The possible commands are `/from`, `/to`, and `/exit`.
* If the user types `/from`, the program should behave as in the previous stage and convert the user's number from the decimal system to binary, octal, or hexadecimal.
* If the user types /to, the program should:    
  * Print the prompt `Enter source number:` and read the user input number to be converted to decimal.
  * Print the prompt `Enter source base:` and read the target base (2, 8, or 16).
  * Output the message `Conversion to decimal result:` followed by the number's representation in the decimal system.
* If the user types `/exit`, the program stops. Otherwise, it should process the command and prompt for the next one.
### Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.
#### Example 1:
```text
Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /from
Enter a number in decimal system: > 8
Enter the target base: > 16
Conversion result: 8

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /from
Enter a number in decimal system: > 101
Enter the target base: > 2
Conversion result: 1100101

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /from
Enter a number in decimal system: > 103
Enter the target base: > 8
Conversion result: 147

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /exit
```
#### Example 2:
```text
Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /to
Enter source number: > ff
Enter source base: > 16
Conversion to decimal result: 255

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /to
Enter source number: > 71
Enter source base: > 8
Conversion to decimal result: 57

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /to
Enter source number: > 111001
Enter source base: > 2
Conversion to decimal result: 57

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /exit
```
#### Example 3:
```text
Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /to
Enter source number: > 25a
Enter source base: > 16
Conversion to decimal result: 602

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /from
Enter number in decimal system: > 602
Enter target base: > 16
Conversion result: 25a

Do you want to convert /from decimal or /to decimal? (To quit type /exit) > /exit
```