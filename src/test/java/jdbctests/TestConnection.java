package jdbctests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] arg) throws SQLException {
         String dbUrl= "jdbc:oracle:thin:@100.26.102.114:1521:XE";
         String dbUsername ="hr";
         String dbPassword = "hr";


        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

        // once you set up connection default pointer looks for 0
        // next()  --> move pointer to first row
         resultSet.next();

        //row'u next() ile ilerletebiliriz. column ilerletmek için ise 2 seçenek var, ya column ismi ya da column indexi)

        // getting information with column name
       System.out.println(resultSet.getString("region_name"));

        // getting information with column index(starts 1)
       System.out.println(resultSet.getString(2));

        //you will choose (getString,getInt) this data type according to what you gonna display from database

        // 1 - Europe
        // 2 - Americas
      System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        // move to second row
        resultSet.next();
      System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        // move to thord row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        //for this repeating, use loops
        while (resultSet.next()){     //whenever no more row avaliable,it will stop
            System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        }
        //by the help of while loop we can get that -> row number is dynamic



        // close connection
        connection.close();
        statement.close();
        resultSet.close();


    }
}


/*
This 3 steps are important and all comes from import java.sql.*;
Connection (java.sql)—> Helps our java project connect to database
Statement —> Helps to write and execute SQL query
ResultSet —> A datastructure where we can store the data that came from database
 */