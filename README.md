# Trabajo TPJ
Commit 5
Nombre del paquete de Android:
com.mygdx.game
Sobrenombre de la app:
TPJ
Certificado de firma SHA-1 de depuración:
C8:15:46:05:B1:BB:25:66:8C:C6:ED:56:39:AE:B9:96:7F:DA:F4:97

Descargamos google-services.json y lo incorporamos al proyecto.

Archivo build.gradle de nivel de proyecto (<project>/build.gradle):
dependencies {
classpath 'com.google.gms:google-services:3.3.1'
}

Archivo build.gradle de nivel de app (<project>/<app-module>/build.gradle):
dependencies {
compile 'com.google.firebase:firebase-core:15.0.2'
}
(lo modificamos a peticion del android studio a)
dependencies {
compile 'com.google.firebase:firebase-core:16.0.0'
}

y agregamos al final:
apply plugin: 'com.google.gms.google-services'

Commit 6

Error en el gradle:

Gradle sync failed: Could not find method classpath() for arguments [com.google.gms:google-services:3.3.1] on object of type org.gradle.api.internal.artifacts.dsl.dependencies.DefaultDependencyHandler.
			Consult IDE log for more details (Help | Show Log) (801ms)

//MENSAJE MOSTRADO:

25/5/18 10:38:34,000 kernel[0]: Google Chrome He[1841] triggered unnest of range 0x7fff95400000->0x7fff95600000 of DYLD shared region in VM map 0x2691a9279b574981. While not abnormal for debuggers, this increases system memory footprint until the target exits.

Commit 7

Probamos a consultar la documentacion de firebase, la cual parece bastante desactualizada.
Realizamos un par de cambios recomendados y probamos a incorporar el plugin: google-services.json
en el core y el proyecto general con el fin de comprobar si consigue encontrarlo en alguno de los dos casos,
sin exito.
En todos los casos se ha probado modificando el classpath por compile e implements por si se encontraba ahi el fallo,
nuevamente sin exito.
