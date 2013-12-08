package dao.implement;

import global.LoggHelper;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Account;
import dao.IAccountDao;
import dao.base.BaseDao;
@Repository
public class AccountDaoImpl extends BaseDao implements IAccountDao {
	@Transactional
	public boolean saveOrUpdate(Account user) {
		try {
			session().saveOrUpdate(user);
			LoggHelper.info("Account is saved or update");
		} catch (Exception ex) {
			LoggHelper.waring("Error when save or update account: "
					+ ex.getMessage());
		}
		return false;
	}
	@Transactional
	public Account get(String username) {
		Account acc = null;
		try {
			acc = (Account) session().get(Account.class, username);
			LoggHelper.info("Get account success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get account");
		}
		return acc;
	}
	@Transactional
	public List<Account> getAll() {
		List<Account> accounts = null;
		try {
			Query query = session().createQuery("from Account");
			accounts = query.list();
			LoggHelper.info("Get accounts success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get accounts: " + ex.getMessage());
		}
		return accounts;
	}
	@Transactional
	public boolean isExist(String username) {
		return get(username) == null ? false : true;
	}

}
