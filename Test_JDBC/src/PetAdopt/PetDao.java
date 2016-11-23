package PetAdopt;
/**
 * 宠物的接口
 * 抽象定义了增删改查功能
 * @author LST
 *
 */
public interface PetDao {
	int Add(Pet pet);//增加宠物
	int Del(Pet pet);//删除宠物
	int Update(Pet pet);//更新宠物
	void GetByName();//根据名字精确查询
	void  FindByName();//模糊查询
	void FindByStrain();//根据品种查询
}
