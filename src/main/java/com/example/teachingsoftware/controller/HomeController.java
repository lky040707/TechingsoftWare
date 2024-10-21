package com.example.teachingsoftware.controller;

import com.example.teachingsoftware.service.ArchitectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ArchitectureService architectureService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/process")
    @ResponseBody
    public String processFile(@RequestParam("file") MultipartFile file, @RequestParam("method") String method) {
        try {
            return architectureService.processFile(file, method);
        } catch (Exception e) {
            logger.error("处理文件时发生错误: ", e);
            return "处理文件时发生错误: " + e.getMessage();
        }
    }

    @GetMapping("/architecture/{type}")
    public String showArchitecture(@PathVariable String type, Model model) {
        try {
            model.addAttribute("title", architectureService.getTitle(type));
            model.addAttribute("description", architectureService.getDescription(type));
            model.addAttribute("code", architectureService.getCode(type));
            model.addAttribute("imageSrc", "/images/" + type + ".png");
            model.addAttribute("importantfx", architectureService.getImportantfx(type));

            return "architecture";
        } catch (Exception e) {
            logger.error("显示架构页面时发生错误: ", e);
            model.addAttribute("title", "错误");
            model.addAttribute("description", "显示架构页面时发生错误");
            model.addAttribute("code", e.getMessage());
            return "error";
        }
    }
}