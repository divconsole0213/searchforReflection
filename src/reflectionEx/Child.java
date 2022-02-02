package reflectionEx;

public class Child extends Parent {
	
	public String childStr = "1";
	private String childStr2 = "private 2";
	
	public Child() {
		
	}
	
	private Child(String str) {
		childStr = str;
	}
	
	public String childmethod(String str_) {
		System.out.println("childmethod:" + str_);
		return str_;
		
	}
	
	public int childmethod_(int n) {
		System.out.println("childmethod_:" + n);
		return n;
		
	}

}
