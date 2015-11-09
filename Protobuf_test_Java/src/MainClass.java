import java.nio.ByteBuffer;

import com.google.protobuf.InvalidProtocolBufferException;
import com.keyofspectator.protobuf.PersonProtos.Person;


/**
 *  测试 Protobuf 对 Java对象的 序列化 与 反序列化
 * 
 *  @author KeyOfSpectator
 *
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a test for protobuf");
		
		//序列化
		Person.Builder b = Person.newBuilder();
        b.setId(1);
        b.setName("fsc");
        b.setSex("男");
        b.setTel("123456");
        Person p = b.build();
        
        byte [] value = p.toByteArray();
        
        System.out.println("byte array : " + value.length);
        
        //反序列化：
        Person last = null;
        try {
			last = Person.parseFrom(value);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
        System.out.println("person id : " + last.getId());
        System.out.println("person name : " + last.getName());
        System.out.println("person sex : " + last.getSex());
        System.out.println("person Tel : " + last.getTel());
        byte a = 5;
        byte[] b1 = new byte[2];
        
		ByteBuffer buffer = ByteBuffer.allocate(1);
		buffer.put(a);
		
		System.out.println(a);
		buffer.clear();
	}

}
