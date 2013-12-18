package service.implement;

<<<<<<< HEAD
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

=======
>>>>>>> 13c63850a390582d5bb4630027ac8c2276597c6e
import pojo.Account;
import service.IAccountService;
import dao.implement.AccountDaoImpl;

public class AccountServiceImpl implements IAccountService{
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
			return "Tài khoản đã tồn tại";
		if (accountDao.saveOrUpdate(account))
			return null;
		return "Lỗi chưa xác định";
	}

	/***
	 * Cap nhat thong tin tai khoan/ null: cap nhat thanh cong /String : loi
	 */
	public String update(Account account) {
		if (accountDao.isExist(account.getUsername())) {
			if (accountDao.saveOrUpdate(account))
				return null;
			else
				return "Lá»—i chÆ°a xÃ¡c Ä‘á»‹nh";
		}
		return "TÃ i khoáº£n khÃ´ng tá»“n táº¡i";
	}


	public Account get(String username) {
		// TODO Auto-generated method stub
		return accountDao.get(username);
	}

	public List<Account> getAccounts(int page) {
		// TODO Auto-generated method stub
		return accountDao.getAccounts(page);
	}

	public int countAccouts() {
		// TODO Auto-generated method stub
		return accountDao.countAccount();
	}

	public Account get(String username) {
		// TODO Auto-generated method stub
		return accountDao.get(username);
	}

}
