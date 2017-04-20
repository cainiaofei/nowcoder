import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	class Node{
		int[][] matrix = new int[5][4];
		public Node(int[][] matrix){
			this.matrix = matrix;
		}
	}
	
	public Map<Character,Node> showNumberByString(){
		Map<Character,Node> map = new HashMap<Character,Node>();
		//1
		int[][] matrix1 = {{1,0,0},{1,0,0},{1,0,0},{1,0,0},{1,0,0}};
		map.put('1', new Node(matrix1));
		//2
		int[][] matrix2 = {{1,1,1},{0,0,1},{1,1,1},{1,0,0},{1,1,1}};
		map.put('2', new Node(matrix2));
		//3
		int[][] matrix3 = {{1,1,1},{0,0,1},{1,1,1},{0,0,1},{1,1,1}};
		map.put('3', new Node(matrix3));
		//4
		int[][] matrix4 = {{1,0,1},{1,0,1},{1,1,1},{0,0,1},{0,0,1}};
		map.put('4', new Node(matrix4));
		//5
		int[][] matrix5 = {{1,1,1},{1,0,0},{1,1,1},{0,0,1},{1,1,1}};
		map.put('5', new Node(matrix5));
		//6
		int[][] matrix6 = {{1,1,1},{1,0,0},{1,1,1},{1,0,1},{1,1,1}};
		map.put('6', new Node(matrix6));
		//7
		int[][] matrix7 = {{1,1,1},{1,0,0},{1,0,0},{1,0,0},{1,0,0}};
		map.put('7', new Node(matrix7));
		//8
		int[][] matrix8 = {{1,1,1},{1,0,1},{1,1,1},{1,0,1},{1,1,1}};
		map.put('8', new Node(matrix8));
		//9
		int[][] matrix9 = {{1,1,1},{1,0,1},{1,1,1},{0,0,1},{1,1,1}};
		map.put('9', new Node(matrix9));
		//0
		int[][] matrix0 = {{1,1,1},{1,0,1},{1,0,1},{1,0,1},{1,1,1}};
		map.put('0', new Node(matrix0));
		//+
		int[][] matrixAdd = {{0,0,0},{0,1,0},{1,1,1},{0,1,0},{0,0,0}};
		map.put('+', new Node(matrixAdd));	
		//-
		int[][] matrixSub = {{0,0,0},{0,0,0},{1,1,1},{0,0,0},{0,0,0}};
		map.put('-', new Node(matrixSub));	
		//*
		int[][] matrixMul = {{0,0,0},{1,0,1},{0,1,0},{1,0,1},{0,0,0}};
		map.put('*', new Node(matrixMul));	
		// /
		int[][] matrixDiv = {{0,0,0},{0,0,1},{0,1,0},{1,0,0},{0,0,0}};
		map.put('/', new Node(matrixDiv));	
		//=
		int[][] matrixEqual = {{0,0,0},{1,1,1},{0,0,0},{1,1,1},{0,0,0}};
		map.put('&', new Node(matrixEqual));	
		//.
		int[][] matrixDot = {{0,0,0},{0,0,0},{0,0,0},{1,1,0},{1,1,0}};
		map.put('.', new Node(matrixDot));
		return map;
	}
	
	public void print(int a,int b,double res,Map<Character,Node> map,char op){
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(op);
		sb.append(b);
		sb.append('&');
		int temp = (int) res;
		if(temp==res){
			sb.append(temp);
		}
		else{
			sb.append(res);
		}
		char[] chs = sb.toString().toCharArray();
		for(int i = 0; i < 5;i++){
			for(int j = 0; j < chs.length;j++){
				print(chs[j],i,map);
				if(j!=chs.length-1){
					if(chs[j]=='1'){
						;
					}
					else if(chs[j]=='.'){
						System.out.print(' ');
					}
					else{
						System.out.print(' ');
						System.out.print(' ');
					}
				}
			}
			System.out.println();
		}
	}
	
	
	private void print(char c, int line, Map<Character, Node> map) {
		
		if(c=='&'){
			if(line==1||line==3){
				for(int i = 0; i < 4;i++){
					System.out.print("*");
				}
				return ;
			}
			else{
				for(int i = 0; i < 4;i++){
					System.out.print(' ');
				}
				return ;
			}
		}
		
		
		
		
		int[][] matrix = map.get(c).matrix;
		for(int i = 0; i < matrix[0].length;i++){
			if(matrix[line][i]==1){
				System.out.print('*');
			}
			else{
				System.out.print(' ');
			}
		}
	}

	public void process(){
		Map<Character,Node> map = showNumberByString();
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		char op = getOperator(line);
		String[] strs = line.split("\\+|\\-|\\*|/");
		int a = Integer.valueOf(strs[0].trim());
		int b = Integer.valueOf(strs[1].trim());
		if(op=='+'){
			print(a,b,a+b,map,op);
		}
		if(op=='-'){
			print(a,b,a-b,map,op);
		}
		if(op=='*'){
			print(a,b,a*b,map,op);
		}
		if(op=='/'){
			print(a,b,Double.valueOf(String.format("%.2f",a*1.0/b)),map,op);
		}
		scan.close();
	}

	private char getOperator(String line) {
		if(line.indexOf('+')!=-1){
			return '+';
		}
		if(line.indexOf('-')!=-1){
			return '-';
		}
		if(line.indexOf('*')!=-1){
			return '*';
		}
		if(line.indexOf('/')!=-1){
			return '/';
		}
		return 0;
	}

	public static void main(String[] args){
		Main m = new Main();
		m.process();
	}
}
