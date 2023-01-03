package MyUtils;

import java.util.Scanner;

/**
 *
 * @author duyba
 */
public class Utils {

    public static String getString(String s, String msg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getString(String s, String pattern, String msg, String msgl) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else if (!result.matches(pattern)) {
                System.out.println(msgl);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static double LimitMinMax(String s, double min, double max) {
        boolean check = true;
        double number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(s);
                number = Double.parseDouble(sc.nextLine().trim());
                if (number <= min || number > max) {
                    System.out.println("Number must be larger than "
                            + min + " and smaller or equal to " + max);
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("You should input number");
            }
        } while (check);
        return number;
    }

    public static int LimitMinMax(String s, int min, int max) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(s);
                number = Integer.parseInt(sc.nextLine());
                if (number <= min || number > max) {
                    System.out.println("Number must be larger than "
                            + min + " and smaller or equal to " + max);
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("You should input number");
            }
        } while (check);
        return number;
    }

    public static String getStatus(String s, String msg, String str, String strs) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            result = sc.nextLine();
            if (result.equalsIgnoreCase(str) || result.equalsIgnoreCase(strs)) {
                check = false;
            } else {
                System.out.println(msg);
                check = true;
            }
        } while (check);
        return result;
    }

    public static int getInt(String s) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(s);
                number = Integer.parseInt(sc.nextLine().trim());
                check = false;
            } catch (Exception e) {
                System.err.println("You should input number");
            }

        } while (check);
        return number;
    }

    public static int checkBlank(String s, int min, int max) {
        boolean check = true;
        int number = 0;
        String str = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            str = sc.nextLine();
            if (str.isEmpty()) {
                return -1;
            } else {
                try {
                    number = Integer.parseInt(str);
                    if (number <= min || number > max) {
                        System.out.println("Number must be larger than "
                                + min + " and smaller or equal to " + max);
                    } else {
                        check = false;
                    }
                } catch (Exception e) {
                    System.err.println("You should input number");
                }
            }

        } while (check);
        return number;
    }

    public static double checkBlank(String s, double min, double max) {
        boolean check = true;
        double number = 0;
        String str = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            str = sc.nextLine();
            if (str.isEmpty()) {
                return -1;
            } else {
                try {
                    number = Double.parseDouble(str);
                    if (number <= min || number > max) {
                        System.out.println("Number must be larger than "
                                + min + " and smaller or equal to " + max);
                    } else {
                        check = false;
                    }
                } catch (Exception e) {
                    System.err.println("You should input number");
                }
            }

        } while (check);
        return number;
    }

    public static String checkBlank(String s, String pattern, String msg) {
        String result = "";
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            result = sc.nextLine();
            if (result.isEmpty()) {
                check = false;
            } else if (!result.matches(pattern)) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String checkBlank(String s, String msg, String str, String strl) {
        String result = "";
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            result = sc.nextLine();
            if (result.isEmpty()) {
                check = false;
            } else if (result.equalsIgnoreCase(str) || result.equalsIgnoreCase(strl)) {
                check = false;
            } else {
                check = true;
                System.out.println(msg);
            }
        } while (check);
        return result;
    }

    public static String backToMainMenu(String s) {
        String ans;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println();
            System.out.print(s);
            ans = sc.nextLine();
            if (ans.equalsIgnoreCase("Y")) {
                check = false;
            } else if (ans.equalsIgnoreCase("n")) {
                check = false;
            } else {
                System.out.println("You should input Y(yes) or N(no)!!!");
            }
        } while (check);
        return ans;
    }

    public static boolean readbool(String s, String str) {
        boolean result = true;
        boolean check;
        String ans;
        Scanner sc = new Scanner(System.in);
        do {
            check = false;
            System.out.print(s);
            ans = sc.nextLine();
            if (ans.equalsIgnoreCase("true") || ans.equalsIgnoreCase("false")) {
                result = Boolean.parseBoolean(ans);
            } else {
                System.out.println(str);
                check = true;
            }
        } while (check);
        return result;
    }

    public static String readboolblank(String s, String str) {
        boolean check;
        String ans = "";
        Scanner sc = new Scanner(System.in);
        do {
            check = false;
            System.out.print(s);
            ans = sc.nextLine();
            if (ans.equalsIgnoreCase("true") || ans.equalsIgnoreCase("false")) {
                return ans;
            } else if (ans.isEmpty()) {
                return ans;
            } else {
                System.out.println(str);
                check = true;
            }
        } while (check);
        return ans;
    }

    public static int getChoice(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        return Utils.getInt("Enter your choice: ");
    }

}
