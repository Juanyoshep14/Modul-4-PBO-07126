package Entity;

public class AbstractEntity {
    protected String nama,password;

    public AbstractEntity(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }
    
    public AbstractEntity(){
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
