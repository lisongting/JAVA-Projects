package PetAdopt;
/**
 * ���˵Ľӿ�
 * ����������ɾ�Ĳ� �ķ���
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
