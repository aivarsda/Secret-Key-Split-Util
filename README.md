Secret Key Split Util
=====================
This application is a demonstration of the Key Splitting Utility. That Utility allows you to split your secret Key into several pieces, these pieces can be stored in different places of your application code. When needed, you can reassemble the secret Key by applying the XOR function on the splitted pieces. For more information visit the GitHub project by clicking the link below.

Secret Key Split Basics
--------------
shdgd

How To Use
--------------
[![Get it on Google Play](https://raw.github.com/repat/README-template/master/googleplay.png)](https://play.google.com/store/apps/details?id=com.aivarsda.certpinning.demo)

- 1. Splitting the Secret Key:
```java
    String KEY = "This is 32 characters long Key !"
    int PIECES_NUM = 5;
    KP keyPieces = Kspl.splitKey(PIECES_NUM, KEY , KEY.length()*8);
		return _keyPieces;
```
Note: if you don't want to leave the key splitting logic in the code, you can remove the Kspl class, after you splread your key pieces in the code. The Kspl class is not used for the key reassembly.
 
- 2. Reassembly of the originally splited key:
 
```java
    ArrayList<String> splitedPiecesArray = new ArrayList<String>();
		splitedPiecesArray.add(YourLocationInCode.KP1);
		splitedPiecesArray.add(YourLocationInCode.KP2);
		splitedPiecesArray.add(YourLocationInCode.KP3);

		String reassembledKey = new String(Kasm.getK(splitedPiecesArray));
```


## Contact Developer
Aivars Dalderis
* e-mail: <aivars.dalderis@gmail.com>
* LinkedIn: [Aivars LinkedIn](http://il.linkedin.com/in/aivarsd)
