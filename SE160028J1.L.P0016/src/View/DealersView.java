package View;

import Controller.DealersController;
import MyException.GeneralException;
import Model.Dealers;
import MyUtils.Utils;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author duyba
 */
public class DealersView {

    public String inputID() {
        String id = Utils.getString("Enter dealers's ID: ", "^D\\d{3,}|d\\d{3,}",
                "ID cannot be empty!!!", "ID format Dxxx(x is digit)").toUpperCase();
        return id;
    }

    public String inputName() {
        String name = Utils.getString("Enter dealers's name: ", "Dealers'name cannot be empty!!!");
        return name.trim();
    }

    public String inputAddr() {
        String addr = Utils.getString("Enter dealer's address: ", "^\\d{1,}[\\s]street[\\s][a-zA-z]*$",
                "Dealer's address cannot be empty!!!", "Address format must be xx street xx");
        return addr;
    }

    public String inputPhone() {
        String phone = Utils.getString("Enter dealers's phone: ", "\\d{9}|\\d{11}",
                "Phone number cannot empty!!!", "Phone number is 9 digit or 11 digit");
        return phone;
    }

    public boolean inputCountinuing() {
        boolean coutinuing = Utils.readbool("Enter dealer continuing or not(True or False): ",
                "You should type True or False");
        return coutinuing;
    }

    public String updateName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        return name.trim();
    }

    public String updateAddr() {
        String newAddr = Utils.checkBlank("Enter new address: ",
                "^\\d{1,}[\\s]street[\\s][a-zA-z]*$", "Address format must be xx street xx");
        return newAddr;
    }

    public String updatePhone() {
        String newPhone = Utils.checkBlank("Enter new phone: ", "\\d{9}|\\d{11}", "Phone number is 9 digit or 11 digit");
        return newPhone;
    }

    public String updateCountinuing() {
        String checkBool = Utils.readboolblank("Enter new countinuing status (True or False):",
                "You should enter True or False");
        return checkBool;
    }

    public void showMessage(String str) {
        System.out.println(str);
    }

    public void viewDealerInfo(Dealers dealer) {
        System.out.println(dealer);
    }

    public void viewListDeal(List<Dealers> listDeal) {
        listDeal.forEach((dealers) -> {
            System.out.println(dealers);
        });
    }

    public void DealerMenu() {
        String[] options = {
            "Add new dealer",
            "Search dealer",
            "Remove dealer",
            "Update dealer",
            "Print all dealer",
            "Print countinuing dealer",
            "Print UN-countinuing dealer",
            "Write to file",
            "Log out",
            "Other quit"};
        int choice;
        boolean check = true;
        DealersController ctrl = new DealersController();
        do {
            System.out.println("===================Dealers Menu ===================");
            choice = Utils.getChoice(options);
            switch (choice) {
                case 1:
                    showMessage("\n--------Create Dealer---------\n");
                    ctrl.request1();
                    showMessage("\n--------Create Successfully!!!---------\n");
                    break;
                case 2:
                    showMessage("\n--------Search Dealer---------\n");
                     {
                        try {
                            ctrl.request2();
                            showMessage("\n-----------------------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 3:
                    showMessage("\n--------Remove Dealer---------\n");
                     {
                        try {
                            ctrl.request3();
                            showMessage("\n--------Remove Successfully!!!---------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 4:
                    showMessage("\n--------Update Dealer---------\n");
                     {
                        try {
                            ctrl.request4();
                            showMessage("\n--------Update Successfully!!!---------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 5:
                    showMessage("\n--------List Dealers---------\n");
                     {
                        try {
                            ctrl.request5();
                            showMessage("\n-------------------------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 6:
                    showMessage("\n--------List Countinuing Dealers---------\n");
                     {
                        try {
                            ctrl.request6();
                            showMessage("\n-------------------------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 7:
                    showMessage("\n--------List Un-Countinuing Dealers---------\n");
                     {
                        try {
                            ctrl.request7();
                            showMessage("\n-------------------------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 8:
                    ctrl.request8();
                    showMessage("\n--------Save Successfully!!!---------\n");
                    break;
                case 9:
                    Menu.display();
                default:
                    System.out.println("Good Bye!!!");
                    System.exit(0);

            }

        } while (choice >= 1 || choice <= 8);
    }

}
