package service;

import java.util.List;

import pojo.Account;

public interface IAccountService {
	public String create(Account account);
	public String update(Account account);

	public List<Account> getAccounts(int page);
	public int countAccouts();
	public Account get(String username);
}
