#-*- encoding: utf-8 -*-
import hashlib
import json
import base64
from Crypto.Util.Padding import pad
from Crypto.Random import get_random_bytes
from base64 import b64decode, b64encode
from Crypto.Util.Padding import unpad
from Crypto.Random import random
from Crypto.PublicKey import RSA
from Crypto.Random import get_random_bytes
from Crypto.Cipher import AES, PKCS1_OAEP
from Crypto import Random

# funcions MODUL 1

def GenerateRSA_2048():
    
    key = RSA.generate(2048)
    return key


def ExportPublicPrivateToFile(name, key):
    
    #Export key
    k = key.exportKey('PEM')
    
    #Open file and write key
    f = open(name+ ".pem", "wb")
    f.write(k)

    f.close()



# funcions MODUL 2

def GenerateKeySHA():

     #input password
    passw = input("Introdueix una contrasenya de 4 digits: ")

    #Generate password with SHA
    key = hashlib.sha256(passw.encode("utf-8")).digest()

    return key

def EncryptAES(fixero, key):
    #file
    file = open(fixero,"r")
    data = file.read()
    file.close()


    #Calculating if the message length is multiple of 16
    length = 16
    data = data + (length - len(data) % length) * chr(length - len(data) % length)

    #Initializing vector
    #iv = ''.join(chr(random.randint(0, 0xFF)) for i in range(16))
    iv = Random.new().read(AES.block_size)
    
    code = AES.new(key, AES.MODE_CBC, iv = iv)
    
    encMessage = code.encrypt(data.encode())
     
    #Return initializing vector + message encypted
    return base64.b64encode(iv + encMessage)




def ImportPublicToFile(name):
    return RSA.import_key(open(name).read())

def EncryptMessageRSA(message, key):

    # Encrypt the session key with the public RSA key
    encMessage = PKCS1_OAEP.new(key)

    #return message encrypt
    return encMessage.encrypt(message)


def SaveFile(name, key):
    fileExport = open(name+ ".txt", "wb")
    fileExport.write(key)
    fileExport.close()


# funcions MODULO 3

def ImportKeyPrivate(path):
    return RSA.import_key(open(path).read())

def DesencryptMessageRSA(message, key):
    encMessage = PKCS1_OAEP.new(key)
    return encMessage.decrypt(message)   


def DesencryptAES(encMessage,key):

    encMessage = base64.b64decode(encMessage)
    
    #vector
    iv = encMessage[:AES.block_size]

    #encrypted message
    encryptedMessage = encMessage[AES.block_size:]

    #code
    code = AES.new(key, AES.MODE_CBC, iv)
    
    #Desencrypt message
    return code.decrypt(encryptedMessage).decode('utf-8')