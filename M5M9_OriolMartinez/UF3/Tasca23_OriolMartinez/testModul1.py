from encryptGenerate import *

#key
key = GenerateRSA_2048()

# private key
ExportPublicPrivateToFile("OriolMartinez_Privada", key)

# public key
ExportPublicPrivateToFile("OriolMartinez_Publica", key.publickey())