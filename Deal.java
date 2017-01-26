import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;
//import java.net.URL;
//import java.net.MalformedURLException;
/*
<applet code="Deal" width=250 height=200>
</applet>
*/
public class Deal extends JApplet implements ActionListener 
{
	
	int i,j=0,k=0,count=0,itemno=1,x,y=0,n=0,amount=0,value=0;
	JLabel lab[]=new JLabel[26];
	JButton but[]=new JButton[26];
	double a[]={1,2,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,500000,1000000,2500000,4000000,5000000};
	double totalPossibleCash=0, totalRemaining,you;
	int b[]=new int[26];
	double l[]=new double[25];
	boolean[] taken = new boolean[26];
	Random r = new Random();
	int[] uniqueRNums = new int[26];	
	public void init()  
	{
		for(i=0;i<26;i++)
			b[i]=i;
		for(i=0;i<26;i++)
			totalPossibleCash+=a[i];
		totalRemaining=totalPossibleCash;
		setLayout(new GridLayout(13,4));
		ImageIcon i1=new ImageIcon("u.jpg");
		ImageIcon i2=new ImageIcon("ddd.jpg");
		for(count=0;count<26;)
		{
    			 int rNum = r.nextInt(26);
			 if(!taken[rNum] )
    			 {     
        				taken[rNum] = true;	       
    				uniqueRNums[count++]=rNum;		       
   			 }
		}
		for(i=0;i<26;i++)
		{			
			but[i]=new JButton(""+b[i],i2);			
			lab[i]=new JLabel(""+a[i],i1,JLabel.CENTER);
			but[i].addActionListener(this);
		}
		i=0;
		for(j=0;j<52;j++)
			if(j%4==0||j%4==3)			
				add(lab[i++]);
			else
				add(but[k++]);
		JFrame frame=new JFrame();
		int result = JOptionPane.showConfirmDialog(frame, "Ready to Play?" );
		if(JOptionPane.YES_OPTION == result)
		{
			JOptionPane.showMessageDialog(frame,"First Choose your briefcase");	
		}
		else
		
			System.exit(0);
		
	}
	static int tick=0;
	static int cs=0;
	int result;
	
				
		public void start()
		{
			JFrame frame=new JFrame();
			
			
			//AppletContext ac = getAppletContext();
			if(n==0)
			{}
			//if(kn==0)
			//{
			else if(n==7||n==12||n==16||n==19||n==21||n==22||n==23||n==24||n==25)
			{
				
				
				//JFrame frame=new JFrame("show");
				amount = (int)((totalRemaining) / (26 - n)*0.5);
				value = Math.round(amount);
				if( cs==0 ){
				//JFrame frame=new JFrame();
				 result = JOptionPane.showConfirmDialog(frame, "Banker's call.. He offers you "+value);
				if(JOptionPane.YES_OPTION == result)
				{
					
					++tick;
					++cs;
					//JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame,"Congrats.You have won"+value);
					
					//System.out.println("You have won"+value);
					//System.exit(0);
					//getAppletContext().showDocument(new URL("Thankyou.html"));
				
				if(tick==1){
				//JFrame frame=new JFrame();
				JOptionPane.showMessageDialog(frame, "Thanks for playing.Just See what happens if u continue playing till end");
				}
				
				
				}}
			
				//}
				else if(JOptionPane.NO_OPTION==result)		
				{
							
				}
				else
				{	
				
				
				
				
				
				
				}
			}
			else if(n==26)
			{
				System.out.println("You have won"+you);
				//JFrame frame=new JFrame();
				if(tick==1)
				JOptionPane.showMessageDialog(frame,"If you had played till the end.You would have won"+you);
				else
				JOptionPane.showMessageDialog(frame,"Congrats..Finally.You would have won"+you);

				/*try{	
				getAppletContext().showDocument(new URL(getCodeBase()+"Thankyou.html"),"_top");
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}*/
				
				
				
				
				
			}
			else
			{
			}	
	}
	public void actionPerformed(ActionEvent ae)
	{
		x=0;
		String str=ae.getActionCommand();
		 x=Integer.parseInt(str);
		if(itemno==1)
		{
			showStatus("You have chosen the briefacase no."+x+"Continue Playing");
			JFrame frame=new JFrame();
			JOptionPane.showMessageDialog( frame,"You have chosen the briefacase no."+x);
			but[x].setEnabled(false);
			itemno++;
			n++;
			you=a[uniqueRNums[x]];
		}
		else
		{
			showStatus("You have clicked"+a[uniqueRNums[x]]);
			JFrame frame=new JFrame();
			JOptionPane.showMessageDialog(frame,"This box had Rs."+a[uniqueRNums[x]]);
			but[x].setEnabled(false);
			String str1=lab[uniqueRNums[x]].getText();
			l[y++]=a[uniqueRNums[x]];
			lab[uniqueRNums[x]].setText("   ");
			System.out.println(""+l[y-1]);
			totalRemaining-=l[y-1];
			n++;
			start();		
		}
	}
}	

