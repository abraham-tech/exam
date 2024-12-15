package com.example.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
//@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("items")
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        Integer total = items.stream().mapToInt(item -> item.getPrice()).sum();
        model.addAttribute("total", total);
        return "home";
    }


    @GetMapping("items/add")
    public String addItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "addItem";
    }

    @PostMapping("items/add")
    public String addItem(@ModelAttribute("item") Item item) {
        itemRepository.save(item);
        return "redirect:/items";
    }


    @GetMapping("items/red")
    public String onlyRed(Model model) {
        List<Item> items = itemRepository.findAll();
        List<Item> filteredItems = new ArrayList<>(100);
        String redFlower = "";
        for (Item item : items) {
            if(item.getColor().equals("red")){
                filteredItems.add(item);
                redFlower = redFlower + " " +item.getName();
            }
        }

        model.addAttribute("items", filteredItems);
        model.addAttribute("redFlower", redFlower);
        return "home";
    }

    @GetMapping("items/total")
    public String totalItems(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        Integer total = items.stream().mapToInt(item -> item.getPrice()).sum();
        model.addAttribute("total", total);

        model.addAttribute("showTotal", true);
        return "home";
    }


}

