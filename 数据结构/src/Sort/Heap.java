package Sort;

public class Heap {
	void heapSort(int[] data){
		for(int i=data.length/2-1;i>=0;i--)
			moveDown(data,i,data.length-1);//���Ƚ����鹹����һ����
		//�������ٽ��ж�����
		for(int i=data.length-1;i>=1;i--){
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;//��ĩβԪ���붥��Ԫ�ؽ���
			//���ж�����
			moveDown(data,0,i-1);
		}
		
	}
	//ÿһ��moveDown����Ѷ��������Ǹ�Ԫ���������ŵ��Ѷ�
	public void moveDown(int[] data,int first,int last){
		int largest = first*2+1;
		while(largest<=last){
			if(largest<last && data[largest]<data[largest+1])
				largest++;   //������Һ����нϴ���Ǹ�
			if(data[first]<data[largest]){//����ǰ�ڵ��ֵ��ϴ�ĺ���ֵ���н���
				int tmp;
				tmp = data[largest];
				data[largest] = data[first];
				data[first] = tmp;
				
				first = largest;
				largest = first*2+1;//���������ƶ�
			}
			else break;//����ýڵ��Ѿ����������Ӵ�������ѭ��
		}
	}
	public static void main(String[] args){
		int[] data = new int[]{2,8,6,1,10,15,3,12,11}; 
		for(int i:data)
			System.out.print(i+" ");
		System.out.println();
		new Heap().heapSort(data);
		for(int i:data)
			System.out.print(i+" ");
	}
}
