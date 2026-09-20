package coffee;
import java.util.Scanner;
public class Coffee {
    static String[] menu = {"อเมริกาโน่","ลาเต้","คาปูชิโน่","มอคค่า","ชาเขียว","โกโก้"};
    static double[] bath = {45.00,55.00,55.00,60.00,50.00,55.00};
    static double[] orderAmount = new double[6];



    public static void main(String[] args) {
        System.out.println("===ยินดีต้อนรับสู่ร้านกาแฟ==="); 
        showMenu();
        order();     
        receipt();
        
        }
         
        public static void showMenu() {
            System.out.println();
            System.out.println("--------เมนูสินค้า---------"); 
            for (int i = 0; i < menu.length; i++) 
                System.out.println((i + 1) + ". " + menu[i] + "\t" +String.format("%.2f", bath[i]) + " บาท");
             System.out.println("0. จบการสั่งซื้อ");
             System.out.println("---------------------------"); } 


       public static void order() { 
           Scanner sc = new Scanner(System.in); 
           while (true) { 
               System.out.print("เลือกรายการ(0-6) : "); 
               int c = sc.nextInt(); 
               if (c == 0) { break; } 
               if (c < 1 || c > 6) { System.out.println("กรุณาเลือกเมนู 1-6"); continue; } 
               System.out.print("จำนวนแก้ว(แก้ว): "); 
               int amount = sc.nextInt(); 
               orderAmount[c-1] += amount;
               System.out.println(">> เพิ่ม  " + menu[c - 1]+ "x"+amount+"แล้ว"); 
               System.out.print("ต้องการสั่งเพิ่มหรืไม่? (y/n) : ");
               String a = sc.next();
               if(a.equalsIgnoreCase("y")){
                   showMenu();
                   continue;}
               else {break;}
           } 
       
       }
       
       public static double calculateTotal(){
           double total = 0 ; 
           for (int i = 0 ; i < menu.length;i++){
               total += orderAmount[i] * bath[i];
           }
           return total;                   
       }
       
       public static  double calculateDiscount(double total){
           double discount = 0;
            if (total >= 500) {discount = total * 10 / 100;}   
            else if (total >= 300) {discount = total * 5 / 100;}
            return discount;
       }
       
       public static void receipt(){
           double total = calculateTotal();
           double discount = calculateDiscount(total);
           double net = total - discount;
           System.out.println("==============ใบเสร็จรับเงิน=============");
           System.out.println("รายการ "+"\t"+" จำนวน ราคา/หน่วย "+"\t"+"  รวม");
           System.out.println("---------------------------------------------------------------------------");        
            for (int i = 0; i < menu.length; i++) {
                if (orderAmount[i] > 0) {
                    double price = bath[i] * orderAmount[i];
                    System.out.println(menu[i] +"      \t"+bath[i]+ " x " +orderAmount[i] + "\t\t " +price + " บาท");}}
           System.out.println("---------------------------------------------------------------------------");
           System.out.println("รวมส่วดลด : "+"\t"+total);
           System.out.println("ส่วดลด : "+"\t"+discount);
           System.out.println("ยอดสุทธิ : "+"\t"+net);
           System.out.println("==================================");
           System.out.println("\t"+"ขอบคุณที่ใช้บริการ"+"\t");
           System.out.println("==================================");   
       }

}

        
    
    
