from Crypto.PublicKey import RSA
from Crypto.Cipher import AES, PKCS1_OAEP
import hashlib
from Crypto.Random import random
from Crypto import Random
import base64





#               -- Methods for RSA --

#--------------------------------------
# 1 RSA 2048 bytes

def GenerateRSA_2048():
    
    key = RSA.generate(2048)
    return key

#---------------------------------------

#---------------------------------------
# 2 export key RSA (private/public)

def ExportPublicPrivateToFile(name, key):
    
    #Export key
    k = key.exportKey('PEM')
    
    #Open file and write key
    f = open(name+ ".pem", "wb")
    f.write(k)

    f.close()

#---------------------------------------

#---------------------------------------
# 3 import key RSA (private/public)

def ImportPublicPrivateToFile(name):

    # read file and return the key
    return RSA.import_key(open(name).read())

#---------------------------------------

# 4 Encrypt message with RSA

def EncryptMessageRSA(message, key):

    # Encrypt the session key with the public RSA key
    encMessage = PKCS1_OAEP.new(key)

    #return message encrypt
    return encMessage.encrypt(message.encode())

#---------------------------------------

# 5 Desencrypt message with RSA

def DesencryptMessageRSA(message, key):

    desMessage = PKCS1_OAEP.new(key)
    return desMessage.decrypt(message).decode('utf-8')

#---------------------------------------


#               -- Methods for SHA256 --

def GenerateKeySHA():

     #input password
    passw = input("Introdueix una contrasenya: ")

    #Generate password with SHA
    key = hashlib.sha256(passw.encode("utf-8")).digest()

    return key

#------------------------------------------

#               -- Methods for AES --

def EncryptAES(message, key):

    #Calculating if the message length is multiple of 16
    message += ' ' * (16 - len(message) % 16)

    #Initializing vector
    #iv = ''.join(chr(random.randint(0, 0xFF)) for i in range(16))
    iv = Random.new().read(AES.block_size)
    
    code = AES.new(key, AES.MODE_CBC, iv = iv)
 
    #Encrypting message
    encMessage = code.encrypt(message.encode())
     
    #Return initializing vector + message encypted
    return base64.b64encode(iv + encMessage)

#--------------------------------------------

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