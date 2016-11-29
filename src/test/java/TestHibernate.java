import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.ttblog.sshbootstrap_table.model.User;
import cn.com.ttblog.sshbootstrap_table.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml"})
public class TestHibernate {

	private static Logger LOG = LoggerFactory.getLogger(TestHibernate.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private SessionFactory hibernate;

	private Session session;
	
	@Before
	public void inject(){
		session=hibernate.openSession();
	}
	
	@Test
	public void  testcount(){
	 	Query q=session.createSQLQuery("select count(*) from user");
	 	LOG.debug("查询用户个数:{}",q.uniqueResult());
	}
	
	@Test
	public void  testfind(){
		List<User> users=session.createSQLQuery("select * from user").list();
		LOG.debug("查询用户列表:{}",users.size());
	}
	
	@Test
	public void testHql(){
		String hql="from User where id=?";
		Query q=session.createQuery(hql);
		q.setParameter(0, 1L);
		List result=q.list();
		User u=(User) result.get(0);
		LOG.debug("hql-result:{},u.getName():{}",result,u.getName());
	}
}