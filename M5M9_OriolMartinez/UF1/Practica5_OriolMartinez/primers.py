#-*- coding: utf-8 -*-

import sys

"""
Modul per printar tants números primàris com s'ha indicat
"""

class llista_primers:
    def __init__(self, n):
        self.n = n
        self.llista = []
        self.busca()
    """
    metode per buscar el numero, aquest mètode es recursiu
    """
    def busca(self):
       
        """
        Cas quan la llagaria de la llista es 0
        """
        if (len(self.llista) == 0):
            self.llista.append(2)
           
            self.busca()
            
            """
            Cas quan la llargaria de la llista es més petita que el número introduit
            """
        elif (len(self.llista) < self.n):
            
            trobat = False
            seguent = self.llista[-1]+1
         
            while not trobat:

            """
            bucle que recòrre numero per numero de la llista
            """

                for i in self.llista:

                    """
                    Condició per saber si s'ha trobat el número primàri o no, fent el modul de la variable següent
                    i la variable "i"
                    """
                    if seguent%i == 0:
                        seguent += 1
                        trobat = False
                        break
                    else:
                        trobat = True

            """
            introduirem el valor de "següent" dins de l'array "llista"
            """             
            self.llista.append(seguent)
            self.busca()


if __name__ == '__main__':

    """
    obliguem a l'usuari a introduir un paràmetre
    """
    l = llista_primers(int(sys.argv[1]))
    print l.llista


    "..............."
