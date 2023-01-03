package Model;

/**
 *
 * @author duyba
 */
public class Dealers implements Comparable<Dealers>{

    private String id;
    private String name;
    private String addr;
    private String phone;
    private boolean coutinuing;

    public Dealers() {
    }

    public Dealers(String id, String name, String addr, String phone, boolean coutinuing) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.coutinuing = coutinuing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCoutinuing() {
        return coutinuing;
    }

    public void setCoutinuing(boolean coutinuing) {
        this.coutinuing = coutinuing;
    }

    @Override
    public String toString() {
        return this.id.toUpperCase() + "," + this.name + "," + this.addr + "," + this.phone + "," + this.coutinuing;
    }

    @Override
    public int compareTo(Dealers t) {
        return this.id.compareTo(t.id);
    }
}
