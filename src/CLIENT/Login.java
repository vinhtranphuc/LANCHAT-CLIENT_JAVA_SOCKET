package CLIENT;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLIENT.ChatRoom;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** ỨNG DỤNG CHAT TRONG MẠNG LAN
 ** Bản quyền thuộc về: Trần Phúc Vinh - DT13CTT02 - Đại Học Quảng Nam
 ** Email: vinhtranphuc@gmail.com, Sdt: 01682607172 */
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaikhoan;
	private JPasswordField pwMatkhau;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 538, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTaikhoan = new JTextField();
		txtTaikhoan.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtTaikhoan.setColumns(10);
		txtTaikhoan.setBorder(null);
		txtTaikhoan.setBounds(100, 117, 321, 20);
		contentPane.add(txtTaikhoan);
		
		pwMatkhau = new JPasswordField();
		pwMatkhau.setFont(new Font("Monospaced", Font.BOLD, 14));
		pwMatkhau.setBorder(null);
		pwMatkhau.setBounds(100, 173, 321, 20);
		contentPane.add(pwMatkhau);
		
		JLabel lblTiKhon = new JLabel("Tài khoản:");
		lblTiKhon.setForeground(Color.WHITE);
		lblTiKhon.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblTiKhon.setBorder(null);
		lblTiKhon.setBounds(99, 90, 100, 14);
		contentPane.add(lblTiKhon);
		
		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblPassword.setBorder(null);
		lblPassword.setBounds(100, 148, 90, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("đăng nhập");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/IconClient/Unlock-20.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	   new ChatRoom(1,txtTaikhoan.getText(),String.valueOf(pwMatkhau.getPassword()),"");
	   dispose();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(51, 153, 204));
		btnLogin.setBounds(99, 204, 322, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignin = new JButton("đăng ký");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		new SignIn().setVisible(true);
		dispose();
			}
		});
		btnSignin.setIcon(new ImageIcon(Login.class.getResource("/IconClient/Forward-20.png")));
		btnSignin.setForeground(Color.WHITE);
		btnSignin.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnSignin.setBorder(null);
		btnSignin.setBackground(new Color(51, 153, 204));
		btnSignin.setBounds(258, 238, 163, 23);
		contentPane.add(btnSignin);
		
		JButton btnLammoi = new JButton("làm mới ");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		txtTaikhoan.setText("");
		pwMatkhau.setText("");
			}
		});
		btnLammoi.setIcon(new ImageIcon(Login.class.getResource("/IconClient/Delete-20.png")));
		btnLammoi.setForeground(Color.WHITE);
		btnLammoi.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnLammoi.setBorder(null);
		btnLammoi.setBackground(new Color(51, 153, 204));
		btnLammoi.setBounds(99, 238, 152, 23);
		contentPane.add(btnLammoi);
		
		JLabel label_2 = new JLabel("ĐĂNG NHẬP");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/IconClient/Response-52.png")));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Monospaced", Font.BOLD, 28));
		label_2.setBackground(new Color(51, 153, 204));
		label_2.setBounds(142, 34, 221, 52);
		contentPane.add(label_2);
		
		JLabel lblAbout = new JLabel("Ứng dụng chat trong mạng LAN phiên bản 1.0");
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
	    new About().setVisible(true);
			}
		});
		lblAbout.setForeground(new Color(0, 51, 255));
		lblAbout.setBounds(142, 415, 264, 14);
		contentPane.add(lblAbout);
	}
}
