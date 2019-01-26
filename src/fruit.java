import java.io.*;


public class fruit implements Comparable<fruit>, Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name, type;
	private float weight, price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public fruit(String name, String type, float weight, float price )
	{
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.price = price;
		
	}
	
	public String toString()
	{
		return "\nFruit: " + this.name + "\nType: " + this.type + "\nWeight: " + this.weight + "\nPrice: " + this.price + "\n";
	}
	

	 public int compareTo(fruit fruitToCompare) {
	        float compareWeight = fruitToCompare.getWeight();
	        return (int)(this.getWeight() - compareWeight);
	    }
	 
}
