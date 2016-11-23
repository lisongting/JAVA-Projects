package asset_management;
/**
 * 基类-----管理员
 * @author LST
 *
 */
public class Manager {
	private int mgr_id;//管理员id
	private String mgr_name;//管理员姓名
	private String mgr_pwd;//管理员密码
	private boolean islogin=false; 
	int flagId=0;  //用来寻找需要修改密码的ID
	String Odpwd=null;  //用来标记原密码
	//以下的都是setters &getters 生成的
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
