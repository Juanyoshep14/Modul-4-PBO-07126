package Entity;


public class PembeliEntity extends AbstractEntity {
    private String alamat;

    public PembeliEntity(String nama, String password,String alamat) {
        super(nama, password);
        this.alamat = alamat;
    }
    @Override
    public String getNama() {
        return nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
