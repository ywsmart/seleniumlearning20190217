package com.yvan.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/24
 * Created by yawa1hz1 on 2019/2/24 10:28.
 */
public class FileUtils {
    /**
     * 读取CSV文件
     * @param filePath
     * @return
     * @throws Exception
     */
    public static Iterator<Object[]> readCsvFile(String filePath) throws Exception {
        List<Object[]> dataArray = new ArrayList<>();
        Reader in = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            List<Object> rowList = new ArrayList<>();
            Iterator i = record.iterator();
            while (i.hasNext()) {
                rowList.add(i.next());
            }
            Object[] rowArray = rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();
    }

    /**
     * 读取Yml文件
     * @param path
     * @param attribute
     * @return
     * @throws Exception
     */
    public static String readYmlFile(String path, String attribute) throws Exception {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(path);
        Map map = yaml.loadAs(fileInputStream, Map.class);
        fileInputStream.close();
        return (String) map.get(attribute);
    }

    /**
     * 临时测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String path = getPath("/clickBanner.yml");
        System.err.println(path);

        String value = readYmlFile(path, "expectTitle");
        System.err.println(value);

    }

    public static String getPath(String partPath) throws Exception {
        String path = FileUtils.class.getResource(partPath).getPath();
        // 路径有中文时，可以用下面代码转换编码格式
        return URLDecoder.decode(path, "UTF-8");
    }
}
