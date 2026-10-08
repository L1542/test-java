# Coffee Shop Java

โปรแกรมร้านกาแฟสำหรับรับรายการสั่งซื้อ คำนวณราคา และแสดงใบเสร็จ

## รายละเอียดโปรแกรม

โปรแกรมนี้พัฒนาด้วยภาษา Java โดยใช้แนวคิดการเขียนโปรแกรมแบบ Object-Oriented Programming (OOP)

โปรแกรมสามารถทำงานได้ดังนี้

- แสดงรายการเมนูเครื่องดื่ม
- เลือกเมนูที่ต้องการสั่ง
- ระบุจำนวนเครื่องดื่ม
- ตรวจสอบข้อมูลที่ผู้ใช้กรอก
- คำนวณราคาสินค้า
- สามารถสั่งซื้อหลายรายการได้
- คำนวณส่วนลด 10% เมื่อซื้อครบ 100 บาทขึ้นไป
- แสดงใบเสร็จ
- แสดงราคาก่อนลด ส่วนลด และราคาสุทธิ

## เมนู

| No. | Menu | Price |
|---|---|---:|
| 1 | Espresso | 60 Baht |
| 2 | Americano | 65 Baht |
| 3 | Latte | 75 Baht |
| 4 | Cappuccino | 75 Baht |
| 5 | Mocha | 65 Baht |
| 6 | Tea | 40 Baht |
| 7 | Green tea with milk | 50 Baht |
| 8 | Fresh milk | 45 Baht |
| 9 | Chocolate | 50 Baht |
| 10 | Lychee juice | 40 Baht |

## วิธีการใช้งาน

1. เปิดโปรแกรม
2. เลือกหมายเลขเมนูที่ต้องการ
3. กรอกจำนวนที่ต้องการสั่ง
4. เลือกว่าจะสั่งสินค้าเพิ่มเติมหรือไม่
5. เมื่อสั่งเสร็จ โปรแกรมจะแสดงใบเสร็จ
6. หากยอดรวมตั้งแต่ 100 บาทขึ้นไป จะได้รับส่วนลด 10%

## ตัวอย่างการทำงาน

```text
*****Welcome to cafe.*****

Here is our menu.
----------- Menu -----------
1   Espresso
2   Americano
3   Latte
4   Cappuccino
5   Mocha
6   Tea
7   Green tea with milk
8   Fresh milk
9   Chocolate
10  Lychee juice
----------------------------

Please choose menu by enter number.(1-10)(0=close): 2
How much. : 2
Added Americano x 2

Would you like to continue shopping? (y/n) : n

========== RECEIPT ==========
Americano    65.0    X2    130.0
-----------------------------
Total price(before discount) = 130.0
Discount = 13.0
Net price = 117.0

=================================
 Thank you for using our service.
=================================
