
package cafe;
import java.util.Scanner;

public class Cafe {
  
    static String[] menu = {"Espresso","Americano","Latte","Cappuccino","Mocha"};
    static double[] priceMenu ={65,60,75,70,60};
    static double[] addAmount = new double[menu.length];
    public void showMenu(){
            System.out.println("====ยินดีต้อนรับสู่ร้านกาแฟ====");
            System.out.println("-----------เมนูสินค้า-----------");
            for(int i = 0; i < menu.length; i++){
                System.out.println( (i+1) +"."+ menu[i]+"\t" +priceMenu[i]+"   บาท");
            }
            System.out.println("-----------------------------------");
    }
    
    public double calculator(double pricemenu,double amount){
            double fin = pricemenu*amount;
            return fin;
    }

    public void receipt(){
            System.out.println("========== ใบเสร็จรับเงิน ==========");
            double sumBefore = 0;
            System.out.println("รายการ    จำนวนราคาต่อหน่วย     รวม");
            System.out.println("-------------------------------------------------------");
            for(int i=0;i<addAmount.length;i++){
            if(addAmount[i]==0) continue;
                System.out.println(menu[i]+"\t"+addAmount[i]+"   "+priceMenu[i]+"       "+calculator(priceMenu[i],addAmount[i])+"   บาท");
                sumBefore += calculator(priceMenu[i],addAmount[i]);
            }
            double  net = 0;
            net = sumBefore;
            double dis = 0;
            if( sumBefore >= 100 ){
                dis = net*0.10;
                net = net - dis;
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("รวมก่อนส่วนลด    =   "+ sumBefore+"   บาท");
            System.out.println("ส่วนลด               =   "+ dis+"   บาท");
            System.out.println("ยอดสุทธิ             =   "+ net+"   บาท");
    }
    public void addmenu(int Quan,int choose){
            addAmount[choose] += Quan;
    }
    public static void main(String[] args) {
            Cafe c = new Cafe();
            Scanner sc = new Scanner(System.in);
            int choose;
            while(true){
                c.showMenu();
                System.out.print("เลือกรายการ(1-5|0=close): ");
                while(true){
                    if(!sc.hasNextInt()){
                    System.out.print("จำนวน(แก้ว) : ");
                    sc.next();
                    continue;
                }
                choose = sc.nextInt();
                choose--;
                if(choose == -1 ) break;
                if(choose >= 0 && choose < menu.length) break;
                System.out.print("เลือกรายการ(1-5|0=close) : ");
                }  
                if(choose == -1) break;
                    System.out.print("จำนวน(แก้ว) : ");
                while(!sc.hasNextInt()){
                    System.out.print("กรุณาพิมพ์เฉพาะตัวเลข : ");
                    sc.next();
                }
                int much = sc.nextInt();
                if(much > 0){
                    c.addmenu(much, choose);
                    System.out.println(">>เพิ่ม  "+menu[choose]+" x "+much+"แล้ว");
                } else {
                    System.out.println("จำนวนของที่สั้งต้องมากกว่า 0 ");
                }
                System.out.print("ต้องการสั่งเพิ่มหรือไม่ ? (y/n) : ");
                String con = sc.next();
                if(con.equalsIgnoreCase("n")) break;
                }
                for(int i=0;i<Cafe.addAmount.length;i++){
                    if (Cafe.addAmount[i] != 0) {
                    c.receipt();
                    break;
                    }
                }
            System.out.println("=================================");
            System.out.println("\tขอบคุณที่ใช้บริการ\t");
            System.out.println("=================================");
    }
}