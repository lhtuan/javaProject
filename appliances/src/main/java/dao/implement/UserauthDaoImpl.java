package dao.implement;

import global.LoggHelper;
import pojo.Userauth;
import dao.IUserAuthDao;
import dao.base.BaseDao;

public class UserauthDaoImpl extends BaseDao implements IUserAuthDao {

	public boolean saveOrUpdate(Userauth userauth) {
		try
		{
		session().saveOrUpdate(userauth);
		LoggHelper.info("Userauth is saved or updated");
		}
		catch(Exception ex)
		{
			LoggHelper.waring("Error when save or update userauth");
			return false;
		}
		return true;
	}

}
