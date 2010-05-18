ALTER TABLE `trasplante`.`evolucion_trasplante_ecodopler` ADD COLUMN `OTROS` VARCHAR(1000)  AFTER `INDICE`,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`IdTrasplante`, `FECHA`);

UPDATE evolucion_trasplante_ecodopler SET OTROS = ''


ALTER TABLE `trasplante`.`evolucion_trasplante_ecografia` ADD COLUMN `OTROS` VARCHAR(1000)  DEFAULT ' '  AFTER `Espesor`;
