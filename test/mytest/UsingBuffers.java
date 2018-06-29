package mytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
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
        //cb.reset();
        cb.mark();
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
        System.out.println(Pattern.matches("\\d", "\\d2"));//false
        System.out.println(Pattern.matches("\\d", "\\d3"));//false
        System.out.println(Pattern.matches("\\d", "\\d4"));//false
        System.out.println(Pattern.matches("\\d", "\\d5"));//false
        System.out.println(Pattern.matches("\\d", "\\d6"));//false
        System.out.println(Pattern.matches("\\d", "\\d7"));//false
        System.out.println(Pattern.matches("\\d", "\\d8"));//false
    		StringBuilder sbf=new StringBuilder();
    		int i=0;
    		for(i=0;i<43200000;i++){
    			sbf.append(i);
    		}
    		System.out.println(1);

    }
    public void test() throws IOException
    {
        ByteBuffer buff = ByteBuffer.allocate(128);
        FileChannel fin = null;
        FileChannel fout = null;
        try
        {
            fin = new FileInputStream("filein").getChannel();
            fout = new FileOutputStream("fileout").getChannel();
            while(fin.read(buff) != -1) {
                buff.flip();
                fout.write(buff);
                buff.clear();
            }
        }
        catch (FileNotFoundException e)
        {

        } finally {
            try {
                if(fin != null) {
                    fin.close();
                }
                if(fout != null) {
                    fout.close();
                }
            } catch(IOException e) {
                throw e;
            }
        }
    }
  
}  
