package DAO;

import Controller.Config;
import Model.Deliveries;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyba
 */
public class DeliveriesDAO extends ArrayList<Deliveries>{
    List<Deliveries> listDeli = new ArrayList<>();
    String deliFile;
    DataDAO data = new DataDAO();

    public DeliveriesDAO() {
        setUpDealersFile();
        this.listDeli = data.readDeliersFromFile(deliFile);
    }

     public void setUpDealersFile(){
        Config cf = new Config();
        deliFile = cf.getDeliveryFile();
    }

    public List<Deliveries> getListDeli() {
        return listDeli;
    }

    public void setListDeli(List<Deliveries> listDeli) {
        this.listDeli = listDeli;
    }
  
}
