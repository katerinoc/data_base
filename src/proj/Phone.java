package proj;



public class Phone {

  
    private String brand;
    private int vendor_code;
    private int price;

    public Phone(String brand, int vendor_code, int price) {
      
        this.brand = brand;
        this.vendor_code = vendor_code;
        this.price = price;
    }

    public Phone() {
    }
    

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(Integer vendor_code) {
        this.vendor_code = vendor_code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

