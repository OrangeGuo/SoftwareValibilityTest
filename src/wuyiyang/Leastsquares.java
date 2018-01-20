package wuyiyang;

import java.util.ArrayList;
public class Leastsquares {
	private double[]x;
	private double[]y;
	ArrayList<Float> list = null;
	public Leastsquares(){
		x=new double [1000];
		y=new double [1000];
		String fileName="data/func_train2.txt";
		Dataset dataset = Dataset.load(fileName, "\t",2, false);
		for(int i=0;i<dataset.size();i++){
			this.x[i]=dataset.getAttrs(i)[0];
			this.y[i]=dataset.getAttrs(i)[1];
			//System.out.println(dataset.getAttrs(i)[0]+"   "+dataset.getAttrs(i)[1]);
	    }
		 list=new ArrayList<Float>();
				estimate(this.x, this.y,1000 );
		
	}
	

	
public  void estimate( double[] x , double[] y , int i ) {
	double a = getA( x , y ) ;
	double b = getB( x , y , a ) ;
	double j=1;
	double predictnumber;
	
	for(int k=1;k<1000;k++)
	{
		j=j+0.000001;
		predictnumber=j*a+b;
		list.add((float)predictnumber);
	}
}
public ArrayList<Float> getArrayList(){
	return list;
}
 public static double getA( double[] x , double[] y ){
	// ���� x��ϵ��a:a=((1--n)xi*yi-(1--n)x*(1--n)y)/(1--n)xi2-((1--n)x)2
	 int n = x.length ;
	 return ( n * mul( x , y ) - sum( x ) * sum( y ) )/ ( n * rooting( x ) - Math.pow(sum(x), 2) ) ;
 }
 
 
 public static double getB( double[] x , double[] y , double a ){
	 //���㳣��ϵ��b=((1--n)yi-axi)/n
	 int n = x.length ;
	 return (sum( y ) - a * sum( x )) / n ;
 }
 

 

 private static double sum(double[] x) {
	 //�����ֵ
	 double s = 0 ;
	 double d;
	
	 for( int i = 0 ; i < x.length ; i++ )
	 {   d=x[i];
		 s = s + d ;
	 }
	 
	 return s ;
 }

 private static double rooting(double[] x) {
	//���㿪ƽ����ֵ
	 double s = 0 ;
	 double d;
	 for( int i = 0 ; i < x.length ; i++ ) 
     {   d=x[i];
		 s = s + Math.pow(d, 2) ;
     }
     
	 return s ;
 }

 private static double mul( double[] x , double[] y ) {
	 //����x��y��ĺ�ֵ
	 double s = 0 ;
	 for( int i = 0 ; i < x.length ; i++ ) 
	 s = s + x[i] * y[i] ;
	 return s ;
 }
}
