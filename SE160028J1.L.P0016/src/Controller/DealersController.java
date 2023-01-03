package Controller;

import Model.Dealers;
import MyException.DuplicatedException;
import MyException.GeneralException;
import Services.DealersManager;
import View.DealersView;

/**
 *
 * @author duyba
 */
public class DealersController {

    DealersView dealView = new DealersView();
    DealersManager dealMng = new DealersManager();
    Dealers deal = new Dealers();

    public void request1() {
        String id = "", phone = "";
        boolean check = true;
        do {
            check = false;
            try {
                id = dealMng.checkIdDuplicate(dealView.inputID());
            } catch (DuplicatedException ex) {
                check = true;
                dealView.showMessage(ex.getMessage());
            }
        } while (check);
        do {
            try {
                check = false;
                phone = dealMng.checkPhoneDuplicated(dealView.inputPhone());
            } catch (DuplicatedException ex) {
                check = true;
                dealView.showMessage(ex.getMessage());
            }
        } while (check);
        dealMng.createDealer(id, dealView.inputName(), dealView.inputAddr(), phone, dealView.inputCountinuing());
    }
    
    public void request2() throws GeneralException{
        dealView.viewDealerInfo(dealMng.searchByID(dealView.inputID()));
    }
    
     public void request3() throws GeneralException{
         dealMng.removeDeal(dealMng.searchByID(dealView.inputID()));
    }
     
     public void request4() throws GeneralException{
         String phone ="";
         boolean check = true;
         deal = dealMng.searchByID(dealView.inputID());
         do {             
             try {
                 phone = dealMng.checkPhoneDuplicated(dealView.updatePhone());
                 check = false;
             } catch (DuplicatedException ex) {
                 dealView.showMessage(ex.getMessage());
             }
         } while (check);
         dealMng.updateDeal(deal, dealView.updateName(), dealView.updateAddr(), phone, dealView.updateCountinuing());
    }
     
    public void request5() throws GeneralException {
        dealView.viewListDeal(dealMng.printListDeal());
    }
    
    public void request6() throws GeneralException{
        dealView.viewListDeal(dealMng.printTrueDealer());
    }
    
      public void request7() throws GeneralException{
        dealView.viewListDeal(dealMng.printFalseDealer());
    }
      
       public void request8(){
        dealMng.saveToFile();
    }
}
