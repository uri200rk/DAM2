import telebot
import webbrowser
import pyowm

bot = telebot.TeleBot("850906969:AAEggI372vsBtM84ozbxRIKKBHJGEvWqRuQ")

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
	bot.reply_to(message, "Soy tu hombre del tiempo, preguntame!")



@bot.message_handler(commands=['tiempo'])
def send_welcome(message):
    #bot.reply_to(message, )
    lugar = message.text.split()
    print (lugar[1])

    webbrowser.open("https://www.eltiempo.es/"+lugar[1]+".html", new=2, autoraise=True)

@bot.message_handler(commands=['neifi'])
def send_welcome(message):
    #bot.reply_to(message, )

    own = pyowm.owM
    

   

bot.polling() 

