package service.implement;

import dao.implement.UserauthDaoImpl;
import pojo.Userauth;
import service.IUserauthService;

public class UserauthServiceImpl implements IUserauthService {
	private UserauthDaoImpl userauthDao;

	public String add(Userauth userauth) {
		if (userauthDao.saveOrUpdate(userauth))
			return null;
		return "Lỗi chưa xác định";
	}

	public UserauthDaoImpl getUserauthDao() {
		return userauthDao;
	}

	public void setUserauthDao(UserauthDaoImpl userauthDao) {
		this.userauthDao = userauthDao;
	}

}
