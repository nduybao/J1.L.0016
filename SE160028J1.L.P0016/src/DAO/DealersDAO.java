package DAO;

import Controller.Config;
import Model.Dealers;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyba
 */
public class DealersDAO extends ArrayList<Dealers>{
    List<Dealers> listDeal = new ArrayList<Dealers>();
    String dealersFile;
    DataDAO data = new DataDAO();
    public DealersDAO() {
        setUpDealersFile();
        this.listDeal = data.readDealersFromFile(dealersFile);
    }
    
    public void setUpDealersFile(){
        Config cf = new Config();
        dealersFile = cf.getDealerFile();
    }

    public List<Dealers> getListDeal() {
        return listDeal;
    }

    public void setListDeal(List<Dealers> listDeal) {
        this.listDeal = listDeal;
    }

}
