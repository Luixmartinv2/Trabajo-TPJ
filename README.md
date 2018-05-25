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
