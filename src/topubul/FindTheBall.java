package topubul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FindTheBall extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel play, win, lose;
	private int plays, wins, loses;
	private JButton choice1;
	private JButton choice2;
	private JButton choice3;
	private JLabel sonuc;
	private JButton again;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindTheBall frame = new FindTheBall();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FindTheBall() {
		//EKRAN AYARLARI
		setTitle("Find The Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(0, 0, 786, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//OYUN ALANI
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 161, 55));
		panel_1.setBounds(10, 153, 766, 400);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//SEÇENEKLER
		choice1 = new JButton();
		choice1.setBackground(new Color(255, 255, 255));
		choice1.setFocusable(false);
		choice1.setIcon(new ImageIcon("src\\kapalı.png"));
		choice1.setBounds(94, 10, 194, 194);
		
		choice2 = new JButton();
		choice2.setBackground(new Color(255, 255, 255));
		choice2.setFocusable(false);
		choice2.setIcon(new ImageIcon("src\\kapalı.png"));
		choice2.setBounds(288, 10, 194, 194);
		
		choice3 = new JButton();
		choice3.setBackground(new Color(255, 255, 255));
		choice3.setFocusable(false);
		choice3.setIcon(new ImageIcon("src\\kapalı.png"));
		choice3.setBounds(482, 10, 194, 194);

		panel_1.add(choice1);
		panel_1.add(choice2);
		panel_1.add(choice3);
		
		//SONUÇ YAZISI
		sonuc = new JLabel("");
		sonuc.setVisible(false);
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		sonuc.setBounds(94, 278, 386, 42);
		panel_1.add(sonuc);
		
		//TEKRAR OYNAMA BUTONU
		again = new JButton("Play Again");
		again.setFocusable(false);
		again.setVisible(false);
		again.setBackground(new Color(128, 128, 0));
		again.setForeground(new Color(255, 255, 0));
		again.setFont(new Font("Tahoma", Font.PLAIN, 20));
		again.setBounds(502, 278, 158, 42);
		panel_1.add(again);
		
		//İSTATİSTİK ALANI
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 0));
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 0), new Color(0, 0, 0)), "STATISTICS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_2.setBounds(10, 10, 766, 133);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		//İSTATİSTİKLER
		play = new JLabel("Plays: 0");
		play.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		play.setBounds(31, 51, 155, 35);
		panel_2.add(play);
		
		win = new JLabel("Wins: 0");
		win.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		win.setBounds(231, 51, 155, 35);
		panel_2.add(win);
		
		lose = new JLabel("Loses: 0");
		lose.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		lose.setBounds(431, 51, 155, 35);
		panel_2.add(lose);
		
		//RESET BUTONU
		JButton reset = new JButton("Restart");
		reset.setFocusable(false);
		reset.setForeground(new Color(0, 128, 0));
		reset.setFont(new Font("Times New Roman", Font.BOLD, 21));
		reset.setBackground(new Color(255, 255, 0));
		reset.setBounds(627, 51, 105, 35);
		panel_2.add(reset);
		
		//SEÇENEKLER SEÇİLİNCE
		choice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				choice1.setBackground(Color.yellow);
				topunYeri(0);
			}
		});
		
		choice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				choice2.setBackground(Color.yellow);
				topunYeri(1);
			}
		});
		
		choice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				choice3.setBackground(Color.yellow);
				topunYeri(2);
			}
		});
	
		//TEKRAR OYNANMAK İSTENİNCE
		again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tekrar();
			}
		});
		
		//İSTATİSTİKLER SIFIRLANINCA
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bastan();
			}
		});
	}
	
	private void topunYeri(int secim) {
		plays++;
		choice1.setEnabled(false);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		again.setVisible(true);
		Random random=new Random();
		int top=random.nextInt(3);
		if(top==0) {
			choice1.setIcon(new ImageIcon("src\\dolu.png"));
			choice2.setIcon(new ImageIcon("src\\boş.png"));
			choice3.setIcon(new ImageIcon("src\\boş.png"));
		}else if(top==1) {
			choice1.setIcon(new ImageIcon("src\\boş.png"));
			choice2.setIcon(new ImageIcon("src\\dolu.png"));
			choice3.setIcon(new ImageIcon("src\\boş.png"));
		}else {
			choice1.setIcon(new ImageIcon("src\\boş.png"));
			choice2.setIcon(new ImageIcon("src\\boş.png"));
			choice3.setIcon(new ImageIcon("src\\dolu.png"));
		}
		if(top==secim) {
			sonuc.setText("Congratulations! You found the ball.");
			sonuc.setVisible(true);
			wins++;
		}else {
			sonuc.setText("Unfortunately! Try again.");
			sonuc.setVisible(true);
			loses++;
		}
		play.setText("Plays: "+plays);
		win.setText("Wins: "+wins);
		lose.setText("Loses: "+loses);
	}
	
	private void tekrar() {
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice1.setBackground(null);
		choice2.setBackground(null);
		choice3.setBackground(null);
		choice1.setIcon(new ImageIcon("src\\kapalı.png"));
		choice2.setIcon(new ImageIcon("src\\kapalı.png"));
		choice3.setIcon(new ImageIcon("src\\kapalı.png"));
		again.setVisible(false);
		sonuc.setVisible(false);
	}
	
	private void bastan() {
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice1.setBackground(null);
		choice2.setBackground(null);
		choice3.setBackground(null);
		choice1.setIcon(new ImageIcon("src\\kapalı.png"));
		choice2.setIcon(new ImageIcon("src\\kapalı.png"));
		choice3.setIcon(new ImageIcon("src\\kapalı.png"));
		again.setVisible(false);
		sonuc.setVisible(false);
		plays=0;
		wins=0;
		loses=0;
		play.setText("Plays: 0");
		win.setText("Wins: 0");
		lose.setText("Loses: 0");
	}
}
