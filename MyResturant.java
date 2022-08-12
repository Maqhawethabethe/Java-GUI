
package myresturant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyResturant extends JFrame{
    
    JLabel customer,Name,contact,food,drinks,type;
    JTextField tfcustomerNo,tfName,tfcontact;
    JButton reset,print,receipt;
    JComboBox cb1,cb2;
    JRadioButton rb1,rb2;
    JTextArea tA2;
    int ptotal,fprice,dprice;
    
    
    
    
    
    
    
    MyResturant()
    {
        setTitle("Resturant and coffee");
        setSize(700,500);
        setLayout(null);
        
       
        customer=new JLabel("customer No");
        customer.setBounds(20, 20, 120, 30);
        getContentPane().add(customer);
        tfcustomerNo=new JTextField();
        tfcustomerNo.setBounds(150, 15, 200, 30);
        getContentPane().add(tfcustomerNo);
        
        
        
        
        Name=new JLabel("customer Name");
        Name.setBounds(20, 60, 120, 30);
        getContentPane().add(Name);
        tfName=new JTextField();
        tfName.setBounds(150, 60, 200, 30);
        getContentPane().add(tfName);
        
        
        
        contact=new JLabel("customer contact");
        contact.setBounds(20, 100, 120, 30);
        getContentPane().add(contact);
        tfcontact=new JTextField();
        tfcontact.setBounds(150, 100, 200, 30);
        getContentPane().add(tfcontact);
        
        
        food=new JLabel("Food:");
        food.setBounds(20, 140, 120, 30);
        getContentPane().add(food);
        String foods[]={"Pizza","KFC","Burger"};
        cb1=new JComboBox(foods);
        cb1.setBounds(150,140,120,30);
        getContentPane().add(cb1);
        
        
        
        drinks=new JLabel("Drinks:");
        drinks.setBounds(20, 180, 120, 30);
        getContentPane().add(drinks);
        String drinks[]={"coca-cola","juice","coffee"};
        cb2=new JComboBox(drinks);
        cb2.setBounds(150,180,120,30);
        getContentPane().add(cb2);
        
        
        
        type=new JLabel("Type:");
        type.setBounds(20, 220, 120, 30);
        getContentPane().add(type);
        rb1=new JRadioButton("Diet");
        rb1.setBounds(150,220,50,30);
        getContentPane().add(rb1);
      //we add another radio button  
        rb2=new JRadioButton("Normal");
        rb2.setBounds(250,220,80,30);
        getContentPane().add(rb2);
        //since we want to click only one radio button option we add ButtonGroup
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);
        
        
        reset=new JButton("reset");
        reset.setBounds(400,150,90,30);
        getContentPane().add(reset);
        
        //now we want to clear any userInput in the textFields
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                tfcustomerNo.setText("");
                tfName.setText("");
                tfcontact.setText(""); 
                tA2.setText("");
                
                
            }    
        });
        
        //RECEIPT
        receipt=new JButton("Generate");
        receipt.setBounds(480,150,90,30);
        getContentPane().add(receipt);
        
// we want to get user's info and orders to the textArea so we can print the receipt

receipt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                tA2.setText("-----Happy resturant and Coffee-----\n\n");
                tA2.setText(tA2.getText()+ "Customer Number :"+ tfcustomerNo.getText()+"\n\n " + "Customer Name :" +tfName.getText()+"\n\n" + "Customer Contact :" + tfcontact.getText()+"\n\n"+ "Food :"+cb1.getSelectedItem()+"\n\n"+"Drinks :"+cb2.getSelectedItem());
                
                if(cb1.getSelectedIndex()==0)
                {
                    fprice=200;
                }
                 if(cb1.getSelectedIndex()==1)
                {
                    fprice=100;  
                }
                  if(cb1.getSelectedIndex()==2)
                {
                    fprice=50;
                    
                }
                  
              //we add price to drinks
               if(cb2.getSelectedIndex()==0)
                {
                    dprice=20; 
                    ptotal=dprice+fprice;
                    tA2.setText(tA2.getText()+"\n\nTotal :"+ptotal);

                    
                }
                   if(cb2.getSelectedIndex()==1)
                {
                    dprice=25;
                    ptotal=dprice+fprice;
                    tA2.setText(tA2.getText()+"\n\nTotal :"+ptotal);
                }
                 if(cb2.getSelectedIndex()==2)
                {
                    dprice=45;
                    ptotal=dprice+fprice;
                    tA2.setText(tA2.getText()+"\n\nTotal :"+ptotal);
                }  
                  
       }
                
            }
        );

        //print
        print=new JButton("Print");
        print.setBounds(560,150,90,30);
        getContentPane().add(print);
        
        //now we want to print the receipt 
        print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                try {
                    tA2.print();
                } catch (PrinterException ex) {
                    System.out.println("printer not found");
                }
                
            }
            
        });
        
        
        tA2=new JTextArea();
        tA2.setBounds(400,180,250,250);
        getContentPane().add(tA2);
        
        
        
       
        
      
        setVisible(true);
        
        
        
        
    }

    
    public static void main(String[] args) {
        
       new MyResturant();
       
    }
    
}
