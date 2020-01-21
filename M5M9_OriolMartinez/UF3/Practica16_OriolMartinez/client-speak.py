# Echo client program
import socket
import time

HOST = 'localhost'    # The remote host
PORT = 50007              # The same port as used by the server
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST,PORT))



def recibir(socket):
    #recibir mensaje
    mensaje = socket.recv(1024)
    print mensaje
    

def enviar(socket,data):
    #misatge a enviar
    socket.sendall(data)
    

while True:
   
    #entramos parametro por teclado
    data = raw_input()
    enviar(s,data)
    recibir(s)

s.close()

