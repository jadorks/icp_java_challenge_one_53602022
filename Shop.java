import java.util.Scanner;

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
    }
}