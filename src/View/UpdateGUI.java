package View;
import Entity.GameEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;

public class UpdateGUI {
    JComboBox pilGame = new JComboBox(GameEntity.list);
    JButton konfirmasi,kembali;
    JFrame TampilanAwal = new JFrame();
    JTextArea area = new JTextArea();
    JLabel update,labelGameUpdate;
    JTextField textGameUpdate;
    
    public UpdateGUI() {
        
        TampilanAwal.setSize(720,600);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.RED);
        
        update = new JLabel("Update Data");
        update.setFont(new Font("Times New Roman",Font.BOLD,43));
        update.setBounds(240,30,300,80);
        TampilanAwal.add(update);
        
        labelGameUpdate = new JLabel("Nama Pembeli");
        labelGameUpdate.setBounds(300,180,150,30);
        TampilanAwal.add(labelGameUpdate);
        
        textGameUpdate = new JTextField();
        textGameUpdate.setBounds(250,210,200,40);
        TampilanAwal.add(textGameUpdate);
        
        pilGame.setBounds(276,270,150,40);
        TampilanAwal.add(pilGame);
        
        konfirmasi = new JButton("KONFIRMASI");
        konfirmasi.setBounds(290,330,120,40);
        konfirmasi.setBackground(Color.LIGHT_GRAY);
        TampilanAwal.add(konfirmasi);
        
        kembali = new JButton("KEMBALI");
        kembali.setBounds(290,380,120,40);
        kembali.setBackground(Color.LIGHT_GRAY);
        TampilanAwal.add(kembali);
        
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal. setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        
        konfirmasi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int GameUpdate = pilGame.getSelectedIndex();
                AllObjctrl.pembeli.update(textGameUpdate.getText(), GameUpdate);
                JOptionPane.showMessageDialog(null,"PILIHAN GAME BERHASIL DI UPDATE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                kosong();
            }
            
        });
        
        kembali.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                TampilanAwal.dispose();
                GUI men = new GUI();
            }
            
        });
    }
    void kosong() {
        textGameUpdate.setText(null);
    }
}
