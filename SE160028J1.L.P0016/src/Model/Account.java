package Model;

/**
 *
 * @author duyba
 */
public class Account implements Comparable<Account>{

    private String accName;
    private String pwd;
    private String role;

    public Account() {
    }

    public Account(String accName) {
        this.accName = accName;
    }
    
    public Account(String accName, String pwd) {
        this.accName = accName;
        this.pwd = pwd;
    }

    public Account(String accName, String pwd, String role) {
        this.accName = accName;
        this.pwd = pwd;
        this.role = role;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.accName.toUpperCase() + "," + this.pwd + ',' + this.role.toUpperCase();
    }

    @Override
    public int compareTo(Account t) {
        return this.getAccName().compareTo(t.getAccName());
    }
}
