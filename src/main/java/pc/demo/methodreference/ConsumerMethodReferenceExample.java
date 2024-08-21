package pc.demo.methodreference;

import java.util.List;
import java.util.function.Consumer;

import com.pc.data.Student;
import com.pc.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		
		Consumer<Student> consumerStudent = System.out::println;
		students.forEach(consumerStudent);
		
		Consumer<Student> consumerStudent1 = Student::printListOfActivities;
		students.forEach(consumerStudent1);
	}

}
