#-*- coding: utf-8 -*-

"""
Modul per printar tants números primàris com s'ha indicat
"""
import sys

class llista_primers:

    """
    >>> llista_primers(3).llista
    [2, 3, 5]
    >>> llista_primers(4).llista
    [2, 3, 5, 7]
    >>> llista_primers(5).llista
    [2, 3, 5, 7, 11]
    """

    def __init__(self, n):
        self.n = n
        self.llista = []
        self.busca()
   
    def busca(self):
        """
        metode per buscar numeros primàris, la funció demanarà un número, per tal de retornar tants  números primàris com el número introduit
        
        """
       
        if (len(self.llista) == 0):
            
            #Cas quan la llagaria de la llista es 0
            
            self.llista.append(2)
           
            self.busca()
            

        elif (len(self.llista) < self.n):
            
            #Cas quan la llargaria de la llista es més petita que el número introduit
            
            trobat = False
            seguent = self.llista[-1]+1
         
            while not trobat:



                for i in self.llista:

                    
                    #bucle que recòrre numero per numero de la llista
                    

                    
                    if seguent%i == 0:

                        
                        #Condició per saber si s'ha trobat el número primàri o no, fent el modul de la variable següent
                        #i la variable "i"
                        
                        seguent += 1
                        trobat = False
                        break
                    else:
                        trobat = True

            
            self.llista.append(seguent)
            
            #introduirem el valor de "següent" dins de l'array "llista"
            
            self.busca()


if __name__ == '__main__':

    import doctest
    doctest.testmod()