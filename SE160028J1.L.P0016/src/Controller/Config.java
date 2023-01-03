package Controller;

import DAO.DataDAO;
import java.util.List;

/**
 *
 * @author duyba
 */
public class Config {

    private static final String CONFIG_FILE = "DealerData\\CONFIG.txt";
    private String accountFile;
    private String dealerFile;
    private String deliveryFile;

    public Config() {
        readData();
    }

    private void readData() {
        DataDAO data = new DataDAO();
        List<String> lines = data.readLineFromFile(CONFIG_FILE);
        for (String line : lines) {
            line = line.toUpperCase();
            String[] parts = line.split(":");
            if (line.indexOf("ACCOUN") >= 0) {
                accountFile = "DealerData/" + parts[1].trim();
            } else if (line.indexOf("DEALE") >= 0) {
                dealerFile = "DealerData/" + parts[1].trim();
            } else if (line.indexOf("DELIVER") >= 0) {
                deliveryFile = "DealerData/" + parts[1].trim();
            }
        }
    }

    public String getAccountFile() {
        return this.accountFile;
    }

    public String getDealerFile() {
        return this.dealerFile;
    }

    public String getDeliveryFile() {
        return this.deliveryFile;
    }

}
