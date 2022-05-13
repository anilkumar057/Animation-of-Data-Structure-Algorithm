package dataStructureAnimation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class home {

	private static final int CENTER = 0;
	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(300, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton bub_label = new JButton("Bubble Sort");
		bub_label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(() -> {
		            JFrame ex = new TempFrame();
		            ex.setVisible(true);
		        });
			}
		});
		bub_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bub_label.setBounds(0, 0, 433, 35);
		frame.getContentPane().add(bub_label);
		bub_label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		JButton ins_label = new JButton("Insertion Sort");
		ins_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ins_label.setBounds(0, 35, 433, 35);
		frame.getContentPane().add(ins_label);
		ins_label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ins_label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(() -> {
					JFrame ex =new InsertFrame();
					ex.setVisible(true);
				});
			}
		});
		
		JButton sel_label = new JButton("Selection Sort");
		sel_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sel_label.setBounds(0, 70, 433, 35);
		frame.getContentPane().add(sel_label);
		sel_label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		sel_label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(() -> {
					JFrame ex=new SelFrame();
					ex.setVisible(true);
				});
			}
		});
		
		JButton stack =new JButton("Stack");
		stack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stack.setBounds(0, 105, 433, 35);
		frame.getContentPane().add(stack);
		stack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(() -> {
					JFrame ex=new StackFrame();
					ex.setVisible(true);
				});
			}
		});
	}
}

//Bubble Sort
class TempFrame extends JFrame{
	JFrame tframe;
	
	TempFrame(){
		tframe = new JFrame();
		setBackground(Color.WHITE);
		setBounds(10, 0, 600, 300);
		initialize();
	}
	
	private void initialize() {
		
		JButton startbtn = new JButton("Start");
		startbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(startbtn);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startbtn.setVisible(false);
				Table obj=new Table();
				add(obj);
			}
		});
	}
}

class Table extends JPanel implements ActionListener{
	int arr[]=new int[10];
	int position[]={50,100,150,200,250,300,350,400,450,500};
	Timer timer;
	int delay=500;
	int count=0;
	int pointer=1;
	public Table(){
		for(int i=0;i<10;i++){
			arr[i]=(int)(Math.random()*100);
		}
		timer=new Timer(delay,this);
		timer.start();
	}

	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(10, 0, getWidth(), getHeight());
		if(arr[pointer]<arr[pointer-1]){
			int temp=arr[pointer];
			arr[pointer]=arr[pointer-1];
			arr[pointer-1]=temp;
		}
		g.setColor(Color.YELLOW);
		g.fillRect(position[pointer-1]-10, 10, 30, 30);
		g.setColor(Color.PINK);
		g.fillRect(position[pointer]-10, 10, 30, 30);
		g.setColor(Color.BLACK);
		for(int i=0;i<10;i++){
			g.drawString(arr[i]+"",position[i],30);
		}
	}

	public void actionPerformed(ActionEvent arg0){
		if(count<9){
			if(pointer<9-count){
				pointer++;
				repaint();
			}
			else{
				count++;
				pointer=1;
				repaint();
			}
		}
		else timer.stop();
	}
}

//Insertion Sort
class InsertFrame extends JFrame{
	JFrame iframe;
	
	InsertFrame(){
		iframe = new JFrame();
		setBackground(Color.WHITE);
		setBounds(10, 0, 600, 300);
		initialize();
	}
	
	private void initialize() {
		
		JButton startbtn = new JButton("Start");
		startbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(startbtn);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startbtn.setVisible(false);
				InsTable obj=new InsTable();
				add(obj);
			}
		});
	}
}

class InsTable extends JPanel implements ActionListener{
	int arr[]=new int[10];
	int position[]={50,100,150,200,250,300,350,400,450,500};
	Timer timer;
	int delay=500;
	int count=1;
	int pointer=1;
	public InsTable(){
		for(int i=0;i<10;i++){
			arr[i]=(int)(Math.random()*100);
		}
		timer=new Timer(delay,this);
		timer.start();
	}

	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(10, 0, getWidth(), getHeight());
		if(arr[pointer]<arr[pointer-1]){
			int temp=arr[pointer];
			arr[pointer]=arr[pointer-1];
			arr[pointer-1]=temp;
		}
		g.setColor(Color.YELLOW);
		g.fillRect(position[pointer-1]-10, 10, 30, 30);
		g.setColor(Color.PINK);
		g.fillRect(position[pointer]-10, 10, 30, 30);
		g.setColor(Color.BLACK);
		for(int i=0;i<10;i++){
			g.drawString(arr[i]+"",position[i],30);
		}
		pointer--;
	}

	public void actionPerformed(ActionEvent arg0){
		if(count<10){
			if(pointer>0 && arr[pointer]<arr[pointer-1]){
				repaint();
			}
			else{
				count++;
				pointer=count;
				if(count<10) repaint();
			}
		}
		else timer.stop();
	}
}

//Selection Sort
class SelFrame extends JFrame{
	JFrame sframe;
	SelFrame(){
		sframe=new JFrame();
		setBackground(Color.WHITE);
		setBounds(10,0,600,300);
		setVisible(true);
		initialize();
	}
	
	void initialize() {
		JButton startbtn=new JButton("Start");
		startbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(startbtn);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startbtn.setVisible(false);
				SelTable obj=new SelTable();
				add(obj);
			}
		});
	}
}

class SelTable extends JPanel implements ActionListener{
	int[] arr=new int[10];
	int[] position= {50,100,150,200,250,300,350,400,450,500};
	Timer timer;
	int delay=500;
	int count=0;
	int pointer=0;
	
	public SelTable(){
		for(int i=0;i<10;i++) {
			arr[i]=(int)(Math.random()*100);
		}
		timer=new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(10, 0, getWidth(), getHeight());
		if(arr[count]>arr[pointer]) {
			int temp=arr[count];
			arr[count]=arr[pointer];
			arr[pointer]=temp;
		}
		g.setColor(Color.YELLOW);
		g.fillRect(position[count]-10, 10, 30, 30);
		g.setColor(Color.PINK);
		g.fillRect(position[pointer]-10, 10, 30, 30);
		g.setColor(Color.BLACK);
		for(int i=0;i<10;i++){
			g.drawString(arr[i]+"",position[i],30);
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(count<9) {
			if(pointer<9) {
				pointer++;
				repaint();
			}
			else {
				count++;
				pointer=count+1;
				if(pointer<9) repaint();
			}
		}
		else timer.stop();
	}
}

//stack
class StackFrame extends JFrame{
	JFrame sframe;
	public StackFrame() {
		sframe=new JFrame();
		setBackground(Color.WHITE);
		setBounds(10,0,600,500);
		setLayout(null);
		setVisible(true);
		initialize();
	}
	
	public void initialize() {
		
	}
}
