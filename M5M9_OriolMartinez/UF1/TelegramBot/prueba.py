texto = "hola buenos dias 24"
numeros = ["0","1","2","3","4","5","6","7","8","9"]
print(numeros[2])

def function(texto,numeros):
    lista = texto.split(" ")
    for i in numeros:
        if str(lista[-1]) == i:
            print("es numero")
        
    
    
    print (type(lista[-1]))
        
function(texto,numeros)
print(type(texto))