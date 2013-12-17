package dao.implement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import global.LoggHelper;
import pojo.Userauth;
import dao.IUserauthDao;
import dao.base.BaseDao;
@Repository
public class UserauthDaoImpl extends BaseDao implements IUserauthDao {
	@Transactional
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
