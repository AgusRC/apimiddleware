package com.gruposti.apimiddleware.model;

public class GameIndices {
	private Integer game_index;
	private game_version version;
	
	
	public static class game_version {
		private String name;
		private String url;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
	
	public Integer getGame_index() {
		return game_index;
	}
	public void setGame_index(Integer game_index) {
		this.game_index = game_index;
	}
	public game_version getVersion() {
		return version;
	}
	public void setVersion(game_version version) {
		this.version = version;
	}

}
