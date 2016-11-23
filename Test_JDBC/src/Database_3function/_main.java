package Database_3function;

/**
 * 主函数，完成数据库的三个功能：注册，登录，退出
 * 问题：显示数据库只显示了一次就不能再次进入到选择菜单的while()中了
 * @author LST
 *2016.7.7
 */
public class _main {

	public static void main(String[] args) {
		SelectFun S = new SelectFun();
		S.Select();
	}

}
