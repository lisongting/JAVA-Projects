package PetAdopt;
/**
 * 主人的接口
 * 抽象定义了增删改查 的方法
 * @author LST
 *
 */
public interface MasterDao {
	  void Add();
	  void Del();
	  int Update(Master master);
	  void FindMasterRoughly();
	  void FindMasterPrecisely();
}
