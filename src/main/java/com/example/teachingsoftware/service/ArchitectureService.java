package com.example.teachingsoftware.service;

import com.example.teachingsoftware.first.demo1;
import com.example.teachingsoftware.forth.*;
import com.example.teachingsoftware.second.Alphabetizer2;
import com.example.teachingsoftware.second.Input2;
import com.example.teachingsoftware.second.Output2;
import com.example.teachingsoftware.second.Shift2;
import com.example.teachingsoftware.third.*;
import com.example.teachingsoftware.third.KWICSubject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class ArchitectureService {

    public String getTitle(String type) {
        switch (type) {
            case "mainSubroutine":
                return "主程序-子程序架构";
            case "objectOriented":
                return "面向对象架构";
            case "eventSystem":
                return "事件系统架构";
            case "pipelineFilter":
                return "管道-过滤器架构";
            default:
                return "未知架构";
        }
    }

    public String getDescription(String type) {
        switch (type) {
            case "mainSubroutine":
                return "主程序-子程序是一种传统的软件架构风格，其中主程序调用子程序来完成特定任务。";
            case "objectOriented":
                return "面向对象架构是一种基于类和对象的软件架构风格，强调封装、继承和多态。";
            case "eventSystem":
                return "事件系统架构是一种基于事件驱动的软件架构风格，其中组件通过事件进行通信。";
            case "pipelineFilter":
                return "管道-过滤器架构是一种基于数据流的软件架构风格，数据通过一系列过滤器进行处理。";
            default:
                return "未知的架构类型";
        }
    }

    public String getImportantfx(String type){
        switch (type) {
            case "mainSubroutine":
                return "关键函数\n" + "\n" +
                        " main：主程序入口，调用子程序。\n" +
                        " subRoutine1：子程序1，执行特定任务。\n" +
                        " subRoutine2：子程序2，执行特定任务。\n";
            case "objectOriented":
                return "关键函数\n" + "\n" +
                        "makeSound：基类中的方法，定义默认行为。\n" +
                        "makeSound（重写）：派生类中的方法，提供具体实现。\n" +
                        "main：测试类的主程序入口，演示多态。\n";
            case "eventSystem":
                return "关键函数\n" + "\n" +
                        "handle：事件处理器接口的方法，定义事件处理逻辑。\n" +
                        "registerHandler：事件系统类的方法，注册事件处理器。\n" +
                        "fireEvent：事件系统类的方法，触发事件并通知所有注册的处理器。\n" +
                        "main：测试类的主程序入口，演示事件系统的使用。\n";
            case "pipelineFilter":
                return "关键函数\n" + "\n" +
                        "process：过滤器接口的方法，定义数据处理逻辑。\n" +
                        "addFilter：管道类的方法，添加过滤器到管道中。\n" +
                        "process：管道类的方法，依次调用所有过滤器处理数据。\n" +
                        "main：测试类的主程序入口，演示管道-过滤器架构的使用。\n";
            default:
                return "未知的架构类型";
        }
    }
    public String getCode(String type) {
        switch (type) {
            case "mainSubroutine":
                return """
                            public class MainProgram {
                                 public static void main(String[] args) {  
                                     subRoutine1(); 
                                     subRoutine2();
                                 }
                                 public static void subRoutine1() {
                                     System.out.println("执行子程序1");
                                 }
                                 public static void subRoutine2() {
                                     System.out.println("执行子程序2");
                                 }
                             }
                        """;
            case "objectOriented":
                return """
                            // 基类
                             public class Animal {
                                 public void makeSound() {
                                     System.out.println("Animal sound");
                                 }
                             }
                             
                             // 派生类
                             public class Dog extends Animal {
                                 @Override
                                 public void makeSound() {
                                     System.out.println("Dog barks");
                                 }
                             }
                             
                             // 测试类
                             public class Test {
                                 public static void main(String[] args) {
                                     Animal animal = new Animal();
                                     Dog dog = new Dog();
                             
                                     animal.makeSound(); // 输出: Animal sound
                                     dog.makeSound();    // 输出: Dog barks
                             
                                     // 多态
                                     Animal animalRef = new Dog();
                                     animalRef.makeSound(); // 输出: Dog barks
                                 }
                             }
                        """;
            case "eventSystem":
                return """
                            // 事件接口
                             public interface EventHandler {
                                 void handle(Event event);
                             }
                             
                             // 事件类
                             public class Event {
                                 private String message;
                             
                                 public Event(String message) {
                                     this.message = message;
                                 }
                             
                                 public String getMessage() {
                                     return message;
                                 }
                             }
                             
                             // 事件系统类
                             public class EventSystem {
                                 private List<EventHandler> handlers = new ArrayList<>();
                             
                                 public void registerHandler(EventHandler handler) {
                                     handlers.add(handler);
                                 }
                             
                                 public void fireEvent(Event event) {
                                     for (EventHandler handler : handlers) {
                                         handler.handle(event);
                                     }
                                 }
                             }
                             
                             // 具体的事件处理器
                             public class PrintEventHandler implements EventHandler {
                                 @Override
                                 public void handle(Event event) {
                                     System.out.println("处理事件: " + event.getMessage());
                                 }
                             }
                             
                             // 测试类
                             public class Test {
                                 public static void main(String[] args) {
                                     EventSystem eventSystem = new EventSystem();
                                     EventHandler printHandler = new PrintEventHandler();
                             
                                     eventSystem.registerHandler(printHandler);
                             
                                     Event event1 = new Event("事件1");
                                     eventSystem.fireEvent(event1); // 输出: 处理事件: 事件1
                             
                                     Event event2 = new Event("事件2");
                                     eventSystem.fireEvent(event2); // 输出: 处理事件: 事件2
                                 }
                             }
                        """;
            case "pipelineFilter":
                return """
                            // 过滤器接口
                             public interface Filter {
                                 Data process(Data data);
                             }
                             
                             // 数据类
                             public class Data {
                                 private String content;
                             
                                 public Data(String content) {
                                     this.content = content;
                                 }
                             
                                 public String getContent() {
                                     return content;
                                 }
                             
                                 public void setContent(String content) {
                                     this.content = content;
                                 }
                             }
                             
                             // 具体的过滤器
                             public class Filter1 implements Filter {
                                 @Override
                                 public Data process(Data data) {
                                     String processedContent = data.getContent().toUpperCase();
                                     data.setContent(processedContent);
                                     return data;
                                 }
                             }
                             
                             public class Filter2 implements Filter {
                                 @Override
                                 public Data process(Data data) {
                                     String processedContent = data.getContent().replaceAll(" ", "_");
                                     data.setContent(processedContent);
                                     return data;
                                 }
                             }
                             
                             // 管道类
                             public class Pipeline {
                                 private List<Filter> filters = new ArrayList<>();
                             
                                 public void addFilter(Filter filter) {
                                     filters.add(filter);
                                 }
                             
                                 public Data process(Data data) {
                                     for (Filter filter : filters) {
                                         data = filter.process(data);
                                     }
                                     return data;
                                 }
                             }
                             
                             // 测试类
                             public class Test {
                                 public static void main(String[] args) {
                                     Pipeline pipeline = new Pipeline();
                                     Filter filter1 = new Filter1();
                                     Filter filter2 = new Filter2();
                             
                                     pipeline.addFilter(filter1);
                                     pipeline.addFilter(filter2);
                             
                                     Data inputData = new Data("Hello World");
                                     Data processedData = pipeline.process(inputData);
                             
                                     System.out.println("处理后的数据: " + processedData.getContent()); // 输出: HELLO_WORLD
                                 }
                             }
                        """;
            default:
                return "";
        }
    }


    public String processMainSubroutineFile(MultipartFile file) throws IOException {
            String content = new String(file.getBytes(), "UTF-8");
            demo1 demo1 = new demo1();
            demo1.input(content);
            demo1.shift();
            demo1.alphabetizer();
            return "主程序-子程序架构处理文件结果\n"+demo1.output();
    }
    public String processObjectOrientedFile(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), "UTF-8");
        // 创建输入对象
        Input2 input2= new Input2();
        input2.input(new StringReader(content));

        // 创建和执行 Shift 对象
        Shift2 shift2 = new Shift2(input2.getLineTxt());
        shift2.shift();

        // 创建和执行 Alphabetizer 对象
        Alphabetizer2 alphabetizer2 = new Alphabetizer2(shift2.getKwicList());
        alphabetizer2.sort();

        // 创建和执行 Output 对象
        Output2 output2 = new Output2(alphabetizer2.getKwicList());
        StringWriter stringWriter = new StringWriter();
        output2.output(stringWriter);
        return "面向对象架构处理文件结果\n"+stringWriter.toString();
    }

    public String processEventSystemFile(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), "UTF-8");
        // 创建主题
        KWICSubject kwicSubject = new KWICSubject();
        // 创建观察者
        Input3 input3 = new Input3(new StringReader(content));
        Shift3 shift3 = new Shift3(input3.getLineTxt());
        Alphabetizer3 alphabetizer3 = new Alphabetizer3(shift3.getKwicList());
        Output3 output3 = new Output3(alphabetizer3.getKwicList(), new StringWriter());
        // 将观察者加入主题
        kwicSubject.addObserver(input3);
        kwicSubject.addObserver(shift3);
        kwicSubject.addObserver(alphabetizer3);
        kwicSubject.addObserver(output3);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
        // 获取输出结果
        return "事件系统架构处理文件结果\n"+output3.getWriter().toString();
    }

    public String processPipelineFilterFile(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), "UTF-8");
        Reader reader = new StringReader(content);
        Writer writer = new StringWriter();
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input4 input4 = new Input4(reader, pipe1);
        Shift4 shift4 = new Shift4(pipe1, pipe2);
        Alphabetizer4 alphabetizer4 = new Alphabetizer4(pipe2, pipe3);
        Output4 output4 = new Output4(pipe3, writer);
        input4.transform();
        shift4.transform();
        alphabetizer4.transform();
        output4.transform();
        return "管道-过滤器架构处理文件结果\n"+writer.toString();
    }



    public String processFile(MultipartFile file, String method) {
        try {
            if ("mainSubroutine".equals(method)) {
                return processMainSubroutineFile(file);
            }else if("objectOriented".equals(method)){
                return processObjectOrientedFile(file);
            }else if("eventSystem".equals(method)){
                return processEventSystemFile(file);
            }else if("pipelineFilter".equals(method)){
                return processPipelineFilterFile(file);
            }else{
                return "不支持的处理方法: " + method;
            }
        } catch (Exception e) {
            return "处理文件时发生错误: " + e.getMessage();
        }
    }
}

