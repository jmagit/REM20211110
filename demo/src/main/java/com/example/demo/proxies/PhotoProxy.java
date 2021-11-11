package com.example.demo.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.PhotoDTO;

@FeignClient(name="photos", url="https://picsum.photos")
public interface PhotoProxy {
    @RequestMapping(method = RequestMethod.GET, value = "/v2/list?limit=1000")
    List<PhotoDTO> getAll();
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}/info")
    PhotoDTO getOne(@PathVariable int id);
}
