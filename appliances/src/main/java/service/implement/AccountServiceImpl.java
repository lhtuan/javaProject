package service.implement;

import pojo.Account;
import service.IAccountService;
import dao.implement.AccountDaoImpl;

public class AccountServiceImpl implements IAccountService {
	private AccountDaoImpl accountDao;

	public AccountDaoImpl getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDaoImpl accountDao) {
		this.accountDao = accountDao;
	}

	/***
	 * Tao tai khoan moi / null: tao tai khoan thanh cong / String: loi
	 */
	public String create(Account account) {
		if (accountDao.isExist(account.getUsername()))
			return "Tên tài khoản đã tồn tại";
		if (accountDao.saveOrUpdate(account))
			return null;
		return "Lỗi chưa xac định";
	}


	/***
	 * Cap nhat thong tin tai khoan/ null: cap nhat thanh cong /String : loi
	 */
	public String update(Account account) {
		if (accountDao.isExist(account.getUsername())) {
			if (accountDao.saveOrUpdate(account))
				return null;
			else
				return "Lỗi chưa xác định";
		}
		return "Tài khoản không tồn tại";
	}

}
