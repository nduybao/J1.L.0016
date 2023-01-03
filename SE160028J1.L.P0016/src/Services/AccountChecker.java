package Services;

import DAO.AccountDAO;
import Model.Account;

/**
 *
 * @author duyba
 */
public class AccountChecker {

    public Account check(Account acc) {
        AccountDAO listAcc= new AccountDAO();
        for (Account a : listAcc.getListAcc()) {
            if (a.getPwd().equals(acc.getPwd()) && a.getAccName().equals(acc.getAccName())) {
                return a;
            }
        }
        return null;
    }
    
    public int checkRole(Account acc) {
        if(acc == null){
            return -1;
        }
        if(acc.getRole().equalsIgnoreCase("BOSS")){
            return 0;
        }
        if(acc.getRole().equalsIgnoreCase("ACC-1")){
            return 1;
        }
        if(acc.getRole().equalsIgnoreCase("ACC-2")){
            return 2;
        }
        return -1;
    }
}
