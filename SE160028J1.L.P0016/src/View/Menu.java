package View;

import Controller.LoginController;

/**
 *
 * @author duyba
 */
public class Menu {

    public static void display() {
        LoginController login = new LoginController();
        AccountView AccMenu = new AccountView();
        DealersView DealMenu = new DealersView();
        DeliveriesView DeliMenu = new DeliveriesView();
        boolean check;
        System.out.println("\n===================Login===================\n");
        do {
            check = false;
            int i = login.callMenu();
            switch (i) {
                case 0:
                    System.out.println("Your Role: BOSS");
                    AccMenu.BossMenu();
                    break;
                case 1:
                    System.out.println("Your Role: ACC-1");
                    DealMenu.DealerMenu();
                    break;
                case 2:
                    System.out.println("Your Role: ACC-2");
                    DeliMenu.DeliMenu();
                    break;
                case -1:
                    System.out.println("No Account Found!!!\nPlease re-enter!!!");
                    check = true;
                    break;
                default:
                    break;
            }
        } while (check);
    }
}
