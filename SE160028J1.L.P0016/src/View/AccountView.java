package View;

import Controller.AccountController;
import MyException.GeneralException;
import Model.Account;
import MyException.DuplicatedException;
import MyUtils.Utils;
import java.util.List;

/**
 *
 * @author duyba
 */
public class AccountView {

    public Account Login() {
        String userName = Utils.getString("Enter Username: ", "Username cannot empty!!!").toUpperCase();
        String passWord = Utils.getString("Enter password: ", "Password cannot empty!!!");
        Account acc = new Account(userName, passWord);
        return acc;
    }

    public String inputUserName() {
        String userName = Utils.getString("Enter your username: ", "^E\\d{3,}$|e\\d{3,}$",
                "Username cannot empty!!!", "Username is format Exxx (x is digit)").toUpperCase();
        return userName;
    }

    public String inputPassWord() {
        String passWord = Utils.getString("Enter your password: ", "[a-zA-Z_0-9]{8,}",
                "Password cannot be empty!!!", "Password is at least 8 characters!!!");
        return passWord;
    }

    public String inputRole() {
        String role = Utils.getStatus("Enter your role: ", "You should enter \"ACC-1 or ACC-2\"", "ACC-1", "ACC-2");
        return role;
    }

    public String updatePassWord() {
        String newPassword = Utils.checkBlank("Enter new password: ", "[a-zA-Z_0-9]{8,}", "Password is at least 8 characters!!!");
        return newPassword;
    }

    public String updateRole() {
        String newRole = Utils.checkBlank("Enter new role: ", "You should enter \"ACC-1 or ACC-2\"", "ACC-1", "ACC-2");
        return newRole;
    }

    public void showMessage(String str) {
        System.out.println(str);
    }

    public void viewAccountInfo(Account acc) {
        System.out.println(acc);
    }

    public void viewList(List<Account> listAcc) {
        listAcc.forEach((account) -> {
            System.out.println(account);
        });
    }

    public void BossMenu() {
        String[] options = {
            "Add new account",
            "Search account",
            "Remove account",
            "Update account",
            "Print all account",
            "Write to file",
            "Log out",
            "Other quit"};
        int choice;
        boolean check = true;
        AccountController ctrl = new AccountController();
        do {
            System.out.println("===================BOSS Menu ===================");
            choice = Utils.getChoice(options);
            switch (choice) {
                case 1:
                    showMessage("\n--------Create Account---------\n");
                    do {
                        try {
                            check = false;
                            ctrl.Request1();
                            showMessage("\n--------Create Successfully---------\n");
                        } catch (DuplicatedException ex) {
                            check = true;
                            showMessage(ex.getMessage());
                        }
                    } while (check);
                    break;
                case 2:
                    showMessage("\n--------Search Account---------\n");
                     {
                        try {
                            ctrl.Request2();
                            showMessage("\n-------------------------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 3:
                    showMessage("\n--------Remove Account---------\n");
                     {
                        try {
                            ctrl.Request3();
                            showMessage("\n--------Remove Succesfully!!!---------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 4:
                    showMessage("\n--------Update Account---------\n");
                     {
                        try {
                            ctrl.Request4();
                            showMessage("\n--------Update Succesfully!!!---------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 5:
                    showMessage("\n--------List Account---------\n");
                     {
                        try {
                            ctrl.Request5();
                            showMessage("\n-------------------------\n");
                        } catch (GeneralException ex) {
                            showMessage(ex.getMessage());
                        }
                    }
                    break;
                case 6:
                    ctrl.Request6();
                    showMessage("\n----------Save Successfully!!!-----------\n");
                    break;
                case 7:
                    Menu.display();
                default:
                    System.out.println("Good Bye!!!");
                    System.exit(0);
            }

        } while (choice >= 1 || choice <= 6);
    }

}
