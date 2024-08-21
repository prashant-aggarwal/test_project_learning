package pc.demo.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {
	
	static Function<String, String> functionUpperCase=(str) -> str.toUpperCase();
	
	static Function<String, String> functionUpperCaseMethodReference= String::toUpperCase;

	public static void main(String[] args) {
		System.out.println(functionUpperCase.apply("prashant"));
		System.out.println(functionUpperCaseMethodReference.apply("aggarwal"));

	}

}
