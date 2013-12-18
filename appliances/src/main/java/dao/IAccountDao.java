package dao;

import java.util.List;

import pojo.Account;
import pojo.Catalog;

public interface IAccountDao {
	public boolean saveOrUpdate(Account user);
	public Account get(String username);
	public List<Account> getAll();
	public boolean isExist(String username);
	public int countAccount();
	public List<Account> getAccounts(int page);
}
