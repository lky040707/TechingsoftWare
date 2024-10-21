
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // 获取项目的根目录路径
        String projectRootPath = System.getProperty("user.dir");
        // 构建资源文件的完整路径
        String filePath = projectRootPath + "/src/main/resources/input.txt";
        // 使用TextFileProcessor处理文件
        TextFileProcessor processor = new TextFileProcessor(filePath);
        String result = processor.processFile();
        System.out.println(result);
    }
}