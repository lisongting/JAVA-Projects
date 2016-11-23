package PetAdopt;
import java.util.Date;
/**
 * 宠物类
 * @author LST
 *
 */
public class Pet {
	private int id;					
	private String name;			//宠物名字
	private int health;				//健康值
	private int love;				//亲密度
	private String strain;			//宠物品种
	
	private String mastername;          //主人的id
	private Date adoptTime;		   //被领养的时间
	private String status;		   //状态
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
