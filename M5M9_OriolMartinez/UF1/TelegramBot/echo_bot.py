import telebot
import webbrowser
import requests
bot = telebot.TeleBot("850906969:AAEggI372vsBtM84ozbxRIKKBHJGEvWqRuQ")

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
	bot.reply_to(message, "Soy tu hombre del tiempo, preguntame! Como funciono? Introduce el comando /tiempo i seguidamente el stitio")



@bot.message_handler(commands=['tiempo'])
def send_welcome(message):
    #bot.reply_to(message, )
    lugar = message.text.split()
    print (lugar[1])
    response = requests.get("https://www.eltiempo.es/"+lugar[1]+".html")
    findText = response.text.find("setTargeting(\'temp_c\'")
    # en caso que se meta numero del dia, dara el tiempo medio de ese dia
    number = response.text.find(lugar[2]+" Oct")
    if lugar[2] >=10:
        temp = response.text[number+241:number+243]
    else:
        temp = response.text[number+240:number+243]   
    print ("parte2",lugar[2])
    print ("number",number)
    print ("Tiempo",temp)
    #webbrowser.open("https://www.eltiempo.es/"+lugar[1]+".html", new=2, autoraise=True)
    bot.reply_to(message,"La temperatura en " +lugar[1]+" el dia "+lugar[2]+" es de: " +temp)
    
bot.polling() 

