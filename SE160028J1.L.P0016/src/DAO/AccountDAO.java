package DAO;

import Controller.Config;
import Model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyba
 */
public class AccountDAO extends ArrayList<Account> {

    List<Account> listAcc = new ArrayList<>();
    String accFile;
    DataDAO data = new DataDAO();

    public AccountDAO() {
        setUpAccFile();
        this.listAcc = data.readAccFromFile(accFile);
    }

    public void setUpAccFile() {
        Config cf = new Config();
        accFile = cf.getAccountFile();
    }

    public List<Account> getListAcc() {
        return listAcc;
    }

    public void setListAcc(List<Account> listAcc) {
        this.listAcc = listAcc;
    }

}
