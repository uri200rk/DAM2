# Echo client program
import socket
import time

HOST = 'localhost'    # The remote host
PORT = 50007              # The same port as used by the server
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST,PORT))

#rebem el misatge
t=s.recv(1024)
#printem el misatge 
print t
    
s.close()

