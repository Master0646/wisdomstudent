package net.huawei.wisdomstudy.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.huawei.wisdomstudy.dao.inter.IStudentDao;
import net.huawei.wisdomstudy.domain.Student;

@ContextConfiguration(locations = { "classpath:spring-hibernate.xml" }) // 用于指定配置文件所在的位置
@RunWith(SpringJUnit4ClassRunner.class) // 用于配置spring中测试的环境
@Rollback(true)
@Transactional
public class StudentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource // 注入Spring容器Bean对象，注意与@Autowired区别
	private IStudentDao studentDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.out.println("***************class StudentDaoTest begin[]***************");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		System.out.println("***************class StudentDaoTest  end[]***************");
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void addStudent() {
		
		Student student = new Student();
		student.setName("张三");
		student.setStudentNo("309020316");
		student.setSex("男");
		studentDao.addStudent(student, 1);
	}
}
