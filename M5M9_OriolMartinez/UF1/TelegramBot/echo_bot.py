# -*- coding: utf-8 -*-
import telebot
import webbrowser
import requests
import os
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

bot = telebot.TeleBot("850906969:AAEggI372vsBtM84ozbxRIKKBHJGEvWqRuQ")

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
	bot.reply_to(message, "Soy tu hombre del tiempo, preguntame! Como funciono? Introduce el comando /tiempo i seguidamente el stitio")

@bot.message_handler(commands=['setHome'])
def send_welcome(message):

    home = message.text.split()
    
    idPers = str(message.chat.id)

    
    file = open("setHome.txt","a")

    if os.stat("setHome.txt").st_size == 0:
        file.write(idPers+","+home[1])
    else:
        file.write("\n"+idPers+","+home[1])
    



@bot.message_handler(commands=['tiempo'])
def send_welcome(message):
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
        finally:
            file.close()
        
        lugar.append(str(puebloUsuario))
    print (lugar[1])

    response = requests.get("https://www.eltiempo.es/"+lugar[1]+".html")    #descargamos la pagina eltiempo con el pueblo introducido/correpondiente

    findText = response.text.find("setTargeting(\'temp_c\'")    #buscamos una frase clave en la fuente de la pagina, donde seguidamente se encuentra
                                                                #el tiempo que queremos
    print ("findText",findText)
    # caso de error findError = responde.tetx.find("dataLayer = [{\'error404\': true}")
    # en caso que se meta numero del dia, dara el tiempo medio de ese dia
    
    
    if len(lugar) ==3:  #CASO 2: INTRODUCION DE PUEBLO + FECHA
        if int(lugar[2]) >=10: #por si el numero introducido es mas grande que 10(para encontrar la posicion exacta de la temp)
            number = response.text.find(lugar[2]+" Nov") #busca de palabra clave para obtener numero de la posicion
            temp = response.text[number+241:number+243] #guardamos en "temp" la temperatura
            bot.reply_to(message,"La temperatura en " +lugar[1]+" el dia "+lugar[2]+" es de: " +temp)   #MOSTRAMOS TIEMPO CASO 2(si es mas grande que 10)
        else:
            number = response.text.find(lugar[2]+" Nov")
            temp = response.text[number+240:number+243]
            bot.reply_to(message,"La temperatura en " +lugar[1]+" el dia "+lugar[2]+" es de: " +temp)   #MOSTRAMOS TIEMPO CASO 2(si es mas pequeño que 10)
    else: #CASO DONDE SOLO SE INTRODUCE EL LUGAR O SE OBTIENE DEL FIXERO
        try:
            temp2 = response.text[findText+24:findText+26]
            if int(temp2) >= 10:    #si el tiempo es mas grande que 10
                temp2 = response.text[findText+24:findText+26]
            
        except ValueError:  #caso que de error por si hay comillas porque es un numero mas pequeño que 10
            temp2 = response.text[findText+24:findText+25]

        bot.reply_to(message,temp2) #MOSTRAMOS TIEMPO CASO 1

    print ("tiempo 2",temp2)
  
    
    
    
bot.polling() 