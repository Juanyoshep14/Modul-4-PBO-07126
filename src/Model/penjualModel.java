package Model;
import Entity.PenjualEntity;
import java.util.ArrayList;

public class penjualModel implements ModelInterface{
    private ArrayList<PenjualEntity> penjualEntityArrayList;
    
    public penjualModel() {
        penjualEntityArrayList = new ArrayList<PenjualEntity>();
    }
    public void inserPenjual(PenjualEntity penjual) {
        penjualEntityArrayList.add(penjual);
    }
     public void view() {
        for (PenjualEntity penjualEntity : penjualEntityArrayList) {
            System.out.println(penjualEntity.getNama());
            System.out.println(penjualEntity.getPassword());
            System.out.println(penjualEntity.getToko());
        }
    }

    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
       for (PenjualEntity penjualEntity : penjualEntityArrayList) {
            if (penjualEntity.getNama().equals(nama) && penjualEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    public PenjualEntity showDataPenjual(int index) {
        return penjualEntityArrayList.get(index);
    }
     
}
