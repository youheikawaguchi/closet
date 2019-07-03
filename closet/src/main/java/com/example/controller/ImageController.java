package com.example.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Item;
import com.example.service.ItemService;

@Controller
public class ImageController {
	
	@Autowired
	ItemService itemService;
	
    @GetMapping("/image")
    public @ResponseBody String responseImage(@RequestParam("userid") int userid, @RequestParam("itemid") int itemid) throws IOException {
    	Item item = itemService.getItemById(itemid);
        String filename = item.getPicture();

        return "redirect:" + filename;
//        return FileUtils.readFileToByteArray(new File(filename));
    }
}
