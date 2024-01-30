package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlaylistReposiyory;

@Service
public class PlaylistServiceImpliment implements PlaylistService{
@Autowired
	PlaylistReposiyory repo;
	@Override
	public  void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Playlist> fetchAllPlaylists() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
