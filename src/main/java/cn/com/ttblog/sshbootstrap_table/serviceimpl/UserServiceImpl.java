package cn.com.ttblog.sshbootstrap_table.serviceimpl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.ttblog.sshbootstrap_table.dao.IUserDao;
import cn.com.ttblog.sshbootstrap_table.model.User;
import cn.com.ttblog.sshbootstrap_table.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUserList(String order, int limit, int offset) {
		return userDao.getUserList(order,limit,offset);
	}

	@Override
	public List<User> getUserList(String search, String order, int limit,
			int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUserListCount() {
		return userDao.getUserListCount();
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
	public void addUM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUMtest() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
}