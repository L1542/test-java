/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffee_shop1;
/**
 *
 * @author Admin
 */
public class Coffee_Shop1 {
  public static void main(String[] args) {
    // TODO code application logic here
        Coffee_Order c = new Coffee_Order();
//        System.out.println("===ยินดีต้อนรับสู่ร้านกาแฟ===");
        while(true){
            c.showMenu();
            System.out.print("เลือกรายการ(0-6) : ");
            int choose = c.getChoose();
            if(choose == -1) break;
            System.out.print("จำนวนแก้ว(แก้ว):  ");
            int much = c.onlyNum();
            c.amountCheck(much,choose);
            System.out.print("ต้องการสั่งเพิ่มหรือไม่? (y/n) :  ");
            String con = c.sc.next();
            if(con.equalsIgnoreCase("n")) break;
        }
        c.emptyOrNot();
        c.goodBye();
    }

    private static int onlyNum() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}  
