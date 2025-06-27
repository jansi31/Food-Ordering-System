package projects;
import java.util.*;
class food{
	String name;
	int price;
	Scanner s=new Scanner(System.in);
	food(){
		
	}
	food(String name){
		this.name=name;
	}
	 Map<Integer,food> menu =new HashMap<>();
     List<food> cart=new ArrayList<>();
	food(String name,int price){
		this.name=name;
		this.price=price;
	}
	public void display() {
		System.out.println("Item: "+name+" "+"Price: "+price);
	}
	public void showmenu() {
		System.out.println("Menu:");
		for(Map.Entry<Integer, food> entry:menu.entrySet()) {
			System.out.print(entry.getKey()+"."+" ");
			entry.getValue().display();
		}
		
	}
	public void additem(String item) {
		int flag=0;
		for(Map.Entry<Integer, food> entry:menu.entrySet()) {
		if(entry.getValue().name.equalsIgnoreCase(item)) {
			cart.add(entry.getValue());
			System.out.println("added successfully");
			flag=1;
			return;
		}
	}
		if(flag==0) {
			System.out.println("Invalid item");
		}
	}
	public void viewcart() {
		
			for(food c:cart) {
			 c.display();
			
		}
	}
	public void removeitem(String name) {
		for(Map.Entry<Integer, food> en:menu.entrySet()) {
			if(en.getValue().name.equalsIgnoreCase(name)) {
				cart.remove(en.getValue());
				System.out.println("removed successfully");
			}
		}
	}
	public void checkout() {
		if(cart.isEmpty()) {
			System.out.println("Your cart is empty");
			return;
		}
		System.out.println("Order Summary");
		int total=0;
		for(food f:cart) {
			f.display();
			total+=f.price;
		}
		System.out.println("Total Amount: "+total);
		System.out.println("Do You want to conform the order(yes or no)");
		String want=s.nextLine();
		if(want.equalsIgnoreCase("yes")) {
			System.out.println("Order placed successfully");
			cart.clear();
		
		}else {
			System.out.println("Order cancelled");
			cart.clear();
		}
	}
}
public class FoodOrderingsystem {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		food f=new food();
		f.menu.put(1,new food("biryani",100));
	     f.menu.put(2,new food("chicken rice",80));
	     f.menu.put(3,new food("idly",50));
	     f.menu.put(4,new food("dhosa",60));
     
      
      System.out.println("Food Ordering System");
      while(true) {
      System.out.println("1.show item");
      System.out.println("2.Add Item to the cart");
      System.out.println("3.Remove Item from the cart");
      System.out.println("4.view cart");
      System.out.println("5.checkout");
      System.out.println("6.Exit");
      System.out.println("enter your choice");
      int choice=sc.nextInt();
      sc.nextLine();
      switch(choice) {
      case 1:
    	  f.showmenu();
    	  break;
      case 2:
    	  System.out.println("enter the item to be added to the cart");
    	  String item=sc.nextLine();
    	  f.additem(item);
    	  break;
      case 3:
    	  System.out.println("enter the item to be remove from the cart:");
    	  String name=sc.nextLine();
    	  f.removeitem(name);
    	  break;
      case 4:
    	  f.viewcart();
    	  break;
      case 5:
    	  f.checkout();
    	  break;
      case 6:
    	  return;
      }
      
	}
	}
}
