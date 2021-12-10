package classLoader;

import java.io.*;

public class ReadDiskClassloader extends ClassLoader {
    private String directory;

    public ReadDiskClassloader(String directory) {
        this.directory = directory;
    }

    public ReadDiskClassloader(ClassLoader parent, String directory) {
        super(parent);
        this.directory = directory;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String file=directory+File.separator+name.replace(".",File.separator)+".class";
        //构建输入流
        try {
            InputStream in=new FileInputStream(file);

            //构建字节输出流
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte buffer[]=new byte[1024];
            int len=-1;
            while((len=in.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            byte data[]=baos.toByteArray();//读取到的字节码得二进制数据
            in.close();
            baos.close();
            return defineClass(name,data,0,data.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ReadDiskClassloader readDiskClassloader=new ReadDiskClassloader("E:/");
        Class clazz=readDiskClassloader.loadClass("ReadDiskClassLoader");
        clazz.newInstance();
    }
}
