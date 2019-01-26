import java.util.ArrayList;
import java.util.Collections;
import java.io.*;


public class FruitBasket implements Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String name;
	    private ArrayList<fruit> fruits = new ArrayList<>();

	    // getters
	    public ArrayList<fruit> getFruits() { return this.fruits; }
	    public String getName() { return this.name; }
	    
	    public void setFruits(ArrayList<fruit> fruits) { this.fruits = fruits; }

	    // constructor
	    public FruitBasket() {}
	    public FruitBasket(String name) {
	        this.name = name;
	    }

	    // methods
	    // add a new fruit
	    public void addFruit(fruit f) {
	        fruits.add(f);
	    }
	    
	 // print all fruits
	    public void showFruits(ArrayList<fruit> fruitsArray) {
	        
	        for (fruit f: fruitsArray) {
	        	System.out.printf("\n== Fruit nr %d ==\n%s", fruitsArray.indexOf(f) + 1, f);

	        }
	        }
	    
	    
	    // get the basket price
	    public float getBasketPrice() {
	        float price = 0, p = 0;
	        for (fruit f: fruits) {
	        	p = f.getPrice()*f.getWeight();
	            price += p;
	        }
	        return price;
	    }
	    
	 // get fruits between 2 prices
	    public ArrayList<fruit> getMaximumPrice(float minPrice, float maxPrice) {
	        ArrayList<fruit> fruits = new ArrayList<>();
	        for (fruit f: this.fruits) {
	            if (f.getPrice() >= minPrice && f.getPrice() <= maxPrice) {
	                fruits.add(f);
	            }
	            
	        }
	        return fruits;
	    }
	    
	    // sort by weight
	    public void weightSort(ArrayList<fruit> fruits) {
	        Collections.sort(fruits);
	    }

	    // serialization
	    public void writeExternal(ObjectOutput out) {
	        try {
	            out.writeUTF(this.name);
	            out.writeObject(this.fruits);
	        } catch (IOException e) {
	            System.out.printf("Error! Can't write to file.");
	        }
	    }

	    // deserialization
	    @SuppressWarnings("unchecked")
		public void readExternal(ObjectInput in) {
	        try {
	            this.name = in.readUTF();
	            this.fruits = (ArrayList<fruit>) in.readObject();
	        } catch (IOException e) {
	            System.out.printf("Error! Can't write to file.");
	        } catch (ClassNotFoundException e) {
	            System.out.printf("Error! Can't find a class.");
	        }
	    }
	
}
