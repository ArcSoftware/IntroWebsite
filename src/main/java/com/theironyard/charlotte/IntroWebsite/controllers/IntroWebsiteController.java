package com.theironyard.charlotte.IntroWebsite.controllers;

import com.theironyard.charlotte.IntroWebsite.models.ImgurData;
import com.theironyard.charlotte.IntroWebsite.models.WeatherData;
import com.theironyard.charlotte.IntroWebsite.services.ImageService;
import com.theironyard.charlotte.IntroWebsite.services.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntroWebsiteController {
    ImageService imageService;
    WeatherService weatherService;

    public IntroWebsiteController(ImageService imageService, WeatherService weatherService) {
        this.imageService = imageService;
        this.weatherService = weatherService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("home", true);
        return "index";
    }

    @RequestMapping(path = "/albums", method = RequestMethod.GET)
    public String albums(Model model) {
        ImgurData imageData = imageService.getData("OqVcK");
        model.addAttribute("images", imageData.getImages());
        model.addAttribute("alb", true);
        return "albums";
    }

    @RequestMapping(path = "/soundboard", method = RequestMethod.GET)
    public String homePage(Model model, String name, String version) {
        model.addAttribute("soundname", name);
        model.addAttribute("version", version);
        return "soundboard";
    }

    @RequestMapping(path = "/weather", method = RequestMethod.GET)
    public String weather(Model model) {
        WeatherData weatherData = weatherService.getWeather();
        model.addAttribute("weather", weatherData.getCurrently());
        return "weather";
    }

    @RequestMapping(path = "/allAlbums", method = RequestMethod.GET)
    public String allAlbums(Model model, String albumID) {
        albumID = (albumID == null) ? "OqVcK" : albumID;
        ImgurData imageData = imageService.getData(albumID);
        model.addAttribute("images", imageData.getImages());
        model.addAttribute("allAlbums", true);
        return "albums";
    }
//
//    @RequestMapping(path = "/chatroom", method = RequestMethod.GET)
//    public String chatroom(Model model) {
//        List<Message> allMessages= messageRepo.findFirst5ByOrderByIdDesc();
//        Collections.reverse(allMessages);
//        model.addAttribute("messages", allMessages);
//        return "chatroom";
//    }
//    @RequestMapping(path = "/addmessage", method = RequestMethod.POST)
//    public String messagePost(Model model, String message) {
//        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
//        String currentUser = currentAuth.getName();
//        msg.createMessage(currentUser, message);
//        return "redirect:/chatroom";
//    }
//
//    @RequestMapping(path = "/adminchat", method = RequestMethod.GET)
//    public String adminPage(Model model) {
//        return "adminchat";
//    }
}
