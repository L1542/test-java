package coffee_shop;
public class CoffeeOrder { 
    String menuName; 
    double price; 
    int quantity; 
    public CoffeeOrder(String menuName, double price, int quantity) {
        this.menuName = menuName;
        this.price = price;
        this.quantity = quantity; } 
    
    public double calculateTotal() { 
        return price * quantity; } 
    
    public double calculateDiscount() { 
        double total = calculateTotal(); 
        if (total >= 500) { return total * 0.10; } 
        return 0; }
    
    public void printSummary() { 
        double total = calculateTotal(); 
        double discount = calculateDiscount(); 
        double net = total - discount; 
        System.out.println("========== ใบสรุปคำสั่งซื้อ =========="); 
        System.out.println("ชื่อเมนู : " + menuName); 
        System.out.println("ราคา : " + price + " บาท"); 
        System.out.println("จำนวน : " + quantity); 
        System.out.println("ราคารวม : " + total + " บาท"); 
        System.out.println("ส่วนลด : " + discount + " บาท"); 
        System.out.println("ราคาสุทธิ : " + net + " บาท"); 
        System.out.println("======================================"); } 
}