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
	String[] ColumnName = {"�̸�","����","�̸���","��ȭ��ȣ","����"};
	  List<ItemInfo> list;
	   ItemModel(CRUDprocess crud, Map map){
	      list = crud.selectIteminfoCondition(map);
	      cols = columnName.length; rows = list.size();
	      setData();
	   }
	   
	   void setData() {//��ȸ����� 2�����迭�� ����
	      rows = list.size(); cols = columnName.length;
	      tableData = new Object[rows][cols];
	      Iterator it = list.iterator();
	      int r = 0;
	      while(it.hasNext()) {
	         ItemInfo info = (ItemInfo)it.next();
	         tableData[r][0] = info.getCode();//��ǰ��ȣ
	         tableData[r][1] = info.getName();//��ǰ�̸�
	         tableData[r][2] = info.getPrice();//��ǰ����
	         tableData[r][3] = info.getInfo();//��ǰ����
	         tableData[r][4] = info.getOrigin();//������
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
    		//JOptionPane.showMessageDialog(this, "��ư�׼�");
    		this.card.show(Total,"hajinloginmain");
    			
    		}
		
	}
    BookSystem book; //����ý��ۼ���
    HaJinLoginMain Loginmain; //��������������
    JPanel Total; //�׸��巹���̿� �г��� ���δ� ��ü�г�
    CardLayout card;//ī�巹�̾ƿ�
	JButton button;
	JPanel[] panels;
	//JPanel toppanel;
    JPanel Totalpanel;//�׸��巹�̾ƿ��г�
	JLabel toplabel;
	JTextField textfield;
	JTable table;
	JScrollPane scroll;
	String[] columnName = {"�̸� ","��ȭ��ȣ", "��¥", "���Ź�ȣ", "�ݾ�", "���������Ȳ"}; //������
	String[][] data = {
	         {"Ȳ����","010-xxxx-xxxx","2019/05/18","Y0001","45000","���ſϷ�"},
	         {"������","010-xxxx-xxxx","2019/05/18","Y0002","30000","���ſϷ�"},
	         {"����","010-xxxx-xxxx","2019/05/18","Y0003","30000","�������"},
	         {"������","010-xxxx-xxxx","2019/05/18","Y0004","30000","�������"}
	         //������
	   };
	
	Purchase(BookSystem book){ //������ ����
	//	super(str);
		this.book = book;
		Loginmain = new HaJinLoginMain(this); //�α��θ��λ����ϰ� ����â�� ���̱�
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
		toplabel = new JLabel("�����ڵ�");
		
		textfield = new JTextField(5);
		
		table = new JTable(data,columnName);//������,������
	    scroll = new JScrollPane(table);
	  //  toppanel.add("Center",panels[0]);
	    panels[0].add(toplabel); panels[0].add(textfield);
	    panels[1].add(table); button = new JButton("HOME");
	    panels[2].add(button);
	
	    for(int i=0; i < panels.length; i++) {
	    	Totalpanel.add(panels[i]);	
	    }
	    
	    Totalpanel.setBackground(new Color(199, 228, 248));
//	    TotalPanel.setLayout(card); //ī�巹�̾ƿ��� �������� ����
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
	    button.addActionListener(this);//��ư�� �׼Ǹ����� �ޱ�
//	    cardpanel.setLayout(card);
//	    cardpanel.add(Totalpanel);
//	    this.add(cardpanel);
	
	    
	  //  this.setSize(1000, 500);
	  //  this.setVisible(true);
	}//�����ڳ�

	public static void main(String[] args) {
	//	new Purchase("�����ϱ�");

	}

}
