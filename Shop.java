import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Jeffrey Kafui Adorkor
 */
public class Shop{


    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Add products");
        System.out.println("2. View stock");
        System.out.println("3. Backup stock");
        int choice = input.nextInt();

        if(choice == 1){
            System.out.println("How many products do you want to add?");
            int numItems = input.nextInt(); // input for number of items to add. Determines number of times the loop runs

            for(int i = 0; i < numItems; i++){
                input.nextLine();
                System.out.println("Enter the product name");
                String name = input.nextLine();
        
                System.out.println("Enter quantity of product");
                int quantity = input.nextInt();
        
                System.out.println("Enter price of product");
                double price = input.nextDouble();
        
                Product shopProduct = new Product(name, quantity, price);
        
                writeToFile(shopProduct);
            }
        }
        else if(choice == 2){
            System.out.println("Current stock");
            viewFile();
        }
        else if(choice == 3){
            backupFile();
        }
        else{
            System.out.println("Invalid choice");
        }
    }

    /**
     * 
     * @param p Instance of product class whose details would be written to the file
     */
    public static void writeToFile(Product p){
        String item = p.getItem();
        int quantity = p.getQuantity();
        double price = p.getPrice();

        PrintWriter printWriter = null;

        // try...catch block to handle possible FileNotFoundException
        try {
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt",true));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        printWriter.printf(item + ", " +quantity + ", GHC %.2f", price); // printf to perform string formatting
        printWriter.println();

        printWriter.close(); // close printWriter after use
        
    }

    /**
     * backupFile method creates a backup of the essentials_stock file
     */
    public static void backupFile(){

        PrintWriter printWriter = null;


        // try...catch block to handle possible FileNotFoundException
        try {
            printWriter = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }


        String file = "essentials_stock.txt";
        Scanner reader = null;

        // try...catch block to handle possible FileNotFoundException
        try {
            reader = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // while the scanner finds a next line print to the new file
        while(reader.hasNextLine()){
            String s = reader.nextLine();
            printWriter.print(s);
            printWriter.println();
        }

        printWriter.close(); // close printWriter after use

    }

    /**
     * viewFile method shows the current stock
     */
    public static void viewFile(){
        String file = "essentials_stock.txt";
        Scanner reader = null;

        // try...catch block to handle possible FileNotFoundException
        try {
            reader = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNextLine()){
            String s = reader.nextLine();
            System.out.println(s);
        }
    }

}