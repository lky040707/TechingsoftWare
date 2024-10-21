
// 继承自FileProcessor类，专门处理文本文件
public class TextFileProcessor extends FileProcessor {

    public TextFileProcessor(String filePath) {
        super(filePath);
    }

    @Override
    public String processFile() {
        String content = readFile();
        if (content.startsWith("Error")) {
            return content;
        }
        int characterCount = content.length();
        return "File content: \n" + content+ "\nCharacter count: " + characterCount;
    }
}