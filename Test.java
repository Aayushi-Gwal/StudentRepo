import java.sql.SQLException;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test
{
		public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		StudentService studentService = (StudentService) context.getBean("studentService", StudentServiceImpl.class);
		Student student = new  Student();
		
		int choice;
		Scanner scanner = new Scanner(System.in);
		try
		{
			while (true)
		
			 {

				System.out.println("1. New Registeration");
				System.out.println("2. Update Student's Name");
				System.out.println("3. Delete a Student's record");
				System.out.println("4. Display Student's Result");
				System.out.println("5. Display all students records");
				System.out.println("6. Exit");
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				switch (choice) 
				{
					case 1: //new student registration
							int mobile_Number;
							String name;
							double Marks1, Marks2, Marks3;
							System.out.println("Enter your mobile number");
							mobile_Number = scanner.nextInt();
							System.out.println("Enter your Name");
							name = scanner.next();
							if(name.matches("[a-zA-Z]+"))
							{
								System.out.println("enter Marks 1");
								Marks1 = scanner.nextDouble();
								System.out.println("enter Marks 2");
								Marks2 = scanner.nextDouble();
								System.out.println("enter Marks 3");
								Marks3 = scanner.nextDouble();
							
							student.setMobileNumber(mobile_Number);
							student.setName(name);
							student.setMarks1(Marks1);
							student.setMarks2(Marks2);
							student.setMarks3(Marks3);
							studentService.save(student);
							}
							else if(!name.matches("[a-zA-Z]+"))
								System.out.println("Invalid name format!!");
							break;
						
					case 2: //Update Student's record
						    int mobileNumber;
						    String newName;
						    System.out.println("Please enter the mobile number");
						    mobileNumber = scanner.nextInt();
						    System.out.println("Enter the new name");
						    newName = scanner.next();
						    if(newName.matches("[a-zA-Z]+"))
						    {
						    	student.setMobileNumber(mobileNumber);
							    student.setName(newName);
							    studentService.updateStudent(student);
						    }
						    else if(!newName.matches("[a-zA-Z]+"))
						    	System.out.println("Invalid Name Format!!");
						   
						    break;
						    
					case 3://delete a students record  
							int mobileNumber1;
							System.out.println("Enter the your mobile number");
							mobileNumber1 = scanner.nextInt();
							student.setMobileNumber(mobileNumber1);
							studentService.deleteStudent(student);
							break;
							
					case 4 : //Display a student's record
							int mobileNumber2;
							System.out.println("Enter the mobile number");
							mobileNumber2=scanner.nextInt();
							student.setMobileNumber(mobileNumber2);
							studentService.findByName(mobileNumber2);
							break;
							
							
					case 5: // Display All students records
							studentService.findAll();
							List<Student> list = studentService.findAll();
							for (Student student1 : list) {
							System.out.println("Roll Number "+student1.getRollNumber()+"\tMobile Number"+student1.getMobileNumber()+"\t Name: "+student1.getName()+"\t Marks1: "+student1.getMarks1()+"\t Marks2: "+student1.getMarks2()+"\tMarks3: "+student1.getMarks3()+"\t Average" +student1.getAverage()+"\t Percentage:"+student1.getPercentage());
							}
							break;
						
							
							
					case 6: //exit
						System.out.println("Closing!!!");
						System.exit(0);
						break;
						 
						
					default:
						System.out.println("Wrong Choice");
						break;
							
							
							
				}
		
			 }
		}catch(RuntimeException ex)
		{
			System.out.println("Invalid Format!!");
//			ex.printStackTrace();
		}
		
		
		}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
