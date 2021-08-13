# Sistema de ventas de productos


_A continuación se dará una breve explicacion del sistema: Esta es una API REST para administrar venta de productos (Solo backend) las pruebas para las rutas se hicieron en postman. Este sistema permite ingresar productos, tipos 
de producto y productos vendidos_

### Pre-requisitos 📋


_Que cosas necesitas para instalar el software y como instalarlas?_

```
Necesitas además tener preferentemente el IDE Spring Tool Suite o cualquier IDE compatible con JAVA si es Eclipse bajar plugin para spring.
Este proyecto fue hecho con OpenJDK 14. Tener cualquier tipo de base de datos en el computador ( En este proyecto se trabajo con MySQL). 
Tener instalado  en el IDE la libreria Lombok. Lo anterior no es obligatoio ya que es para evitar hacer manual los getter y setter y el constructor de las clases. 
Se debe contar con Postman o cualquier software para probar las rutas de la API. Ver en elproyecto la siguiente ruta de carpeta (se llama encuessta) : src/main/resources/application.properties en este ultimo archivo modificar los parametros de conexion a la base de datos segun sea la preferencia.
```

### Instalación 🔧

1. Una vez que se descarga el proyecto se debe ejecutar en el IDE o la imagen en docker(hubo unos problemas al momento de iniciar la imagen del proyecto que es venta_producto, revisar)
2. En postman se debe seguir los siguientes pasos:

```
La ruta para probar los productos es: localhost:8080/api/productos (POSTy GET) y 
localhost:8080/api/productos/1 (PUT y DELETE). el parametro id=1 se da como ejemplo.

La ruta para probar los tipos de productos: localhost:8080/api/tipos (POSTy GET) y 
localhost:8080/api/tipos/1 (PUT y DELETE). el parametro id=1 se da como ejemplo.

La ruta para ver los productos vendidos es: localhost:8080/api/registroVendidos (POSTy GET) y 
localhost:8080/api/registroVendidos/1 (PUT y DELETE). el parametro id=1 se da como ejemplo.

La ruta para realizar la simulacion por dia es: localhost:8080/api/productos/evaluateProducts/1 (GET)
```

        
 _Ejemplo de obtener datos del API REST_
 
 _1 Get a localhost:8080/api/tipos resultados:_
 
 ```
 [
    {
        "id": 1,
        "tipo": "Full cobertura",
        "descripcion": "incrementa su precio a medida que pasa el tiempo"
    },
    {
        "id": 2,
        "tipo": "Full cobertura Super duper",
        "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
    },
    {
        "id": 3,
        "tipo": "Super avance",
        "descripcion": "dismuniye su precio el doble de rapido que un producto normal"
    },
    {
        "id": 4,
        "tipo": "Mega cobertura",
        "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
    },
    {
        "id": 5,
        "tipo": "Cobertura",
        "descripcion": "producto normal"
    },
    {
        "id": 6,
        "tipo": "Baja cobertura",
        "descripcion": "producto que no cubre todo"
    }
]
 ```
 _2 Get a Productos  localhost:8080/api/productos_
 
 ```
[
    {
        "id": 1,
        "nombre": "Tv Lg",
        "price": 20,
        "sellIn": 10,
        "stock": 200,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 2,
        "nombre": "Computador Acer",
        "price": 0,
        "sellIn": 2,
        "stock": 500,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 1,
            "tipo": "Full cobertura",
            "descripcion": "incrementa su precio a medida que pasa el tiempo"
        }
    },
    {
        "id": 3,
        "nombre": "Asus Notebook",
        "price": 7,
        "sellIn": 5,
        "stock": 150,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 6,
            "tipo": "Baja cobertura",
            "descripcion": "producto que no cubre todo"
        }
    },
    {
        "id": 4,
        "nombre": "Lavadora LG",
        "price": 80,
        "sellIn": 0,
        "stock": 80,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 4,
            "tipo": "Mega cobertura",
            "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
        }
    },
    {
        "id": 5,
        "nombre": "Hp Notebook",
        "price": 80,
        "sellIn": -1,
        "stock": 90,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 4,
            "tipo": "Mega cobertura",
            "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
        }
    },
    {
        "id": 6,
        "nombre": "Hp teclado Lg",
        "price": 20,
        "sellIn": 15,
        "stock": 175,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 7,
        "nombre": "Refrigerador Daewoo",
        "price": 49,
        "sellIn": 10,
        "stock": 20,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 8,
        "nombre": "Impresora HP",
        "price": 49,
        "sellIn": 5,
        "stock": 45,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 9,
        "nombre": "Acer Notebook Nitro 5",
        "price": 6,
        "sellIn": 3,
        "stock": 41,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 3,
            "tipo": "Super avance",
            "descripcion": "dismuniye su precio el doble de rapido que un producto normal"
        }
    },
    {
        "id": 10,
        "nombre": "TV Master-G",
        "price": 20,
        "sellIn": 10,
        "stock": 100,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 11,
        "nombre": "Notebook Dell",
        "price": 20,
        "sellIn": 10,
        "stock": 200,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 12,
        "nombre": "Lavadora mademsa ubuntu",
        "price": 20,
        "sellIn": 10,
        "stock": 70,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    }
]
 ```
_3 POST a tipos de productos: localhost:8080/api/tipos_

```
Datos a ingresar: 

{ 
"tipo": "Super me Venta full stack de noche",
"descripcion": "producto que solo se vende en vispera de ciberday"

}

El resultado es: 

{
    "mensaje": "El tipo de producto ha sido creado con éxito! ",
    "tipo de producto": {
        "id": 7,
        "tipo": "Super me Venta full stack de noche",
        "descripcion": "producto que solo se vende en vispera de ciberday"
    }
}


```

_4 Simulacion de variacion de price y sellin por dia: localhost:8080/api/productos/evaluateProducts/{dia}_

```
La lita de productos antes de ir a esta ruta es:

[
    {
        "id": 1,
        "nombre": "Tv Lg",
        "price": 20,
        "sellIn": 10,
        "stock": 200,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 2,
        "nombre": "Computador Acer",
        "price": 0,
        "sellIn": 2,
        "stock": 500,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 1,
            "tipo": "Full cobertura",
            "descripcion": "incrementa su precio a medida que pasa el tiempo"
        }
    },
    {
        "id": 3,
        "nombre": "Asus Notebook",
        "price": 7,
        "sellIn": 5,
        "stock": 150,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 6,
            "tipo": "Baja cobertura",
            "descripcion": "producto que no cubre todo"
        }
    },
    {
        "id": 4,
        "nombre": "Lavadora LG",
        "price": 80,
        "sellIn": 0,
        "stock": 80,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 4,
            "tipo": "Mega cobertura",
            "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
        }
    },
    {
        "id": 5,
        "nombre": "Hp Notebook",
        "price": 80,
        "sellIn": -1,
        "stock": 90,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 4,
            "tipo": "Mega cobertura",
            "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
        }
    },
    {
        "id": 6,
        "nombre": "Hp teclado Lg",
        "price": 20,
        "sellIn": 15,
        "stock": 175,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 7,
        "nombre": "Refrigerador Daewoo",
        "price": 49,
        "sellIn": 10,
        "stock": 20,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 8,
        "nombre": "Impresora HP",
        "price": 49,
        "sellIn": 5,
        "stock": 45,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 9,
        "nombre": "Acer Notebook Nitro 5",
        "price": 6,
        "sellIn": 3,
        "stock": 41,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 3,
            "tipo": "Super avance",
            "descripcion": "dismuniye su precio el doble de rapido que un producto normal"
        }
    },
    {
        "id": 10,
        "nombre": "TV Master-G",
        "price": 20,
        "sellIn": 10,
        "stock": 100,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 11,
        "nombre": "Notebook Dell",
        "price": 20,
        "sellIn": 10,
        "stock": 200,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 12,
        "nombre": "Lavadora mademsa ubuntu",
        "price": 20,
        "sellIn": 10,
        "stock": 70,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    }
]

Y cuando probamos para el dia uno: localhost:8080/api/productos/evaluateProducts/1 es:

[
    {
        "id": 1,
        "nombre": "Tv Lg",
        "price": 19,
        "sellIn": 9,
        "stock": 200,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 2,
        "nombre": "Computador Acer",
        "price": 0,
        "sellIn": 2,
        "stock": 500,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 1,
            "tipo": "Full cobertura",
            "descripcion": "incrementa su precio a medida que pasa el tiempo"
        }
    },
    {
        "id": 3,
        "nombre": "Asus Notebook",
        "price": 6,
        "sellIn": 4,
        "stock": 150,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 6,
            "tipo": "Baja cobertura",
            "descripcion": "producto que no cubre todo"
        }
    },
    {
        "id": 4,
        "nombre": "Lavadora LG",
        "price": 80,
        "sellIn": 0,
        "stock": 80,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 4,
            "tipo": "Mega cobertura",
            "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
        }
    },
    {
        "id": 5,
        "nombre": "Hp Notebook",
        "price": 80,
        "sellIn": -1,
        "stock": 90,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 4,
            "tipo": "Mega cobertura",
            "descripcion": "nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180."
        }
    },
    {
        "id": 6,
        "nombre": "Hp teclado Lg",
        "price": 19,
        "sellIn": 14,
        "stock": 175,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 7,
        "nombre": "Refrigerador Daewoo",
        "price": 48,
        "sellIn": 9,
        "stock": 20,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 8,
        "nombre": "Impresora HP",
        "price": 48,
        "sellIn": 4,
        "stock": 45,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 2,
            "tipo": "Full cobertura Super duper",
            "descripcion": " tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento"
        }
    },
    {
        "id": 9,
        "nombre": "Acer Notebook Nitro 5",
        "price": 5,
        "sellIn": 2,
        "stock": 41,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 3,
            "tipo": "Super avance",
            "descripcion": "dismuniye su precio el doble de rapido que un producto normal"
        }
    },
    {
        "id": 10,
        "nombre": "TV Master-G",
        "price": 19,
        "sellIn": 9,
        "stock": 100,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 11,
        "nombre": "Notebook Dell",
        "price": 19,
        "sellIn": 9,
        "stock": 200,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    },
    {
        "id": 12,
        "nombre": "Lavadora mademsa ubuntu",
        "price": 19,
        "sellIn": 9,
        "stock": 70,
        "descripcion": "Corresponde a televisores de marca LG",
        "fecha": "2021-07-26",
        "tipo": {
            "id": 5,
            "tipo": "Cobertura",
            "descripcion": "producto normal"
        }
    }
]
```
_Las rutas se puede aplicar para un crud para probar_

 ## Construido con 🛠️
 _Herramientas utilizadas_
 *[spring IDE](https://spring.io/tools) - El framework web usado
 *[Gradle](https://gradle.org/) - Manejador de dependencias
 *[Postman](https://www.postman.com/)- Para probar las rutas


 
