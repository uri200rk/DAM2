#-*- coding: utf8 -*-

from datetime import datetime
import multiprocessing
from multiprocessing import Pool

def primers(num):
    for i in range(2, num/2):
        if num % i == 0:
            return False
        else:
            pass
    return True

if __name__ == '__main__':
    #l = range(40000000, 40000100)
    start = datetime.now()
    pool = multiprocessing.Pool(processes=1)
    results = pool.map(primers, range(40000000, 40000100))
    print (results)
    print datetime.now() - start

#La quantitat de processos que podem executar alhora depen dels nuclis que té el nostre ordinador, per tant si fiquem més, quan tots els nuclis estiguin ocupats, el proxim process haurà d'esperar a que un quedi lliure
#per tant si fiquem molts més processos dels que tenim, molts dels processos s'hauràn d'esperar i pot ser el motiu que l'ordinador pugui penjar-se.
#Per tant surt a compte ficar un parell de processos més de nuclis que te l'ordinador, aixi sempre hi hauràn dos processos esperant per entrar, i serà més ràpid, ja que el timesleep dels processadors s'acceleraràn, amb dos processos de més es suficient, així no carreguem molte feina e l'ordinador.

