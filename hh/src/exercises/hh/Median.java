package exercises.hh;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Median{
	public static void main(String [] args){	
		System.out.println("������� �����: "+ getMedian("Median.txt"));
	}
	
	// �������� �����, �������������� ������ ���������
	public static BigDecimal getMedian(String filepath){
		ArrayList<BigDecimal> arr1 = new ArrayList<BigDecimal>();
		ArrayList<BigDecimal> arr2 = new ArrayList<BigDecimal>();
		
		fillArrayLists(filepath, arr1, arr2);
		return calcMedian( arr1, arr2);
	}
	
	
	// ���������� �������� �������
		private static BigDecimal calcMedian( ArrayList<BigDecimal> arr1,  ArrayList<BigDecimal> arr2){
			int N=arr1.size();
			if (N==0) return BigDecimal.valueOf(0);
			ArrayList<BigDecimal> res = new ArrayList<BigDecimal>();
			int i=0,j=0;
			 while (i < N && j < N) {
		            // � ������������ � ���, ������� �������
		            // ������ ������� ������, �� ����������
		            // ���� ������� � ������-��������� �
		            // ��������� ������ ������ (i ��� j)
		            if (arr2.get(j).compareTo(arr1.get(i))==1) {
		               res.add(arr1.get(i));
		                i++;
		            } else {
		            	res.add(arr2.get(j));
		                j++;
		            }
		        }

		        // ����� ���������� ����������� �����
		        // ��� �������� ������ �� �������� �����
		        // ����������, ����� ���������� ��������
		        // ������� ������� ����� ������ ��������
		        // � ������-���������
		        // �������, ��� ���� �� ������� (i < n)
		        // ��� (j < m) ����� �������������� �����
		        while (i < N) {
		        	res.add(arr1.get(i));
		            i++;
		        }
		        while (j < N) {
		        	res.add(arr2.get(j));
		            j++;
		        }  
		        

		        BigDecimal median = (res.get(N).add(res.get(N-1)).divide(BigDecimal.valueOf(2)));
		        return median;		
		}
	
	//-- ��������������� ������ --

	// ���������� ������ �� ����� � ���������� ArrayList-��
	private static void fillArrayLists(String filepath, ArrayList<BigDecimal> arr1, ArrayList<BigDecimal> arr2) {
		try{
			 File file = new File(filepath);
			 Scanner sc = new Scanner(file);
			 String s1, s2;
			 s1 = sc.nextLine();
			 s2 = sc.nextLine();
			 sc.close();
			 fillSingleArray( arr1, s1);
			 fillSingleArray(arr2, s2);
		}catch (FileNotFoundException e) {
			 e.printStackTrace();
		}
	}
	
	// ���������� ���������� ArrayList ������� �� ������
	private static void fillSingleArray(ArrayList<BigDecimal> arr1,String s1) {
			 String[] as1 = s1.split(" ");
			 for(int i=0; i<as1.length; i++){
				 arr1.add(new BigDecimal(as1[i]));
			 }
		 }

	

}
