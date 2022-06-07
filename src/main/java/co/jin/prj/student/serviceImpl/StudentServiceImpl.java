package co.jin.prj.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jin.prj.DataSource;
import co.jin.prj.student.service.StudentMapper;
import co.jin.prj.student.service.StudentService;
import co.jin.prj.student.vo.StudentVO;

public class StudentServiceImpl implements StudentService {
	
	// 가장 중요한게 아래 두줄을 쓰는것
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
	
	@Override
	public List<StudentVO> studentSelectList() {
		return map.studentSelectList();
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		return map.studentSelect(vo);
	}

	@Override
	public int studentInsert(StudentVO vo) {
		return map.studentInsert(vo);
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		return map.studentUpdate(vo);
	}

	@Override
	public int studentDelete(StudentVO vo) {
		return map.studentDelete(vo);
	}

}
