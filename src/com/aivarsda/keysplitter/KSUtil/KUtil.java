package com.aivarsda.keysplitter.KSUtil;

import java.util.ArrayList;

import android.util.Log;


public class KUtil
{
	public static final String		TAG				= "KUtil";
	protected static final boolean	IS_LOGGABLE		= false;
	
	
	protected static byte[] XORonByteArr (ArrayList<byte[]> listOfByteArr)
	{
		byte[] xor = null;
		
		if(listOfByteArr == null || listOfByteArr.size() < 1)
		{
			return null;
		}
		else if(listOfByteArr.size() < 2)
		{
			return listOfByteArr.get(0);
		}
		else
		{
			if(IS_LOGGABLE)
			{
				Log.w(TAG, "-----  XORonByteArr  -----");
				Log.w(TAG, "Piece [0] = "+new String(listOfByteArr.get(0)));
				Log.w(TAG, "Piece [1] = "+new String(listOfByteArr.get(1)));
			}
			
			xor = xor2ByteArr(listOfByteArr.get(0),listOfByteArr.get(1));
			for(int i=2; i<listOfByteArr.size(); i++)
			{
				if(IS_LOGGABLE)Log.w(TAG, "Piece ["+i+"] = "+new String(listOfByteArr.get(i)));
				xor = xor2ByteArr(xor,listOfByteArr.get(i));
			}
		}

		if(IS_LOGGABLE)Log.w(TAG, "XOR Out = "+new String(xor));
		return xor;
	}
	
	protected static byte[] xor2ByteArr(byte[] byteArr1, byte[] byteArr2)
	{
		byte[] out = null;
		if(byteArr1 == null || byteArr2 == null)
		{
			return null;
		}
		else
		{
			byte[] longerByteArr = null;
			if(byteArr1.length >= byteArr2.length)
			{
				longerByteArr = byteArr1;
			}
			else
			{
				longerByteArr = byteArr2;
				byteArr2 = byteArr1;
			}
			
			out = new byte[longerByteArr.length];
			for (int i = 0; i < longerByteArr.length; i++)
			{
				out[i] = (byte) (longerByteArr[i] ^ byteArr2[i % byteArr2.length]);
			}
		}

		return out;
	}
}
