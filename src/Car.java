
//Object Car
public class Car
{
  private String carNumber;
  private String colorCar;
  private boolean isPark;
  public Car() { 
		this.isPark=false;
  }
  public Car(String carNumber, String colorCar){
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
    this.colorCar=colorCar; 
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
