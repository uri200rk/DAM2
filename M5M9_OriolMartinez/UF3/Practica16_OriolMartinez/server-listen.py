# Echo server program
import socket
import time

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 50007              # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST,PORT))
# marquem cuantes conexions esperem
s.listen(1)
#acceptem la conexio
conn, addr = s.accept()
#misatge a enviar
conn.sendall("conectado exitosamente!")



s.close()
