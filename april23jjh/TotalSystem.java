package april23jjh;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotalSystem extends Frame implements ActionListener {
	
	
	
	class SystemBackgroundImage extends Panel {
		final String PATH = "src\\april23jjh\\1.jpg";
		Image img;

		SystemBackgroundImage() {
			img = Toolkit.getDefaultToolkit().getImage(PATH);
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	public static void main(String[] args) {
		new TotalSystem("정보관리 시스템");
	}

	Font font, menuFont;
	CardLayout card;
	Panel totalPanel;
	FruitsShopping fruitsSystem;
	SystemBackgroundImage backgroundImage;
	OrderingSystem orderingSystem;
	LoginSystem loginSystem;
	ItemSystem itemSystem;
	EmployeeSystem employeeSystem;
	CustomerSystem customerSystem;
	BarchartSystem barchartSystem;
	ImageSystem imageSystem;
	MenuBar mb;
	Menu menu_logout, menu_fruits, menu_order, menu_item, menu_home, menu_employee, menu_customer, menu_barchartSystem, menu_imageSystem;
	MenuItem item_logout, item_fruits, item_order, item_item, item_home, item_employee, item_customer,
			item_barchartSystem, item_imageSystem;

	public TotalSystem(String str) {
		super(str);

		font = new Font("굴림체", Font.BOLD, 20);
		card = new CardLayout();
		totalPanel = new Panel();
		totalPanel.setLayout(card);
		loginSystem = new LoginSystem(this);
		// loginSystem을 Panel로 변경
		fruitsSystem = new FruitsShopping(this);
		// card.show(totalPanel, "Fruits");
		// cardLayOut에서 처음 출력될 채널 설정
		orderingSystem = new OrderingSystem(this);
		itemSystem = new ItemSystem(this);
		employeeSystem = new EmployeeSystem(this);
		customerSystem = new CustomerSystem(this);
		barchartSystem = new BarchartSystem(this);
		imageSystem = new ImageSystem(this);
		// menu관련작업

		menuFont = new Font("굴림체", Font.PLAIN, 15);
		mb = new MenuBar();
		menu_logout = new Menu("로그아웃");
		menu_fruits = new Menu("과일안내");
		menu_order = new Menu("오더");
		menu_item = new Menu("아이템");
		menu_home = new Menu("홈으로");
		menu_employee = new Menu("사원 관리 시스템");
		menu_barchartSystem = new Menu("차트연습");
		menu_customer = new Menu("고객 관리");
		menu_imageSystem = new Menu("이미지 시스템");
		menu_logout.setFont(menuFont);
		menu_fruits.setFont(menuFont);
		menu_order.setFont(menuFont);
		menu_item.setFont(menuFont);
		menu_home.setFont(menuFont);
		menu_employee.setFont(menuFont);
		menu_customer.setFont(menuFont);
		menu_barchartSystem.setFont(menuFont);
		menu_imageSystem.setFont(menuFont);
		item_logout = new MenuItem("로그아웃");
		item_fruits = new MenuItem("시스템 열기");
		item_order = new MenuItem("주문");
		item_item = new MenuItem("갱신");
		item_home = new MenuItem("홈으로 이동");
		item_employee = new MenuItem("시스템 열기");
		item_customer = new MenuItem("고객 관리한다");
		item_barchartSystem = new MenuItem("메뉴아이템에 차트붙이기");
		item_imageSystem = new MenuItem("이미지 붙이기");
		item_fruits.setFont(menuFont);
		item_logout.setFont(menuFont);
		item_order.setFont(menuFont);
		item_item.setFont(menuFont);
		item_employee.setFont(menuFont);
		item_home.setFont(menuFont);
		item_customer.setFont(menuFont);
		item_barchartSystem.setFont(menuFont);
		item_imageSystem.setFont(menuFont);
		item_fruits.addActionListener(this);// 리스너는 메뉴아이템에 붙어야 동작됨
		item_logout.addActionListener(this);
		item_order.addActionListener(this);
		item_item.addActionListener(this);
		item_employee.addActionListener(this);
		item_home.addActionListener(this);
		item_customer.addActionListener(this);
		item_barchartSystem.addActionListener(this);
		item_imageSystem.addActionListener(this);
		menu_logout.setEnabled(false); // 비활성화 (로그인전상황)
		menu_fruits.setEnabled(false);
		menu_order.setEnabled(false);
		menu_item.setEnabled(false);
		menu_home.setEnabled(false);
		menu_employee.setEnabled(false);
		menu_customer.setEnabled(false);
		menu_barchartSystem.setEnabled(false);
		menu_imageSystem.setEnabled(false);
		menu_fruits.add(item_fruits); // 과일 시스템 열기를 메뉴에 붙임
		menu_logout.add(item_logout);
		menu_order.add(item_order);
		menu_item.add(item_item);
		menu_employee.add(item_employee);
		menu_home.add(item_home);
		menu_customer.add(item_customer);
		menu_barchartSystem.add(item_barchartSystem);
		menu_imageSystem.add(item_imageSystem);
		mb.add(menu_logout);
		mb.add(menu_fruits); // 메뉴바에 과일안내 붙임
		mb.add(menu_order);
		mb.add(menu_item);
		mb.add(menu_employee);
		mb.add(menu_customer);
		mb.add(menu_barchartSystem);
		mb.add(menu_imageSystem);
		mb.add(menu_home);

		backgroundImage = new SystemBackgroundImage();

		totalPanel.add(loginSystem, "login");
		totalPanel.add(backgroundImage, "background");
		totalPanel.add(fruitsSystem, "fruits");
		totalPanel.add(orderingSystem, "orders");
		totalPanel.add(itemSystem, "item");
		totalPanel.add(employeeSystem, "employees");
		totalPanel.add(customerSystem, "customer");
		totalPanel.add(barchartSystem, "barchart");
		totalPanel.add(imageSystem, "image");

		this.setMenuBar(mb);
		this.add("Center", totalPanel);
		this.setSize(800, 500);
		this.setLocation(200, 200);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == item_item) {
			this.card.show(totalPanel, "item");
		} else if (obj == item_fruits) {
			this.card.show(totalPanel, "fruits");
		} else if (obj == item_logout) {
			// 정말로 종료하시겠습니까? 라는 다이얼로그를 출력
			// "예"를 선택한 경우에만 로그아웃 처리
			// 다이얼로그를 처리 했다고 가정하고
			this.card.show(totalPanel, "login");// 로그인화면으로 전환
			loginSystem.id_txt.setText(" ");
			loginSystem.id_txt.setText("");
			loginSystem.pwd_txt.setText(" ");
			loginSystem.pwd_txt.setText("");
			// 로그인화면의 계정입력창을 지운다
			menu_logout.setEnabled(false);// 메뉴 비활성화
			menu_fruits.setEnabled(false);
			menu_order.setEnabled(false);
			menu_item.setEnabled(false);
			menu_employee.setEnabled(false);
			menu_customer.setEnabled(false);
			menu_barchartSystem.setEnabled(false);
			menu_imageSystem.setEnabled(false);
			menu_home.setEnabled(false);
			this.setTitle("정보관리 시스템");
		} else if (obj == item_order) {
			this.card.show(totalPanel, "orders");
		} else if (obj == item_home) {
			this.card.show(totalPanel, "background");
		} else if (obj == item_employee) {
			this.card.show(totalPanel, "employees");
		} else if (obj == item_customer) {
			this.card.show(totalPanel, "customer");
		} else if (obj == item_barchartSystem) {
			this.card.show(totalPanel, "barchart");
		} else if (obj == item_imageSystem) {
			this.card.show(totalPanel, "image");
		}
	}
}

class SystemBackgroundImage extends Panel {

	final String PATH = "src\\april23jjh\\1.jpg";
	Image img;

	SystemBackgroundImage() {
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}