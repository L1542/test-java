package coffee_shop1;
import java.util.Scanner;

public class Coffee_Order {
        static Scanner sc = new Scanner(System.in);
        static String[] menuName = new String[10];
        static double[] price =new double[menuName.length];
        static int[] quantity = new int[menuName.length];
        Coffee_Order(){
            menuName = new String[]{"อเมริกาโน่", "ลาเต้", "คาปูชิโน่", "มอคค่า", "ชาเขียว", "โกโก้"};
            price =new double[]{45.00, 55.00, 55.00, 60.00, 50.00, 55.00};
            quantity = new int[menuName.length];
        }
        public void showMenu(){
                System.out.println("===ยินดีต้อนรับสู่ร้านกาแฟ===.");
                System.out.println("----------- เมนู -----------");
                for(int i = 0; i < menuName.length; i++){
                    System.out.println((i + 1) + ". " + menuName[i] + "\t" + String.format("%.2f", price[i]) +"     "+ " บาท");}     
                System.out.println("0. จบการสั่งซื้อ");
                System.out.println("----------------------------");
        }

        public double calculator(double pricemenu,double amount){
                double fin = pricemenu*amount;
                return fin;
        }

        public void receipt(){
                System.out.println("==============ใบเสร็จรับเงิน=============");
                double sumBefore = 0;
                for(int i=0;i<quantity.length;i++){
                if(quantity[i]==0) continue;
                    System.out.println(menuName[i]+"\t"+price[i]+"\t X"+quantity[i]+"\t"+calculator(price[i],quantity[i]));
                    sumBefore += calculator(price[i],quantity[i]);
                }
                double  net;
                net = sumBefore;
                double dis = 0;
                if( sumBefore >= 100 ){
                    dis = net*0.10;
                    net = net - dis;
                }
                System.out.println("-----------------------------");
                System.out.println("รวมทั้งหมด : "+ sumBefore);
                System.out.println("ส่วนลด : "+ dis);
                System.out.println("ยอดสุทธิ : "+ net);
        }
        public void addMenu(int Quan,int choose){
                quantity[choose] += Quan;
        }
        public int onlyNum() {
            while (!sc.hasNextInt()) {
                    System.out.print("จำนวนแก้วต้องมากกว่า 0 ");
                    sc.next();
            }
            return sc.nextInt();
        } 
        public int getChoose(){
           int chooseCheck;
            while(true){
                    chooseCheck = onlyNum();
                    chooseCheck--;
                    if(chooseCheck == -1 ) break;
                    if(chooseCheck >= 0 && chooseCheck < menuName.length) break;
                    System.out.print("เลือกรายการ(0-6) : ");
                }  
                return chooseCheck;
        }
        public void amountCheck(int amount,int where){
            if(amount > 0){
                addMenu(amount, where);
                System.out.println("เพิ่ม"+menuName[where]+" x "+amount);
            } else {
                System.out.println("จำนวนแก้วต้องมากกว่า 0 ");
            }
        }
        public void emptyOrNot(){
           for(int i=0;i<quantity.length;i++){
                if (quantity[i] != 0) {
                    receipt();
                    break;
                }
          }
        }
        public void goodBye(){
            System.out.println("=================================");
            System.out.println(" \tขอบคุณที่ใช้บริการ\t");
            System.out.println("=================================");
        }
        }