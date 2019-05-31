package april23jjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyLoginEvent implements ActionListener {

	LoginSystem ls;
	TotalSystem ts;

	public MyLoginEvent(LoginSystem l, TotalSystem ts) {
		ls = l;
		this.ts = ts;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == ls.Login || obj == ls.pwd_txt) {

			if (obj == ls.Login) { // 로그인 버튼 누를시
				// db접속후 manager_info에서 계정과암호찾고 찾은 계쩡과 id를 비교
				String id = ls.id_txt.getText(); // 입력한 id를 id에 저장
				String pwd = ls.pwd_txt.getText();
				UserIdPwd idPwd = new UserIdPwd();
				idPwd.setId(id);
				idPwd.setPwd(pwd);
				CRUDprocess crud = new CRUDprocess();
				ManagerInfo info = crud.selectIdAndPwd(idPwd);
				if (info == null) { // 로그인실패
					String title = "정보관리 시스템 계정과 암호 확인하시길 바랍니다.";
					// title을 윈도우의 제목으로 출력
					// ls.setTitle(title); //Panel은 제목설정이 안됨
					// ts.setTitle(title);
					// 다이얼로그 생성
					JOptionPane.showMessageDialog(ts, "ID와 PASSWORD를 확인하세요.");
				} else { // 성공
					String title = "정보관리 시스템 환영합니다." + id + "님";
					// ls.setTitle(title);
					ts.setTitle(title);
					JOptionPane.showMessageDialog(ts, "로그인 되었습니다.");
					// menu 활성화 한다.
					ts.menu_logout.setEnabled(true);
					ts.menu_fruits.setEnabled(true);
					ts.menu_order.setEnabled(true);
					ts.menu_item.setEnabled(true);
					ts.menu_employee.setEnabled(true);
					ts.menu_home.setEnabled(true);
					ts.menu_customer.setEnabled(true);
					ts.menu_barchartSystem.setEnabled(true);
					ts.menu_imageSystem.setEnabled(true);
					ts.card.show(ts.totalPanel, "background");
				}

			} else if (obj == ls.Cancel) { // 다시입력버튼

				ls.id_txt.setText(" ");
				ls.id_txt.setText(""); // 계정 text필드 지움
				ls.pwd_txt.setText(" ");
				ls.pwd_txt.setText("");
			}
		}
	}
}
