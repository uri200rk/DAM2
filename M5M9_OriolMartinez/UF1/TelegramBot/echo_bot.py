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
    #findText = response.text.find("setTargeting(\'temp_c\'")
    # en caso que se meta numero del dia number = response.text.find("23 Oct")
    # caso en que se meta numero del dia temp = response.text[number+241:number+243]
    print ("number",number)
    print temp
    webbrowser.open("https://www.eltiempo.es/"+lugar[1]+".html", new=2, autoraise=True)

@bot.message_handler(commands=['neifi'])
def send_welcome(message):
    #bot.reply_to(message, )

    lugar = message.text.split()
    

    webbrowser.open("https://www.netflix.com/es/", new=2, autoraise=True)    
    
bot.polling() 

