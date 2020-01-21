import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Shop{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the product name");
        String name = input.nextLine();

        System.out.println("Enter quantity of product");
        int quantity = input.nextInt();

        System.out.println("Enter price of product");
        double price = input.nextDouble();

        Product shopProduct = new Product(name, quantity, price);

        writeToFile(shopProduct);
    }

    public static void writeToFile(Product p){
        String item = p.getItem();
        int quantity = p.getQuantity();
        double price = p.getPrice();

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt",true));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        printWriter.printf(item + ", " +quantity + ", GHC %.2f", price);
        printWriter.println();

        printWriter.close();
    }
}