package asset_management;
/**
 * 接口---用户
 * 抽象定义了用户的增,删,改,查操作
 * 具体实现写在UserDaoImpl类中
 * @author LST
 *
 */
public interface UserDao {
	public void Add(User user);
	public void Del(User user);
	public void Update(User user);
	public void FindById();//根据人员的id查找
	public void FindByName();//根据人员的姓名查找
	public void Display();
}
