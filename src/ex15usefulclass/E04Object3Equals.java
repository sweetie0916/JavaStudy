package ex15usefulclass;

import java.util.Objects;

class MyClass {
	int data;
	public MyClass(int data) {
		this.data = data;
	/*
	toString() : 객체가 가진 데이터를 String으로 반환해준다.
		print()가 호출될때 자동으로 호출되어 출력에 도움을 준다.
	*/
	}
	@Override
	public int hashCode() {
		return Objects.hash(data);
	}
	/*
	MyClass 인스턴스간의 내용 비교를 위해 equals()를 오버라이딩하여 재정의한다.
	인스턴스가 가진 멤머변수의 값에 대한 비교를 통해 동일여부를 판단한다. equals()메서드의
	매개변수 타입은 모든 인스턴스를 대상으로 하므로 Object형으로 정의되어 있다.
	*/
	@Override
	public boolean equals(Object obj) {
		/* 매개변수로 전달된 인스턴스를 Object로 받으면 업캐스팅이되므로
		다운캐스팅 이후에 비교를 해야된다. 
		이때 전달된 인스턴스가 MyClass형이 아니라면 비교의 대상이 될 수 없으므로
		상속관계 확인을 위해 instanceof 연산자를 사용한다. */
		if (obj instanceof MyClass)
			/* 매개변수가 MyClass 타입이 맞다면 비교를 위해
			다운캐스팅한다. 그렇지 않으면 부모타입으로는 자식 멤버에 접근할수 없으므로
			멤버변수 data에 대한 비교가 불가능해진다. */
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		return data == other.data;
	}
	
//@Override
//	public int hashCode() {
//		return Objects.hash(data);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		MyClass other = (MyClass) obj;
//		return data == other.data;
//	}
}
public class E04Object3Equals {
	public static void main(String[] args) {
		
		//클래스를 통해 2개의 인스턴스를 생성한다.
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		//해당 비교는 참조값에 대한 비교이므로 다르다고 출력된다.
		/* 만약 오버라이딩 해놓은 equals()를 삭제한 후 비교하면
		다르다는 결과가 나오게된다. 즉 오버라이딩이 필요없는 경우는
		기본클래스일때만 가능하다. */
		System.out.println("[두 객체를 비교연산자를 통해 비교]");
		if(mc1==mc2) {
			System.out.println("인스턴스 참조값(주소값)이 같다");
		}
		else {
			System.out.println("인스턴스 참조값(주소값)이 다르다");//[0]
		}
		
		//인스턴스의 내용을 비교하므로 같다고 출력된다.
		System.out.println("[두 객체를 equals()메소드로 비교]");
		System.out.println(mc1.equals(mc2) ? "같다" : "다르다");//[같다]
		
		/* print()를 통해 출력하면 자동으로 toString()을 호출하므로
		아래 출력결과는 동일하다. */
		System.out.println("[두 객체의 toString()메소드 호출");
		System.out.println("mc1.toString()=>"+ mc1.toString());
		System.out.println("mc=>+ mc2");
	}

}
