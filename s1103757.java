
import java.awt.*;
import java.awt.event.*;


public class s1103757 extends Frame implements TextListener
{
   
   private Button[] btn=new Button[3];
   private Button nowbtn;
   private String[] titles = { "Red Light", "Yellow Light",
                 "Green Light"};                               
   private Panel buttonPanel=new Panel();
   private Frame frm=new Frame("Traffic Light");
   private DrawingPanel dg= new DrawingPanel(); //dg 指向 繪圖區物件 (dg 是繪圖區)
   private TextField txt=new TextField();
   public void init()
   {
      
      buildButtonPanel();
      //0,595,800,5
      txt.setBounds(0,595,800,5);  
      txt.setForeground(Color.black);
      //txt.addTextListener(frm);
      frm.setSize(800,600); 
          
      frm.setBackground(Color.white);
      
      
      frm.setLocation(250,250);               
      frm.add(buttonPanel, BorderLayout.EAST);
      frm.add(dg, BorderLayout.CENTER);
      frm.add(txt,BorderLayout.SOUTH); 
      frm.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)  
                             {  System.exit(0);}});
      frm.setVisible(true);
      
      
   }
   
      
   public void buildButtonPanel()
   {
   	  ButtonListener btnLis=new ButtonListener();
      
      buttonPanel.setLayout(new GridLayout(3, 1));

      for (int i = 0; i < btn.length; i++)
      {
         btn[i] = new Button(titles[i]);
         btn[i].addActionListener(btnLis);
         buttonPanel.add(btn[i]);
      }
   }
    

   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      	 nowbtn=(Button)e.getSource();
         dg.repaint(); // repaint()會先呼叫 update(g)將繪圖區清成空白
      	               // update(g) 再呼叫 繪圖區的 paint(g) 
      	               
      	 if (btn[0]==nowbtn)
       	{
         txt.setText("Red Light Stop !!");
        }
        if (btn[1]==nowbtn)
        {
           txt.setText("Yellow Light Alert !!");
        }
        if (btn[2]==nowbtn)
        {
           txt.setText("Green Light Pass !!");
        }
      }
   }
   
   
   
   class DrawingPanel extends Panel //定義繪圖區
   {     
      
      public DrawingPanel()
      {
            
         setBackground(Color.WHITE); //設定繪圖區背景顏色
      
      }
   	  
      public void paint(Graphics g)
      {
          
         Graphics2D g2D=(Graphics2D) g;
         
         g2D.setColor(Color.black);
         g2D.drawRect(80, 180, 290, 90);
         g2D.fillOval(100, 200, 50, 50);
         g2D.fillOval(200, 200, 50, 50);
         g2D.fillOval(300, 200, 50, 50);
         
         if (btn[0]==nowbtn)
         {
            g2D.setColor(Color.RED);
            g2D.fillOval(100, 200, 50, 50);
         }
         if (btn[1]==nowbtn)
         {
            g2D.setColor(Color.YELLOW);
            g2D.fillOval(200, 200, 50, 50);
         }
         if (btn[2]==nowbtn)
         {
            g2D.setColor(Color.GREEN);
            g2D.fillOval(300, 200, 50, 50);
         }
      }
    }
    
    public void textValueChanged(TextEvent e){
    	txt.setText("123");
    }
    
    public static void main(String args[])
    {
   	   new s1103757().init();
   	   
    }
}
