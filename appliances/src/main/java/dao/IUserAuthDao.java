package dao;

import pojo.Userauth;

public interface IUserAuthDao {
	public boolean saveOrUpdate(Userauth userauth);
}
