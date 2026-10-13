package coffee_shop2;

import java.util.Scanner;

public class Coffee_Order {
    private String[] menuName = {"อเมริกาโน่", "ลาเต้", "คาปูชิโน่", "มอคค่า", "ชาเขียว", "โกโก้"};
    private double[] price    = {45.00, 55.00, 55.00, 60.00, 50.00, 55.00};
    private int[] quantity    = new int[menuName.length];
    private static final int MAX_AMOUNT = 100;
    private static final String STUDENT_ID = "6830250129";
    private double extraPrice;
    private int extraQty;
    private Scanner sc = new Scanner(System.in);

    public Coffee_Order() {
        int lastTwo = Integer.parseInt(STUDENT_ID.substring(STUDENT_ID.length() - 2));
        int lastDigit = Integer.parseInt(STUDENT_ID.substring(STUDENT_ID.length() - 1));
        extraPrice = lastTwo * 2;
        extraQty = lastDigit % 5;
    }

    private double getPrice(int i) {return price[i] + extraPrice; }

    public void showMenu() {
        System.out.println("=== ยินดีต้อนรับสู่ร้านกาแฟ ===");
        System.out.println("----------- เมนู -----------");
        for (int i = 0; i < menuName.length; i++) {System.out.println((i + 1) + ". " + menuName[i] + "\t"
                + String.format("%.2f", getPrice(i)) + " บาท");}
        System.out.println("0. จบการสั่งซื้อ");
        System.out.println("----------------------------");}

    private int onlyNum() {
        while (!sc.hasNextInt()) {
            String bad = sc.next();
            System.out.print("\"" + bad + "\" ไม่ใช่ตัวเลข กรุณาป้อนตัวเลขเท่านั้น : ");}
        return sc.nextInt(); }

    private int getChoose() {
        System.out.print("เลือกรายการ (0-" + menuName.length + ") : ");
        int choose = onlyNum();
        while (choose < 0 || choose > menuName.length) {
            System.out.print("ไม่มีเมนูนี้ กรุณาเลือกใหม่ (0-" + menuName.length + ") : ");
            choose = onlyNum();}
        return choose;}

    private int getAmount() {
        System.out.print("จำนวนแก้ว : ");
        int amount = onlyNum();
        while (amount <= 0 || amount > MAX_AMOUNT) {
            if (amount <= 0) {} 
            else {
                System.out.print("สั่งได้ไม่เกิน " + MAX_AMOUNT + " แก้วต่อครั้ง กรุณาป้อนใหม่ : ");  }
            amount = onlyNum();
        }
        return amount;}

    private boolean askContinue() {
        System.out.print("สั่งต่อหรือไม่ (y/n) : ");
        String ans = sc.next();
        while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
            System.out.print("กรุณาตอบ y หรือ n เท่านั้น : ");
            ans = sc.next();}
        return ans.equalsIgnoreCase("y");}

    public void order() {
        boolean again = true;
        while (again) {
            showMenu();
            int choose = getChoose();
            if (choose == 0) { break;}
            int amount = getAmount();
            int total = amount + extraQty;
            quantity[choose - 1] += total;
            System.out.println("เพิ่ม " + menuName[choose - 1] + " x " + total
                    + " (สั่ง " + amount + " + " + extraQty + ")");
            again = askContinue();} }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < menuName.length; i++) {total += getPrice(i) * quantity[i];}
        return total;}

    public double calculateDiscount() {
        double total = calculateTotal();
        if (total >= 500) {return total * 0.10;}
        return 0;}

    public void showSummary() {
        double total = calculateTotal();
        if (total == 0) {System.out.println("ไม่มีรายการสั่งซื้อ"); return;}
        double discount = calculateDiscount();
        double net = total - discount;
        System.out.println("============== ใบสรุปคำสั่งซื้อ ==============");
        System.out.println("รหัสนิสิต : " + STUDENT_ID);
        for (int i = 0; i < menuName.length; i++) {
            if (quantity[i] == 0) continue;
            double lineTotal = getPrice(i) * quantity[i];
            System.out.println(menuName[i] + "\t" + String.format("%.2f", getPrice(i))
                    + "\t X" + quantity[i] + "\t" + String.format("%.2f", lineTotal));
        }
        System.out.println("---------------------------------------------");
        System.out.println("ราคารวม  : " + String.format("%.2f", total) + " บาท");
        System.out.println("ส่วนลด   : " + String.format("%.2f", discount) + " บาท");
        System.out.println("ราคาสุทธิ : " + String.format("%.2f", net) + " บาท");
        System.out.println("=============================================");
        System.out.println("\tขอบคุณที่ใช้บริการ\t");
        System.out.println("=============================================");
    }
}