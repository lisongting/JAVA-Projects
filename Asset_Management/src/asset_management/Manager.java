package asset_management;
/**
 * ����-----����Ա
 * @author LST
 *
 */
public class Manager {
	private int mgr_id;//����Աid
	private String mgr_name;//����Ա����
	private String mgr_pwd;//����Ա����
	private boolean islogin=false; 
	int flagId=0;  //����Ѱ����Ҫ�޸������ID
	String Odpwd=null;  //�������ԭ����
	//���µĶ���setters &getters ���ɵ�
	public int getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}
	public String getMgr_name() {
		return mgr_name;
	}
	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}
	public String getMgr_pwd() {
		return mgr_pwd;
	}
	public void setMgr_pwd(String mgr_pwd) {
		this.mgr_pwd = mgr_pwd;
	}
	
}
