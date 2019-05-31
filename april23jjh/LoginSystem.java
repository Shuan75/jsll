package april23jjh;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

//public class LoginSystem extends Frame {
public class LoginSystem extends Panel {

	public static void main(String[] args) {
//		new LoginSystem("LoginSystem");
	}

	Font font;
	Label id_info, pwd_info;
	TextField id_txt, pwd_txt;
	Button Login, Cancel;
	Panel pa_id, pa_pwd, pa_button;
	Panel North;
	TotalSystem ts;

	// public LoginSystem(String str) {
	public LoginSystem(TotalSystem ts) {
		this.ts = ts;
		// super(str); Panel은 제목처리안됨
		font = new Font("굴림체", Font.BOLD, 20);
		id_info = new Label("아이디를 입력하세요.");
		id_info.setFont(font);
		pwd_info = new Label("패스워드를 입력하세요.");
		pwd_info.setFont(font);
		id_txt = new TextField(10);
		id_txt.setFont(font);
		pwd_txt = new TextField(10);
		pwd_info.setFont(font);
		pwd_txt.setEchoChar('*');
		pa_id = new Panel();
		pa_id.add(id_info);
		pa_id.add(id_txt);
		pa_pwd = new Panel();
		pa_pwd.add(pwd_info);
		pa_pwd.add(pwd_txt);
		Login = new Button("로그인");
		Login.setFont(font);
		Cancel = new Button("다시입력");
		Cancel.setFont(font);
		North = new Panel();
		North.setLayout(new GridLayout(2, 1));
		North.add(pa_id);
		North.add(pa_pwd);
		Login.addActionListener(new MyLoginEvent(this, ts));
		Cancel.addActionListener(new MyLoginEvent(this, ts));
		pa_button = new Panel();
		pa_button.add(Login);
		pa_button.add(Cancel);

		// this.setSize(400, 300);
		this.add("North", North);
		this.add("South", pa_button);
		this.setBackground(Color.cyan);
		// this.addWindowListener(new LoginSystemExit());
		// this.setVisible(true); //윈도우가아님

	}
}
