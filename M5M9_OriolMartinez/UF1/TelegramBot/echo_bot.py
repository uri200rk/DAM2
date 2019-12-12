# -*- coding: utf-8 -*-
import telebot
import webbrowser
import requests
import os
import sys
from datetime import datetime
from threading import Semaphore
reload(sys)
sys.setdefaultencoding('utf-8')

bot = telebot.TeleBot("850906969:AAEggI372vsBtM84ozbxRIKKBHJGEvWqRuQ")
s = Semaphore(1)

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
    bot.reply_to(message, "Soy tu hombre del tiempo, preguntame! Como funciono? Tienes 2 tipos de formas para saber el tiempo:\n        1:/tiempo + lugar\n        2:/tiempo + lugar + dia(numero)\nCon /setHome + lugar guardaras la ubicacion de tu casa o sitio favorito y cuando tengas un sitio guardado solo te bastara con introducir /tiempo y obtendras el tiempo actual de tu sitio guardado\n\nPor ultimo, tienes que tener en cuenta que si el lugar contiene mas de una palabra, tiene que ir separado por un '-'")

@bot.message_handler(commands=['setHome'])
def send_welcome(message):

    s.acquire()

    home = message.text.split()
    
    idPers = str(message.chat.id)

    
    file = open("setHome.txt","a")


    try:
        if os.stat("setHome.txt").st_size == 0:
            file.write(idPers+","+home[1])
        else:
            file.write("\n"+idPers+","+home[1])
        file.close()
        
        bot.send_message(message.chat.id,"Casa establecido en : "+home[1])
    except:
        bot.send_message(message.chat.id,"Introduce un lugar!")

    
    s.release()

@bot.message_handler(commands=['tiempo'])
def send_welcome(message):
    #obtener mes actual
    s.acquire()
    now = datetime.now()
    mes = int(format(now.month))
    llistaMesos = ["","Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"]
    mesAbre = llistaMesos[mes]
    print(mesAbre)


    idPers = str(message.chat.id)
    temp = 0
    temp2 = 0
    lugar = message.text.split()    #dividimos el texto introducido por el usuario
    puebloUsuario = 0
    if len(lugar)==1:   #CASO 1: NO INTRODUCE NINGUN PARAMETRO
        file = open('setHome.txt', 'r')
        
        try:
            for linea in file.readlines():
               
                parte = linea.split(",")
                print ("linea 0",parte[1])
                if parte[0] == idPers:
                    puebloUsuario = parte[1]
                    if puebloUsuario.find("\n") > -1:
                        puebloUsuario = parte[1][:-1]
        finally:
            file.close()
        
        lugar.append(str(puebloUsuario))
    print ("lugar 1:"+lugar[1])
    print("puebloUsuario: ",puebloUsuario)

    response = requests.get("https://www.eltiempo.es/"+lugar[1]+".html")    #descargamos la pagina eltiempo con el pueblo introducido/correpondiente
    print("https://www.eltiempo.es/"+lugar[1]+".html")
    findText = response.text.find("setTargeting(\'temp_c\'")    #buscamos una frase clave en la fuente de la pagina, donde seguidamente se encuentra
                                                                #el tiempo que queremos
    print ("findText",findText)
    # caso de error findError = responde.tetx.find("dataLayer = [{\'error404\': true}")
    # en caso que se meta numero del dia, dara el tiempo medio de ese dia
    
    if findText == -1:
         bot.send_message(message.chat.id,"Error! En el caso de haber introducido /tiempo, asegurate previamente de haber guardado un sitio favorito o asegurate que el lugar es correcto")
    else:
            
        if len(lugar) ==3:  #CASO 2: INTRODUCION DE PUEBLO + FECHA
            if int(lugar[2]) >=10: #por si el numero introducido es mas grande que 10(para encontrar la posicion exacta de la temp)
                number = response.text.find(lugar[2]+" "+mesAbre) #busca de palabra clave para obtener numero de la posicion
                temp = response.text[number+241:number+243] #guardamos en "temp" la temperatura
                bot.send_message(message.chat.id,"La temperatura máxima en " +lugar[1]+" el dia "+lugar[2]+" es de: " +temp+"°")   #MOSTRAMOS TIEMPO CASO 2(si es mas grande que 10)
            else:
                number = response.text.find(lugar[2]+" "+mesAbre)
                temp = response.text[number+240:number+242]
                bot.send_message(message.chat.id,"La temperatura máxima en " +lugar[1]+" el dia "+lugar[2]+" es de: " +temp+"°")   #MOSTRAMOS TIEMPO CASO 2(si es mas pequeño que 10)
        else: #CASO DONDE SOLO SE INTRODUCE EL LUGAR O SE OBTIENE DEL FIXERO
            try:
                temp2 = response.text[findText+24:findText+26]
                if int(temp2) >= 10:    #si el tiempo es mas grande que 10
                    temp2 = response.text[findText+24:findText+26]
                
            except ValueError:  #caso que de error por si hay comillas porque es un numero mas pequeño que 10
                temp2 = response.text[findText+24:findText+25]

            bot.send_message(message.chat.id,"El tiempo actual en "+lugar[1]+" es de: "+temp2+"°") #MOSTRAMOS TIEMPO CASO 1

    print ("tiempo 2",temp2)
    print("tiempo: ",temp)
    s.release()
    
    
    
bot.polling() 
