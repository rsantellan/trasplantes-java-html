#!/bin/bash
date
echo "Empieza limpiando el cache por posibles errores."
php symfony cc
date
php symfony doctrine:build --all --and-load --no-confirmation
date
echo "Empezando la carga de datos"
php symfony loading:cargarDatos
date
echo "Empezando la carga de datos de transplantes (java)"
java -jar exportarDatosTrasplante.jar
date
echo "Empezando la carga de datos de cmv"
php symfony loading:cargarDatosTransplante
date
echo "Actualiza los contadores de las evoluciones."
php symfony loading:updateEvolucionCounter
date
echo "Verifica las fechas de alta de los pre trasplantes."
php symfony loading:correctPreTrasplanteDates
date
