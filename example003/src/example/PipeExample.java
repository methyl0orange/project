package example;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

public class PipeExample {
    private static class chushi extends Thread{
        private PipedOutputStream outputStream;
        public chushi(PipedOutputStream outputStream){
            super();
            this.outputStream=outputStream;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                outputStream.write("快来端菜，菜好了".getBytes(StandardCharsets.UTF_8));
                Thread.sleep(1000);
                outputStream.write("再不端菜就凉了".getBytes(StandardCharsets.UTF_8));
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class keren extends Thread{
        private PipedInputStream inputStream;

        public keren(PipedInputStream inputStream) {
            super();
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            byte[] byteArray=new byte[1024];
            int len= 0;
            try {
                while ((len=inputStream.read(byteArray))!=-1){
                    String readStr=new String(byteArray,0,len);
                    System.out.println("客人收到消息:"+readStr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        PipedOutputStream outputStream=new PipedOutputStream();
        PipedInputStream inputStream=new PipedInputStream();
        inputStream.connect(outputStream);
        Thread chushi=new chushi(outputStream);
        Thread keren=new keren(inputStream);
        chushi.start();
        keren.start();

    }


}
