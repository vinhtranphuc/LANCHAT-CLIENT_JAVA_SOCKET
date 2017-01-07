/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIENT;
import java.io.DataInputStream;
import java.io.IOException;
/** ỨNG DỤNG CHAT TRONG MẠNG LAN
 ** Bản quyền thuộc về: Trần Phúc Vinh - DT13CTT02 - Đại Học Quảng Nam
 ** Email: vinhtranphuc@gmail.com, Sdt: 01682607172 */
public class ThreadClient extends Thread{
  private boolean run;
	private DataInputStream dis;
	private ChatRoom client;
	public String check;

	public ThreadClient(ChatRoom client,DataInputStream dis){
		run=true;
		this.client=client;
		this.dis=dis;

		this.start();
	}
	public void run(){
		String msg1,msg2;
		while(run){
			try {
				msg1=dis.readUTF();
				msg2=dis.readUTF();
				client.CapNhatLogin(msg1,msg2);
				client.CapNhatDangKy(msg1,msg2);
				client.thuDl(msg1,msg2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void stopThread(){
		this.run=false;
	}  
}
