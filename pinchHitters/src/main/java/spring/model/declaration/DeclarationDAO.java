package spring.model.declaration;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeclarationDAO implements IDeclarationDAO {
 
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.insert("declaration.create",dto);
		if(cnt>0) flag = true;
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		
		return mybatis.selectList("declaration.list",map);
	}

	@Override
	public DeclarationDTO read(Object d_num) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("declaration.read",d_num);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("declaration.update",dto);
		if(cnt>0) flag = true;
	return flag;	
	}

	@Override
	public boolean delete(Object d_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("declaration.delete",d_num);
		if(cnt>0) flag=true;
		
	return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("declaration.total",map);
	}

}
