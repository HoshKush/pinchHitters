package spring.model.u_rate;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class U_RateDAO implements IU_RateDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = true;
		
		int cnt = mybatis.insert("u_rate.create", dto);
		if(cnt > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		return mybatis.selectList("u_rate.list", map);
	}

	@Override
	public Object read(Object pk) throws Exception {
		return mybatis.selectOne("u_rate.read", pk);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		
		int cnt = mybatis.update("u_rate.update", dto);
		if(cnt > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		boolean flag = false;
		
		int cnt = mybatis.delete("u_rate.delete", pk);
		if(cnt > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		return mybatis.selectOne("u_rate.total", map);
	}

}
