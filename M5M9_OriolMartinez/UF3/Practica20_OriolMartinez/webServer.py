from http.server import HTTPServer, BaseHTTPRequestHandler

from PIL import Image
import urllib
import smtplib, ssl 

port = 587  # For starttls
smtp_server = "smtp.gmail.com"
sender_email = "enterprisedollarduck@gmail.com"
receiver_email = "oriolmartinez2@gmail.com"
password = "DollarDuck123"

message = """\
Subject: Hi there

This message is sent from Python.

El mensaje lo ha enviado: """





class server(BaseHTTPRequestHandler):


    def do_GET(self):
        if self.path == "/practica.html":
            file_to_open = open(self.path[1:]).read()
            self.send_response(200)
            
            #send mail

            try: 

                context = ssl.create_default_context()
                with smtplib.SMTP(smtp_server, port) as server:
                    server.ehlo()  # Can be omitted
                    server.starttls(context=context)
                    server.ehlo()  # Can be omitted
                    server.login(sender_email, password)
                    server.sendmail(sender_email, receiver_email, message)
    
            except: 
                print ("""Error: el mensaje no pudo enviarse.""")



        elif self.path == "/imagen.jpg":
           
                content = open(self.path[1:], 'rb')
                self.send_response(200)
                self.send_header('Content-type', 'image/jpg')
                self.end_headers()
                with open(self.path[1:], 'rb') as content:
                    shutil.copyfileobj(content, self.wfile)
                
           
        else:    
            self.send_error(404)
            
        self.end_headers()
        self.wfile.write(bytes(file_to_open, 'utf-8'))
        self.wfile.write(bytes(img, 'utf-8'))
httpd = HTTPServer(('localhost', 8080), server)  
httpd.serve_forever()




import smtplib, getpass
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

print("**** Enviar email con Gmail ****")
user = input("Cuenta de gmail: ")
password = getpass.getpass("Password: ")





