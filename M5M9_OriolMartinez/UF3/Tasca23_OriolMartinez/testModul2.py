from encryptGenerate import *

#key sha256
mensaje = "missatge.txt"
key = "OriolMartinez_Publica.pem"

#Crear la clau AES amb una contrasenya de 4 números
keySHA256 = GenerateKeySHA()

#Xifrar el missatge amb aquesta clau (el missatge l'haureu de llegir del fitxer).
encryptAES = EncryptAES(mensaje, keySHA256)

#Xifrar la clau AES amb la clau RSA pública
public_key = ImportPublicToFile(key)
keyEncryptAES = EncryptMessageRSA(keySHA256, public_key)

#Guardar en un fitxer (missatge_en.txt) el missatge xifrat, recordeu que també hi ha d'anar el vector d'inicialització.
SaveFile("missatge_en", encryptAES)

#Guardar en un fitxer (en_k_aes.txt) la clau AES xifrada.
SaveFile("en_k_aes",keyEncryptAES)