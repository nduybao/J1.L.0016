package Controller;

import Model.Deliveries;
import MyException.DuplicatedException;
import MyException.GeneralException;
import Services.DeliveriesManager;
import View.DeliveriesView;

/**
 *
 * @author duyba
 */
public class DeliveriesController {

    DeliveriesView deliView = new DeliveriesView();
    DeliveriesManager deliMng = new DeliveriesManager();
    Deliveries deli = new Deliveries();

    public void request1() {
        String code = "", phone = "";
        boolean check = true;
        do {
            check = false;
            try {
                code = deliMng.checkCodeDuplicate(deliView.inputCode());
            } catch (DuplicatedException ex) {
                check = true;
                deliView.showMessage(ex.getMessage());
            }
        } while (check);
        do {
            try {
                check = false;
                phone = deliMng.checkPhoneDuplicated(deliView.inputPhone());
            } catch (DuplicatedException ex) {
                check = true;
                deliView.showMessage(ex.getMessage());
            }
        } while (check);
        deliMng.createDeli(code, deliView.inputName(), deliView.inputAddr(), phone, deliView.inputStatus());
    }

    public void request2() throws GeneralException {
        deliView.viewDeliInfo(deliMng.searchByCode(deliView.inputCode()));
    }

    public void request3() throws GeneralException {
        deliMng.removeDeli(deliMng.searchByCode(deliView.inputCode()));
    }

    public void request4() throws GeneralException {
        String phone = "";
        boolean check = true;
        deli = deliMng.searchByCode(deliView.inputCode());
        do {
            try {
                phone = deliMng.checkPhoneDuplicated(deliView.updatePhone());
                check = false;
            } catch (DuplicatedException ex) {
                deliView.showMessage(ex.getMessage());
            }
        } while (check);
        deliMng.updateDeli(deli, deliView.updateName(), deliView.updateAddr(), phone, deliView.updateStatus());
    }

    public void request5() throws GeneralException {
        deliView.viewListDeli(deliMng.printListDeli());
    }

    public void request6() throws GeneralException {
        deliView.viewListDeli(deliMng.printTrueDeli());
    }

    public void request7() throws GeneralException {
        deliView.viewListDeli(deliMng.printFalseDeli());
    }

    public void request8() {
        deliMng.saveToFile();
    }
}
