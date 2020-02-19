# Echo server program
import socket
import time
import threading

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 8029              # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST,PORT))

# marquem cuantes conexions esperem
s.listen(3)
listaConex = []

def acceptace(s):
    while True:
        #acceptem la conexio
        conn, addr = s.accept()
        

        t = threading.Thread(target=recibir, args=(conn, listaConex))
        t.start()
       


def recibir(conexion, listaConex):
    nombre = ""
    while True:
        if nombre == "":
            #establecer nombre
            nombre = conexion.recv(1024)
            listaConex.append((conexion, nombre[:-1]))
            
            print "nombre ",nombre
            


        else:
            #recibir mensaje
            data = conexion.recv(1024)
            print data
            t2 = threading.Thread(target=enviar, args=(conexion, nombre, data))
            t2.start()
            if data == "bye\n":
                print "entro a bye"
                conexion.close()
                listaConex.remove(conexion)
                print listaConex
                break
            
          
        
           
        
    
def enviar(conexion, nombre, data):
          
    for x in listaConex:
        print "lista", x
        print "nombreLista",x[1]
        if x[0] == conexion:
            pass
        else:    
            x[0].sendall(nombre[:-1]+":"+data)
            

        
        
t3 = threading.Thread(target=acceptace, args=(s,))
t3.start()





t3.join()
s.close()
print 'Programa acabat'