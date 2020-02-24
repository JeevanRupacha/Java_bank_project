import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class Login implements MouseListener{
    ////colors/////

public  final Color LIGHT_BLUE = new Color(51,153,255);
public  final Color Very_light_blue = new Color(51-204-255);
public  final Color VERY_DARK_GREY = new Color(52,52,52);
public  final Color WHITE = new Color(255,255,255);
public  final Color LIGHT_BROWN = new Color(153,102,0);
public  final Color BLACK = new Color(0, 0, 0);
public  final Color PURPLE = new Color(102,0,153);
public  final Color DARK_BROWN = new Color(51,0,0);
public  final Color BROWN = new Color(102,51,0);
public  final Color GRAY = new Color(102,102,102);
public  final Color VERY_LIGHT_RED = new Color(255,102,102);
public  final Color VERY_DARK_GREEN = new Color(0,102,0);
public  final Color VERY_DARK_RED = new Color(153,0,0);
public  final Color BLUE_C = new Color(139,203,240);
public  final Color BLUE_D = new Color(0,126,255);
public  final Color ORANGE = new Color(235,145,0);
public  final Color CURD = new Color(210,237,187);

    ////colors/////0, 162, 255 235, 145, 0 201, 237, 187

    /////fonts/////
    Font font1 = new Font("SansSerif",Font.BOLD, 20);
     Font font2 = new Font ("Characters",Font.PLAIN,18);
     Font font3 = new Font("Helvetica",Font.PLAIN,15);
    /////fonts/////


    //////String random number
    String randomstring;
    //////String random number

    ///////signup//////////////
     JPanel panel10,panel11;
     JPanel singupPanel,headPanel;
 JButton submit;
 JLabel lnotice,lname, lpass1,lpass2 ,lbod, laddr,lacc_no,lid_no,loccupation,lemail,lphone,lgender;
 JTextField tname1,tname2, tpass1,tpass2 ,tbod,tbodm,tbodd, taddr,tacc_no,tid_no,toccupation,temail,tphone;
// DatePicker datepick ;
 JRadioButton radio1,radio2,radio3;
// ButtonGroup gender;
/////////signup////////////



///submit ////////////////////

 JPanel submitPanel;
 JLabel randomShow,succAcc;
 JTextField accNum;
 JButton submit2;
double randomNum;

///submit ////////////////////

/////Create login ////////////////////

  JPanel home,withDrawPanel,addMoneyPanel;
  JLabel id_no,welcome,accBalance;
  JTextField withDraw,addMoney,transferMoney;
  JButton bwithDraw, baddMoney,btransferMoney,bsubmit1,bsubmit2;


/////Create login ////////////////////


////Database////
 Connection conn;
 Statement stmt;
 ResultSet r;
 String getEmail;
 double money,entermoney;
////Database////

/////insufficient
JLabel insufficientMoney;



     JFrame f ;
    JPanel loginPanel;
    JLabel username,password,loginAlert;
     JTextField userText,passText;
     JButton login, signup;

    Login(){
       

           withDraw = new JTextField();
        ///insuff
        insufficientMoney = new JLabel();

        ////

        panel10 = new JPanel();
        panel11 = new JPanel();
        ////



        f = new JFrame();
        f.setSize(600,600);
        loginPanel = new JPanel();
        f.add(loginPanel);
        loginPanel.setBounds(0,100,600,450);

        

        final LineBorder rBorder = new LineBorder(Color.BLUE,2,true);
        final LineBorder rBorder2 = new LineBorder(Color.RED,2,true);
       // RoundedBorder rborder1 = new RoundedBorder(10);
      //  LineBorder line = new LineBorder(Color.blue, 2, true);
        username = new JLabel("Enter your username:");
        password = new JLabel("Enter your password:");
        loginAlert = new JLabel("Login your account or Sign up!");
        loginPanel.add(loginAlert);
        loginAlert.setFont(font1);
        loginAlert.setBounds(180,40,400,30);
        userText = new JTextField();
        passText = new JTextField();
        login = new JButton("Login");
        signup = new JButton("Sign up");
        submit = new JButton("Submit");
        submit2 = new JButton("Submit");
        bwithDraw = new JButton("With Draw");
        baddMoney = new JButton("Add Money");
        btransferMoney = new JButton("Transfer");
        bsubmit1 = new JButton("Submit");
        bsubmit2 = new JButton("Submit");
        home =new JPanel();
        withDrawPanel = new JPanel();
        addMoneyPanel = new JPanel();
        

        loginPanel.add(username);
        loginPanel.add(password);
        loginPanel.add(userText);
        loginPanel.add(passText);
        loginPanel.add(login);
        loginPanel.add(signup);

        username.setBounds(10,100,200,30);
        password.setBounds(10,140,200,30);
        userText.setBounds(220,100,200,30);
        passText.setBounds(220,140,200,30);
        login.setBounds(220,185,90,30);
        signup.setBounds(330,185,90,30);

        
        // login.setBorderPainted(true);
        // login.setOpaque(false);
        login.setBorder(rBorder);
        login.setBackground(Color.RED);
        signup.setBackground(ORANGE);
        signup.setBorder(rBorder2);

        userText.setBorder(null);
        passText.setBorder(null);
        userText.setBackground(BLUE_D);
        passText.setBackground(BLUE_D);
        userText.setForeground(Color.WHITE);
        passText.setForeground(Color.WHITE);
        userText.setFont(font3);
        // passText.setFont(font2);

       // loginPanel.setVisible(false);
        loginPanel.setLayout(null);
        // username.setFont(font2);
        // password.setFont(font2);
        
loginPanel.setVisible(true);
f.setVisible(true);
f.setLayout(null);
f.setBackground(BLUE_C);
loginPanel.setBackground(BLUE_C);
f.addMouseListener(this);
login.addMouseListener(this);
signup.addMouseListener(this);
submit.addMouseListener(this);
submit2.addMouseListener(this);
baddMoney.addMouseListener(this);
bwithDraw.addMouseListener(this);
btransferMoney.addMouseListener(this);
bsubmit1.addMouseListener(this);
bsubmit2.addMouseListener(this);


f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);


    }

    public void mouseEntered(final MouseEvent e){
      
    }
    public void mouseExited(final MouseEvent e){
       
    }
    public void mouseReleased(final MouseEvent e){}
    public void mouseClicked(final MouseEvent e){
        
        

        if(e.getSource()==signup){
            loginPanel.setVisible(false);
           createForm();
        }

        if(e.getSource()==submit){
            if((tname1.getText()).isEmpty()){tname1.setText("Name is empty!");tname1.setForeground(Color.RED);}
           else if((tname2.getText()).isEmpty()){tname2.setText("Name is empty!");tname2.setForeground(Color.RED);}
           else if((tbod.getText()).isEmpty()){tbod.setText("Birth date is empty!");tbod.setForeground(Color.RED);}
           else if((taddr.getText()).isEmpty()){taddr.setText("Address is empty!");taddr.setForeground(Color.RED);}
           else if((tid_no.getText()).isEmpty()){tid_no.setText("ID is empty!");tid_no.setForeground(Color.RED);}
           else if((tphone.getText()).isEmpty()){tphone.setText("Phone number is empty!");tphone.setForeground(Color.RED);}
           else if((toccupation.getText()).isEmpty()){toccupation.setText("Occupation is empty!");toccupation.setForeground(Color.RED);}
           else if((temail.getText()).isEmpty()){temail.setText("Email is empty!");temail.setForeground(Color.RED);}
           else if((tpass1.getText()).isEmpty()){tpass1.setText("Password is empty!");tpass1.setForeground(Color.RED);}
           else if((tpass2.getText()).isEmpty()){tpass2.setText("Password is empty!");tpass2.setForeground(Color.RED);}
            else if(!(tpass1.getText()).equals(tpass2.getText())){
                tpass1.setText("Password doesn't match!");
                tpass2.setText("Password doesn't match!");
                tpass1.setForeground(Color.RED);
                tpass2.setForeground(Color.RED);
            }else{
                    
                    loginPanel.setVisible(false);
                    singupPanel.setVisible(false);
                    createSubmit();
                }
            
        }

        if(e.getSource()==login){
        
            // while(name ==(userText.getText())){
          // System.out.println(name.equals(userText.getText()));
            
           
            
        ///database

       
            try{
        Class.forName("com.mysql.jdbc.Driver");
   conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onebank","root"," ");
    stmt = conn.createStatement();
      r = stmt.executeQuery("select * from member_table");
        while(r.next()){
          if(((r.getString(4)).equals(userText.getText()))&&(r.getString(6).equals(passText.getText()))){
            loginPanel.setVisible(false);
            createLogin();
            System.out.println(userText.getText());

           getEmail = r.getString(5);
            ///display accno and welcome back curent balance
            id_no.setText("Account No: "+ r.getString(5));
            id_no.setForeground(Color.RED);
            welcome.setText("Welcome back Mr. "+r.getString(2));
            accBalance.setText("Your current Balance is "+r.getDouble(3)+"$");
            accBalance.setFont(font1);
          }
           
        }
        conn.close();
            } catch(SQLException ey){
                System.out.println(ey.getMessage());
            }catch(ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            }
        }

          
            

        if(e.getSource()==submit2){
            if((accNum.getText()).isEmpty()){
                accNum.setText("Account number is empty!");
                accNum.setForeground(Color.RED);
         
            }else if(!randomstring.equals(accNum.getText())){
                accNum.setText("Account number no match!");
                accNum.setForeground(Color.RED);
                System.out.println(randomstring);
                System.out.println(accNum.getText());
            }
            else{
               

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String name = tname1.getText()+" "+ tname2.getText();
                    System.out.println(name);
                    double balance = 0;
                    String email = temail.getText() ;
                    String acc_no = accNum.getText();
                    String pass = tpass1.getText();
                    String date_of_b = tbod.getText();
                    String occupation = toccupation.getText();
                    String phone = tphone.getText();
                    String address = taddr.getText();

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onebank","root"," ");
                  PreparedStatement stmt = conn.prepareStatement("INSERT INTO member_table values(?,?,?,?,?,?,?,?,?,?)");
                 stmt.setInt(1,0);
                  stmt.setString(2,name);
                  stmt.setDouble(3,balance);
                  stmt.setString(4,email);
                  stmt.setString(5,acc_no);
                  stmt.setString(6,pass);
                  stmt.setString(7,date_of_b);
                  stmt.setString(8,address);
                  stmt.setString(9,occupation);
                  stmt.setString(10,phone);
                  //String query = "INSERT INTO member_table(name,balance,email,password_p,date_of_birth,address,occupation,phone_no) values(name,balance,email,pass,date_of_b,address,occupation,phone_no)";
                   int n = stmt.executeUpdate();
                   System.out.println(n);
                   conn.close();
                       } catch(SQLException ey){
                           System.out.println(ey.getMessage());
                       }catch(ClassNotFoundException ex){
                           System.out.println(ex.getMessage());
                       }

                System.out.println("test");
                loginPanel.setVisible(true);
                singupPanel.setVisible(false);
                     submitPanel.setVisible(false);  
                     succAcc = new JLabel("Successfully Account is created!");
                     loginPanel.add(succAcc);
                     succAcc.setBounds(230,250,400,40);
            }
     
                }

                if(e.getSource()==baddMoney){

                    try{
                    faddMoney();
                    }catch(NullPointerException ex){
                        System.out.println(ex.getMessage());
                     }catch(NumberFormatException ey){
                        System.out.println(ey.getMessage());
                     }
                }
                if(e.getSource()==bwithDraw){
                    fwithDraw();
                    
                }
                if(e.getSource() == bsubmit1){
                    System.out.println(getEmail);

                    JLabel shownoticeMoney ;
                    
                    shownoticeMoney = new JLabel();
                    // panel10.setVisible(false);
                    // panel11.setVisible(false);
                    panel10.add(shownoticeMoney);
                    shownoticeMoney.setBounds(200,15,500,40);
                   shownoticeMoney.setText(" ");
                    shownoticeMoney.setVisible(false);
                    
                   //home.add(JL);
                   
                   
                    try{
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onebank","root"," ");
                         stmt = conn.createStatement();
                                String sql_query = "SELECT * FROM member_table WHERE "+" account_no= "+getEmail;
                               ResultSet r1 = stmt.executeQuery(sql_query);
                                   while(r1.next()){
                                       money = r1.getDouble(3);
                                       if(!(withDraw.getText()).equals(" ")){
                                       entermoney = Double.valueOf(withDraw.getText());
                                       }else{
                                           System.out.println("space");
                                       }
                                        System.out.println(money);
                                        System.out.println(entermoney);
                                    
                                    }
                                    if(money<entermoney){

                                       
                                        panel10.setVisible(false);
                                        panel11.setVisible(false);
                                       
                                       
                                        home.add(insufficientMoney);
                                        insufficientMoney.setBounds(200,400,500,40);
                                        insufficientMoney.setText("You have insufficient Money! "); 
                                       
                                    }else{
                                        //updateBalaceof();
                                        insufficientMoney.setVisible(false);
                                        panel11.setVisible(false);
                                        money = money - entermoney;
                                        System.out.println("ox");
                                        System.out.println(money);
                                      
                                       System.out.println(getEmail);
                                     


                                       String queryN = "update member_table set balance = ? where account_no = ?";
                                       PreparedStatement preparedStmt = conn.prepareStatement(queryN);
                                       preparedStmt.setDouble(1,money);
                                       preparedStmt.setString(2,getEmail);
                                       int n = preparedStmt.executeUpdate();
                                       System.out.println(n+"row is affected");

                                        // String sql_query1 = "UPDATE member_table set balance="+money+" WHERE account_no= "+getEmail;
                                        // int n = stmt.executeUpdate(sql_query1);
                                   
                                      
                                             
                                             home.add(panel10);
                                             panel10.setBounds(25,400,470,100);
                                             panel10.setBackground(ORANGE);
                                             panel10.setVisible(true);
                                             panel10.setLayout(null); 
                                            shownoticeMoney = new JLabel();
                                            panel10.add(shownoticeMoney);
                                            shownoticeMoney.setBounds(200,15,500,40);
                                        shownoticeMoney.setText("You with draw "+entermoney+" $");
                                        shownoticeMoney.setVisible(true);
                                        accBalance.setText("Your current Balance is "+money+"$");
                                        accBalance.setFont(font1);
                                   
                                    
                                }

                                    conn.close();
                                 
                                        } catch(SQLException ex){
                                            System.out.println(ex.getMessage());
                                        }catch(ClassNotFoundException ex){
                                            System.out.println(ex.getMessage());
                                        }catch(NumberFormatException ec){
                                            System.out.println(ec.getMessage());
                                        }catch(InputMismatchException en){
                                            System.out.println(en.getMessage());
                                        }

       

                                        //updateBalaceof();
            }
                if(e.getSource() == bsubmit2){


                   
                   JLabel shownoticeMoney = new JLabel();
   
            try{
                shownoticeMoney.setVisible(false);
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onebank","root"," ");
                     stmt = conn.createStatement();
                     String sql_query = "SELECT * FROM member_table WHERE "+" account_no= "+getEmail;
                    ResultSet re = stmt.executeQuery(sql_query);
                        while(re.next()){
                            money = re.getDouble(3);
                            if(!(withDraw.getText()).equals(" ")){
                            entermoney = Double.valueOf(withDraw.getText());
                            }else{System.out.println("space");}
                             System.out.println(money);
                             System.out.println(entermoney);
                           
                                
                        }
                        money = money + entermoney;
                        System.out.println(money);

                             String queryM = "update member_table set balance = ? where account_no = ?";
                             PreparedStatement preparedStmt = conn.prepareStatement(queryM);
                             preparedStmt.setDouble(1,money);
                             preparedStmt.setString(2,getEmail);
                             int n = preparedStmt.executeUpdate();
                             System.out.println(n+"row is affected");
                             //panel10.setVisible(false);
                             insufficientMoney.setVisible(false);
                             panel10.setVisible(false);
                                       home.add(panel11);
                                       panel11.setBounds(25,400,470,100);
                                       panel11.setBackground(ORANGE);
                                       panel11.setVisible(true);
                                       panel11.setLayout(null); 
                                       panel11.add(shownoticeMoney);
                                       shownoticeMoney.setBounds(200,15,500,40);  
                                  shownoticeMoney.setText("You add "+entermoney+" $");
                                  shownoticeMoney.setVisible(true);
                                  accBalance.setText("Your current Balance is "+money+"$");
                                  accBalance.setFont(font1);

                                //    String sql_query1 = "UPDATE member_table set balance=10000 WHERE account_no= "+getEmail;
                                //    int n = stmt.executeUpdate(sql_query1);
                                     

                                   conn.close();
                                
                                       } catch(SQLException ex){
                                           System.out.println(ex.getMessage());
                                       }catch(ClassNotFoundException ea){
                                           System.out.println(ea.getMessage());
                                       }catch(NumberFormatException eb){
                                           System.out.println(eb.getMessage());
                                       }catch(InputMismatchException ed){
                                           System.out.println(ed.getMessage());
                                       }
                                       
                    
                }
}
    public void mousePressed( MouseEvent e){}


    public  void  createForm(){
        headPanel = new JPanel();
        singupPanel = new JPanel();
        f.add(singupPanel);
        singupPanel.setBounds(0,30,600,570);
        singupPanel.setVisible(true);
        singupPanel.setLayout(null);
        headPanel.setBounds(0,0,600,30);
        lnotice = new JLabel("Fill up the form**");
        singupPanel.add(headPanel);
        headPanel.add(lnotice);
        lnotice.setBounds(200,0,400,40);
    headPanel.setVisible(true);
    lnotice.setFont(font1);



lname = new JLabel("Name*:");
lbod = new JLabel("Date of Birth*:");
laddr = new JLabel("Address*:");
lid_no = new JLabel("ID No*:");
loccupation = new JLabel("Occupation*:");
lemail = new JLabel("Email*:");
lphone = new JLabel("Phone Number*:");
lgender = new JLabel("Select Gender*:");
lpass1 = new JLabel("Enter Password*:");
lpass2 = new JLabel("Re-enter Password*:");



singupPanel.add(lname);
singupPanel.add(lbod);
singupPanel.add(laddr);
singupPanel.add(lid_no);
singupPanel.add(loccupation);
singupPanel.add(lemail);
singupPanel.add(lphone);
singupPanel.add(lgender);
singupPanel.add(lpass1);
singupPanel.add(lpass2);

lname.setBounds(10,30,150,25);
lbod.setBounds(10,90,150,25);
laddr.setBounds(10,120,150,25);
lid_no.setBounds(10,150,150,25);
loccupation.setBounds(10,210,150,25);
lphone.setBounds(10,180,210,25);
lgender.setBounds(10,240,150,25);
lemail.setBounds(10,270,150,25);
lpass1.setBounds(10,300,150,25);
lpass2.setBounds(10,330,150,25);

//tname1,tname2, tpass1,tpass2 ,tbod,tbodm,tbodd, taddr,tacc_no,tid_no,toccupation,temai,tphone;
tname1 =new JTextField("Enter First Name");
tname2 =new JTextField("Enter Second Name");
tbod =new JTextField("2020/3/23");
//datepick= new DatePicker();
// datepick.setValue(LocalDate.now());
// datepick.setClearButtonVisible(true);
taddr =new JTextField();
tid_no = new JTextField();
toccupation = new JTextField();
tphone = new JTextField();
temail =new JTextField();
//gennder
radio1 = new JRadioButton("Male");
radio2 = new JRadioButton("Female");
radio3 = new JRadioButton("Custom");
final ButtonGroup gender = new ButtonGroup();

tpass1 = new JTextField();
tpass2 = new JTextField();

singupPanel.add(tname1);
singupPanel.add(tname2);
singupPanel.add(tbod);
//singupPanel.add(datepick);
singupPanel.add(taddr);
singupPanel.add(tid_no);
singupPanel.add(toccupation);
singupPanel.add(temail);
singupPanel.add(tphone);
singupPanel.add(tpass1);
singupPanel.add(tpass2);
gender.add(radio1);
gender.add(radio2);
gender.add(radio3);
singupPanel.add(radio1);
singupPanel.add(radio2);
singupPanel.add(radio3);

tname1.setBounds(200,30,200,25);
tname2.setBounds(200,60,200,25);
tbod.setBounds(200,90,200,25);
//datepick.setBounds(220,60,200,25);
taddr.setBounds(200,120,200,25);
tid_no.setBounds(200,150,200,25);
toccupation.setBounds(200,210,200,25);
tphone.setBounds(200,180,200,25);
radio1.setBounds(200,240,65,25);
radio2.setBounds(260,240,80,25);
radio3.setBounds(335,240,80,25);
temail.setBounds(200,270,200,25);
tpass1.setBounds(200,300,200,25);
tpass2.setBounds(200,330,200,25);

//submit = new JButton("Submit");
singupPanel.add(submit);
submit.setBounds(200,380,200,30);
submit.setBackground(VERY_DARK_GREEN);

///note 
final JLabel note = new JLabel("\"Note: All the information provided by you will not be miss use by our team @OneBank\"");
singupPanel.add(note);
note.setBounds(30,450,500,40);
note.setForeground(Color.RED);

    }


    public   void createSubmit(){

     
        submitPanel =new JPanel();
        f.add(submitPanel);
        submitPanel.setBounds(0,0,600,600);
        submitPanel.setVisible(true);
        submitPanel.setLayout(null);


        accNum =new JTextField();
        submitPanel.add(accNum);
        accNum.setBounds(200,200,200,25);
        submitPanel.add(submit2);
        submit2.setBounds(200,235,200,25);

        randomstring = String.valueOf((int)randomNumber1())+String.valueOf((int)(randomNumber2()));
        randomShow = new JLabel("Your account number is "+randomstring+" !"+"  enter below");
        submitPanel.add(randomShow);
        randomShow.setBounds(150,120,500,40);
      


    }

////  JPanel home;
 /// JLabel id_no,welcome,accBalance;
 /////// JTextField withDraw,addMoney,transferMoney;/
    public  void createLogin()
{
   
    f.add(home);
    home.setBounds(0,0,600,600);
    id_no = new JLabel("Account No:"+"");
    welcome = new JLabel("Welcome back "+"");
    accBalance = new JLabel("Your current balance is "+" "+"$");
    home.add(id_no);
    home.add(welcome);
    home.add(accBalance);

    home.add(bwithDraw);
    home.add(baddMoney);
    home.add(btransferMoney);
    bwithDraw.setBounds(30,150,150,30);
    baddMoney.setBounds(185,150,150,30);
    btransferMoney.setBounds(340,150,150,30);




    id_no.setBounds(8,0,300,25);
    welcome.setBounds(8,30,300,25);
    accBalance.setBounds(120,100,400,30);
    home.setBackground(CURD);
    home.setVisible(true);
    home.setLayout(null);

}


    public  void fwithDraw(){
    addMoneyPanel.setVisible(false);
    home.add(withDrawPanel);
     withDrawPanel.setBounds(30,200,460,100);
     withDrawPanel.setVisible(true);
     withDrawPanel.setLayout(null);   
    
        withDrawPanel.add(withDraw);
        withDrawPanel.add(bsubmit1);
        withDraw.setBounds(20,50,200,30);///40,220,200,30
        bsubmit1.setBounds(230,50,100,30);
        
        // withDraw.setVisible(true);
        // bsubmit1.setVisible(true);
        withDrawPanel.setBackground(Color.RED);  

    }


  
    public  void faddMoney(){
    
        home.add(addMoneyPanel);
        addMoneyPanel.setBounds(30,200,460,100);
        addMoneyPanel.add(withDraw);
        addMoneyPanel.add(bsubmit2);
        withDraw.setBounds(20,50,200,30);
        bsubmit2.setBounds(230,50,100,30);
        addMoneyPanel.setVisible(true);
       addMoneyPanel.setLayout(null);
       withDrawPanel.setVisible(false);
       addMoneyPanel.setBackground(BLUE_D);
       

    }
    public  void ftransfer(){
           
       // home.add(transferMoney);
       transferMoney = new JTextField();
    }



    

    public  double randomNumber1(){

        return (Math.random()*100000000);

    }
    public  double randomNumber2(){

        return (Math.random()*100000000);

    }

    
        ///database

//         public  void databaseConn(){
//             try{
//         Class.forName("com.mysql.jdbc.Driver");
//    conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onebank","root","rupachazevn");
//     stmt = conn.createStatement();
//         ResultSet rs = stmt.executeQuery("select * from member_table");
//         while(rs.next()){
//             System.out.println(rs.getString(2));
           
//         }
//         conn.close();
//             } catch(SQLException e){
//                 System.out.println(e.getMessage());
//             }catch(ClassNotFoundException ex){
//                 System.out.println(ex.getMessage());
//             }
//         }


        
    
        ///databas

    


    public static void main(final String []args){
     new Login();
   //databaseConn();


//register driver
//create connection
//create statement
//execute statement
//close connection
   


  

    }
}
