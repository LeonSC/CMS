package dao;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Repository;

import model.Page;
import model.User;
import startup.MongoDBConnector;

@Repository
public class WriterDao {

	//////////////////////管理员方法///////////////////////////
	public Page<User> getWriterList(int state,int nowPage, int numInPage)
	{
		Query<User> query=MongoDBConnector.datastore.createQuery(User.class);
		
		Page<User> page=new Page<User>();
		
		page.setTotal(query.field("BM_DEL").notEqual(-1).field("writer.state").equal(state).countAll());
		
		page.setNowPage(nowPage);
		page.setTotalInPage(numInPage);
		
		page.getPage();
		
		page.setList(query.field("BM_DEL").equal(0).field("writer.state").equal(state).order("-BM_TIME").offset(page.getSkip()).limit(numInPage).asList());
		
		return page;
	}
	
	/**
	 * 修改writer的状态
	 * @param user
	 * @return
	 */
	public User editWriterState(User user)
	{
		if(user==null)
		{
			user=new User();
			user.setBM_DEL(-1);
			return user;
		}
		
		if(user.getBM_ID()==null)
		{
			user=new User();
			user.setBM_DEL(-2);
			return user;
		}
		
		if(user.getWriter()==null)
		{
			user=new User();
			user.setBM_DEL(-4);
			return user;
		}
		
		if(user.getWriter().getState()==null)
		{
			user.getWriter().setState(0);
		}
		
		UpdateOperations<User> ops=MongoDBConnector.datastore.createUpdateOperations(User.class);
		
		ops.set("writer.state", user.getWriter().getState());
		
		MongoDBConnector.datastore.updateFirst(MongoDBConnector.datastore.createQuery(User.class).field("BM_ID").equal(user.getBM_ID()),ops,false);
		
		return MongoDBConnector.datastore.createQuery(User.class).field("BM_ID").equal(user.getBM_ID()).get();
	}
}
