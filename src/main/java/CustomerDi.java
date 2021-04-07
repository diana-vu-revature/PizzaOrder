

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import hiworld.Customer;

public class CustomerDi extends Thread{
    Connection connection;

    Customer customer;

    int insertedRow;

    public void run(){
        try{
            PreparedStatement pStatement = connection.prepareStatement("insert into customers(fname, size, cheese, pepperoni) values (?, ?, ?, ?)");
            pStatement.setString(1, customer.getName());
            pStatement.setString(2, customer.getSize());
            pStatement.setString(3, customer.getCheese());
            pStatement.setString(4, customer.getPepperoni());
            insertedRow = pStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public CustomerDi(Connection connection, Customer customer) {
        this.connection = connection;
        this.customer = customer;
    }

}
