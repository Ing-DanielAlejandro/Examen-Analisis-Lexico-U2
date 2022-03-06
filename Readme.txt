Objetivo
Resolver un problema que requiera el reconocimiento de patrones de texto, mediante la aplicación de los conceptos del análisis léxico utilizando una herramienta de construcción de analizadores léxicos automatizada.
 
Enunciado del problema
Crear un programa, utilizando el generador de analizadores léxicos JFlex, que lea un archivo de texto a la entrada y lo transforme a un archivo HTML equivalente a la salida, aplicando las reglas de formato descritas en la siguiente sección.
 
Especificaciones tokens


Nombre completo de una persona: Palabras (al menos dos) unidas por guión bajo. El primer nombre debe iniciar con mayúscula, puede tener conectores que inicien con minúscula pero no pueden ser de más de 4 caracteres. No más de 4 bloques de nombres y apellidos (pueden ser más con los conectores).  No puede terminar con un conector 
o   Juan_Perez
o   Jose_Ramon_de_la_Morena
No son nombres válidos:  JuAn_PErez 	Jorge_ysdf 	Juan  juan_Perez   Juan23_Perez  Juan_de 
 Teléfono local: Secuencias de 8 dígitos unidas por guión medio cada par de dígitos, o de 10 dígitos con paréntesis en el primer par.
o   30-30-64-00
o   (33)-30-30-45-23        
 Teléfono celular: Secuencias de 10 dígitos unidas por guión medio cada par de dígitos, o de 13 dígitos con los 3 primeros utilizando corchetes opcionales
o   33-35-22-33-44
o   044-33-35-22-33-44
o   [044]-33-35-22-33-44
                      

 
Correo electrónico: Secuencia separada por el símbolo de @. El nombre de usuario debe iniciar por una letra, puede contener letras, números, guión bajo, guión medio o punto. Los elementos del dominio siguen las mismas reglas que los de la URL.
o   profesor@localhost
o   aderas.apellido@mail.edunet.mx
o   soporte.hardware-software4@mail.net.mx
 
Tarjetas bancarias  mastercard : 16 dígitos empieza  con 51, 52, 53, 54 o 55.

			5212345678910111

Tarjetas bancarias  visa : 16 dígitos empieza  con 4.
       			4212345678910111
Especificaciones para el html                

Conforme se procesen los tokens del archivo, se generará un nuevo archivo HTML que es una "copia" del original, es decir, palabras, espacios, saltos de línea se ven igual, excepto que debe venir con el siguiente formato:
·   	Los nombres completos deberán ir resaltados en NEGRITAS
·   	Los teléfonos locales deberán aparecer en color VERDE
·   	Los teléfonos celulares deberán aparecer en color ROJO
·   	Los correos electrónicos aparecerán también como enlaces, pero al dar clic deberán lanzar el programa predeterminado de correo electrónico (mailto)
·   	Las tarjetas mastercard deberán aparecer en color AZUL
·   	Las tarjetas mastercard deberán aparecer en color MORADO
           
Al final de la creación del archivo de salida, el programa principal deberá emitir un resumen con las estadísticas de su procesamiento, esto es, la cantidad de nombres, teléfonos locales, celulares, URL, etc. que encontraron durante el análisis.


Reporte para completar

Utiliza la siguiente entrada : 


Nombre completo de una persona: Palabras (al menos dos) unidas por guión bajo. El primer nombre debe iniciar con mayúscula, puede tener conectores que inicien con minúscula pero no pueden ser de más de 4 caracteres. No más de 4 bloques de nombres y apellidos (pueden ser más con los conectores).  No puede terminar con un conector 
o   Juan_Perez
o   Jose_Ramon_de_la_Morena
No son nombres válidos:  JuAn_PErez 	Jorge_ysdf 	Juan  juan_Perez   Juan23_Perez  Juan_de 
 Teléfono local: Secuencias de 8 dígitos unidas por guión medio cada par de dígitos, o de 10 dígitos con paréntesis en el primer par.
o   30-30-64-00
o   (33)-30-30-45-23        
 Teléfono celular: Secuencias de 10 dígitos unidas por guión medio cada par de dígitos, o de 13 dígitos con los 3 primeros utilizando corchetes opcionales
o   33-35-22-33-44
o   044-33-35-22-33-44
o   [044]-33-35-22-33-44
                      

 
Correo electrónico: Secuencia separada por el símbolo de @. El nombre de usuario debe iniciar por una letra, puede contener letras, números, guión bajo, guión medio o punto. Los elementos del dominio siguen las mismas reglas que los de la URL.
o   profesor@localhost
o   aderas.apellido@mail.edunet.mx
o   soporte.hardware-software4@mail.net.mx
 
Tarjetas bancarias  mastercard : 16 dígitos empieza  con 51, 52, 53, 54 o 55.

			5212345678910111

Tarjetas bancarias  visa : 16 dígitos empieza  con 4.
       			4212345678910111





