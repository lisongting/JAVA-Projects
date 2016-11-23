package Net;

public class MultiThreadDown {

	public static void main(String[] args) {
		final DownUtil downUtil = new DownUtil("http://www.crazyit.org/attachments/month_1403/1403202355ff6cc9a4fbf6f14a.png"
				,"ios.png",4);
		downUtil.download();
		new Thread()
	}

}
