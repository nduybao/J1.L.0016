package DAO;

import Model.Account;
import Model.Dealers;
import Model.Deliveries;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyba
 */
public class DataDAO {

    public DataDAO() {
    }

    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;
    private FileReader fr;
    private BufferedReader br;

    public void openFileToWrite(String fName) {
        try {
            fw = new FileWriter(fName);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeAccountToFile(List<Account> listAcc, String fName) {
        openFileToWrite(fName);
        try {
            for (Account account : listAcc) {
                pw.println(account.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        closeFileAfterWrite(fName);
    }

    public void writeDealersToFile(List<Dealers> listDel, String fName) {
        openFileToWrite(fName);
        try {
            for (Dealers dealers : listDel) {
                pw.println(dealers.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        closeFileAfterWrite(fName);
    }

    public void writeDeliToFile(List<Deliveries> listDeli, String fName) {
        openFileToWrite(fName);
        try {
            for (Deliveries deliveries : listDeli) {
                pw.println(deliveries.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        closeFileAfterWrite(fName);
    }

    public void closeFileAfterWrite(String fName) {
        try {
            pw.flush();
            bw.flush();
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void openFileToRead(String fName) {
        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> readLineFromFile(String fName) {
        List<String> list = new ArrayList<>();
        openFileToRead(fName);
        try {
            String datas;
            while ((datas = br.readLine()) != null) {
                list.add(datas);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<Account> readAccFromFile(String fName) {
        List<Account> listAcc = new ArrayList<>();
        openFileToRead(fName);
        try {
            String datas;
            while ((datas = br.readLine()) != null) {
                Account account = createAccFromFile(datas);
                listAcc.add(account);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeFileAfterRead(fName);
        return listAcc;
    }

    private Account createAccFromFile(String datas) {
        String[] details = datas.split(",");
        String accName = details[0];
        String pwd = details[1];
        String role = details[2];
        Account account = new Account(accName, pwd, role);
        return account;
    }

    public List<Dealers> readDealersFromFile(String fName) {
        List<Dealers> listDeal = new ArrayList<>();
        openFileToRead(fName);
        try {
            String datas;
            while ((datas = br.readLine()) != null) {
                Dealers dealers = createDealersFromFile(datas);
                listDeal.add(dealers);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeFileAfterRead(fName);
        return listDeal;
    }

    private Dealers createDealersFromFile(String datas) {
        String[] details = datas.split(",");
        String id = details[0];
        String name = details[1];
        String addr = details[2];
        String phone = details[3];
        boolean coutinuing = Boolean.parseBoolean(details[4]);
        Dealers dealers = new Dealers(id, name, addr, phone, coutinuing);
        return dealers;
    }

    public List<Deliveries> readDeliersFromFile(String fName) {
        List<Deliveries> listDeli = new ArrayList<>();
        openFileToRead(fName);
        try {
            String datas;
            while ((datas = br.readLine()) != null) {
                Deliveries deli = createDeliFromFile(datas);
                listDeli.add(deli);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        closeFileAfterRead(fName);
        return listDeli;
    }

    private Deliveries createDeliFromFile(String datas) {
        String[] details = datas.split(",");
        String code = details[0];
        String name =details[1];
        String phone = details[2];
        String addr = details[3];
        boolean status = Boolean.parseBoolean(details[4]);
        Deliveries deli = new Deliveries(code, name, phone, addr, status);
        return deli;
    }

    public void closeFileAfterRead(String fName) {
        try {
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
