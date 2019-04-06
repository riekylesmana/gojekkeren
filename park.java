//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
// Also, sorry that the "Paste" feature no longer works! GitHub broke
// this (so we'll switch to a new provider): https://blog.github.com\
// /2018-02-18-deprecation-notice-removing-anonymous-gist-creation/
//*******************************************************************
 	
import java.util.*;
import java.util.Scanner;


// one class needs to have a main() method
public class HelloWorld
{
  
//Define slot for parking
public static ArrayList<Car> parkSlot;
	
public static String create_parking_lot(int totalSlot){
	parkSlot =  new ArrayList<Car>(totalSlot);
	return "Created a parking lot with "+totalSlot+" slots";
}
  
public static String park(ArrayList<Car> parkSlot, String carNumber, String colorCar ){
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
	return "Allocated slot number: "+ freeSlot+1;
}
  
public static String leave(int parkNumber){
	//set free slot in index
	parkSlot.get(parkNumber-1).setIsPark(false);
	return "Slot number "+parkNumber+" is free";
}

public static String status(){
  String textReturn="";
	for(int i=0;i<parkSlot.size();i++){
		textReturn = "Slot No. Registration No Colour";
		if(parkSlot.get(i).getIsPark()==true){
			textReturn += i+" "+parkSlot.get(i).getCarNumber()+" "+parkSlot.get(i).getColorCar();
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
	if(textReturn!=""){
		return textReturn;
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
	if(textReturn!=""){
      	return textReturn;
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
	if(textReturn!=""){
      	return textReturn;
	}
  return "Not found";
}

  
 
  
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {   
    //sample input
    String input="create_parking_lot 6";
    String [] arrInput=input.split(" ");
    if(arrInput.length>3){
      System.out.print("wrong iput"); 
    }else{
      switch(arrInput[0]){
       	case "create_parking_lot"						: System.out.println(create_parking_lot(Integer.parseInt(arrInput[1])));
        case "park"										: System.out.println(park(parkSlot,arrInput[1],arrInput[2]));
       	case "leave"									: System.out.println(leave(Integer.parseInt(arrInput[1])));
       	case "status"									: System.out.println(status());
       	case "registration_numbers_for_cars_with_colour": System.out.println(registration_numbers_for_cars_with_colour(arrInput[1]));
       	case "slot_numbers_for_cars_with_colour"		: System.out.println(slot_numbers_for_cars_with_colour(arrInput[1]));
       	case "slot_number_for_registration_number"		: System.out.println(slot_number_for_registration_number(arrInput[1]));
      }
    }  
  }
}
 
//Object Car
public class Car
{
  private String carNumber;
  private String colorCar;
  private boolean isPark;
  Car(String carNumber, String colorCar){
		this.carNumber=carNumber;
		this.colorCar=colorCar; 
		this.isPark=false;
	}
  
  public void setCarNumber(String carNumber){
    this.carNumber=carNumber; 
  }
  public String getCarNumber(){
    return this.carNumber; 
  }
  public void setColorCar(String colorCar){
    this.carNumber=carNumber; 
  }
  public String getColorCar(){
    return this.colorCar; 
  }
  public void setIsPark(boolean isPark){
    this.isPark=isPark;
  }
  public boolean getIsPark(){
    return this.isPark;
  }
  
  
}
