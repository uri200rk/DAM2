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
    file.write("\n"+idPers+","+home[1])
     



@bot.message_handler(commands=['tiempo'])
def send_welcome(message):
    #bot.reply_to(message, )
    temp = 0
    lugar = message.text.split()
    #print (lugar[1])
    if len(lugar)==1:
        lugar.append("manresa")
    print lugar   
    response = requests.get("https://www.eltiempo.es/"+lugar[1]+".html")
    findText = response.text.find("setTargeting(\'temp_c\'")
    print "findText",findText
    # caso de error findError = responde.tetx.find("dataLayer = [{\'error404\': true}")
    # en caso que se meta numero del dia, dara el tiempo medio de ese dia
    
    
    if len(lugar) ==3:
        if lugar[2] >=10:
            number = response.text.find(lugar[2]+" Nov")
            temp = response.text[number+241:number+243]
        else:
            number = response.text.find(lugar[2]+" Nov")
            temp = response.text[number+240:number+243]
    else:
        temp2 = response.text[findText+21:findText+25]
        bot.reply_to(message,temp2)

    print "tiempo 2",temp2
   # print ("parte2",lugar[2])
    #print ("number",number)
    #print ("Tiempo",temp)
    #webbrowser.open("https://www.eltiempo.es/"+lugar[1]+".html", new=2, autoraise=True)
   # if temp == 0:
    #    bot.reply_to(message,"Datos introducidos erroneos, asegurese que el luga introducido es un pueblo")
    #bot.reply_to(message,"La temperatura en " +lugar[1]+" el dia "+lugar[2]+" es de: " +temp)
    
    
bot.polling() 

