package asset_management;
/**
 * ����---�û���
 * @author LST
 *
 */
public class User {
	private int usr_id;//�û�id
	private String usr_name;//�û�����
	private String job;//�û�ְ��
	private String usr_remark;//��ע
	
	//���µĶ���setters &getters ���ɵ�
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
