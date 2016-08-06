package dao;

import org.mongodb.morphia.query.Query;

import model.Page;
import model.User;
import startup.MongoDBConnector;

public class WriterDao {

	//////////////////////管理员方法///////////////////////////
	public Page<User> getWriterWaitList(int nowPage, int numInPage)
	{
		Query<User> query=MongoDBConnector.datastore.createQuery(User.class);
		
		Page<User> page=new Page<User>();
		
		page.setTotal(query.field("BM_DEL").notEqual(-1).field("mark").equal(0).countAll());
		
		page.setNowPage(nowPage);
		page.setTotalInPage(numInPage);
		
		page.getPage();
		
		page.setList(query.field("BM_DEL").equal(0).field("mark").equal(0).order("-BM_TIME").offset(page.getSkip()).limit(numInPage).asList());
		
		return page;
	}
}
