package mytest;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.regex.Pattern;
  
public class UsingBuffers {  
  
      
    public static void main(String[] args) {  
        char[] data = "UsingBuffers".toCharArray();  
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);  
        CharBuffer cb = bb.asCharBuffer();  
        cb.put(data);  
        cb.rewind();  
        System.out.println(cb.limit() + "  " + cb.position()+cb.toString());//12 2  
        System.out.println(cb.get() + "  " + cb.position()+cb.toString());//U 1  
        System.out.println(cb.get() + "  " + cb.position()+cb.toString());//n 1  
        System.out.println(cb.get(3) + "  " + cb.position()+cb.toString());//n 1  
        cb.flip();
        System.out.println(cb);//12  
        cb.clear();
        System.out.println(cb.limit());//12  
        System.out.println(cb);//12  
        cb.put(5,'x');  
        System.out.println(cb.limit() + "  " + cb.position()+cb.toString());//12 1  
        cb.put('x');  
        cb.put('x');  
        cb.put('x');  
        System.out.println(cb.limit() + "  " + cb.position()+cb.toString());//12 2  
        cb.flip();
        System.out.println(cb.limit() + "  " + cb.position()+cb.toString());//12 2  
        System.out.println(cb.get(0));
        System.out.println((char)0x43);
        String quote = Pattern.quote("\\d");  
        System.out.println(quote);
        System.out.println(Pattern.matches(quote, "\\d"));//true  
        System.out.println(Pattern.matches("\\d", "\\d"));//false  
        System.out.println(Pattern.matches("\\d", "\\d"));//false  
    }  
  
  
}  
