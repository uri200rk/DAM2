#-*- coding: utf8 -*-
#4523

# 40 / 2 = 20
# 40 / 4 = 10
from datetime import datetime
from multiprocessing import Pool
def primers(num):
    for i in range(2, num/2):
        if num % i == 0:
            return False
        else:
            pass
    return True

if __name__ == '__main__':

    pool = Pool(2)  # el numero indica quants procesos es fan com a màxim, surt a compte sempre i quan no es pasis de procesos actius, depenent del processador
                    # del pc, admetrà més processos o menys, ja que si forçem a fer més processos del que pot, es probable que no pugui. L'avantatge d'incloure més
                    # d'un process es que el programa s'acabarà abans, ja que els processos es fan a la vegada.

    l = range(40000000, 40000100)#[45445535, 56534563, 43566487, 43635453, 52346557, 53454433, 43546453, 26847357, 54577647]
    start = datetime.now()
    llista = pool.map(primers,l)
    contador = 0
    for i in l:
        
        print i,llista[contador]
        contador += 1

    print datetime.now() - start
    
