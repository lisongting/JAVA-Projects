package asset_management;
/**
 * 基类---资产类
 * @author LST
 *
 */
public class Asset {
	private int ast_id;   //资产编号
	private String ast_name;//资产名
	private String ast_category1;//资产类别
	private String ast_category2;
	private String ast_type;//资产型号
	private String ast_value;//资产价值(元)
	private String ast_boughtDay;//资产购买日期
	private String ast_status;//资产状态
	private String ast_user; //资产使用者
	private String ast_remark;//资产的备注
	
	
	//以下的都是setters &getters 生成的
	public int getAst_id() {
		return ast_id;
	}
	public void setAst_id(int ast_id) {
		this.ast_id = ast_id;
	}
	public String getAst_name() {
		return ast_name;
	}
	public void setAst_name(String ast_name) {
		this.ast_name = ast_name;
	}
	public String getAst_type() {
		return ast_type;
	}
	public void setAst_type(String ast_type) {
		this.ast_type = ast_type;
	}
	public String getAst_value() {
		return ast_value;
	}
	public void setAst_value(String ast_value) {
		this.ast_value = ast_value;
	}
	public String getAst_boughtDay() {
		return ast_boughtDay;
	}
	public void setAst_boughtDay(String ast_boughtDay) {
		this.ast_boughtDay = ast_boughtDay;
	}
	public String getAst_status() {
		return ast_status;
	}
	public void setAst_status(String ast_status) {
		this.ast_status = ast_status;
	}
	public String getAst_user() {
		return ast_user;
	}
	public void setAst_user(String ast_user) {
		this.ast_user = ast_user;
	}
	public String getAst_remark() {
		return ast_remark;
	}
	public void setAst_remark(String ast_remark) {
		this.ast_remark = ast_remark;
	}
	public String getAst_category1() {
		return ast_category1;
	}
	public void setAst_category1(String ast_category1) {
		this.ast_category1 = ast_category1;
	}
	public String getAst_category2() {
		return ast_category2;
	}
	public void setAst_category2(String ast_category2) {
		this.ast_category2 = ast_category2;
	}
	
	
}
