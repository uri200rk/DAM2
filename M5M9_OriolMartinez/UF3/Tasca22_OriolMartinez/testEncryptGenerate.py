from encryptGenerate import *



                            # -- RSA --

# 1

print("-----Exercise 1-----")
key = GenerateRSA_2048()
print(key)
#----------------------------------------------------------------------

# 2

# private
ExportPublicPrivateToFile("private_key", key)

# Public
ExportPublicPrivateToFile("public_key", key.publickey())

#----------------------------------------------------------------------

# 3

print("-----Exercise 3-----")

private_key = ImportPublicPrivateToFile("private_key.pem")
print("PRIVATE KEY: " + str(private_key))

public_key = ImportPublicPrivateToFile("public_key.pem")
print("PUBLIC KEY: " + str(public_key))

#----------------------------------------------------------------------

# 4

print("-----Exercise 4-----")

encMessage = EncryptMessageRSA('missatge de prova', public_key)
print("Message encrypted: " + str(encMessage))

#----------------------------------------------------------------------

#5
print("-----Exercise 5-----")

desMessage = DesencryptMessageRSA(encMessage,private_key)
print("Message desencrypted: " + str(desMessage))

#----------------------------------------------------------------------



                            # -- SHA256 --

#6
print("-----Exercise 6-----")

keySHA = GenerateKeySHA()
print(keySHA)

#----------------------------------------------------------------------


                            # -- AES --

#7

print("-----Exercise 7-----")

ivEncMessage = EncryptAES("Missatge a encriptar amb AES", keySHA)
print("Message encrypted: " + str(ivEncMessage))


#8

print("-----Exercise 8-----")

desMessage = DesencryptAES(ivEncMessage , keySHA)
print("desencrypt message: " + desMessage)