package cn.com.ttblog.sshbootstrap_table.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.ttblog.sshbootstrap_table.dao.IUserDao;
import cn.com.ttblog.sshbootstrap_table.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao{
	
	@Autowired
	private SessionFactory hibernateSession;
	
	private Session getSession(){
		return hibernateSession.getCurrentSession();
	}
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(User record) {
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getUserListCount() {
		Query q=getSession().createSQLQuery("select count(*) from user");
		return Long.parseLong(q.uniqueResult().toString());
	}

	@Override
	public int getNewData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> getDataSum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectWhen(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList(String order, int limit, int offset) {
		String hql="from User u order by u.adddate "+order;
		System.out.println("hql:"+hql);
		Query q=getSession().createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(limit);
		return q.list();
	}
	
}