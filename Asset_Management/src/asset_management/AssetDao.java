package asset_management;
/**
 * �ӿ�----�ʲ�
 * ����������ɾ�Ĳ鹦��
 * ����ʵ��д��AssetDaoImpl����
 * @author LST
 *
 */
public interface AssetDao {
	public void Categoryadd();//�������
	public void Categorydel();//ɾ�����
	public void Add(Asset ass);//�����ʲ�
	public void Del(Asset ass);//ɾ���ʲ�
	public void Revise(Asset ass);//�޸��ʲ���Ϣ
	public void FindById();//���ʲ�id��ѯ
	public void FindByCatgy();//������ѯ
	public void FindByUser();//��ʹ���߲�ѯ
	public void Display();//�ʲ����:��ʾ�����ʲ���Ϣ
	
}
