package View;
import Entity.GameEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class pembeliGUI {
    JFrame pembeli = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarGame;
    JComboBox pilGame = new JComboBox(GameEntity.list);
    int cek = AllObjctrl.pembeli.cekDaftarPembeli(AllObjctrl.pembeli.getData().getNama());
    
    public pembeliGUI() {
        pembeli.setSize(720,600);
        pembeli.setLayout(null);
        pembeli.getContentPane().setBackground(Color.RED);
        
        datadiri = new JLabel("Data Pembeli");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        pembeli.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        pembeli.add(area);
        
        daftarGame = new JLabel("Daftar Game");
        daftarGame.setBounds(450, 30, 250, 30);
        daftarGame.setFont(new Font("Times New Roman",Font.BOLD,30));
        pembeli.add(daftarGame);
        pilGame.setBounds(450, 90, 230, 30);
        pembeli.add(pilGame);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.LIGHT_GRAY);
        pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.LIGHT_GRAY);
        pembeli.add(back);
        
        pembeli.setVisible(true);
        pembeli.setLocationRelativeTo(null);
        pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(cek==-1){
             JOptionPane.showMessageDialog(null, "Anda Belum Membeli Game", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Membeli Game", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexgame = pilGame.getSelectedIndex();
                AllObjctrl.pembeli.daftargame(indexgame,AllObjctrl.pembeli.getData(),false);
                area.setText(datapembeli());
            }
            
        });
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                pembeli.dispose();
                GUI men = new GUI();
            }
            
        });
}
    String datapembeli(){
        int cek = AllObjctrl.pembeli.cekDaftarPembeli(AllObjctrl.pembeli.getData().getNama());
        String cekverif;
        if(AllObjctrl.pembeli.showDaftarPembeli(cek).isIsVerified()==false) {
            cekverif = "belum di verifikasi";
        }else{
            cekverif = "Sudah di verifikasi";
        }
        String text = "Nama = "+AllObjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getNama()+"\n"
                +"Alamat = "+AllObjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getAlamat()+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"Game = "+GameEntity.list[AllObjctrl.pembeli.showDaftarPembeli(cek).getIndexGame()];
        return text;
    }
}