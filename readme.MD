# Hotel Management Software

To run this software clone this repository by using git clone https://github.com/djgupta820/hotel-management.git command.

Now go to cmd (Command Prompt) and compile all the classes by using javac *.java or javac <filename>.java(this is for indvidual compilation of all classes).

Now run login class by using java login.java command and login screen will appear on the screen.

############################ IMPORTANT ########################################
This software is created using java 15 and mysql server 8.

In order to run this software you need to create database named hotelmanagement or create your database and change the db name in java classes.

The below table is the description of availabel_rooms table

+--------------+----------+------+-----+---------+-------+
| Field        | Type     | Null | Key | Default | Extra |
+--------------+----------+------+-----+---------+-------+
| Room_number  | int      | YES  |     | NULL    |       |
| Room_type    | char(10) | YES  |     | NULL    |       |
| Cost_of_room | double   | YES  |     | NULL    |       |
+--------------+----------+------+-----+---------+-------+

The below table is the description of check_in table

+--------------------+-------------+------+-----+---------+-------+
| Field              | Type        | Null | Key | Default | Extra |
+--------------------+-------------+------+-----+---------+-------+
| first_name         | char(20)    | YES  |     | NULL    |       |
| Middle_name        | char(20)    | YES  |     | NULL    |       |
| Last_name          | char(20)    | YES  |     | NULL    |       |
| Gender             | char(6)     | YES  |     | NULL    |       |
| date_of_birth      | char(11)    | YES  |     | NULL    |       |
| Address            | varchar(50) | YES  |     | NULL    |       |
| contact_number     | char(11)    | YES  |     | NULL    |       |
| Email              | varchar(25) | YES  |     | NULL    |       |
| Nationality        | char(15)    | YES  |     | NULL    |       |
| passport_number    | char(20)    | NO   |     | NULL    |       |
| Room_type          | char(10)    | YES  |     | NULL    |       |
| Smoking            | char(3)     | YES  |     | NULL    |       |
| Number_of_males    | int         | YES  |     | NULL    |       |
| Number_of_females  | int         | YES  |     | NULL    |       |
| Number_of_children | int         | YES  |     | NULL    |       |
| Mode_of_payment    | char(15)    | YES  |     | NULL    |       |
| Discount           | double      | YES  |     | NULL    |       |
| Total_payment      | double      | YES  |     | NULL    |       |
| room_number        | int         | NO   | PRI | NULL    |       |
| check_in_dateTime  | char(20)    | NO   |     | NULL    |       |
+--------------------+-------------+------+-----+---------+-------+

The below table is description of guests table
+--------------------+-------------+------+-----+---------+-------+
| Field              | Type        | Null | Key | Default | Extra |
+--------------------+-------------+------+-----+---------+-------+
| first_name         | char(20)    | YES  |     | NULL    |       |
| middle_name        | char(20)    | YES  |     | NULL    |       |
| last_name          | char(20)    | YES  |     | NULL    |       |
| Gender             | char(6)     | YES  |     | NULL    |       |
| Date_of_Birth      | char(11)    | YES  |     | NULL    |       |
| Address            | varchar(50) | YES  |     | NULL    |       |
| Contact_number     | char(11)    | YES  |     | NULL    |       |
| Email              | varchar(25) | YES  |     | NULL    |       |
| Nationality        | char(15)    | YES  |     | NULL    |       |
| Passport_Number    | varchar(9)  | YES  |     | NULL    |       |
| Room_Type          | char(10)    | YES  |     | NULL    |       |
| Smoking            | char(3)     | YES  |     | NULL    |       |
| Number_of_males    | int         | YES  |     | NULL    |       |
| Number_of_Females  | int         | YES  |     | NULL    |       |
| Number_of_Children | int         | YES  |     | NULL    |       |
| Mode_of_Payment    | char(15)    | YES  |     | NULL    |       |
| Discount           | double      | YES  |     | NULL    |       |
| Total_Payment      | double      | YES  |     | NULL    |       |
| Room_Number        | int         | NO   | PRI | NULL    |       |
| check_in_dateTime  | char(20)    | NO   |     | NULL    |       |
+--------------------+-------------+------+-----+---------+-------+

The below table is description of users table
+-------------------+-------------+------+-----+---------+-------+
| Field             | Type        | Null | Key | Default | Extra |
+-------------------+-------------+------+-----+---------+-------+
| first_name        | char(20)    | YES  |     | NULL    |       |
| Last_Name         | char(20)    | YES  |     | NULL    |       |
| phone_number      | char(10)    | YES  |     | NULL    |       |
| Address           | varchar(50) | YES  |     | NULL    |       |
| Employee_ID       | int         | NO   | PRI | NULL    |       |
| work_phone_number | char(10)    | YES  |     | NULL    |       |
| Username          | varchar(20) | YES  |     | NULL    |       |
| Password          | varchar(20) | YES  |     | NULL    |       |
+-------------------+-------------+------+-----+---------+-------+

In order to run this software you need to create these tables in mysql 
hotelmanagement database(Created by you only) or create your own database 
and tables and change the db name and tables name in the java classes (try catch block).