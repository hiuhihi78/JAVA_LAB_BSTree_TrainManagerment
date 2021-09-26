Return to Assignments

DSA - Assignment 2
Train Booking System
using Binary Search Tree data structure
INTRODUCTION


Your second assignment in this block will be using Binary Search Tree data struture for implementing a Train Booking System  (TBS) in Java language. 
TBS manages information about Trains, customers and train booking. These information are:

About a train:

tcode (string): the code of the train (this variable is the key of the tree, thus it should be unique for the train).
train_name (string): the name of the train.
seat (integer): the number of  seats in the train (seat > 0).
booked (integer): the number of  booked seats in the train (booked >= 0 and booked <= seat).
depart_time (double): The depature time of the train (depart_time >= 0).
depart_place (string): The place of departure of the train.
 

About a customer:

ccode (string): the code of the customer (this should be unique for the customer).
cus_name (string): the name of the customer.
phone (string): The phone number of the customer (must contain digits only).
 

About Booking:

tcode (string): the code of the train to be booked.
ccode (string): the code of the customer.
seat (integer): the number of  seats to be booked on the train.
 

YOUR TASKS
You should use 1 binary search tree to store data for trains and 2 linked lists, each one is used to store data for customers or booking items. You should create the data structures from scratch, do not use structures available in java.

On running, your program displays the menu as below:

Trains (8 marks) (using Binary Search  Tree data structure, where tcode is the key of the tree):
1.1.      Load data from file
1.2.      Input & insert data
1.3.      In-order traverse
1.4.      Breadth-first traverse
1.5.      In-order traverse to file
1.6.      Search by pcode
1.7.      Delete by pcode by copying
1.8.      Simply balancing
1.9.      Count number of trains

Customer list (1 mark):
2.1.      Load data from file
2.2.      Input & add to the end
2.3.      Display data
2.4.      Save customer list to file
2.5.      Search by ccode
2.6.      Delete by ccode

Booking list (1 mark):
3.1.      Input data
3.2.      Display booking data
3.3.      Sort  by pcode + ccode

hint:
3.1.Allow a user to input booking item.
When running, the screen looks like:
Enter train code:
Enter customer code:
Enter number of seats to be booked:
After the user enter tcode and ccode, the program check and acts as follows:
- If tcode not found in the Train list or ccode not found in the customer list  then data is not accepted.
- If  both tcode and ccode are found in the booking list  then  data is not accepted.
- If tcode and ccode found in Traines and customers lists but booked = seat then inform the user that the train is  exhausted.
- If tcode or ccode found and in the Train list booked < seat and k is the entered seat then if  k <= seat - booked then data is accepted and  added to the end of the Booking list.
    
Submission Requirements
Create the directory with a name like <class>-<name><roll number>-ASS1, e.g.
            SE0508-QuangTV00456-AS1                        (1)
The (1) directory contains the following files:

The run.bat  file to run your program.
Your source code files.
Your input test files (train.txt and customer.txt).
The statements in run.bat file may be:
cls
javac Main.java
java Main
pause
del *.class

Compress the folder   (1)  to .zip (or .rar) file (with the same name) and upload to cms.

Assignment assessment
You will be asked to modify immediately and to explain your assignment in lab room to be sure that you are really the author  of the assignment you submitted.

 
