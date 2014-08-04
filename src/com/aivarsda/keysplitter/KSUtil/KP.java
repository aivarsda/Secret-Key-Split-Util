package com.aivarsda.keysplitter.KSUtil;

import java.util.ArrayList;


public class KP
{
	private String orgKey;
	private ArrayList<String> SplitedPiecesArray;

	public ArrayList<String> getSplitedPiecesArray()
	{
		return SplitedPiecesArray;
	}

	public void setSplitedPiecesArray(ArrayList<String> splitedPiecesArray)
	{
		SplitedPiecesArray = splitedPiecesArray;
	}

	public String getOrgKey() {
		return orgKey;
	}

	public void setOrgKey(String orgKey) {
		this.orgKey = orgKey;
	}
}
