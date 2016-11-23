package asset_management;
/**
 * 基类---用户类
 * @author LST
 *
 */
public class User {
	private int usr_id;//用户id
	private String usr_name;//用户姓名
	private String job;//用户职务
	private String usr_remark;//备注
	
	//以下的都是setters &getters 生成的
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getRemark() {
		return usr_remark;
	}
	public void setRemark(String remark) {
		this.usr_remark = remark;
	}
	
}
