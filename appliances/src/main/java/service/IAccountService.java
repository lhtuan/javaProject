package service;

import java.util.List;

import pojo.Account;

public interface IAccountService {
	public Account get(String username);
	public String create(Account account);
	public String update(Account account);

	public List<Account> getAccounts(int page);
	public int countAccouts();
	
}
