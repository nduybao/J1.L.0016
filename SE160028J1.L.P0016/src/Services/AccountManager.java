package Services;

import MyException.GeneralException;
import Controller.Config;
import DAO.AccountDAO;
import DAO.DataDAO;
import Model.Account;
import MyException.DuplicatedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author duyba
 */
public class AccountManager {

    AccountDAO listDAO = new AccountDAO();

    List<Account> listAcc = new ArrayList<>();

    public AccountManager() {
        this.listAcc.addAll(listDAO.getListAcc());
    }

    public void createAccount(String userName, String passWord, String role) {
        Account newAcc = new Account(userName, passWord, role);
        listAcc.add(newAcc);
    }
    
    public String checkNameDuplicated(String userName) throws DuplicatedException{
        int pos = checkIndex(userName);
        if(pos>=0) throw new DuplicatedException("Username " + userName + " already exists!!!");
        return userName;
    }

    private int checkIndex(String userName) {
        int i;
        for (i = 0; i < listAcc.size(); i++) {
            if (listAcc.get(i).getAccName().equalsIgnoreCase(userName)) {
                return i;
            }
        }
        return -1;
    }

    public Account searchAccByName(String userName) throws GeneralException {
        int pos = checkIndex(userName);
        if (pos >= 0) {
            return listAcc.get(pos);
        } else {
            throw new GeneralException("Cannot found " + userName);
        }
    }

    public List<Account> printListAcc() throws GeneralException {
        if (listAcc.isEmpty()) {
            throw new GeneralException("List is empty!!!");
        }
        Collections.sort(listAcc);
        return listAcc;
    }

    public Account update(Account accUpdate, String newPassWord, String newRole) throws GeneralException {
        if(accUpdate.getRole().equalsIgnoreCase("Boss")){
            throw new MyException.GeneralException("Cannot update role Boss");
        }
        if (newPassWord.length() != 0) {
            accUpdate.setPwd(newPassWord);
        }
        if (newRole.length() != 0) {
            accUpdate.setRole(newRole);
        }
        return accUpdate;
    }

    public void remove(Account accRemove) throws GeneralException {
        if(accRemove.getRole().equalsIgnoreCase("BOSS")){
            throw new MyException.GeneralException("Cannot remove Boss Account");
        }
        listAcc.remove(accRemove);
    }

    public void saveToFile() {
        Config cf = new Config();
        String str = cf.getAccountFile();
        DataDAO data = new DataDAO();
        data.writeAccountToFile(listAcc, str);
    }

}
