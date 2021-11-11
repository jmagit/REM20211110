package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.PhotoDTO;
import com.example.demo.proxies.PhotoProxy;

public class PhotoRestItemWriter implements ItemWriter<PhotoDTO> {
	@Autowired
	private PhotoProxy srv;	

	@Override
	public void write(List<? extends PhotoDTO> items) throws Exception {
		items.forEach(f -> srv.send(f));
	}

}
