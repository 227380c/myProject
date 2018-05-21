package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Arrays;

public class MyTest {
	public static void main(String[] args) {
		S[] s1 = new S[5];
		S[] s2 = new S[5];
		S t1 = new S(1);
		S t2 = new S(1);

		Arrays.fill(s1, t1);
		Arrays.fill(s2, t2);

		System.out.println(Arrays.equals(s1, s2));
		System.out.println(t1.equals(t2));
		String[][] name1 = { { "G", "a", "o" }, { "H", "u", "a", "n" },
				{ "j", "i", "e" } };
		String[][] name2 = { { "G", "a", "o" }, { "H", "u", "a", "n" },
				{ "j", "i", "e" } };

		System.out.println(Arrays.equals(name1, name2)); // false
		System.out.println(Arrays.deepEquals(name1, name2));// true
		Arrays.sort(s1);
		System.out.println(s1);
		int b = 65536;
		System.out.println(b>>>1);
		System.out.println(b>>>2);
		System.out.println(b>>>3);
	}
}

class S implements Comparable<S>{
	int i = 0;
    public S(int i){
    	this.i = i;
    }
	@Override
	public boolean equals(Object b) {
		if (this.i == ((S) b).i)
			return true;
		return false;
	}

	@Override
	public int compareTo(S paramT) {
		if(this.i>paramT.i){
			return 1;
		}else if(this.i==paramT.i){
			return 0;
		}else{
			return -1;
		}
	}
}