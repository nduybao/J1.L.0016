package Model;

/**
 *
 * @author duyba
 */
public class Deliveries implements Comparable<Deliveries> {

    private String code;
    private String name;
    private String phone;
    private String addr;
    private boolean status;

    public Deliveries() {
    }

    public Deliveries(String code, String name, String phone, String addr, boolean status) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.code.toUpperCase() + "," + this.name + "," + this.phone + "," + this.addr + "," + this.status;
    }

    @Override
    public int compareTo(Deliveries t) {
        return this.code.compareTo(t.code);
    }

}
