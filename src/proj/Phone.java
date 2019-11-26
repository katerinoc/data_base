package proj;



public class Phone {

   // private int id;
    private String brand;
    private int vendor_code;
    private int price;

    public Phone(/*int id*/String brand, int vendor_code, int price) {
       // this.id = id;
        this.brand = brand;
        this.vendor_code = vendor_code;
        this.price = price;
    }

    public Phone() {
    }
    /*
    public Phone(Integer id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(int vendor_code) {
        this.vendor_code = vendor_code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
/*
public class Phone {
	    String brand; 
	    int vendor_code;
	    int price;
	 
	   // boolean sensor;
	  
	    
	   

	    public Phone(String brand, Integer vendor_code, Integer price) {
	        this.brand = brand;
	        this.vendor_code = vendor_code;
	        this.price = price;
	        
	       // this.sensor = sensor;
	    }
public Phone() {}
/* 	    public Phone(String brand) {
	        this.brand = brand;
	    } 

	    public String get_brand() {
	        return brand;
	    }

	    public void set_brand(String brand) {
	        this.brand = brand;
	    }

	    public int get_vendor_code() {
	        return vendor_code;
	    }

	    public void set_vendor_code(Integer vendor_code) {
	        this.vendor_code = vendor_code;
	    }

	    public int get_price() {
	        return price;
	    }

	    public void set_price(Integer price) {
	        this.price = price;
	    }

	   */

//	    public boolean get_sensor() {
	//        return sensor;
	  //  }

//	    public void set_sensor(boolean sensor) {
	//        this.sensor = sensor;
	  //  }
//}
