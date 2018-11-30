package spring.model.notice;

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

public class NoticeDAOTest {
	
	private static NoticeDAO dao;
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
		dao = (NoticeDAO) beans.getBean("notice");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testCreate() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		
		dto.setN_title("공지사항");
		dto.setN_content("공지사항 내용");
		
		assertTrue(dao.create(dto));
	}

	@Test
	@Ignore
	public void testList() throws Exception {
		Map map = new HashMap();
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<NoticeDTO> list = dao.list(map);
		Iterator<NoticeDTO> iter = list.iterator();
		
		assertEquals(list.size(), 3);
	}

	@Test
	@Ignore
	public void testRead() throws Exception {
		int n_num = 1;
		assertNotNull(dao.read(n_num));
	}

	@Test
	@Ignore
	public void testUpdate() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		dto = dao.read(1);
		dto.setN_title("공지사항업데이트");
		dto.setN_content("공지사항내용업데이트");
		
		assertTrue(dao.update(dto));
	}

	@Test
	@Ignore
	public void testDelete() throws Exception {
		int n_num = 1;
		assertTrue(dao.delete(n_num));
	}

	@Test
	
	public void testTotal() throws Exception {
		Map map = new HashMap();
		map.put("sno", 1);
		map.put("eno", 5);
		
		int total = dao.total(map);
		
		assertEquals(total , 3 );
	}

}
