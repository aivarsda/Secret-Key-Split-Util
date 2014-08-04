package com.aivarsda.keysplitter.KSUtil;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import android.util.Base64;

public class Kspl extends KUtil
{
	public static KP splitKey(int numOfSplitPieces, String k, int pieceLength )
	{
		final byte[] 		byteArrKey	 = k.getBytes(Charset.forName("UTF-8"));
		ArrayList<byte[]> 	randomPieces = getRandomPiecesList(numOfSplitPieces-1,pieceLength);
		
		byte[] xorPieces = XORonByteArr(randomPieces);
		byte[] lastPiece = xor2ByteArr(xorPieces, byteArrKey);
		
		KP splitedKey = new KP();
		splitedKey.setOrgKey(k);
		randomPieces.add(lastPiece);
		splitedKey.setSplitedPiecesArray(ByteArrListToStringsList(randomPieces));
		
		
		if(IS_LOGGABLE)
		{
			//Testing the reassembly of the original Key
			Kasm.getK(splitedKey.getSplitedPiecesArray());
		}
		
		return splitedKey;
	}
	
	private static SecretKey generateSecretKey(int keyLength) throws NoSuchAlgorithmException
	{
		// Generate a key with the required length. (Ex.: keyLength = 256, meaning 256-bit)
		final int outputKeyLength = keyLength;

		SecureRandom secureRandom = new SecureRandom();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

		keyGenerator.init(outputKeyLength, secureRandom);
		SecretKey key = keyGenerator.generateKey();

		return key;
	}
	
	private static ArrayList<byte[]> getRandomPiecesList(int numberOfPieces, int pieceLength)
	{
		ArrayList<byte[]> secretKeyList = new ArrayList<byte[]>(numberOfPieces);
		for (int i=0; i<numberOfPieces; i++)
		{	
			try
			{
				secretKeyList.add(i, generateSecretKey(pieceLength).getEncoded());
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
		}
		
		return secretKeyList;		
	}
	
	private static ArrayList<String> ByteArrListToStringsList(ArrayList<byte[]> listOfByteArrays)
	{
		int size = listOfByteArrays.size();
		ArrayList<String> listOfStrings = new ArrayList<String>(size);
		for(int i=0; i<size; i++)
		{
			listOfStrings.add(Base64.encodeToString(listOfByteArrays.get(i), Base64.DEFAULT));
		}
		return listOfStrings;
	}

}
