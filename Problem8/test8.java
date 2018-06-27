package Problem8;

public class test8 {

	public static void main(String[] args) {
		MinIncNum testinstance = new MinIncNum();
		System.out.println("ffffffffffffffff");
		int[] a1 = {1,0,1,1,1};
		int[] a2 = {1,1,1,0,1};
		int[] a3 = {3,3,3,3,1,2,3};
		int[] a4 = {3,4,5,6,1,2};
//		System.out.println(testinstance.minNum(a1));
//		System.out.println(testinstance.minNum(a2));
//		System.out.println(testinstance.minNum(a3));
		System.out.println(testinstance.minNum(a4));

		RotateArray ra = new RotateArray();
		System.out.println(ra.min(a1));
		System.out.println(ra.min(a2));
		System.out.println(ra.min(a3));

	}

}
