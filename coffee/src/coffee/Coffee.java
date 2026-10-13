package coffee;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Coffee {
    static Scanner sc = new Scanner(System.in);
    static String[] menu = {"อเมริกาโน่", "ลาเต้", "คาปูชิโน่", "มอคค่า", "ชาเขียว", "โกโก้"};
    static double[] bath = {45.00, 55.00, 55.00, 60.00, 50.00, 55.00};
    static int[] orderAmount = new int[menu.length];

    public static void main(String[] args) {
        System.out.println("=== ยินดีต้อนรับสู่ร้านกาแฟ ===");
        showMenu();
        order();
        receipt();}

    public static void showMenu() {
        System.out.println();
        System.out.println("-------- เมนูสินค้า ---------");
        for (int i = 0; i < menu.length; i++) {System.out.println((i + 1) + ". " + menu[i] + "\t" + String.format("%.2f", bath[i]) + " บาท"); }
        System.out.println("0. จบการสั่งซื้อ");
        System.out.println("---------------------------");}

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("กรุณาป้อนตัวเลขเท่านั้น");
                sc.next();}}}

    public static void order() {
        while (true) {
            int c = readInt("เลือกรายการ(0-" + menu.length + ") : ");
            if (c == 0) {break;}
            if (c < 1 || c > menu.length) {System.out.println("กรุณาเลือกเมนู 1-" + menu.length);continue;}
            int amount = readInt("จำนวนแก้ว(แก้ว) : ");
            if (amount <= 0) {System.out.println("จำนวนแก้วต้องมากกว่า 0");continue;}
            orderAmount[c - 1] += amount;
            System.out.println(">> เพิ่ม " + menu[c - 1] + " x " + amount + " แล้ว");

            while (true) {
                System.out.print("ต้องการสั่งเพิ่มหรือไม่? (y/n) : ");
                String a = sc.next();
                if (a.equalsIgnoreCase("y")) {showMenu();break;} 
                else if (a.equalsIgnoreCase("n")) {return;} 
                else {System.out.println("เลือกได้แค่ y/n");}}}}

    public static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < menu.length; i++) {total += orderAmount[i] * bath[i];}
        return total;}

    public static double calculateDiscount(double total) {
        double discount = 0;
        if (total >= 500) {discount = total * 10 / 100;} 
        else if (total >= 300) {discount = total * 5 / 100;}
        return discount;}

    public static void receipt() {
        boolean hasOrder = false;
        for (int qty : orderAmount) {
            if (qty > 0) {
                hasOrder = true;
                break;}}
        if (!hasOrder) {
            System.out.println("ไม่มีรายการสั่งซื้อ");
            return;
        }

        double total = calculateTotal();
        double discount = calculateDiscount(total);
        double net = total - discount;

        System.out.println();
        System.out.println("============== ใบเสร็จรับเงิน =============");
        System.out.println("รายการ\tจำนวน ราคา/หน่วย\tรวม");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < menu.length; i++) {
            if (orderAmount[i] > 0) {
                double price = bath[i] * orderAmount[i];
                System.out.println(menu[i] + "\t" + orderAmount[i] + " x " + String.format("%.2f", bath[i])
                        + "\t" + String.format("%.2f", price) + " บาท");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("รวมทั้งหมด :\t" + String.format("%.2f", total) + " บาท");
        System.out.println("ส่วนลด :\t" + String.format("%.2f", discount) + " บาท");
        System.out.println("ยอดสุทธิ :\t" + String.format("%.2f", net) + " บาท");
        System.out.println("==================================");
        System.out.println("       \tขอบคุณที่ใช้บริการ");
        System.out.println("==================================");
    }
}