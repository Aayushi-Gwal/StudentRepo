import java.util.List;

public class StudentServiceImpl implements StudentService
{
	private StudentDAO studentDAO;
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@Override
	public int save(Student student) {
		
		return studentDAO.save(student) ;
	}

	@Override
	public boolean updateStudent(Student student) {
	// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}
	

	@Override
	public boolean deleteStudent(Student student) {
		return studentDAO.deleteStudent(student);
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Student findByID(int mobileNumber) {
//		return studentDAO.findByID(mobileNumber);
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public Student findByName(int mobileNumber) {
		return studentDAO.findByName(mobileNumber);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
		// TODO Auto-generated method stub
	}

	

}
