
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.protobuf.InvalidProtocolBufferException;
import com.keyofspectator.protobuf.PersonProtos.Person;

/**
 *  测试 Protobuf 对 Java和python语言之间的序列化通信
 *  通过文件
 *  
 *  @author KeyOfSpectator
 *
 */
public class MainClassFileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String file_path = "/Users/KeyOfSpectator/tmp_file";
		
		
//序列化
		Person.Builder b = Person.newBuilder();
		b.setId(2);
		b.setName("fsc");
		b.setSex("男");
		b.setTel("123456");
		Person p = b.build();

		byte[] value = p.toByteArray();

		System.out.println("byte array : " + value);
		
		// write to File
		System.out.println("Ready to write to file , path = " + file_path);
		File file = new File(file_path);
		FileOutputStream out = null;
		if(!file.exists()){
			try {
				file.createNewFile();
				out=new FileOutputStream(file);
				
				// write to file
				out.write(value);
				out.close();
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} finally {
				if(out!=null){
					try {
						out.close();
						System.out.println("write done");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
		// read from File
		file = new File(file_path);
		if(!file.exists())
			return;
		InputStream in = null;
		try {
            System.out.println("Read File from path = " + file_path);
            // 一次读多个字节
            in = new FileInputStream(file_path);
            int len = in.available();
            byte[] tempbytes = new byte[len];
            int byteread = 0;
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
            	System.out.print("bytes: ");
                System.out.write(tempbytes, 0, byteread);
                System.out.println();
            }
            
////反序列化：
            Person last = null;
            try {
    			last = Person.parseFrom(tempbytes);
    		} catch (InvalidProtocolBufferException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            	
            System.out.println("person id : " + last.getId());
            System.out.println("person name : " + last.getName());
            System.out.println("person sex : " + last.getSex());
            System.out.println("person Tel : " + last.getTel());
            
            
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
		
		
	}

}
