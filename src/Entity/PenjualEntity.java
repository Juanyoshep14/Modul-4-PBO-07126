package Entity;


public class PenjualEntity extends AbstractEntity {
    private String toko;

    public PenjualEntity(String nama, String password, String toko) {
        super(nama, password);
        this.toko = toko;
    }
    @Override
    public String getNama() {
        return this.nama;
    }
    public String getToko(){
        return this.toko;
    }
    public void setToko(String toko) {
        this.toko = toko;
    }
    
}
