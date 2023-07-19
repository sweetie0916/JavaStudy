package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Friend {
   // 멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 저장.
   String name;
   String phone;
   String addr;
   // 생성자 : 멤버변수 초기화.
   public Friend(String name, String phone, String addr) {
      this.name = name;
      this.phone = phone;
      this.addr = addr;
   }
   // 멤버변수 전체를 출력하기 위한 멤버메서드
   public void showAllData() {
      System.out.println("이름:"+ name);
      System.out.println("전화번호:"+ phone);
      System.out.println("주소:"+ addr);
   }
   public void showBasicInfo() {}
}

// 고등학교 친구의 정보를 저장할 클래스
class HighFriend extends Friend {
   // 확장한 멤버변수 : 별명
   String nickname;
   // 생성자 : 부모의 생성자를 먼저 호출한 후 멤버변수 초기화.
   public HighFriend(String name, String phone, String addr, String nickname) {
      super(name, phone, addr);
      this.nickname = nickname;
   }
   @Override
   public void showAllData() {
      System.out.println("==고딩친구(전체정보)==");
      super.showAllData();
      System.out.println("별명:"+ nickname);
   }
   @Override
   public void showBasicInfo() {
      System.out.println("==고딩친구==");
      System.out.println("별명:"+ nickname);
      System.out.println("전화번호:"+ phone);
   }
}

// 대학교 친구 정보를 저장하기 위한 클래스
class UnivFriend extends Friend {
   // 확장한 멤버변수로 전공과목을 표현
   String major;
   // 생성자
   public UnivFriend(String name, String phone, String addr, String major) {
      super(name, phone, addr);
      this.major = major;
   }
   // 오버라이딩1,2 역시 HighFriend 클래스와 동일한 패턴으로 정의됨
   @Override
   public void showAllData() {
      System.out.println("==대딩친구(전체정보)==");
      super.showAllData();
      System.out.println("전공:"+ major);
   }
   @Override
   public void showBasicInfo() {
      System.out.println("==대딩친구==");
      System.out.println("이름:"+ name);
      System.out.println("전화번호:"+ phone);
   }
}

// 메인클래스
public class MyFriendInfoList {
   public static void menuShow() {
      System.out.println("############ 메뉴를 입력하세요 ############");
      System.out.print("1. 고딩친구입력 ");
      System.out.println("2. 대딩친구입력 ");
      System.out.print("3. 전체정보출력 ");
      System.out.println("4. 간략정보출력 ");
      System.out.print("5. 검색 ");
      System.out.print("6. 삭제 ");
      System.out.println("7. 프로그램종료 ");
      System.out.print("메뉴선택>>>");
   }
   public static void main(String[] args) {
      // 사용자 입력을 위한 인스턴스 생성
      Scanner scan = new Scanner(System.in);
      // 기능을 담당하는 핸들러 클래스의 인스턴스 생성. 컬렉션은 인스턴스
      // 생성시 크기를 저장할 필요가 없다. 데이터의 갯수에 따라 자동으로 증가된다.
      FriendInfoHandler handler = new FriendInfoHandler();
      
      while(true) {
         // 1. 메뉴를 출력한다.
         menuShow();
         
         // 2. 사용자는 수행할 기능의 메뉴를 선택한다.
         int choice = scan.nextInt();
         
         // 3. 선택한 번호에 따라 switch문으로 각 메서드를 호출한다.
         switch(choice) {
         case 1: case 2:
            handler.addFriend(choice);
            break;
         case 3:
            handler.showAllData();
            break;
         case 4:
            handler.showSimpleData();
            break;
         case 5:
            handler.searchInfo();
            break;
         case 6:
            handler.deleteInfo();
            break;
         case 7:
            System.out.println("프로그램종료");
            return;
         } // switch 끝
      } // while 끝
   } // main 끝
} // class 끝

class FriendInfoHandler {
   // 멤버변수
//   private Friend[] myFriends;
//   private int numOfFriends;
	
	/* 기존에 인스턴스배열에 저장했던 것을 컬렉션으로 변경한다. 컬렉션은
	제네릭을 기반으로 하므로 인스턴스 생성시 저장할 객체의 타입을 결정하게 된다.
	여기서는 Friend클래스를 상속한 High, Univ를 저장할 것이므로
	아래와 같이 선언하면 된다. */
	 ArrayList<Friend> myFriends;
   
   // 생성자 : 컬렉션은 데이터 저장시 자동인덱싱이 되므로 크기는 필요없다.
   public FriendInfoHandler() {
//      System.out.println("생성자 호출됨");
      // 정보를 저장할 인스턴스 배열을 생성한다.
//      myFriends = new Friend[num];
      // 배열의 인덱스는 0부터 시작이므로 이와같이 초기화한다.
//      numOfFriends = 0;
	   //생성자에서 정보를 저장할 List계열의 컬렉션을 생성한다.
	   myFriends = new ArrayList<Friend>();
   }
   
   /*
    * 연습문제] List컬렉션을 기반으로  친구(고딩/대딩) 정보를 
    * 추가하는 프로그램을 작성하시오. 1차는 추가/출력1/출력2
    * 까지 진행합니다.
    * 출력1은 확장 for문을 통해 구현하세요.
    * 출력2는 이터레이터를 통해 구현하세요.
    */
   // 친구 정보 추가
   public void addFriend(int choice) {
      Scanner scan = new Scanner(System.in);
      String iName,iPhone,iAddr,iNickname,iMajor;
      //공통정보를 입력받는다.
      System.out.print("이름:"); iName = scan.nextLine();
      System.out.print("전화번호:"); iPhone = scan.nextLine();
      System.out.print("주소:"); iAddr = scan.nextLine();
      if(choice==1) {
          // 고딩친구 정보 추가
          System.out.print("별명:"); iNickname = scan.nextLine();
          HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
          myFriends.add(high);
       }
       else if(choice==2) {
          // 대딩친구 정보 추가
          System.out.print("전공:"); iMajor = scan.nextLine();
          UnivFriend univ = new UnivFriend(iName, iPhone, iAddr, iMajor);
          myFriends.add(univ);
       }
    }
    
    // 저장된 연락처 전체정보 출력
    public void showAllData() {
       for(Friend fr : myFriends) {
          fr.showAllData();
       }
       System.out.println("==전체정보가 출력되었습니다==");
    }
    // 저장된 연락처 간략정보 출력
    public void showSimpleData() {
       Iterator<Friend> itr = myFriends.iterator();
       while(itr.hasNext()) {
          Friend fr = itr.next();
          fr.showBasicInfo();
       }
       
       System.out.println("==간략정보가 출력되었습니다==");
       
    }
    /****************************************************************/
    /*
    연습문제] 이름을 입력받아 연락처를 검색하는 메서드를 작성하시오.
    */
    // 연락처 정보 검색
    public void searchInfo() {
 	   	boolean isFind = false;
 	   	Scanner scan = new Scanner(System.in);
 	   	System.out.print("검색할 이름을 입력하세요:");
 	   	String searchName = scan.nextLine();

 	   	Iterator<Friend> itr = myFriends.iterator();
 	      while(itr.hasNext()) {
 	         Friend fr = itr.next();
 	         if(searchName.compareTo(fr.name)==0) {
 	            fr.showAllData();
 	            System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
 	            isFind = true;
 	         }
 	      }
 	      if(isFind==false) {
 	         System.out.println("***찾는 정보가 없습니다.***");
     	}
    }
    /* 오늘의숙제] 삭제할 이름을 입력받은 후 삭제하는 메서드를 구현하시오.*/
    // 연락처 정보 삭제
    public void deleteInfo() {
 	   System.out.println("deleteInfo 호출됨");
 	      Scanner scan = new Scanner(System.in);
 	      System.out.println("삭제할 이름을 입력하세요:");
 	      String deleteName = scan.nextLine();
 	      int deleteIndex = -1;
 	      
 	      for(Friend fr : myFriends) {
 	         if(deleteName.compareTo(fr.name)==0) {
 	            myFriends.remove(fr);
 	            deleteIndex = 1;
 	            break;
 	         }
 	      }
 	      
 	      if(deleteIndex==-1) {
 	         System.out.println("==삭제된 데이터가 없습니다==");
 	      }
 	      else {
 	         System.out.println("==데이터가 삭제되었습니다==");
 	      }
     	 
    }///end of searchInfo
}




