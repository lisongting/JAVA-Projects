package PetAdopt;
import java.util.Date;
/**
 * ������
 * @author LST
 *
 */
public class Pet {
	private int id;					
	private String name;			//��������
	private int health;				//����ֵ
	private int love;				//���ܶ�
	private String strain;			//����Ʒ��
	
	private String mastername;          //���˵�id
	private Date adoptTime;		   //��������ʱ��
	private String status;		   //״̬
	private int cost;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	public String getMasterid() {
		return mastername;
	}
	public void setMasterid(String masterN) {
		this.mastername = masterN;
	}
	public Date getAdoptTime() {
		return adoptTime;
	}
	public void setAdoptTime(Date adoptTime) {
		this.adoptTime = adoptTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
