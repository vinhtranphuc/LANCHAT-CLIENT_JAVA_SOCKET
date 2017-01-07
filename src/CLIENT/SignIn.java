package CLIENT;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import CLIENT.ChatRoom;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;

/** ỨNG DỤNG CHAT TRONG MẠNG LAN
 ** Bản quyền thuộc về: Trần Phúc Vinh - DT13CTT02 - Đại Học Quảng Nam
 ** Email: vinhtranphuc@gmail.com, Sdt: 01682607172 */

public class SignIn extends JFrame {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pwMatkhau;
	private JPasswordField pwXacnhan;
	private JTextField txtUser;
	private JButton btnDangnhap;
	private JTextField txtHoten;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public SignIn() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 443, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDangKy = new JButton("đăng ký");
		btnDangKy.setIcon(new ImageIcon(SignIn.class.getResource("/IconClient/Add User Male-30.png")));
		btnDangKy.setBorder(null);
		btnDangKy.setForeground(SystemColor.text);
		btnDangKy.setFont(new Font("Monospaced", Font.BOLD, 21));
		btnDangKy.setBackground(new Color(0, 153, 255));
		btnDangKy.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		DangKy(e);
		}
		});
		btnDangKy.setBounds(37, 214, 160, 30);
		contentPane.add(btnDangKy);
		
		JLabel lblNewLabel_5 = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblNewLabel_5.setBounds(115, 34, 246, 45);
		contentPane.add(lblNewLabel_5);
		
		txtHoten = new JTextField();
		txtHoten.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtHoten.setBorder(null);
		txtHoten.setActionCommand("");
		txtHoten.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtHoten.setBounds(177, 90, 208, 20);
		contentPane.add(txtHoten);
		txtHoten.setColumns(10);
		
		pwMatkhau = new JPasswordField();
		pwMatkhau.setBorder(null);
		pwMatkhau.setBounds(177, 152, 208, 20);
		contentPane.add(pwMatkhau);
		
		pwXacnhan = new JPasswordField();
		pwXacnhan.setBorder(null);
		pwXacnhan.setBounds(177, 183, 208, 20);
		contentPane.add(pwXacnhan);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtUser.setColumns(10);
		txtUser.setBorder(null);
		txtUser.setBounds(177, 121, 208, 20);
		contentPane.add(txtUser);
		
		btnDangnhap = new JButton("đăng nhập");
		btnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		new Login().setVisible(true);;
		dispose();
			}
		});
		btnDangnhap.setIcon(new ImageIcon(SignIn.class.getResource("/IconClient/Login Rounded Right-30.png")));
		btnDangnhap.setForeground(Color.WHITE);
		btnDangnhap.setFont(new Font("Monospaced", Font.BOLD, 21));
		btnDangnhap.setBorder(null);
		btnDangnhap.setBackground(new Color(0, 153, 255));
		btnDangnhap.setBounds(210, 214, 175, 30);
		contentPane.add(btnDangnhap);
		
		JLabel lblNewLabel = new JLabel("Họ Tên:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setBounds(37, 89, 139, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(37, 120, 140, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblMtKhu.setBounds(36, 158, 140, 14);
		contentPane.add(lblMtKhu);
		
		JLabel lblXcNhnMk = new JLabel("Xác nhận Mk:");
		lblXcNhnMk.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblXcNhnMk.setForeground(Color.WHITE);
		lblXcNhnMk.setBounds(37, 186, 141, 17);
		contentPane.add(lblXcNhnMk);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignIn.class.getResource("/IconClient/Add User Male-70.png")));
		lblNewLabel_2.setBounds(37, 11, 85, 68);
		contentPane.add(lblNewLabel_2);
	}
	protected void DangKy(ActionEvent e) {
		String Ten=txtHoten.getText();
		String User=txtUser.getText();
		String Mk=String.valueOf(pwMatkhau.getPassword());
		String Xacnhan=String.valueOf(pwXacnhan.getPassword());
		if(Ten.equals("")||User.equals("")||Mk.equals("")||Xacnhan.equals("")) 
		{JOptionPane.showMessageDialog(null,"Nhập thiếu!");}
		else if(!Mk.equals(Xacnhan))
		{
		JOptionPane.showMessageDialog(null,"Xác nhận sai!");
		}
		else 
		{
		new ChatRoom(0,User,Mk,Ten);
		}		
	}
}
