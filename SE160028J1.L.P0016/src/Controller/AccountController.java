package Controller;

import MyException.DuplicatedException;
import Services.AccountManager;
import MyException.GeneralException;
import View.AccountView;

/**
 *
 * @author duyba
 */
public class AccountController {

    AccountView accView = new AccountView();
    AccountManager accMng = new AccountManager();

    public void Request1() throws DuplicatedException {
        accMng.createAccount(accMng.checkNameDuplicated(accView.inputUserName()), accView.inputPassWord(), accView.inputRole());
    }

    public void Request2() throws GeneralException {
        accView.viewAccountInfo(accMng.searchAccByName(accView.inputUserName()));
    }

    public void Request3() throws GeneralException {
        accMng.remove(accMng.searchAccByName(accView.inputUserName()));
    }

    public void Request4() throws GeneralException {
        accMng.update(accMng.searchAccByName(accView.inputUserName()),
                accView.updatePassWord(), accView.updateRole());
    }

    public void Request5() throws GeneralException {
        accView.viewList(accMng.printListAcc());
    }

    public void Request6() {
        accMng.saveToFile();
    }

}
