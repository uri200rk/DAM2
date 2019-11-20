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

    pool = Pool(2)

    l = range(40000000, 40000100)#[45445535, 56534563, 43566487, 43635453, 52346557, 53454433, 43546453, 26847357, 54577647]
    start = datetime.now()
    llista = pool.map(primers,l)
    contador = 0
    for i in l:
        
        print i,llista[contador]
        contador += 1

    print datetime.now() - start
    
