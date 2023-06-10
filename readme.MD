# Hotel Management Software

To run this software clone this repository by using git clone https://github.com/djgupta820/hotel-management.git command.

Now go to cmd (Command Prompt) and compile all the classes by using javac *.java or javac <filename>.java(this is for indvidual compilation of all classes).

Now run login class by using java login.java command and login screen will appear on the screen.

############################ IMPORTANT ########################################
This software is created using java 15 and mysql server 8.

In order to run this software you need to create database named hotelmanagement or create your database and change the db name in java classes.

### The below table is the description of availabel_rooms table

  <table> 
    <thead> 
      <tr> 
        <td> Field </td>
        <td> Type </td>
        <td> Null </td>
        <td> Key </td>
        <td> Default </td>
        <td> Extra </td>
      </tr>
    </thead>
    <tbody> 
      <tr> 
        <td> Roon_number </td> 
        <td> int </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Roon_type </td> 
        <td> char(10) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Cost_of_room </td> 
        <td> double </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
    </tbody>
  </table>
 
### The below table is the description of check_in table
 <table> 
    <thead> 
      <tr> 
        <td> Field </td>
        <td> Type </td>
        <td> Null </td>
        <td> Key </td>
        <td> Default </td>
        <td> Extra </td>
      </tr>
    </thead>
    <tbody> 
      <tr> 
        <td> first_name </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Middle_name </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Last_name </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Gender </td> 
        <td> char(6) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> date_of_birth </td> 
        <td> char(11) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Address </td> 
        <td> varchar(50) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> contact_number </td> 
        <td> char(11) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> email </td> 
        <td> varchar(25) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Nationality </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> passpoer_number </td> 
        <td> char(20) </td>
        <td> No </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Room_type </td> 
        <td> char(10) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Smoking </td> 
        <td> char(3) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Number_of_males </td> 
        <td> int </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Number_of_females </td> 
        <td> int </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Number_of_children </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Mode_of_payment </td> 
        <td> char(15) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr> 
      <tr> 
        <td> Discount </td> 
        <td> double </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Totla_payment </td> 
        <td> double </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Room_number </td> 
        <td> int </td>
        <td> No </td>
        <td> PRI </td>
        <td> Null </td>
        <td> </td>
      </tr>
      
      <tr> 
        <td> check_in_datetime </td> 
        <td> char(20) </td>
        <td> No </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
   </tbody>
  </table>

### The below table is description of guests table
  <table> 
    <thead> 
      <tr> 
        <td> Field </td>
        <td> Type </td>
        <td> Null </td>
        <td> Key </td>
        <td> Default </td>
        <td> Extra </td>
      </tr>
    </thead>
    <tbody> 
      <tr> 
        <td> first_name </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Middle_name </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Last_name </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Gender </td> 
        <td> char(6) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> date_of_birth </td> 
        <td> char(11) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Address </td> 
        <td> varchar(50) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> contact_number </td> 
        <td> char(11) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> email </td> 
        <td> varchar(25) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Nationality </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> passpoer_number </td> 
        <td> char(20) </td>
        <td> No </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Room_type </td> 
        <td> char(10) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Smoking </td> 
        <td> char(3) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Number_of_males </td> 
        <td> int </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Number_of_females </td> 
        <td> int </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Number_of_children </td> 
        <td> char(20) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Mode_of_payment </td> 
        <td> char(15) </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr> 
      <tr> 
        <td> Discount </td> 
        <td> double </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Totla_payment </td> 
        <td> double </td>
        <td> Yes </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
      <tr> 
        <td> Room_number </td> 
        <td> int </td>
        <td> No </td>
        <td> PRI </td>
        <td> Null </td>
        <td> </td>
      </tr>
      
      <tr> 
        <td> check_in_datetime </td> 
        <td> char(20) </td>
        <td> No </td>
        <td> </td>
        <td> Null </td>
        <td> </td>
      </tr>
   </tbody>
  </table>

### The below table is description of users table
  <table> 
    <thead> 
      <tr> 
        <td> Field </td>
        <td> Type </td>
        <td> Null </td>
        <td> Key </td>
        <td> Default </td>
        <td> Extra </td>
      </tr>
    </thead>
    </tbody>
      <tr> 
        <td> first_name </td>
        <td> Last_name </td>
        <td> phone_number </td>
        <td> Address </td>
        <td> Employee_ID </td>
        <td> work_phone_number </td>
        <td> Username </td>
        <td> Password </td>
      </tr>
    </tbody>
 </table>

In order to run this software you need to create these tables in mysql 
hotelmanagement database(Created by you only) or create your own database 
and tables and change the db name and tables name in the java classes (try catch block).
