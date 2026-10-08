package coffee_shop;
public class Coffee_Shop {
    public static void main(String[] args) {
        CoffeeOrder order = new CoffeeOrder("ลาเต้", 50+(29*2), 6+(9%5)); 
        order.printSummary();
    }
    
}
