package Service;

import Model.Account;
import DAO.AccountDAO;

import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        this.accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public List<Account> getAllAccounts(){
        return this.accountDAO.getAllAccounts();
    }

    public Account getAccountById(int id){
        return this.accountDAO.getAccountById(id);
    }

    public Account createAccount(Account account){
        if (
            this.accountDAO.getUser(account.getUsername()) != null
            || account.getUsername().length() == 0
            || account.getPassword().length() < 4
        ){
            return null;
        }
        return this.accountDAO.insertAccount(account);
    }

    public Account verifyAccount(Account account){
        return this.accountDAO.verifyAccount(account);

    }

}
