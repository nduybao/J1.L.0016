package Controller;

import Services.AccountChecker;
import View.AccountView;

/**
 *
 * @author duyba
 */
public class LoginController {
    
    AccountView accView = new AccountView();
    AccountChecker checkLogin = new AccountChecker();
    
    public int callMenu(){
        return checkLogin.checkRole(checkLogin.check(accView.Login()));
    }
}
