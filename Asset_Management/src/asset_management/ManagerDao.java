package asset_management;
/**
 * �ӿ�----����Ա
 * �������˹���Աע��,��¼,�޸�����3������
 * ����ʵ��д��ManagerDaoImpl����
 * @author LST
 *
 */
public interface ManagerDao {
	public void Register();
	public void Log();
	public void ChangePassword();
	public void AssetLend();//�ʲ��Ľ��õǼ�
	public void AssetReturn();//�ʲ��Ĺ黹�Ǽ�
}
