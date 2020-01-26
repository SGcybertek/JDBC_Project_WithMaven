package JDBC_Practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBC_TestCases  {

    Connection connection;
    Statement statement;


    @BeforeMethod
    public  void setUp() throws Exception{
        String url = "jdbc:oracle:thin:@54.147.169.86:1521:xe";
        String username = "hr";
        String password = "hr";

        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();

    }



    @Test(description = "Verify that Seyfo' salary is greater than  Ibrahim' salary")
    public  void Test1()throws SQLException {


        int seyfoSalary= 0,
                hakanSalary =0;

        String query = "SELECT * FROM testers";

       ResultSet result = statement.executeQuery(query);
       while (result.next() ) {
        String name = result.getString(2);
        int salary = result.getInt(3);
        if (name.equals("Seyfo")) {
               seyfoSalary = salary;
           }
           if (name.equals("hakan")) {
               hakanSalary = salary;
           }

           //System.out.println(name +" "+salary);
       }
        System.out.println("Seyfo salary: "+seyfoSalary);
        System.out.println("hakan salary: "+hakanSalary);


         Assert.assertTrue(seyfoSalary> hakanSalary);

    }
}
