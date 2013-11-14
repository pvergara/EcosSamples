package com.ecos.samples.spinnerboxsamples.model;

public class SomePojo {


	private int mId;
	private String mName;

	public SomePojo(int id, String name) {
		super();
		this.mId = id;
		this.mName = name;
	}

	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}
	
	@Override
	public String toString() {
		return mName;
	}
}
