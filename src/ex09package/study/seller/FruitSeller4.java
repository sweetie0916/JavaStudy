package ex09package.study.seller;

public class FruitSeller4 {
   //멤버변수
      //보유한 사과의 재고수량
      int numOfApple; 
      //판매 수익금
      int myMoney;
      //기존에 상수로 선언했던 부분을 일반 멤버변수로 변경했다.
      final int APPLE_PRICE;
      /* 멤버상수는 값의 변경이 불가능하고, 단 한번만 초기화되기
      때문에 일반 메서드에서는 초기화할 수 없다. 또한 초기값이
      없는 상태로 선언 자체가 불가능하다.
      하지만 새엇ㅇ자는 객체생성시 딱 한번만 호출되고, 개발자가 마음대로
      호출할 수 없으므로 한번 이상 초기화되지 않음이 보장된다.
      따라서 멤멉상수는 생성자에서 초기화할 수 있다. */
      
      /* 초기화 메서드를 선언하여 객체 생성 후 다양한 형태의
      초기화가 가능하다. */
      public FruitSeller4(int money, int appleNum, int price) {
         myMoney = money;
         numOfApple = appleNum;
         APPLE_PRICE = price;
      }
      
      //판매자의 현재 상태를 출력한다.
      public int saleApple(int money) {
         int num = money / APPLE_PRICE;
         numOfApple -= num;
         myMoney += money;
         return num;
      }
      //구매자의 현재상태 출력
      public void showsaleResult() {
         System.out.println("[판매자]남은 사과갯수:" + numOfApple);
         System.out.println("[판매자]판매수익:" + myMoney);
      }

   
}