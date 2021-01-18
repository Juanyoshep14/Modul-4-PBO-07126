package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

    JFrame TampilanAwal = new JFrame();
    JLabel login, daftar, top;
    JRadioButton radiopenjual, radiopembeli;
    JTextField textnamalogin, textnamadaftar, textalamat;
    JLabel labelnamalogin, labelpasswordlogin, labelnamadaftar, labelpassworddaftar, labelalamat;
    JButton check, reg, update;
    JPasswordField passwordlogin, passworddaftar;
    private boolean ceklogin = false;

    public GUI() {
        TampilanAwal.setSize(650, 470);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.RED);

        top = new JLabel("TOKO GAME XACTIVE");
        top.setBounds(100, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        TampilanAwal.add(top);

        login = new JLabel("LOG IN");
        login.setBounds(80, 50, 120, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        TampilanAwal.add(login);

        radiopenjual = new JRadioButton("Admin");
        radiopenjual.setBounds(30, 125, 100, 30);
        radiopenjual.setBackground(Color.GRAY);
        TampilanAwal.add(radiopenjual);

        radiopembeli = new JRadioButton("Pembeli");
        radiopembeli.setBounds(140, 125, 100, 30);
        radiopembeli.setBackground(Color.GRAY);
        TampilanAwal.add(radiopembeli);

        labelnamalogin = new JLabel("Nama");
        labelnamalogin.setBounds(30, 150, 50, 30);
        TampilanAwal.add(labelnamalogin);

        textnamalogin = new JTextField();
        textnamalogin.setBounds(30, 180, 200, 30);
        TampilanAwal.add(textnamalogin);

        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(30, 210, 100, 30);
        TampilanAwal.add(labelpasswordlogin);

        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 240, 200, 30);
        TampilanAwal.add(passwordlogin);

        check = new JButton("LOGIN");
        check.setBounds(80, 290, 100, 40);
        check.setBackground(Color.LIGHT_GRAY);
        TampilanAwal.add(check);

        update = new JButton("UPDATE");
        update.setBounds(80, 350, 100, 40);
        update.setBackground(Color.LIGHT_GRAY);
        TampilanAwal.add(update);

        daftar = new JLabel("Daftar");
        daftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        daftar.setBounds(460, 50, 150, 100);
        TampilanAwal.add(daftar);

        labelnamadaftar = new JLabel("Nama");
        labelnamadaftar.setBounds(400, 120, 50, 30);
        TampilanAwal.add(labelnamadaftar);
        textnamadaftar = new JTextField();
        textnamadaftar.setBounds(400, 150, 200, 30);
        TampilanAwal.add(textnamadaftar);
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds(400, 180, 100, 30);
        TampilanAwal.add(labelpassworddaftar);
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(400, 210, 200, 30);
        TampilanAwal.add(passworddaftar);
        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(400, 240, 100, 30);
        TampilanAwal.add(labelalamat);
        textalamat = new JTextField();
        textalamat.setBounds(400, 270, 200, 30);
        TampilanAwal.add(textalamat);
        reg = new JButton("Daftar");
        reg.setBounds(460, 320, 100, 40);
        reg.setBackground(Color.LIGHT_GRAY);
        TampilanAwal.add(reg);
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal.setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);

        radiopenjual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiopenjual.isSelected()) {
                    radiopembeli.setSelected(false);
                    ceklogin = true;
                }
            }

        });
        radiopembeli.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiopembeli.isSelected()) {
                    radiopenjual.setSelected(false);
                    ceklogin = false;
                }
            }

        });
        check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ceklogin == true) {
                    try {
                        AllObjctrl.penjual.dataPenjual();
                        AllObjctrl.penjual.login(textnamalogin.getText(), passwordlogin.getText());
                        String nama = AllObjctrl.penjual.penjualEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        penjualGUI penj = new penjualGUI();
                        TampilanAwal.dispose();

                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Nama atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    kosong();
                } else {
                    try {

                        AllObjctrl.pembeli.login(textnamalogin.getText(), passwordlogin.getText());
                        String nama = AllObjctrl.pembeli.pembeliEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        pembeliGUI pemb = new pembeliGUI();
                        TampilanAwal.dispose();
                    } catch (Exception eception) {
                        JOptionPane.showMessageDialog(null, "Nama atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }

        });

        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                UpdateGUI update = new UpdateGUI();
                TampilanAwal.dispose();
            }

        });

        reg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String nama = textnamadaftar.getText();
                    String pass = passworddaftar.getText();
                    String alamat = textalamat.getText();

                    AllObjctrl.pembeli.insert(nama, pass, alamat);
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
    }

    void kosong() {
        textnamadaftar.setText(null);
        passworddaftar.setText(null);
        textnamalogin.setText(null);
        textalamat.setText(null);
        passwordlogin.setText(null);
//        textpasswordlogin.setText(null);
//        textpassworddaftar.setText(null);
    }
}
