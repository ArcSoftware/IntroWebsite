package com.theironyard.charlotte.IntroWebsite.services;

import com.theironyard.charlotte.IntroWebsite.models.ImgurData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {
    RestTemplate template;

    public ImageService(RestTemplate template) {
        this.template = template;
    }

    public ImgurData getData(String album) {

        HttpHeaders headers = new HttpHeaders();
        List<String> authheaders = new ArrayList<>();
        authheaders.add(String.format("Client-ID %s", System.getenv("ISK")));
        headers.put("authorization", authheaders);
        Map<String, String> albumMap = new HashMap<>();
        albumMap.put("albumID", album);
        HttpEntity<ImgurData> data = new HttpEntity<>(new ImgurData(), headers);
        HttpEntity<ImgurData> response = template.exchange("https://api.imgur.com/3/album/{albumID}/images",
                HttpMethod.GET, data, ImgurData.class, albumMap);

        return response.getBody();
    }
}
