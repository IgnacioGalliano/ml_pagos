# ML App

## Documentación
 
#### Contenido:

* View
Contiene 2 Archivos de tipo Activity:
1) Splash: 
	Redirecciona al segundo al Main.
2) MainActivity:
	Se basa toda aplicación principal y contiene 5 fragments 
	* Primero tiene como funcionalidad ingresar el valor a pagar(Su EditText solo acepta "1234567890").
	* Segundo tiene como funcionalidad seleccionar el medio de pago(redirige al fragment con lista).
	* Tercero tiene como funcionalidad seleccionar la tarjeta a utilizar(redirige al fragment con lista).
	* Cuarto tiene como funcionalidad seleccionar la cantidad de cuotas(redirige al fragment con lista).
	* Quinto es el fragmento lista, sirve para seleccionar las opciones a elegir en los anteriores fragment,
	para saber de donde se lo encuentra invocando el activity Main contiene la variable "stateListSelect" la 
	cual contiene los siguientes estados: 1 desde SelectPaymentMethodFragment
				              2 desde SelectCardFragment
					      3 desde SelectInstallmentFragment
* Models
	Contiene el modelado de los datos consumidos de la Api(No se modelaron todos los datos ya que era innecesario)
* Net
	Contiene el Archivo Connector el cual devuelve la url en base a BASE_URL, uri y query params, dependiendo 
	cada uno sea el caso.

#### Flujo:
1) Activity Splash redirige al Main
2) El Main instancia su primer fragment: AmountFragment.
3) En este Fragment solo se acepta en su EditText los siguientes caracteres: "1234567890", una vez ingresado,
   se presiona en siguiente y avanza al fragment SelectPaymentMethodFragment, en caso de estar vacio muestra Mensaje de Alerta.
4) En SelectPaymentMethodFragment se selecciona el metodo de pago, para ello al presionar la opcion, nos dirige hacia 
   la lista con stateListSelect en 1, donde podremos seleccionar el metodo, al hacerlo y presionar siguiente avanzaremos a 
   SelectCardFragment, en caso de estar vacio devuleve mensaje de alerta.
5) En SelectCardFragment se selecciona la tarjeta, para ello al presionar la opcion, nos redirige hacia 
   la lista con stateListSelect en 2, donde podremos seleccionar, al hacerlo y presionar siguiente avanzaremos a 
   SelectInstallmentFragment, en caso de estar vacio devuleve mensaje de alerta.
5) En SelectInstallmentFragment se selecciona la cantidad de cuotas, para ello al presionar la opcion, nos redirige hacia 
   la lista con stateListSelect en 3, donde podremos seleccionar, al hacerlo y presionar siguiente muestra mensaje de alerta
   con los valores seleccionados y pone en nulo paymentMethosSelected, cardSelected, amount, payerCost, para al final redirigir a 
   AmountFragment.
   
#### Librerias Utilizadas:

Nombre|Version|Funcionalidad
|----------------|--------|----------------------------------|
|Ion		 |2.2.1   |Utilizada para servicios API REST |
|recyclerview-v7 |28.0.0  |Lista Reciclable                  |
|acplibrary 	 |1.2.1   |Loading                           |
|Glide 	 	 |4.6.1   |Cargar imagenes enlazadas         |


### Autor: Ignacio Galliano


