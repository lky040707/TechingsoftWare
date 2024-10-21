import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 抽象类，定义文件处理的通用接口
public abstract class FileProcessor {
    protected String filePath;

    // 构造函数，初始化文件路径
    public FileProcessor(String filePath) {
        this.filePath = filePath;
    }

    // 抽象方法，子类需要实现具体的文件处理逻辑
    public abstract String processFile();

    // 受保护的方法，用于读取文件内容
    protected String readFile() {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file.";
        }
        return contentBuilder.toString();
    }
}