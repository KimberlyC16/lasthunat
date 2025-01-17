/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import scholar.loginform;

/**
 *
 * @author ll
 */
public class add_form extends javax.swing.JFrame {

    /**
     * Creates new form add_form
     */
    public add_form() {
        initComponents();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
            } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    
public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

    
      public static String email, usname;
    public boolean duplicateChecker(){
        
        dbConnector dbc = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE u_username = '" + un.getText() + "' OR u_email = '" + em.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                System.out.println(""+email);
                if(email.equals(em.getText())){
                  JOptionPane.showMessageDialog(null,"Email already exist!");   
                  em.setText("");
                }
                usname = resultSet.getString("u_username");
                 System.out.println(""+usname);
                  if(usname.equals(un.getText())){
                  JOptionPane.showMessageDialog(null,"Username already exist!");
                  un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
        
    }
    public boolean updateCheck(){
        dbConnector dbc = new dbConnector();
        try{
            String query = "SELECT * FROM tbl_user WHERE (u_username = '"+un.getText()+"' OR u_email = '"+em.getText()+"') AND u_id != '"+us_id.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                System.out.println(""+email);
                if(email.equals(em.getText())){
                  JOptionPane.showMessageDialog(null,"Email already exist!");   
                  em.setText("");
                }
                usname = resultSet.getString("u_username");
                 System.out.println(""+usname);
                  if(usname.equals(un.getText())){
                  JOptionPane.showMessageDialog(null,"Username already exist!");
                  un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ut = new javax.swing.JComboBox<>();
        us = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        us_id = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ps = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("First Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 140, 89, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 190, 71, 24);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 220, 71, 35);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Username");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, 260, 65, 35);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Password");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 300, 71, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Account Type");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(170, 340, 100, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("User Status");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(170, 370, 88, 34);
        jPanel1.add(fn);
        fn.setBounds(280, 140, 239, 29);
        jPanel1.add(ln);
        ln.setBounds(280, 180, 239, 32);
        jPanel1.add(em);
        em.setBounds(280, 220, 239, 32);
        jPanel1.add(un);
        un.setBounds(280, 260, 239, 32);

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        jPanel1.add(ut);
        ut.setBounds(280, 340, 240, 30);

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "pending" }));
        jPanel1.add(us);
        us.setBounds(280, 380, 240, 30);

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(590, 390, 90, 40);

        update.setText("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(690, 390, 90, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("User ID");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(170, 100, 80, 30);

        us_id.setEnabled(false);
        jPanel1.add(us_id);
        us_id.setBounds(280, 100, 230, 30);

        delete.setText("Delete");
        jPanel1.add(delete);
        delete.setBounds(790, 390, 90, 40);

        clear.setText("Clear");
        jPanel1.add(clear);
        clear.setBounds(590, 440, 90, 40);

        refresh.setText("Refresh");
        jPanel1.add(refresh);
        refresh.setBounds(690, 440, 90, 40);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel);
        cancel.setBounds(790, 440, 90, 40);
        jPanel1.add(ps);
        ps.setBounds(280, 300, 240, 30);

        jPanel2.setLayout(null);
        jPanel2.add(image);
        image.setBounds(0, 0, 190, 180);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(690, 90, 190, 180);

        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(800, 280, 80, 30);

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(700, 280, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Image:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(630, 90, 50, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if(fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()
            || un.getText().isEmpty() || ps.getText().isEmpty() ){ 
         JOptionPane.showMessageDialog(null,"All fields are required!");
        }else if (ps.getText().length() < 8){
            JOptionPane.showMessageDialog(null,"Password must be 8 characters!");
            ps.setText("");
        }else if(duplicateChecker()){
        
            System.out.println("Duplicate Exist!");
        }else{
            
            dbConnector dbc = new dbConnector();
        
        if(dbc.insertData("INSERT INTO tbl_user (u_fname, u_lname, u_email, u_username, u_password, u_type, u_status) "
                      + "VALUES ('"+fn.getText()+"', '"+ln.getText()+"', '"+em.getText()+"', "
                     + "'"+un.getText()+"', '"+ps.getText()+"', '"+ut.getSelectedItem()+"', '"+us.getSelectedItem()+"')"))
        {
            JOptionPane.showMessageDialog(null, "Added Successfully!");
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose(); 
        }else{
                
            JOptionPane.showMessageDialog(null, "Connection error!!");    
       } 
        }
       
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usersForm uf = new usersForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       
        if(fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()
            || un.getText().isEmpty() || ps.getText().isEmpty() ){ 
         JOptionPane.showMessageDialog(null,"All fields are required!");
        }else if (ps.getText().length() < 8){
            JOptionPane.showMessageDialog(null,"Password must be 8 characters!");
            ps.setText("");
        }else if(updateCheck()){
        
            System.out.println("Duplicate Exist!");
        }else{
      
        dbConnector dbc = new dbConnector();
       dbc.updateData("UPDATE tbl_user SET u_fname = '"+fn.getText()+"', u_lname = '"+ln.getText()+"', u_email = '"+em.getText()+"', "
               + "u_username = '"+un.getText()+"', u_password = '"+ps.getText()+"', u_type = '"+ut.getSelectedItem()+"',"
                       + " u_status = '"+us.getSelectedItem()+"' WHERE u_id = '"+us_id.getText()+"' ");
       
         JOptionPane.showMessageDialog(null, "Updated Successfully!");
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose(); 
        }
    }//GEN-LAST:event_updateActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
      JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination ="";
        path="";
    }//GEN-LAST:event_removeActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(add_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton cancel;
    public javax.swing.JButton clear;
    public javax.swing.JButton delete;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField ln;
    private javax.swing.JPasswordField ps;
    public javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JTextField us_id;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
