package Model;

import Entity.PembeliEntity;
import java.util.ArrayList;

public class pembeliModel implements ModelInterface {
    
    private ArrayList<PembeliEntity> pembeliEntityArrayList;
    
    public pembeliModel() {
        pembeliEntityArrayList = new ArrayList<PembeliEntity>();
    }
    
    public void insert(PembeliEntity pembeliEntity) {
        pembeliEntityArrayList.add(pembeliEntity);
    }
    @Override
    public void view() {
        for (PembeliEntity pembeliEntity : pembeliEntityArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : "+ pembeliEntity.getNama()+ "\nPassword : "+ pembeliEntity.getPassword()+"\n Alamat : "+pembeliEntity.getAlamat());
            System.out.println("==============================================");
        }
    }

    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        while (!pembeliEntityArrayList.get(loop).getNama().equals(nama)&&!pembeliEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }
    public PembeliEntity getPembeliEntityArrayList(int index) {
        return pembeliEntityArrayList.get(index);
    }
    
}
