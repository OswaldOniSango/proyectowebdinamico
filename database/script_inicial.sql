CREATE TABLE `cliente` (
  `Id` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(244) DEFAULT NULL,
  `apellido` varchar(244) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `email` varchar(244) DEFAULT NULL,
  `password` varchar(244) DEFAULT NULL,
  `tipo_usuario` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--INSERT INTO `cliente` (`Id`, `Dni`, `Nombres`, `Direccion`, `Estado`) VALUES
--(17, '2', 'Juan Guerrero Solis', 'Los Alamos', '1'),
--(18, '1', 'Maria Rosas Villanueva', 'Los Laureles 234', '1'),
--(19, '3', 'Andres de Santa Cruz', 'Av. La Frontera 347', '1'),
--(20, '4', 'Andres Mendoza', 'Chosica, Lurigancho', '1');
-- --------------------------------------------------------
CREATE TABLE `detalle_compra` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_compra` int(11) UNSIGNED NOT NULL,
  `id_producto` int(11) UNSIGNED NOT NULL,
  `cantidad` int(11) UNSIGNED DEFAULT NULL,
  `Precio_compra` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------


-- --------------------------------------------------------
CREATE TABLE `producto` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `foto` longblob,
  `descripcion` text,
  `precio` double DEFAULT NULL,
  `stock` int(11) UNSIGNED DEFAULT NULL,
  `oferta` tinyint(1) DEFAULT '0',
  `precio_oferta` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




INSERT INTO `producto` (`nombre`, `precio`, `stock`, `oferta`, `precio_oferta`) VALUES
('Teclado Logitech 345 Editado', 150, 99, false, NULL),
( 'Mouse Logitech 567', 20, 98, false, NULL),
( 'Laptop Lenovo Ideapad 520', 800, 100, false, NULL),
( 'HeadPhones Sony M333', 500, 98, false, NULL),
( 'Producto Nuevo w', 22, 35, false, NULL);

-- --------------------------------------------------------
CREATE TABLE `compra` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_cliente` int(11) UNSIGNED NOT NULL,
  `id_pago` int(10) UNSIGNED NOT NULL,
  `fecha_compra` varchar(244) DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id`);
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`id`,`id_compra`,`id_producto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`id_compra`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`id_producto`);


ALTER TABLE `producto`
  ADD PRIMARY KEY (`Id`);

ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ventas_FKIndex1` (`id_cliente`);


ALTER TABLE `cliente`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

ALTER TABLE `detalle_compra`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;

ALTER TABLE `cliente`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `producto`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `compra`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
 
 
 
 
