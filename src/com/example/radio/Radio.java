package com.example.radio;

import java.io.Serializable;

public class Radio implements Serializable {

	/**
	 * Auto generated
	 */
	private static final long serialVersionUID = -6722282401900464569L;

	private long id;
	private String name;
	private String url;
	private int img;

	public Radio(int id, String name, String url, int img) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.url = url;
	}

	public Radio() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

}
