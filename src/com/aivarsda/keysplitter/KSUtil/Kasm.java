package com.aivarsda.keysplitter.KSUtil;

import java.util.ArrayList;
import android.util.Base64;

public class Kasm extends KUtil
{

	public static byte[] getK(ArrayList<String> listOfStrings)
	{
		if(listOfStrings != null)
		{
			return XORonByteArr(StringsListToByteArrList(listOfStrings));
		}
		
		return null;
	}
	
	private static ArrayList<byte[]> StringsListToByteArrList(ArrayList<String> listOfStrings)
	{
		int size = listOfStrings.size();
		ArrayList<byte[]> listOfByteArrays = new ArrayList<byte[]>(size);
		for(int i=0; i<size; i++)
		{
			listOfByteArrays.add(Base64.decode(listOfStrings.get(i), Base64.DEFAULT));
		}
		return listOfByteArrays;
	}
	
}
