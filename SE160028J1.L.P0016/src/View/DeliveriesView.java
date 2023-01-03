package View;

import Controller.DeliveriesController;
import Model.Deliveries;
import MyException.GeneralException;
import MyUtils.Utils;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author duyba
 */
public class DeliveriesView {

    public String inputCode() {
        String code = Utils.getString("Enter delivery's code: ", "^DE\\d{3,}|de\\d{3,}$",
                "Code cannot be empty!!!", "Code format DExxx(x is digit)").toUpperCase();
        return code;
    }

    public String inputName() {
        String name = Utils.getString("Enter delivery's name: ", "Delivery'name cannot be empty!!!");
        return name.trim();
    }

    public String inputAddr() {
        String addr = Utils.getString("Enter delivery's address: ", "^\\d{1,}[\\s]street[\\s][a-zA-z]*$",
                "delivery's address cannot be empty!!!", "Address format must be xx street xx");
        return addr;
    }

    public String inputPhone() {
        String phone = Utils.getString("Enter delivery's phone: ", "\\d{9}|\\d{11}",
                "Phone number cannot empty!!!", "Phone number is 9 digit or 11 digit");
        return phone;
    }

    public boolean inputStatus() {
        boolean status = Utils.readbool("Enter delivery continuing or not(True or False): ", "You should type True or False");
        return status;
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

    public String updateStatus() {
        String checkBool = Utils.readboolblank("Enter new status (True or False):",
                "You should enter True or False");
        return checkBool;
    }

    public void showMessage(String str) {
        System.out.println(str);
    }

    public void viewDeliInfo(Deliveries deli) {
        System.out.println(deli);
    }

    public void viewListDeli(List<Deliveries> listDeli) {
        listDeli.forEach((deliveries) -> {
            System.out.println(deliveries);
        });
    }

    public void DeliMenu() {
        String[] options = {
            "Add new delivery",
            "Search delivery",
            "Remove delivery",
            "Update delivery",
            "Print all delivery",
            "Print countinuing delivery",
            "Print UN-countinuing delivery",
            "Write to file",
            "Log out",
            "Other quit"};
        int choice;

        DeliveriesController ctrl = new DeliveriesController();
        do {
            System.out.println("===================Dealers Menu ===================");
            choice = Utils.getChoice(options);
            switch (choice) {
                case 1:
                    showMessage("\n--------Create Delivery---------\n");
                    ctrl.request1();
                    showMessage("\n--------Create Successfully!!!---------\n");
                    break;
                case 2:
                    showMessage("\n--------Search Delivery---------\n");
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
                    showMessage("\n--------Remove Delivery---------\n");
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
                    showMessage("\n--------Update Delivery---------\n");
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
                    showMessage("\n--------List Delivery---------\n");
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
                    showMessage("\n--------List Countinuing Delivery---------\n");
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
                    showMessage("\n--------List Un-Countinuing Delivery---------\n");
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
