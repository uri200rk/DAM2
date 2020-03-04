from Tkinter import *
from socket import *
import urllib
import re
import pygame
import time
from base64 import *
#import win32gui

HOST = 'localhost'
PORT = 5050


def getmixerargs():
    pygame.mixer.init()
    freq, size, chan = pygame.mixer.get_init()
    return freq, size, chan
def initMixer():
    BUFFER = 3072  # audio buffer size, number of samples since pygame 1.8.
    FREQ, SIZE, CHAN = getmixerargs()
    pygame.mixer.init(FREQ, SIZE, CHAN, BUFFER)
def playsound(soundfile):
    """Play sound through default mixer channel in blocking manner.
       This will load the whole sound into memory before playback
    """
    pygame.init()
    pygame.mixer.init()
    sound = pygame.mixer.Sound(soundfile)
    clock = pygame.time.Clock()
    sound.play()
    while pygame.mixer.get_busy():
        clock.tick(1000)
def playmusic(soundfile):
    """Stream music with mixer.music module in blocking manner.
       This will stream the sound from disk while playing.
    """
    pygame.init()
    pygame.mixer.init()
    clock = pygame.time.Clock()
    pygame.mixer.music.load(soundfile)
    pygame.mixer.music.play()
    while pygame.mixer.music.get_busy():
        clock.tick(1000)
def stopmusic():
    """stop currently playing music"""
    pygame.mixer.music.stop()

#HOW TO PLAY SONG:
initMixer()
#playmusic(filename)



def FlashMyWindow(title):
    pass
    #ID = win32gui.FindWindow(None, title)
    #win32gui.FlashWindow(ID,True)

def FlashMyWindow2(title2):
    ID2 = win32gui.FindWindow(None, title2)
    win32gui.FlashWindow(ID2,True)

def GetExternalIP():
    url = "http://checkip.dyndns.org"
    request = urllib.urlopen(url).read()
    return str(re.findall(r"\d{1,3}\.\d{1,3}\.\d{1,3}.\d{1,3}", request))

def GetInternalIP():
    return str(gethostbyname(getfqdn()))

def FilteredMessage(EntryText):
    """
    Filter out all useless white lines at the end of a string,
    returns a new, beautifully filtered string.
    """
    EndFiltered = ''
    for i in range(len(EntryText)-1,-1,-1):
        if EntryText[i]!='\n':
            EndFiltered = EntryText[0:i+1]
            break
    for i in range(0,len(EndFiltered), 1):
            if EndFiltered[i] != "\n":
                    return EndFiltered[i:]+'\n'
    return ''

def LoadConnectionInfo(ChatLog, EntryText):
    if EntryText != '':
        ChatLog.config(state=NORMAL)
        if ChatLog.index('end') != None:
            ChatLog.insert(END, EntryText+'\n')
            ChatLog.config(state=DISABLED)
            ChatLog.yview(END)

def LoadMyEntry(ChatLog, EntryText):
    if EntryText != '':
        ChatLog.config(state=NORMAL)
        if ChatLog.index('end') != None:
            LineNumber = float(ChatLog.index('end'))-1.0
            ChatLog.insert(END, "You: " + EntryText)
            ChatLog.tag_add("You", LineNumber, LineNumber+0.4)
            ChatLog.tag_config("You", foreground="#FF8000", font=("Arial", 12, "bold"))
            ChatLog.config(state=DISABLED)
            ChatLog.yview(END)


def LoadOtherEntry(ChatLog, EntryText):
    if EntryText != '':
        ChatLog.config(state=NORMAL)
        if ChatLog.index('end') != None:
            try:
                LineNumber = float(ChatLog.index('end'))-1.0
            except:
                pass
            text = EntryText.split(':',1)
            ChatLog.insert(END, text[0] + ": " + text[1])
            ChatLog.tag_add(text[0] + ": ", LineNumber, LineNumber+float('0.' + str(len(text[0] + ":"))))
            ChatLog.tag_config(text[0] + ": ", foreground="#04B404", font=("Arial", 12, "bold"))
            ChatLog.config(state=DISABLED)
            ChatLog.yview(END)

## functions with send and recive image

def sendImage(s, path):

    #######Open image######
    s.sendall("quiere enviar una imagen")
    myfile = open(path, 'rb')

    #recibir tamano imagen
    data = myfile.read()
    bytes = data.encode('base64')
    size = len(bytes)
    print size
    time.sleep(1)


    ######send image size to server########
    print "enviando imagen", "/image "+str(size)
    s.sendall("/image "+str(size))
    time.sleep(1)
    s.sendall("/image "+bytes)
    
    #print bytes
    myfile.close()

def recvImage(s, size): # jgfkj:/image 78687
    print 'recibiendo imagen...'
    data = s.recv(4096000)
    print "size" + size
    print " data" + data
    img = open('/home/oriol/GitHub/DAM2/M5M9_OriolMartinez/UF3/Practica18_OriolMartinez(2)/codi/imgRecibidas/new.png','wb')
    data2=data.split("/image")[-1]
    
    img.write(data2.decode('base64'))
    
    print size, len(data2)
    #print len(c_data)
   # print c_data
    #img.write(data2)
    img.close()

