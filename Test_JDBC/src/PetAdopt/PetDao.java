package PetAdopt;
/**
 * ����Ľӿ�
 * ����������ɾ�Ĳ鹦��
 * @author LST
 *
 */
public interface PetDao {
	int Add(Pet pet);//���ӳ���
	int Del(Pet pet);//ɾ������
	int Update(Pet pet);//���³���
	void GetByName();//�������־�ȷ��ѯ
	void  FindByName();//ģ����ѯ
	void FindByStrain();//����Ʒ�ֲ�ѯ
}
