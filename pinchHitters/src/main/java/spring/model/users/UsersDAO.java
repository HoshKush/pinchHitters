package spring.model.users;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO implements IUsersDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		
		int cnt = mybatis.insert("users.create", dto);
		if(cnt > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		return mybatis.selectList("users.list", map);
	}

	@Override
	public Object read(Object pk) throws Exception {
		return mybatis.selectOne("users.read", pk);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		
		int cnt = mybatis.update("users.update", dto);
		if(cnt > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		boolean flag = false;
		
		int cnt = mybatis.delete("users.delete", pk);
		if(cnt > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		return mybatis.selectOne("users.total", map);
	}

}
