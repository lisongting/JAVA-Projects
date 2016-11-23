package Net;

public class DownUtil {
	private String path;
	private String targetFile;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;
	
	public DownUtil(String path,String targetFile,int threadNum){
		this.path = path;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
		this.targetFile = targetFile;
	}
	
	public class DownThread extends Thread{
		private int startPos;
		
	}
}
