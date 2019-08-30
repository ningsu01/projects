package org.ych.techDemo.netty.nettyServer;
 
import java.io.UnsupportedEncodingException;
 
import org.ych.techDemo.netty.encoder.Header;
import org.ych.techDemo.netty.encoder.Message;
 
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
 
/**
 * Handler implementation for the echo server.
 * 
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
	
	//���������Ĵ�����
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    	
    	Message msg1=(Message)msg;
    	System.out.println(msg1.getData());
    	
    	//�˴�д���յ��ͻ���������ҵ���߼�
    	String content="hello world,this is nettyServer";  
        Header header=new Header((byte)0, (byte)1, (byte)1, (byte)1, (byte)0, "713f17ca614361fb257dc6741332caf2",content.getBytes("UTF-8").length, 1);  
        Message message=new Message(header,content); 
        ctx.writeAndFlush(message);
        
        
    	//ctx.writeAndFlush(Unpooled.copiedBuffer("hello world,this is nettyServer",CharsetUtil.UTF_8));
    
    }
 
    //��ȡ��ɺ�������
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        System.out.println("EchoServerHandler.channelReadComplete");
    	//ctx.flush();
    }
 
    //�쳣����������
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}