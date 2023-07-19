package common;

public class Student extends Person 
{
	//자식에서 확장한 멤버변수
	private String stNumber;
	
	//생성자
	public Student(String name, int age, String stNumber)
	{
		//자식객체를 생성하기전 부모생성자를 먼저 호출해야한다.
		super(name, age);
		this.stNumber = stNumber;
	}
	
	//객체의 저장된 내용을 문자열의 형태로 변환한다.
	@Override
	public String toString() 
	{
		return super.toString() +", 학번:"+ stNumber;
	}
}
