package asset_management;
/**
 * �ӿ�---�û�
 * ���������û�����,ɾ,��,�����
 * ����ʵ��д��UserDaoImpl����
 * @author LST
 *
 */
public interface UserDao {
	public void Add(User user);
	public void Del(User user);
	public void Update(User user);
	public void FindById();//������Ա��id����
	public void FindByName();//������Ա����������
	public void Display();
}
