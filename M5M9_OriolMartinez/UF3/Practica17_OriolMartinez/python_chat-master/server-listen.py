# Echo server program
import socket
import time
import threading

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 8022              # Arbitrary non-privileged port
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
        print 'acceptat'
        t = threading.Thread(target=recibir, args=(conn, listaConex))
        t.start()
       


def recibir(conexion, listaConex):
    while True:
        print "entro a rebre"
        #recibir mensaje
        data = conexion.recv(1024)
        print data
        t2 = threading.Thread(target=enviar, args=(conexion, data, listaConex))
        t2.start()

        '''
        if data == "bye":
            conexion.sendall(data)

            print "break"
            break
        '''
        
        

def enviar(conexion, data, listaConex):
    print "entro a enviar"
    
       
    for x in listaConex:
        
        x.sendall(data)
        if data == "bye":
            break
        
        





t3 = threading.Thread(target=acceptace, args=(s,))
t3.start()
#t2.daemon = True




t3.join()
s.close()
print 'Programa acabat'