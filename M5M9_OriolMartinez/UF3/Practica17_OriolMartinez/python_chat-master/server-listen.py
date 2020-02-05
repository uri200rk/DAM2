# Echo server program
import socket
import time
import threading

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 8013              # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST,PORT))


# marquem cuantes conexions esperem
s.listen(3)
#acceptem la conexio
conn, addr = s.accept()


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
        
        



t = threading.Thread(target=recibir, args=(conn,))
t2 = threading.Thread(target=enviar, args=(conn,))
t2.daemon = True
t.start()
t2.start()

t.join()
print 'break2'

s.close()
print 'break39'