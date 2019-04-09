
import static org.junit.Assert.assertEquals;

import java.util.*;
 
public class GojekPark extends Car
{  
	//Define slot for parking
	public static ArrayList<Car> parkSlot = null;
	 
	public static String create_parking_lot(int totalSlot){
		parkSlot = new ArrayList<Car>(totalSlot);
		for (int i = 0; i < totalSlot; i++) {
			parkSlot.add(new Car());
		}
		return "Created a parking lot with "+totalSlot+" slots";
	}

	public static String park(String carNumber, String colorCar ){
		//check for free slot 
		int freeSlot=-1;
		for(int i=0;i<parkSlot.size();i++){
			if(parkSlot.get(i).getIsPark()==false){
				freeSlot=i;
				break;
			}
		} 
		//if the slot already full
		if(freeSlot < 0){
			return "Sorry, parking lot is full";
		}
	
		//add car to free slot
		parkSlot.get(freeSlot).setCarNumber(carNumber);
		parkSlot.get(freeSlot).setColorCar(colorCar);
		parkSlot.get(freeSlot).setIsPark(true);
		return "Allocated slot number: "+ (freeSlot+1);
	}

	public static String leave(int parkNumber){
		//set free slot in index
		parkSlot.get(parkNumber-1).setIsPark(false);
		return "Slot number "+parkNumber+" is free";
	}

	public static String status(){
		String textReturn = "Slot No. Registration No Colour\n";
		for(int i=0;i<parkSlot.size();i++){
			if(parkSlot.get(i).getIsPark()==true){
				textReturn += i+1+" "+parkSlot.get(i).getCarNumber()+" "+parkSlot.get(i).getColorCar()+"\n";
			} 
		} 
		if(textReturn != ""){
			return textReturn;
		} 
		return "Not Found."; 
	}

	public static String registration_numbers_for_cars_with_colour(String colorCar){ 
		String textReturn="";
		for(int i=0;i<parkSlot.size();i++){ 
			if(parkSlot.get(i).getColorCar() == colorCar){ 
				textReturn += parkSlot.get(i).getCarNumber()+", ";
			} 
		}
		if(textReturn != ""){
			return textReturn.replaceAll(", $", "");
		}
		return "Not found";
	}

	public static String slot_numbers_for_cars_with_colour(String colorCar){
		String textReturn=""; 
		for(int i=0;i<parkSlot.size();i++){ 
			if(parkSlot.get(i).getColorCar() == colorCar){ 
				textReturn += i+1+", ";
			} 
		}
		if(textReturn != ""){
			return textReturn.replaceAll(", $", "");
		}
		return "Not found";
	}

	public static String slot_number_for_registration_number(String carNumber){
		String textReturn=""; 
		for(int i=0;i<parkSlot.size();i++){ 
			if(parkSlot.get(i).getCarNumber() == carNumber){  
			 	textReturn += i+1+", ";
			} 
		}
		if(textReturn != ""){
			return textReturn.replaceAll(", $", "");
		}
		return "Not found";
	}




// arguments are passed using the text field below this editor
	public static void main(String[] args)
	{     

//		//sample data 
//		System.out.println(create_parking_lot(6));
//		System.out.println(park("KA-01-HH-1234","White"));
//		System.out.println(park("KA-01-HH-9999" ,"White"));
//		System.out.println(park("KA-01-BB-0001" ,"Black"));
//		System.out.println(park("KA-01-HH-7777" ,"Red"));
//		System.out.println(park("KA-01-HH-2701" ,"Blue"));
//		System.out.println(park("KA-01-HH-3141" ,"Black"));
//		System.out.println(leave(4));
//		System.out.println(status());
//		System.out.println(park("KA-01-P-333","White"));
//		System.out.println(park("DL-12-AA-9999","White"));
//		System.out.println(registration_numbers_for_cars_with_colour("White"));
//		System.out.println(slot_numbers_for_cars_with_colour("White"));
//		System.out.println(slot_number_for_registration_number("KA-01-HH-3141"));
//		System.out.println(slot_number_for_registration_number("MH-04-AY-1111"));
		
		 
		 //sample input  
//		 String input		=	"create_parking_lot 6";
		
		//comment this "while" if you only want call 1 statement
		 while(true){
			 String input = "";
			 System.out.println("Input: ");
			 Scanner scanner = new Scanner(System.in);
			 input = scanner.nextLine();
			 
			 //split input with space char
			 String [] arrInput	=	input.split(" ");
			 if(arrInput.length>3){
			   System.out.print("wrong iput"); 
			 }else{
			   switch(arrInput[0]){
			    	case "create_parking_lot": 
			    		try {
			    			System.out.println(create_parking_lot(Integer.parseInt(arrInput[1]))); 
						} catch (Exception e) {
							System.out.println("Wrong Input Param.");
						}break;
			    	case "park": 
				    		try {
				    			System.out.println(park(arrInput[1],arrInput[2]));
							} catch (NullPointerException e) {
								System.out.println("Wrong Input Param.");
							}break; 
			    	case "leave": 
			    		try {
			    			System.out.println(leave(Integer.parseInt(arrInput[1]))); 
						} catch (Exception e) {
							System.out.println("Wrong Input Param.");
						}break; 
			    	case "status": 
			    		try {
			    			System.out.println(status()); 
						} catch (Exception e) {
							System.out.println("Wrong Input Param.");
						}break; 
			    	case "registration_numbers_for_cars_with_colour":
			    		try {
			    			System.out.println(registration_numbers_for_cars_with_colour(arrInput[1])); 
						} catch (Exception e) {
							System.out.println("Wrong Input Param.");
						}break; 
			    	case "slot_numbers_for_cars_with_colour": 
			    		try {
			    			System.out.println(slot_numbers_for_cars_with_colour(arrInput[1])); 
						} catch (Exception e) {
							System.out.println("Wrong Input Param.");
						}break; 
			    	case "slot_number_for_registration_number": 
			    		try {
			    			System.out.println(slot_number_for_registration_number(arrInput[1]));
						} catch (Exception e) {
							System.out.println("Wrong Input Param.");
						}break; 
			    	default : System.out.print("wrong iput");break;
			   }
			 }
		 }  
	} 

}

