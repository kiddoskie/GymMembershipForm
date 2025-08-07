
package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.membership.Member;


public class GymMembershipFrame extends JFrame{
    
    //panels
    private JPanel headingPn1;
    private JPanel clientPn1;
    private JPanel namePn1;
    private JPanel surnamePn1;
    private JPanel idNoPn1;
    private JPanel genderPn1;
    private JPanel contractsPn1;
    private JPanel personalTrainerOptionPn1;
    private JPanel membershipPn1;
    private JPanel commentsPn1;
    private JPanel btnsPn1;
    private JPanel headingClientCombinedPn1;
    private JPanel membershipCommentsCombinedPn1;
    private JPanel mainPn1;
    
    //labels
    private JLabel headingLb1;
    private JLabel nameLb1;
    private JLabel surnameLb1;
    private JLabel idNoLb1;
    private JLabel genderLb1;
    private JLabel personalTrainerLb1;
    private JLabel contractTypeLb1;
    
    //textfields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //combobox
    private JComboBox genderComboBox;
    
    //radio buttons
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;
    
    //checkbox
    private JCheckBox personalTrainerChkBx;
    
    //buttongroup
    private ButtonGroup btnGrp;
    
    //textarea
    private JTextArea commentsArea;
    
    //scrollplane
    private JScrollPane scrollableTxtArea;
    
    //private button
    private JButton registerBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    private JButton searchBtn;
    private JButton removeBtn;
    private JButton updateBtn;
    private JButton displayBtn;
    
    //list
    private ArrayList<Member> members;
    
    
    //construct the GUI
    public GymMembershipFrame() {
        
        setTitle("Gym membership");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        //create a list for members
        members = new ArrayList<>();
        
        //create panels
        headingPn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        clientPn1 = new JPanel(new GridLayout(4, 1, 1, 1));
        clientPn1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Client details"));
        
        namePn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contractsPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        membershipPn1 = new JPanel(new GridLayout(2, 1, 1, 1));
        membershipPn1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Contract options"));
        
        commentsPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        btnsPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingClientCombinedPn1 = new JPanel(new BorderLayout());
        membershipCommentsCombinedPn1 = new JPanel(new BorderLayout());
        mainPn1 = new JPanel(new BorderLayout());
        
        //create labels
        headingLb1 = new JLabel("Membership Form");
        headingLb1.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLb1.setForeground(Color.BLUE);
        headingLb1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        nameLb1 = new JLabel("Name:     ");
        surnameLb1 = new JLabel("Surname: ");
        idNoLb1 = new JLabel("Id no:        ");
        genderLb1 = new JLabel("Gender:     ");
        contractTypeLb1 = new JLabel("Type of contract: ");
        personalTrainerLb1 = new JLabel("Select the checkbox if you need a personal trainer ");
        
        //create textfields
        nameTxtFld = new JTextField(10);
        surnameTxtFld = new JTextField(10);
        idNoTxtFld = new JTextField(10);
        
        //create combobox
        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        
        //create radio buttons
        monthToMonthRadBtn = new JRadioButton("Month-to-Month");
        sixMonthsRadBtn = new JRadioButton("Six months");
        annualRadBtn = new JRadioButton("Annual");
        
        //create check box
        personalTrainerChkBx = new JCheckBox();
        
        //create button group
        btnGrp = new ButtonGroup();
        btnGrp.add(monthToMonthRadBtn);
        btnGrp.add(sixMonthsRadBtn);
        btnGrp.add(annualRadBtn);
        
        //create text area
        commentsArea = new JTextArea(15, 50);
        commentsArea.setEditable(false);
        commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Member(s) details"));
        
        scrollableTxtArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //create button
        registerBtn = new JButton("REGISTER");
        registerBtn.addActionListener(new RegisterBtnListener());
        
        searchBtn = new JButton("SEARCH");
        searchBtn.addActionListener(new SearchBtnListener());
        
        removeBtn = new JButton("REMOVE");
        removeBtn.addActionListener(new RemoveBtnListener());
        
        updateBtn = new JButton("UPDATE");
        updateBtn.addActionListener(new UpdateBtnListener());
        
        displayBtn = new JButton("DISPLAY ALL");
        displayBtn.addActionListener(new DisplayBtnListener());
        
        clearBtn = new JButton("CLEAR");
        clearBtn.addActionListener(new ClearBtnListener());
        
        exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(new ExitBtnListener());
        
        //add components to panels
        headingPn1.add(headingLb1); // --> first collective panel
        
        namePn1.add(nameLb1);
        namePn1.add(nameTxtFld);
        
        surnamePn1.add(surnameLb1);
        surnamePn1.add(surnameTxtFld);
        
        idNoPn1.add(idNoLb1);
        idNoPn1.add(idNoTxtFld);
        
        genderPn1.add(genderLb1);
        genderPn1.add(genderComboBox);
        
        clientPn1.add(namePn1); // --> second collective panel
        clientPn1.add(surnamePn1);
        clientPn1.add(idNoPn1);
        clientPn1.add(genderPn1);
        
        headingClientCombinedPn1.add(headingPn1, BorderLayout.NORTH);
        headingClientCombinedPn1.add(clientPn1, BorderLayout.CENTER);
        
        contractsPn1.add(contractTypeLb1);
        contractsPn1.add(monthToMonthRadBtn); // --> third collective panel
        contractsPn1.add(sixMonthsRadBtn);
        contractsPn1.add(annualRadBtn);
        
        personalTrainerOptionPn1.add(personalTrainerLb1);
        personalTrainerOptionPn1.add(personalTrainerChkBx);
        
        membershipPn1.add(contractsPn1);
        membershipPn1.add(personalTrainerOptionPn1);
        
        commentsPn1.add(scrollableTxtArea); // --> fourth collective panel
        
        membershipCommentsCombinedPn1.add(membershipPn1, BorderLayout.NORTH);
        membershipCommentsCombinedPn1.add(commentsPn1, BorderLayout.CENTER);
        
        btnsPn1.add(registerBtn); // --> fifth collective panel
        btnsPn1.add(searchBtn);
        btnsPn1.add(updateBtn);
        btnsPn1.add(removeBtn);
        btnsPn1.add(displayBtn);
        btnsPn1.add(clearBtn);
        btnsPn1.add(exitBtn);
        
        mainPn1.add(headingClientCombinedPn1, BorderLayout.NORTH);
        mainPn1.add(membershipCommentsCombinedPn1, BorderLayout.CENTER);
        mainPn1.add(btnsPn1, BorderLayout.SOUTH);
        
        add(mainPn1);
        
        pack();
        
        setResizable(false);
        
        setVisible(true);
    }
    
    private class RegisterBtnListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            //read data
            String name = nameTxtFld.getText();
            String surname = surnameTxtFld.getText();
            String idNo = idNoTxtFld.getText();
            String gender = (String)genderComboBox.getSelectedItem();
            Boolean isPersonalTrainerSelected = personalTrainerChkBx.isSelected();
            String contractType = "Month-to-month";
            
            if(sixMonthsRadBtn.isSelected()){
                
                contractType = "Six months";
            }
            else{
                
                if(annualRadBtn.isSelected()){
                    
                    contractType = "Annual";
                }
            }
            
            //create a member
            Member member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerSelected);
            
            //add the member to the list
            members.add(member);
            
            //add a confirmation message to the text area
            commentsArea.setText("The member has been successfully added");
            
        }
        
    }
    
    private class SearchBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String idNoToSearch = idNoTxtFld.getText();
            boolean found = false;
            commentsArea.setText(""); 
            
            for (Member member : members) {
                
                if (member.getIdNo().equals(idNoToSearch)) {
                    
                    nameTxtFld.setText(member.getName());
                    surnameTxtFld.setText(member.getSurname());
                    genderComboBox.setSelectedItem(member.getGender());
                    personalTrainerChkBx.setSelected(member.getIsPersonalTrainerNeeded());
                    
                    if (member.getContractType().equals("Month-to-month")) {
                        
                        monthToMonthRadBtn.setSelected(true);
                        
                    } 
                    else 
                        if (member.getContractType().equals("Six months")) {
                            
                        sixMonthsRadBtn.setSelected(true);
                        
                    } 
                    else {
                            
                        annualRadBtn.setSelected(true);
                    }
                    
                    commentsArea.setText("Member with ID " + idNoToSearch + " found. Details loaded into fields.");
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                commentsArea.setText("Error: No member found with ID " + idNoToSearch);
            }
        }
             
    }
    
    private class RemoveBtnListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String idNoToRemove = idNoTxtFld.getText();
            boolean removed = false;
            commentsArea.setText("");
            
            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).getIdNo().equals(idNoToRemove)) {
                    members.remove(i);
                    commentsArea.setText("Member with ID " + idNoToRemove + " has been successfully removed.");
                    removed = true;
                    break;
                }
            }
            
            if (!removed) {
                commentsArea.setText("Error: No member found with ID " + idNoToRemove + " to remove.");
            }
        }
    }
    
    private class ClearBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            //clear the fields
            nameTxtFld.setText("");
            surnameTxtFld.setText("");
            idNoTxtFld.setText("");
            personalTrainerChkBx.setSelected(false);
            btnGrp.clearSelection();
            commentsArea.setText("");
            
            //set focus back to the name text field
            nameTxtFld.setFocusable(true);
            
        }
        
    }
    
    private class UpdateBtnListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String idNoToUpdate = idNoTxtFld.getText();
            boolean updated = false;
            commentsArea.setText("");
            
            for (Member member : members) {
                
                if (member.getIdNo().equals(idNoToUpdate)) {
                    
                    // Update the member's details
                    member.setName(nameTxtFld.getText());
                    member.setSurname(surnameTxtFld.getText());
                    member.setGender((String) genderComboBox.getSelectedItem());
                    member.setIsPersonalTrainerNeeded(personalTrainerChkBx.isSelected());
                    
                    // Set the new contract type
                    String newContractType = "Month-to-month";
                    if (sixMonthsRadBtn.isSelected()) {
                        
                        newContractType = "Six months";
                    } 
                        else 
                            if (annualRadBtn.isSelected()) {
                                
                                newContractType = "Annual";
                    }
                    member.setContractType(newContractType);
                    
                    commentsArea.setText("Member with ID " + idNoToUpdate + " has been successfully updated.");
                    updated = true;
                    break;
                }
            }
            
            if (!updated) {
                commentsArea.setText("Error: No member found with ID " + idNoToUpdate + " to update.");
            }
        }
    }
    
    private class DisplayBtnListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            commentsArea.setText("All Members:\n\n");
            
            if (members.isEmpty()) {
                
                commentsArea.append("No members have been registered yet.");
            } 
                else {
                
                    for (Member member : members) {
                        
                        commentsArea.append(member.toString() + "\n\n");
                }
            }
        }
    }
    
    private class ExitBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            //exit
            System.exit(1);
        }
        
        
    }
       
}
