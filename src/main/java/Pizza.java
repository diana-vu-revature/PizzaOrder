
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Pizza extends Thread{
    int n;
    String size, cheese, pepperoni;

    //creating Arraylist to hold ALL pizza orders
    //ArrayList<ArrayList> totalPizza = new ArrayList<ArrayList>();

    //get the order from the customer
    public void run(){
        //for connecting to postgres
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "hiworld";
        String password = "password";

        System.out.println("\n .....Starting new piza order.....");

        //get name of customer
        Scanner input = new Scanner(System.in);
        System.out.print("\nName: ");
        String name = input.nextLine();


        Scanner reader = new Scanner(System.in);
        System.out.print("\nHow many Pizzas?: ");
        int n = reader.nextInt();


        //create a new pizza for every number of pizza they want
        for(int i = 1; i <= n; i++){
            System.out.println("\n.....Create your pizza for pizza #" + i + ".....\n");

            createPizza();

            try {
                Connection connection = DriverManager.getConnection(url, username, password);

                Customer bob = new Customer(i, name, size, cheese, pepperoni);

                CustomerDi eDi = new CustomerDi(connection, bob);

                eDi.start();

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }


    }

    // //ask customer if they want to make any changes to their order
    // public void reviewOrder() {
    //     System.out.println("\n .....Reviewing your pizza order.....");

    //     for(int i = 1; i <= n; i++){
    //         System.out.println("Pizza #" + i+ ": ");
    //         for(int j = 0; j <= 2; j++){
    //             System.out.println(totalPizza.get(j)); //print everything inside array
    //         }

    //     }
    // }

    public void createPizza(){

        //creating Arraylist to hold one pizza order
        ArrayList<String> pizzaType = new ArrayList<String>();

        Scanner input = new Scanner(System.in);
        System.out.println("\nSize of pizza: S / M / L\n");
        size = input.nextLine();


        //add to arraylist to keep track of all features of pizza
        pizzaType.add(size);

        Scanner in = new Scanner(System.in);
        System.out.println("\nCheese: Y / N\n");
        cheese = in.nextLine();

        pizzaType.add(cheese);

        Scanner user = new Scanner(System.in);
        System.out.println("\nPepperoni: Y / N\n");
        pepperoni = user.nextLine();

        pizzaType.add(pepperoni);

        //add pizza to total pizza orders
        //totalPizza.add(pizzaType);
    }

}
