package asset_management;
/**
 * 接口----管理员
 * 抽象定义了管理员注册,登录,修改密码3个功能
 * 具体实现写在ManagerDaoImpl类中
 * @author LST
 *
 */
public interface ManagerDao {
	public void Register();
	public void Log();
	public void ChangePassword();
	public void AssetLend();//资产的借用登记
	public void AssetReturn();//资产的归还登记
}
