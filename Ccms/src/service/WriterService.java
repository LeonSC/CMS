package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import dao.WriterDao;
import model.Page;
import model.User;

@Service
public class WriterService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private WriterDao writerDao;
	
	/**
	 * 把一个user添加writer权限
	 * @param BMID
	 * @return
	 */
	public User setUserToWriter(String BMID)
	{
		User u=this.userDao.findUserByBMID(BMID);
		
		if(u==null)
		{
			return null;
		}
		
		if(u.getWriter()!=null)
		{
			return u;
		}
		
		return this.userDao.setUserToWriter(u);
	}
	
	
	
	
	
	//////////////////////管理员方法///////////////////////////
	public Page<User> getWriterWaitList(Integer nowPage)
	{
		if(nowPage==null)
		{
			nowPage=1;
		}
		
		if(nowPage<0)
		{
			nowPage=1;
		}
		
		Page<User> page=this.writerDao.getWriterWaitList(nowPage, 10);
		return page;
	}
}
