# Echo server program
import socket
import time
import threading

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 50007              # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST,PORT))


# marquem cuantes conexions esperem
s.listen(1)
#acceptem la conexio
conn, addr = s.accept()


def recibir(socket):
    #recibir mensaje
    data = socket.recv(1024)
    print data

def enviar(socket,data):
    #misatge a enviar
    socket.sendall(data)


    

while True:
    t.start()
    #entramos parametro por teclado
    data = raw_input()
    t2.start()

t = threading.Thread(target=recibir, args=(conn,))
t2 = threading.Thread(target=enviar, args=(conn, data))

s.close()



