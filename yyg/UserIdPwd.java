package yyg;

public class UserIdPwd {
	private String id; // private�� ���� 
	private String pwd; // ��������
	// ���е� ������ �����͸� �־��ִ� �޼��带 �����.
	// �̷� �޼��带 ����(setter)�޼����� �Ѵ�.

	public void setId(String id) {
		this.id = id;//�Ӽ��� �ǹ��� this�� �Ἥ private�� ������� ������ ������
	}

	public void setPwd(String pwd) { //void�޼��� �̸��� set���� �����ؼ� set�Ͷ���
		this.pwd = pwd;
	}// �ҽ� get set�鰡�� ���͸� ������

	public String getId() { //get���� �����ؼ� ����  void�� �ƴ� ���ʹ� ����Ÿ����
		return id;
	}

	public String getPwd() {
		return pwd;
	}
}
// mymapp.xml���� ���̵�� �н����� ������ �α�����