# Echo server program
import socket
import time
import threading

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 8003              # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST,PORT))

# marquem cuantes conexions esperem
s.listen(3)
listaConex = []

def acceptace(s):
    while True:
        #acceptem la conexio
        conn, addr = s.accept()
        listaConex.append(conn)
        t = threading.Thread(target=recibir, args=(conn, listaConex))
        t.start()
       


def recibir(conexion, listaConex):
    while True:
        #recibir mensaje
        data = conexion.recv(1024)
        print data
        if data == "bye\n":
            print "entro a bye"
            conexion.close()
            listaConex.remove(conexion)
            print listaConex
            break
        else:
            break
        '''    
        else:
            t2 = threading.Thread(target=enviar, args=(conexion, data, listaConex))
            t2.start()
        '''
    
def enviar(conexion, data, listaConex):
       
    for x in listaConex:
        if x == conexion:
            pass
        else:    
            x.sendall(data)

        
        
t3 = threading.Thread(target=acceptace, args=(s,))
t3.start()





t3.join()
s.close()
print 'Programa acabat'