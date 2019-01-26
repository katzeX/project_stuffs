import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner read = new Scanner(System.in);
        
        String readName, readType;
        float readWeight, readPrice;
        
        boolean readCommand = true;
        

        FruitBasket basket = new FruitBasket("Dried");
        

        try (FileInputStream file = new FileInputStream("fruits.ser");
             ObjectInputStream stream = new ObjectInputStream(file)) {
            basket = (FruitBasket) stream.readObject();
        } catch (IOException e) {
            System.out.printf("Error! Can't read from file.");
        } catch (ClassNotFoundException e) {
            System.out.printf("Error! Can't find the class.");
        }

        basket.addFruit(new fruit("Apricots" , "Dried" , 200, 25));
        basket.addFruit(new fruit("Plums", "Dried" , 150 , 30));
        basket.addFruit(new fruit("Apple", "Dried", 250, 45));
        
        
        System.out.printf("----- MENU -----\n");
        System.out.printf("1. - Add a new fruit\n");
        System.out.printf("2. - Print all fruits \n");
        System.out.printf("3. - Basket price\n");
        System.out.printf("4. - Get fruits between 2 prices\n");
        System.out.printf("5. - Sort fruits by weight\n");
	
	
	do {
        ArrayList<fruit> fruitsIntermediate;
        System.out.printf("Task number = ");
        try {
            int task = read.nextInt();
            if (task < 1 || task > 5)
                throw new ReadError("int-menu");
            else if (task == 1) {
                System.out.printf("Fruit's name = ");
                readName = read.nextLine();
                read.nextLine();
                System.out.printf("Fruit's type = ");
                readType = read.nextLine();
                System.out.printf("Fruit's weight = ");
                readWeight = read.nextFloat();
                read.nextLine();       
                System.out.printf("Fruit's price = ");
                readPrice = read.nextFloat();
             
                
                fruit fru = new fruit(readName, readType, readWeight, readPrice);
                basket.addFruit(fru);            
            } else if (task == 2) {
                basket.showFruits(basket.getFruits());
            } else if (task == 3) {
                System.out.printf("%s price = %.2f\n\n", basket.getName(), basket.getBasketPrice());
            } else if (task == 4) {
                System.out.printf("Minimum price = ");
                int minPrice = read.nextInt();
                System.out.printf("Maximum price = ");
                int maxPrice = read.nextInt();
                fruitsIntermediate = basket.getMaximumPrice(minPrice, maxPrice);
                if (fruitsIntermediate.isEmpty()) System.out.println("In the basket aren't fruits between the prices that you indicated!"); 
                else
                System.out.printf("Fruits between 2 prices: \n");
                basket.showFruits(fruitsIntermediate);
            } else if (task == 5) {
                System.out.printf("Sorted fruits by weight:\n");
                basket.weightSort(basket.getFruits());
                basket.showFruits(basket.getFruits());
            }
        } catch (ReadError e) {
            System.out.printf("%s", e.getMessage());
        } catch (InputMismatchException e) {
            System.out.printf("Error: enter a valid value!");
        }
        finally {
            read.nextLine();
            System.out.printf("Do you want to do something more ?");
            String response = read.nextLine();
            if (response.toLowerCase().equals("no")) {
                try (FileOutputStream file = new FileOutputStream("fruits.ser");
                     ObjectOutputStream stream = new ObjectOutputStream(file)) {
                    stream.writeObject(basket);
                } catch (IOException e) {
                    System.out.printf("Error! Can't write to file.");
                }

                readCommand = false;
            }
            else
                readCommand = true;
        }
    } while (readCommand);

    read.close();
}
}

