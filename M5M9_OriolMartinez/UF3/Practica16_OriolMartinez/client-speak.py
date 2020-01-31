# Echo client program
import socket
import time
import threading

HOST = 'localhost'    # The remote host
PORT = 50009              # The same port as used by the server
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST,PORT))


def recibir(conexion):
    while True:
        #recibir mensaje
        data = conexion.recv(1024)

        print data
        if data == "bye":
            conexion.sendall(data)
            print "break"
            break
   
            
    

def enviar(conexion):
    while True:
        #entramos parametro por teclado
        data = raw_input()
 
        #misatge a enviar
        conexion.sendall(data)
        if data == "bye":
            break

           
        

    
t = threading.Thread(target=recibir, args=(s,))
t2 = threading.Thread(target=enviar, args=(s,))
t2.deamon = True
t.start()   
t2.start()

t.join()
s.close()
