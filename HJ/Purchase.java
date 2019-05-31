package HJ;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*class CustomerInfoModel extends AbstractTableModel{
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return ColumnName[column];
	}
	
	Object tableData[][]; int rows,cols;
	String[] ColumnName = {"이름","성별","이메일","전화번호","나이"};
	  List<ItemInfo> list;
	   ItemModel(CRUDprocess crud, Map map){
	      list = crud.selectIteminfoCondition(map);
	      cols = columnName.length; rows = list.size();
	      setData();
	   }
	   
	   void setData() {//조회결과를 2차원배열에 저장
	      rows = list.size(); cols = columnName.length;
	      tableData = new Object[rows][cols];
	      Iterator it = list.iterator();
	      int r = 0;
	      while(it.hasNext()) {
	         ItemInfo info = (ItemInfo)it.next();
	         tableData[r][0] = info.getCode();//상품번호
	         tableData[r][1] = info.getName();//상품이름
	         tableData[r][2] = info.getPrice();//상품가격
	         tableData[r][3] = info.getInfo();//상품설명
	         tableData[r][4] = info.getOrigin();//원산지
	         r++;
	      }
	      
	   }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableData[rowIndex][columnIndex];
	}
	
	ExhibitReserveInfoModel(){
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllExhibit_info(map);
	}
	
}
*/
public class Purchase extends JPanel implements ActionListener  {
	

    @Override
	public void actionPerformed(ActionEvent e) {

    		if(e.getSource() == button) {
    		//JOptionPane.showMessageDialog(this, "버튼액션");
    		this.card.show(Total,"hajinloginmain");
    			
    		}
		
	}
    BookSystem book; //예약시스템선언
    HaJinLoginMain Loginmain; //마이페이지선언
    JPanel Total; //그리드레아이웃 패널을 감싸는 전체패널
    CardLayout card;//카드레이아웃
	JButton button;
	JPanel[] panels;
	//JPanel toppanel;
    JPanel Totalpanel;//그리드레이아웃패널
	JLabel toplabel;
	JTextField textfield;
	JTable table;
	JScrollPane scroll;
	String[] columnName = {"이름 ","전화번호", "날짜", "예매번호", "금액", "예매진행상황"}; //열제목
	String[][] data = {
	         {"황현준","010-xxxx-xxxx","2019/05/18","Y0001","45000","예매완료"},
	         {"이하진","010-xxxx-xxxx","2019/05/18","Y0002","30000","예매완료"},
	         {"김용근","010-xxxx-xxxx","2019/05/18","Y0003","30000","예매취소"},
	         {"정종현","010-xxxx-xxxx","2019/05/18","Y0004","30000","예매취소"}
	         //데이터
	   };
	
	Purchase(BookSystem book){ //생성자 생성
	//	super(str);
		this.book = book;
		Loginmain = new HaJinLoginMain(this); //로그인메인생성하고 구입창에 붙이기
		card = new CardLayout();
		
	
		panels = new JPanel[3];
		for(int i=0; i < panels.length; i++) {
		panels[i] = new JPanel();
		panels[i].setBackground(new Color(199, 228, 248));
		}
		Totalpanel = new JPanel();
		Totalpanel.setLayout(new GridLayout(3,1));
		
//		toppanel = new JPanel();
//		toppanel.setLayout(new BorderLayout());
//		toppanel.setBackground(new Color(199, 228, 248));
//		
		toplabel = new JLabel("예매코드");
		
		textfield = new JTextField(5);
		
		table = new JTable(data,columnName);//데이터,열제목
	    scroll = new JScrollPane(table);
	  //  toppanel.add("Center",panels[0]);
	    panels[0].add(toplabel); panels[0].add(textfield);
	    panels[1].add(table); button = new JButton("HOME");
	    panels[2].add(button);
	
	    for(int i=0; i < panels.length; i++) {
	    	Totalpanel.add(panels[i]);	
	    }
	    
	    Totalpanel.setBackground(new Color(199, 228, 248));
//	    TotalPanel.setLayout(card); //카드레이아웃시 주의할점 순서
//		TotalPanel.add(totalpanel);
//		TotalPanel.add(p, "purchase");
//		TotalPanel.setBackground(new Color(199, 228, 248));
		Total = new JPanel();
		Total.setLayout(card);
		Total.add(Totalpanel,"total");
		Total.add(Loginmain,"hajinloginmain");
		Total.setBackground(new Color(199, 228, 248));
	    this.add(Total);
	    this.setBackground(new Color(199, 228, 248));
	    button.addActionListener(this);//버튼에 액션리스너 달기
//	    cardpanel.setLayout(card);
//	    cardpanel.add(Totalpanel);
//	    this.add(cardpanel);
	
	    
	  //  this.setSize(1000, 500);
	  //  this.setVisible(true);
	}//생성자끝

	public static void main(String[] args) {
	//	new Purchase("구입하기");

	}

}
