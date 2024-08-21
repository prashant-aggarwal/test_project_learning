package pc.demo.methodreference;

import java.util.function.Predicate;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class RefactorMethodReferenceExample {

	static Predicate<Student> predicateStudentGradeLevel = (student) -> student.getGradeLevel() >= 2;
	
	static Predicate<Student> predicateStudentGradeLevelRefactor = StudentDataBase::greaterThanGradeLevel; 
	
	public static void main(String[] args) {
		System.out.println(predicateStudentGradeLevel.test(StudentDataBase.studentSupplier.get()));
		System.out.println(predicateStudentGradeLevelRefactor.test(StudentDataBase.studentSupplier.get()));
	}
}
