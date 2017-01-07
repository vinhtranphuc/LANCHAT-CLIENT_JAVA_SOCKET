package CLIENT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;

public class About extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 106);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102, 204, 204));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrngDng = new JTextArea();
		txtrngDng.setEditable(false);
		txtrngDng.setBackground(new Color(204, 255, 204));
		txtrngDng.setForeground(new Color(51, 51, 0));
		txtrngDng.setText("** ỨNG DỤNG CHAT TRONG MẠNG LAN\r\n** Bản quyền thuộc về: Trần Phúc Vinh - DT13CTT02 - Đại Học Quảng Nam\r\n** Email: vinhtranphuc@gmail.com, Sdt: 01682607172 ");
		txtrngDng.setBounds(10, 11, 570, 58);
		contentPane.add(txtrngDng);
	}
}
