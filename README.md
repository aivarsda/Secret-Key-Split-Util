Secret Key Split Util
=====================
That Utility allows you to split your secret Key into several pieces, these pieces can be stored in different places of your application code. When needed, you can reassemble the secret Key by applying the XOR function on the splitted pieces.

Secret Key Split Basics
--------------
Here is how XOR based splitting works:
You provide the required number of pieces - n, and the secret key – K. To generate n pieces of your key, you need to create (n – 1) random numbers: R1, R2, R3, . . . , Rn−1. For that you can use a SecureRandom number generator, which will prevent us from duplicates.Then you operate XOR function on these Rn-1 pieces and your key - K:
<br><b>Rn = R1 ⊕ R2 ⊕ R3 ⊕ . . . ⊕ Rn−1 ⊕ K</b>
<br><br>Now you have your n pieces: R1, R2, R3, …, Rn-1, Rn  and you may destroy the K. Those pieces can be spread in your code or sent to users.
<br><br>To reassemble the key, we use XOR operation on our Rn pieces:
<br><b>K = R1 ⊕ R2 ⊕ R3 ⊕ . . . ⊕ Rn−1 ⊕ Rn</b>

With the XOR function (⊕) each piece is inherently important in the reconstruction of the key, if any bits in any of the pieces are changed, then the key is not recoverable. 


How To Use
--------------
Here is an application that demonstrates how to use the Secret Key Split Util , you can actually use that app to split your secret key and send the key pieces to your email. Then you can use those pieces safely: spread them in your code and reassemble the key when it's needed.
<br>
[![Get it on Google Play](https://raw.github.com/repat/README-template/master/googleplay.png)](https://play.google.com/store/apps/details?id=com.aivarsda.keysplitter)

- <b>1. Splitting the Secret Key:</b>
```java
String KEY = "This is 32 characters long Key !"
int PIECES_NUM = 5;
KP keyPieces = Kspl.splitKey(PIECES_NUM, KEY , KEY.length()*8);
return _keyPieces;
```
Note: if you don't want to leave the key splitting logic in the code, you can remove the Kspl class, after you spread your key pieces in the code or passed them to the users. The Kspl class is not used for the key reassembly.
 
- <b>2. <b>Reassembly of the originally splited key:</b>
 
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
