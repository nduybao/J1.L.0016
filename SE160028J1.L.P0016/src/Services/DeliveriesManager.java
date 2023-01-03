package Services;

import Controller.Config;
import DAO.DataDAO;
import DAO.DeliveriesDAO;
import Model.Deliveries;
import MyException.DuplicatedException;
import MyException.GeneralException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author duyba
 */
public class DeliveriesManager {
    
    
    
    DeliveriesDAO listDAO = new DeliveriesDAO();
    List<Deliveries> listDeli = new ArrayList<>();

    public DeliveriesManager() {
        this.listDeli.addAll(listDAO.getListDeli());
    }

    public void createDeli(String code, String name, String addr, String phone, boolean status){
       Deliveries newDeli = new Deliveries(code, name, phone, addr, status);
       listDeli.add(newDeli);
    }
    
    public String checkCodeDuplicate(String code) throws DuplicatedException{
        int pos = checkIndexCode(code);
        if(pos>=0) throw new DuplicatedException(code + " is already exists!!!");
        return code;
    }
    
    public String checkPhoneDuplicated(String phone) throws DuplicatedException {
        int pos = checkIndexPhone(phone);
        if(pos>=0) throw new DuplicatedException(phone + " is already exists!!!");
        return phone;
    }
    
    public int checkIndexCode(String code) {
        int i;
        for (i = 0; i < listDeli.size(); i++) {
            if (listDeli.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }
    
    public int checkIndexPhone(String phone){
        int i;
        for (i = 0; i < listDeli.size(); i++) {
            if(listDeli.get(i).getPhone().equalsIgnoreCase(phone)){
                return i;
            }
        }
        return -1;
    }
    
    public Deliveries searchByCode(String code) throws GeneralException{
        int pos = checkIndexCode(code);
        if(pos>=0) return listDeli.get(pos);
        else throw new GeneralException("Cannot found " + code);
    }
    
        
    public void removeDeli(Deliveries deliRemove){
        listDeli.remove(deliRemove);
    }

    public void updateDeli(Deliveries deliUpdate, String name, String addr, String phone, String status){
        boolean newStatus;
        if(name.length()!=0){
            deliUpdate.setName(name);
        }
        if(addr.length()!=0){
            deliUpdate.setAddr(addr);
        }
        if(phone.length()!=0){
            deliUpdate.setPhone(phone);
        }
        if(status.length()!=0){
            newStatus = Boolean.parseBoolean(status);
            deliUpdate.setStatus(newStatus);
        }
    }

    
    public List<Deliveries> printListDeli() throws GeneralException{
        if(listDeli.isEmpty()) throw new GeneralException("List is empty!!!");
        Collections.sort(listDeli);
        return listDeli;
    }
    
    public List<Deliveries> printTrueDeli() throws GeneralException{
        List<Deliveries> listTrue = new ArrayList<>();
        listDeli.stream().filter((deliveries) -> (deliveries.isStatus() == true)).forEachOrdered((deliveries) -> {
            listTrue.add(deliveries);
        });
        if(listTrue.isEmpty()) throw new GeneralException("List is empty!!!");
        return listTrue;
    }
    
     public List<Deliveries> printFalseDeli() throws GeneralException{
        List<Deliveries> listFalse = new ArrayList<>();
        listDeli.stream().filter((deliveries) -> (deliveries.isStatus() == false)).forEachOrdered((deliveries) -> {
            listFalse.add(deliveries);
        });
        if(listFalse.isEmpty()) throw new GeneralException("List is empty!!!");
        return listFalse;
    }
    
    public void saveToFile(){
       Config cf = new Config();
        String str = cf.getDeliveryFile();
        DataDAO data = new DataDAO();
        data.writeDeliToFile(listDeli, str);

    }

    
}
