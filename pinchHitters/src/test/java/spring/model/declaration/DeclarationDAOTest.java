package spring.model.declaration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeclarationDAOTest {

	private DeclarationDAO dao;
	private static BeanFactory beans;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			Resource resource = new ClassPathResource("daotest.xml");
			beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		dao = (DeclarationDAO)beans.getBean("declaration");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testCreate() throws Exception {
		DeclarationDTO dto = new DeclarationDTO();
		
		dto.setD_title("신고1");
		dto.setD_content("신고게시판내용");	
		dto.setC_ID("회사");
		assertTrue(dao.create(dto));
	}

	@Test
	@Ignore
	public void testList() throws Exception {
		Map map = new HashMap();
		map.put("sno", 1);
		map.put("eno", 5);
		List<DeclarationDTO> list = dao.list(map);
		
		Iterator<DeclarationDTO> iter = list.iterator();
		assertEquals(list.size(), 5);
	}

	@Test
	@Ignore
	public void testRead() throws Exception {
		DeclarationDTO dto = new DeclarationDTO();
		int d_num = 2;
		dto = dao.read(d_num);
		assertNotNull(dto);
		
	}

	@Test
	@Ignore
	public void testUpdate() throws Exception {
		DeclarationDTO dto = new DeclarationDTO();
		int d_num =2;
		dto = dao.read(d_num);	
		dto.setD_title("업데이트");
		dto.setD_content("신고게시판업데이트");	
		dto.setC_ID("업데이트");
		assertTrue(dao.update(dto));
	}

	@Test
	@Ignore
	public void testDelete() throws Exception {
		int d_num =2;
		assertTrue(dao.delete(d_num));
	}

	@Test
	
	public void testTotal() throws Exception {
		Map map = new HashMap();
		
		int total = dao.total(map);
		
		assertEquals(total, 3);
		
	}

}
