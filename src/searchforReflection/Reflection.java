package searchforReflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection {
	public static void main(String[]args) throws ClassNotFoundException {
		//List 인터페이스의 경로를 가져와 class 객체를 생성
		Class<?> listClass = Class.forName("java.util.List");
		
		//listClass의 메소드들
		Method[] methods = listClass.getDeclaredMethods();
		
		//각 메소드
		for(Method m : methods) {
			System.out.println("method:" + m.getName()); //메서드 이름
			System.out.println("class:" + m.getDeclaringClass()); //클래스 이름
			System.out.println("Return:" + m.getReturnType()); // 메서드의 리턴타입
			
			//List 인터페이스의 메소드들의 파라미터
			Parameter[] parameterList = m.getParameters();
			for(Parameter p : parameterList) {
				System.out.println("type:" + p.getType()); // 각 메소드별 파라미터 타입
				System.out.println("name:" + p.getName()); // 각 메소드별 파라미터 이름
			}
			System.out.println();
		}
}
}
