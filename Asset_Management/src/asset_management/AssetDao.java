package asset_management;
/**
 * 接口----资产
 * 抽象定义了增删改查功能
 * 具体实现写在AssetDaoImpl类中
 * @author LST
 *
 */
public interface AssetDao {
	public void Categoryadd();//增加类别
	public void Categorydel();//删除类别
	public void Add(Asset ass);//增加资产
	public void Del(Asset ass);//删除资产
	public void Revise(Asset ass);//修改资产信息
	public void FindById();//按资产id查询
	public void FindByCatgy();//按类别查询
	public void FindByUser();//按使用者查询
	public void Display();//资产浏览:显示所有资产信息
	
}
