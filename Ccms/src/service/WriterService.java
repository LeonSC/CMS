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
		
		Page<User> page=this.writerDao.getWriterList(0,nowPage, 10);
		return page;
	}
	
	public Page<User> getWriterPassedList(Integer nowPage)
	{
		if(nowPage==null)
		{
			nowPage=1;
		}
		
		if(nowPage<0)
		{
			nowPage=1;
		}
		
		Page<User> page=this.writerDao.getWriterList(1,nowPage, 10);
		return page;
	}
	
	public Page<User> getWriterBannedList(Integer nowPage)
	{
		if(nowPage==null)
		{
			nowPage=1;
		}
		
		if(nowPage<0)
		{
			nowPage=1;
		}
		
		Page<User> page=this.writerDao.getWriterList(2,nowPage, 10);
		return page;
	}
	
	/**
	 * 把编辑设置成为审核中状态
	 * @param BMID
	 * @return
	 */
	public User setWriterToWait(String BMID)
	{
		User u=this.userDao.findUserByBMID(BMID);
		
		if(u==null)
		{
			return null;
		}
		
		if(u.getWriter()!=null)
		{
			u.getWriter().setState(0);
			u=this.writerDao.editWriterState(u);
		}
		
		return u;
	}
	
	/**
	 * 把编辑设置成为通过状态
	 * @param BMID
	 * @return
	 */
	public User setWriterToPassed(String BMID)
	{
		User u=this.userDao.findUserByBMID(BMID);
		
		if(u==null)
		{
			return null;
		}
		
		if(u.getWriter()!=null)
		{
			u.getWriter().setState(1);
			u=this.writerDao.editWriterState(u);
		}
		
		return u;
	}
	
	/**
	 * 把编辑设置成为block状态
	 * @param BMID
	 * @return
	 */
	public User setWriterToBanned(String BMID)
	{
		User u=this.userDao.findUserByBMID(BMID);
		
		if(u==null)
		{
			return null;
		}
		
		if(u.getWriter()!=null)
		{
			u.getWriter().setState(2);
			u=this.writerDao.editWriterState(u);
		}
		
		return u;
	}
}
