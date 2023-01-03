package Services;

import Controller.Config;
import DAO.DataDAO;
import MyException.GeneralException;
import DAO.DealersDAO;
import Model.Dealers;
import MyException.DuplicatedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author duyba
 */
public class DealersManager {
    DealersDAO listDAO = new DealersDAO();
    List<Dealers> listDeal = new ArrayList<>();

    public DealersManager() {
        this.listDeal.addAll(listDAO.getListDeal());
    }
    
    public void createDealer(String id, String name, String addr, String phone, boolean countinuing){
        Dealers newDeal = new Dealers(id, name, addr, phone, countinuing);
        listDeal.add(newDeal);
    }
    
    public String checkIdDuplicate(String id) throws DuplicatedException{
        int pos = checkIndexID(id);
        if(pos>=0) throw new DuplicatedException(id + " is already exists!!!");
        return id;
    }
    
    public String checkPhoneDuplicated(String phone) throws DuplicatedException {
        int pos = checkIndexPhone(phone);
        if(pos>=0) throw new DuplicatedException(phone + " is already exists!!!");
        return phone;
    }
    
    public int checkIndexID(String id) {
        int i;
        for (i = 0; i < listDeal.size(); i++) {
            if (listDeal.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public int checkIndexPhone(String phone){
        int i;
        for (i = 0; i < listDeal.size(); i++) {
            if(listDeal.get(i).getPhone().equalsIgnoreCase(phone)){
                return i;
            }
        }
        return -1;
    }
    
    public Dealers searchByID(String id) throws GeneralException{
        int pos = checkIndexID(id);
        if(pos>=0) return listDeal.get(pos);
        else throw new GeneralException("Cannot found " + id);
    }

    public void updateDeal(Dealers dealUpdate, String name, String addr, String phone, String coutinuing){
        boolean newCoutinuing;
        if(name.length()!=0){
            dealUpdate.setName(name);
        }
        if(addr.length()!=0){
            dealUpdate.setAddr(addr);
        }
        if(phone.length()!=0){
            dealUpdate.setPhone(phone);
        }
        if(coutinuing.length()!=0){
            newCoutinuing = Boolean.parseBoolean(coutinuing);
            dealUpdate.setCoutinuing(newCoutinuing);
        }
    }
    
    public void removeDeal(Dealers dealRemove){
        listDeal.remove(dealRemove);
    }
    
    public List<Dealers> printListDeal() throws GeneralException{
        if(listDeal.isEmpty()) throw new GeneralException("List is empty!!!");
        Collections.sort(listDeal);
        return listDeal;
    }
    
    public List<Dealers> printTrueDealer() throws GeneralException{
        List<Dealers> listTrue = new ArrayList<>();
        listDeal.stream().filter((dealers) -> (dealers.isCoutinuing() == true)).forEachOrdered((dealers) -> {
            listTrue.add(dealers);
        });
        if(listTrue.isEmpty()) throw new GeneralException("List is empty!!!");
        return listTrue;
    }
    
    public List<Dealers> printFalseDealer() throws GeneralException{
        List<Dealers> listFalse = new ArrayList<>();
        listDeal.stream().filter((dealers) -> (dealers.isCoutinuing() == false)).forEachOrdered((dealers) -> {
            listFalse.add(dealers);
        });
        if(listFalse.isEmpty()) throw new GeneralException("List is empty!!!");
        return listFalse;
    }
    
    public void saveToFile(){
        Config cf = new Config();
        String str = cf.getDealerFile();
        DataDAO data = new DataDAO();
        data.writeDealersToFile(listDeal, str);
    }
}
