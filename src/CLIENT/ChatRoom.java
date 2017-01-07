package CLIENT;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
public class ChatRoom extends JFrame {
	/** ỨNG DỤNG CHAT TRONG MẠNG LAN
	 ** Bản quyền thuộc về: Trần Phúc Vinh - DT13CTT02 - Đại Học Quảng Nam
	 ** Email: vinhtranphuc@gmail.com, Sdt: 01682607172 */
	public static final long serialVersionUID = 1L;
	public Socket client;
    public ThreadClient dataStream;
    public DataOutputStream dos;
    public DataInputStream dis;
	public JPanel contentPane; 
	public JTextArea taTinNhan;
	public JTextArea DanhSach;
	public JTextField txtTinNhan;
	public String check="false";
	private String Ip="192.168.173.1"; // Ip Server
	public static String TenTk="Amin";
	public static String Mk="Amin";
	public static String HoTen="Trần Phúc Vinh";
	public static int i=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatRoom frame = new ChatRoom(i,TenTk,Mk,HoTen);
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
	 * @return 
	 */
	public ChatRoom(int i,String TenTk,String Mk,String HoTen) {
		setResizable(false);
	if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thay đổi Ip Server mặc định: '"+Ip+"' ?","Đổi Ip",
	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	this.Ip= JOptionPane.showInputDialog(null, "Nhập địa chỉ Ip máy chủ:");
	KetNoi(Ip);
	if(i==1) guiTtLogin(TenTk,Mk);
	else DangKy(TenTk,Mk,HoTen);
///	Show("aaa");
	}
	
	public void KetNoi(String IP) {
		try { 
			client = new Socket(IP,2207);
			dos=new DataOutputStream(client.getOutputStream());
			dis=new DataInputStream(client.getInputStream());
		} catch (Exception e) {
		JOptionPane.showMessageDialog(this,"Server chưa bật or sai Ip!","Kiểm tra Ip!",JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		}
	}
	
	public void guiTtLogin(String TenTk,String Mk)
	{
		dataStream = new ThreadClient(this, this.dis);	
		guiDl("DangNhap");
		guiDl("12");
		guiDl(TenTk);
		guiDl("13");
		guiDl(Mk);
		guiDl("14");
	}
	
	public void DangKy(String TenTk,String Mk,String HoTen)
	{
		dataStream = new ThreadClient(this, this.dis);
		guiDl("DangKy");
		guiDl("8");   
        guiDl(TenTk);
        
        guiDl("9");
        guiDl(Mk);
        
        guiDl("10");
        guiDl(HoTen);
        guiDl("11");
	}

	public void BatDau(String Ten)
	{
		KetNoi(Ip);
		JOptionPane.showMessageDialog(null,"Chào: "+Ten);
		Login(Ten);
	}
	
	public void Login(String TenUser) {
		if(XuLyDangNhap(TenUser))
		{
		Show(TenUser);
		this.setVisible(true);
		taTinNhan.append("Bạn đã vào phòng!\n");
		dataStream = new ThreadClient(this, this.dis);	
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Tài khoản này đang Onl!");
		Login lg=new Login();
		lg.setVisible(true);
		dispose();
		}
	}
	
	public boolean XuLyDangNhap(String Ten){
		if(Ten.compareTo("")==0)
			return false;
		else if(Ten.compareTo("0")==0){
			return false;
		}
		else{
		// gui tÃªn lÃªn sver
			guiDl(Ten);
			int sst = Integer.parseInt(thuDl());
			if(sst==0)
				 return false;
			else return true;
		}
	}
	
	public void Show(String Ten)
	{
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 703, 312);
		this.setTitle(Ten);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Chat với a/e:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(102, 102, 0)));
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(144, 47, 554, 237);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 21, 534, 148);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(51, 153, 153));
		scrollPane.setBackground(new Color(51, 153, 153));
		scrollPane.setBorder(null);
		panel_1.add(scrollPane);
		
		taTinNhan = new JTextArea();
		taTinNhan.setFont(new Font("Monospaced", Font.PLAIN, 17));
		taTinNhan.setEditable(false);
		taTinNhan.setBorder(null);
		taTinNhan.setForeground(new Color(51, 51, 0));
		taTinNhan.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(taTinNhan);
		
		Action action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
			 Gui();
		     txtTinNhan.setText("");	       
		    }
		};
		
		txtTinNhan = new JTextField();
		txtTinNhan.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtTinNhan.setBorder(null);
		txtTinNhan.setForeground(new Color(51, 51, 0));
		txtTinNhan.setBackground(new Color(255, 255, 204));
		txtTinNhan.setBounds(10, 180, 416, 46);
		panel.add(txtTinNhan);
		txtTinNhan.setColumns(10);
		txtTinNhan.addActionListener(action);
		
		JButton Gui = new JButton("Gửi   ");
		Gui.setIcon(new ImageIcon(ChatRoom.class.getResource("/IconClient/Paper Plane-30.png")));
		Gui.setBorder(null);
		Gui.setBackground(new Color(51, 153, 204));
		Gui.setForeground(Color.WHITE);
		Gui.setFont(new Font("Monospaced", Font.BOLD, 17));
		Gui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui();
			}
		});
		Gui.setBounds(436, 180, 108, 46);
		panel.add(Gui);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "A/e đang online:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 0)));
		panel_2.setBackground(new Color(102, 204, 204));
		panel_2.setBounds(0, 47, 143, 237);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(10, 21, 123, 205);
		panel_2.add(scrollPane_1);
		
		DanhSach = new JTextArea();
		DanhSach.setEditable(false);
		DanhSach.setBorder(null);
		DanhSach.setForeground(new Color(51, 51, 0));
		DanhSach.setLineWrap(true);
		DanhSach.setBackground(new Color(255, 255, 204));
		scrollPane_1.setViewportView(DanhSach);
		
		JButton btnNewButton = new JButton("Thoát   ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		Thoat();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(ChatRoom.class.getResource("/IconClient/Logout Rounded Up-25.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(51, 153, 204));
		btnNewButton.setBounds(581, 11, 107, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("LAN CHAT CLIENT");
		lblNewLabel_1.setIcon(new ImageIcon(ChatRoom.class.getResource("/IconClient/Chat-45.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 237, 42);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		taTinNhan.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ChatRoom.class.getResource("/IconClient/Erase-30.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(469, 11, 102, 34);
		btnNewButton_1.setBackground(new Color(51, 153, 204));
		contentPane.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(244, 11, 215, 34);
		panel_3.setBackground(new Color(102, 204, 204));
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label = new JLabel(" Bạn: "+Ten);
		label.setBorder(new LineBorder(new Color(255, 255, 255)));
		label.setForeground(new Color(51, 51, 0));
		label.setBackground(new Color(102, 204, 204));
		label.setFont(new Font("Monospaced", Font.BOLD, 17));
		panel_3.add(label);
	}
	
// kíck nút gửi
	public void Gui() {
		guiToiSver(txtTinNhan.getText()+"\n");
		txtTinNhan.setText("");
	}
	
	public void guiToiSver(String msg){
		if(msg.compareTo("\n")!=0){
			this.taTinNhan.append("Bạn: "+msg);
			guiDl("1");
			guiDl(msg);
		}
	}
	
	public void guiDl(String data){
		try {
			dos.writeUTF(data);        
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String thuDl(){
		String data=null;
		try {
			data=dis.readUTF(); 
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void thuDl(String msg1, String msg2){
		int stt = Integer.parseInt(msg1);
		switch (stt) {
		// tin nhắn của người khác 
		case 3:
			this.taTinNhan.append(msg2);                    
			break;
		//cập nhật danh sách onl
		case 4:
			this.DanhSach.setText(msg2);         
			break;
		//Dừng
		case 5:
			dataStream.stopThread();
			Thoat();
			System.out.println("đã nhận lệnh thoát");
			break;
		}
	}
	
	public void CapNhatLogin(String msg1, String msg2) throws IOException{
		int stt = Integer.parseInt(msg1);
		switch (stt) {
		case 15:
			JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu!");
		    System.out.println(msg2);
		    Login lg=new Login();
			lg.setVisible(true);
			break;
		case 16: 
			ChatRoom.HoTen=msg2; 
            BatDau(HoTen);
			break;
		}
	}
	
	public void CapNhatDangKy(String msg1, String msg2) throws IOException{
		int stt = Integer.parseInt(msg1);
		switch (stt) {
		case 17:
			JOptionPane.showMessageDialog(null,msg2);
		    System.out.println("Client: "+ msg2);
			break;
		}
	}
	
	public void Thoat(){
		try {
			guiDl("0");
			dos.close();
			dis.close();
			client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}	
}
