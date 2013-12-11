package service.implement;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pojo.Account;
import service.IAccountService;
import dao.implement.AccountDaoImpl;

public class AccountServiceImpl implements IAccountService, UserDetailsService {
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

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		/*Account account = accountDao.get(username);
		UserDetails user = new User(
				username,
				account.getPassword(),
				true,
				true,
				true,
				true,
				(Collection<? extends GrantedAuthority>) new GrantedAuthority{ new GrantedAuthorityImpl("ROLE_USER") });*/
		return null;
	}

}
