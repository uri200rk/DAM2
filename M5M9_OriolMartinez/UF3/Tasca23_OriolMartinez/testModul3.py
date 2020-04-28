from encryptGenerate import *

#key Privada
KeyPem = "OriolMartinez_Privada.pem"

#importa  Key privada RSA
privateKey = ImportKeyPrivate(KeyPem)

# Fitxer "en_k_aes.txt" amb clau AES xifrat
keyAES = open(str("en_k_aes.txt"),'rb').read()

# fitxer "missatge_en.txt" amb missatge xifrat
messageEncrypt = open(str("missatge_en.txt"),'rb').read()


#print key privada
print("Key Privada: " + str(privateKey))



# desixifrar

claveAES = DesencryptMessageRSA(keyAES,privateKey)

message = DesencryptAES(messageEncrypt, claveAES)

print ("Mensaje:" + message)