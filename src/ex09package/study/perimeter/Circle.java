package ex09package.study.perimeter;

public class Circle {
	double rad;
	final double PI;
	//변수명이 동일한 경우 구분을 위해 this사용
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.14159;
	}
	//원의 둘레를 계산한 후 반환한다.
	public double getPerimeter(){
		return 2 * PI * rad;
	}
}
