package service;

import pojo.Account;

public interface IAccountService {
	public Account get(String username);
	public String create(Account account);
	public String update(Account account);
}
