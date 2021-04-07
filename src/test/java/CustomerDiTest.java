import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CustomerDiTest {

    static Connection connection;

    static Customer mockCustomer;

    @BeforeAll public static void init() throws ClassNotFoundException, SQLException{
        Class.forName ("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1", "sa", "");
        
        PreparedStatement pStatement = connection.prepareStatement("create table customers(id serial primary key, fname text not null, size text not null, cheese text not null, pepperoni text not null);");
        pStatement.executeUpdate();

        mockCustomer = new Customer(0, "bob", "s", "y", "n");
    }

    @Test void canInsertData() {
        CustomerDi classUnderTest = new CustomerDi(connection, mockCustomer);
        classUnderTest.run();
        //System.out.println(classUnderTest.insertedRow);
        assertTrue(classUnderTest.insertedRow == 1);
    }
}
