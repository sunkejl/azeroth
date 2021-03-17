import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * 不能使用ClassLoader加载java源码文件，就是.java文件，只能加载.class文件
 *
 * @author sk
 * @date 2021/3/17
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = new HelloClassLoader().findClass("Hello").newInstance();
        Method method = obj.getClass().getMethod("hello");
        method.invoke(obj);
    }

    @Override
    protected Class<?> findClass(String name) {
        System.out.println();
        File f = new File("week01\\Hello_zip\\Hello.xlass");
        System.out.println(f.getAbsolutePath());
//        File f = new File("E:\\github\\azeroth\\week01\\Hello_zip\\Hello.xlass");
//        File f = new File("/mnt/e/github/azeroth/week01/Hello.xlass");
        byte[] fileContent = new byte[0];
        try {
            fileContent = Files.readAllBytes(f.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] newByte = new byte[fileContent.length];
        int index = 0;
        for (Byte i : fileContent) {
            int i1 = 255 - ((int) i) & 0xff;
            newByte[index] = (byte) i1;
            index++;
        }
        System.out.println(new String(newByte));
        return defineClass(name, newByte, 0, fileContent.length);
    }
}
