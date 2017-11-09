package wuyiyang;
import java.util.ArrayList;

import javax.management.loading.MLet;

import Jama.Matrix;
public class Melm {
	private static int inputlayers=0;
	private static int outputlayers=0;
	private static int hiddenlayers=0;
	private static int samplenum=0;

	public static double[][] inputmatrix;
	public static double[][] inputweights;
	public static double[][] hiddenmatrix;
	public static double[][] outputweights;
	public static double[][] outputmatrix;
	
   public Melm() {
	// TODO Auto-generated constructor stub
	   inputmatrix = new double[1000][1];
		inputweights = new double[1][1000];
		hiddenmatrix  = new double[1000][1000];
	    outputweights = new double[1000][1];
		outputmatrix = new double[1000][1];
		String fileName="data/func_train2.txt";
		Dataset dataset = Dataset.load(fileName, "\t",2, false);
		for(int i=0;i<dataset.size();i++){
			//System.out.println(dataset.getAttrs(i)[0]+"   "+dataset.getAttrs(i)[1]);
			inputmatrix[Melm.samplenum][0]=dataset.getAttrs(i)[0];
			Melm.inputlayers++;
			Melm.samplenum++;
			outputmatrix[Melm.outputlayers][0]=dataset.getAttrs(i)[1];
			Melm.outputlayers++;
		randweights();
		}
	}
	public static void randweights(){
		//��������Ϊ�˳�ʼ������Ȩ�ؾ���
		int j;
			for(j=0;j<Melm.samplenum;j++)
			{ inputweights[0][j]=Math.random();
			Melm.hiddenlayers++;
			}
	}
	public  ArrayList<Float> tranmatrix(){
		//�����룬���������Ȩ�ؾ���ת��ΪMatrix��׼���󣬱��ڵ��ð��ں���
		double   j=1;
		ArrayList<Float>list=new ArrayList<Float>();
		Matrix hidden_inversematrix= new Matrix(hiddenmatrix);
		Matrix input_matrix=new Matrix(inputmatrix);
		Matrix input_weights=new Matrix(inputweights);
		Matrix hidden_matrix=new Matrix(hiddenmatrix);;
		hidden_matrix=input_matrix.times(input_weights);
		hidden_inversematrix=hidden_matrix.inverse();
		Matrix output_matrix=new Matrix(outputmatrix);
		Matrix output_weights=new Matrix(outputweights);
		 output_weights=hidden_inversematrix.times(output_matrix);
		 //���ˣ�������д�����ϣ���ʼԤ��
		 for(int i=0;i<Melm.inputlayers;i++)
			{inputmatrix[i][0]=j;
			j=j+0.000001;
			}
		  input_matrix=new Matrix(inputmatrix);
		  hidden_matrix=input_matrix.times(input_weights);
		  output_matrix=hidden_matrix.times(output_weights);
		  for(int i=0;i<Melm.inputlayers;i++)
		  {    j=output_matrix.get(i, 0);
			  list.add((float)(j));
			  System.out.println(j);
		  }
		  return list;
	}


}

