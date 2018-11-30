package spring.model.notice;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class NoticeDAO implements INoticeDAO {
	
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("declaration.update",dto);
		if(cnt>0) flag = true;		
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectList("notice.list",map);
	}

	@Override
	public NoticeDTO read(Object n_num) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("notice.read",n_num);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("notice.update", dto);
		if(cnt>0) flag = true;
		return flag;
	}

	@Override
	public boolean delete(Object n_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("notice.delete", n_num);
		if(cnt>0) flag = true;
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("notice.total", map);
	}

}
