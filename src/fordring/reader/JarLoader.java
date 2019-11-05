package fordring.reader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author wangcanfeng
 * @description jar��������
 * @Date Created in 10:11-2019/9/10
 */
public class JarLoader {

    public JarLoader() {
        //NO_OP
    }

    /**
     * ��������: ɨ��һ���ļ������������jar�����������ļ��к���jar
     *
     * @param directoryPath
     * @return:java.util.Map<java.lang.String,java.lang.Class<?>>
     * @since: v1.0
     * @Author:wangcanfeng
     * @Date: 2019/9/12-15:21
     */
    public static Map<String, Class<?>> loadAllJarFromAbsolute(String directoryPath) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {

        File directory = new File(directoryPath);
        // �ж��Ƿ�Ϊ�ļ��У�������ļ�,ֱ���õ���jar�����ķ���ȥ����
        if (!directory.isDirectory()) {
            // ���jarɨ��·��
            addUrl(directory);
            return loadJarFromAbsolute(directoryPath);
        }
        // ������ļ��У�����Ҫѭ�����ص�ǰ�ļ������������jar
        Map<String, Class<?>> clazzMap = new HashMap<>(16);
        File[] jars = directory.listFiles();
        if (jars != null && jars.length > 0) {
            List<String> jarPath = new LinkedList<>();
            for (File file : jars) {
                String fPath = file.getPath();
                // ֻ����jar
                if (fPath.endsWith(".jar")) {
                    addUrl(file);
                    jarPath.add(fPath);
                }
            }
            if (jarPath.size() > 0) {
                for (String path : jarPath) {
                    clazzMap.putAll(loadJarFromAbsolute(path));
                }
            }
        }
        return clazzMap;
    }

    /**
     * ��������: �Ӿ���·���м���jar���е���
     * ɨ��ָ��jar��ǰ��Ҫ�����jar�ĵ�ַ������ϵͳ���������ɨ���б���
     * ע�⣬����ֻ֧�ֵ���jar�ļ��أ�������jar������������jar�����������ʧ��
     * ����ֻ���������ض�����jar��û�������ļ򵥶�������Ϣ
     *
     * @param path jar��·�����ص�ַ
     * @return:java.util.Map<java.lang.String,java.lang.Class<?>>
     * @since: v1.0
     * @Author:wangcanfeng
     * @Date: 2019/9/12-14:14
     */
    public static Map<String, Class<?>> loadJarFromAbsolute(String path) throws IOException {
        JarFile jar = new JarFile(path);
        Enumeration<JarEntry> entryEnumeration = jar.entries();
        Map<String, Class<?>> clazzMap = new HashMap<>(16);
        while (entryEnumeration.hasMoreElements()) {
            JarEntry entry = entryEnumeration.nextElement();
            // �Ȼ�ȡ������ƣ���������֮�������������⴦��������������
            String clazzName = entry.getName();
            if (clazzName.endsWith(".class")) {
                // ȥ���ļ����ĺ�׺
                clazzName = clazzName.substring(0, clazzName.length() - 6);
                // �滻�ָ���
                clazzName = clazzName.replace("/", ".");
                // ������,���ʧ��ֱ������
                try {
                    Class<?> clazz = Class.forName(clazzName);
                    // ����������Ϊ������Class������Ϊֵ����mao
                    // ��Ϊ���������ظ��Ŀ��ܣ���������������Ǵ�������
                    clazzMap.put(clazzName, clazz);
                } catch (Throwable e) {
                    // ������ܳ�����Щ����������ȫ�ģ�ֱ����������������Ҳû��������
                }
            }
        }
        return clazzMap;
    }


    /**
     * ��������: �����Ҫɨ���jar��
     *
     * @param jarPath
     * @return:void
     * @since: v1.0
     * @Author:wangcanfeng
     * @Date: 2019/9/12-15:21
     */
    public static void addUrl(File jarPath) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, MalformedURLException {

        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        // �����ȡ��������е�addURL������������Ҫ�������jar·��
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        URL url = jarPath.toURI().toURL();
        // �ѵ�ǰjar��·�����뵽���������Ҫɨ���·��
        method.invoke(classLoader, url);
    }

}