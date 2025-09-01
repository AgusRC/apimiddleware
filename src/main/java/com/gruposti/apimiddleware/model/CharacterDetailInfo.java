package com.gruposti.apimiddleware.model;

public class CharacterDetailInfo {
	private int id;
	private String name;
	private String weight;
	private String height;
	private GameIndices[] game_indices;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public GameIndices[] getGame_indices() {
		return game_indices;
	}
	public void setGame_indices(GameIndices[] game_indices) {
		this.game_indices = game_indices;
	}
	
}
