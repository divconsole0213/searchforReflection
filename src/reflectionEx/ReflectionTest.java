package reflectionEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// class를 알고 있다는 전제하
		Class<?> x_class = Child.class;
		System.out.println("Class Name:" + x_class.getName());
		// 클래스를 참조할 수 없고 이름만 알 수 있을 때

		Class<?> x_class_getName = Class.forName("reflectionEx.Child");
		System.out.println("class Name : " + x_class_getName.getName());

		Constructor x_constructor = x_class_getName.getDeclaredConstructor();
		System.out.println("constructor :" + x_constructor);

		Constructor x_constructor_param = x_class_getName.getDeclaredConstructor(String.class);
		System.out.println("constructor(parameter) :" + x_constructor_param);

		Constructor x_constructor_array[] = x_class.getConstructors();
		for (Constructor c : x_constructor_array) {
			System.out.println("public constructor: " + c);
			
			Method[] method = x_class.getDeclaredMethods();
			for(Method m : method) {
				System.out.println("Method:" + m);
			}
			
			Method[] publicMethod = x_class.getMethods();
			for(Method m: publicMethod) {
				System.out.println("publicMethod:" + m);
			}
 			
			Method getMethod = x_class.getDeclaredMethod("childmethod_", int.class);
		    System.out.println("get method: " + getMethod);
		}
		
		//method 호출 
		
		 Method callMethod = x_class.getDeclaredMethod("childmethod", String.class);
		 callMethod.setAccessible(true); //private 함수도 호출 가능 
		 Child child = new Child();
		 String returnValue = (String) callMethod.invoke(child, "childMethod()를 호출하여 그 내용을 바꿨습니다."); 
	     System.out.println(returnValue);
	     
	     //field 찾기
	     Field field_1 = x_class.getDeclaredField("childStr");
	     Field field_2 = x_class.getDeclaredField("childStr2");
	   
	     System.out.println(field_1);
	     System.out.println(field_2);
	}
}
