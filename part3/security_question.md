#Mejores Prácticas de Seguridad según OWASP Top 10

Según OWASP Top 10 2021 nuestra aplicación podría tener las siguientes vulnerabilidades:
- **Inyección SQL**: Ya que por medio de datos de entrada un atacante podría enviar datos dañinos o concatenación de argumentos y estos podrían ser interpretados por SQL como parte de los comandos de consulta. Un atacante puede explotar esta vulnerabilidad obteniendo acceso no autorizado a los datos.
      
     Para solucionarlo debemos hacer nuestra API segura empezando por la validación de los datos de entrada al servidor, dentro de nuestro código debemos usar consultas parametrizadas para separar la entrada del usuario de la instrucción SQL y evitar que la consulta sea modificada.


- **Fallas Criptográficas**: Al almacenar los datos sensibles en texto claro y sin ningún tipo de encriptación.
    
    Para solucionarlo debemos utilizar algoritmos o protocolos criptográficos que utilicen estándares sólidos y estén actualizados, cifrar todos los datos sensibles, no debemos almacenar en cache datos sensibles, para las contraseñas se debe utilizar funciones robustas.


- **Componentes Vulnerables y Desactualizados**: Al usar componentes vulnerables conocidos nuestra app queda expuesta a ataques, especialmente cuando se usan librerías de terceros o software caducado y que contiene vulnerabilidades publicadas.

     Para evitar esta vulnerabilidad debemos eliminar las dependencias que no son utilizadas, funcionalidades, componentes, archivos y documentación innecesarios, se debe supervisar que componentes se encuentran desactualizados y actualizar el código del proyecto por versiones sin vulnerabilidades.


- **Fallas de Identificación y Autenticación**: Esta vulnerabilidad se refiere a debilidades en los sistemas de un software o aplicación que están relacionadas con la identificación y autenticación de usuarios.
      
    Para prevenir esta falla se debe implementar la autenticación multi-factor para evitar ataques automatizados de reutilización de credenciales conocidas, no se debe generar en nuestra aplicación credenciales por defecto, particularmente para usuarios administradores y se debe implementar que las contraseñas no sean débiles, tengan complejidad y rotación con las pautas de la sección 5.1.

Al tener alojada la infraestructura de nuestra aplicación en Kubernetes en Amazon Web Services (AWS)  podemos gestionar credenciales secretas de forma segura utilizando Kubernetes Secrets y así  evitar almacenar claves secretas en el código o en configuraciones, así mismo se debe utilizar imágenes de contenedor seguras que pueden ser escaneadas regularmente para detectar vulnerabilidades.
